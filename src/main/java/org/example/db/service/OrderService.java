package org.example.db.service;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.RandomUtil;
import org.apache.shardingsphere.transaction.annotation.ShardingTransactionType;
import org.apache.shardingsphere.transaction.core.TransactionType;
import org.example.db.entity.OrderMain;
import org.example.db.entity.Product;
import org.example.db.repository.OrderMainRepository;
import org.example.db.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.RoundingMode;
import java.util.List;

/**
 * @author liudaojian
 */
@Service
public class OrderService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderMainRepository orderMainRepository;

    public OrderMain getByMemberOrder(Integer memberId, Long orderId) {
        return orderMainRepository.findByMemberOrder(memberId, orderId);
    }

    public OrderMain getByMemberIdAndOrderId(Integer memberId, Long orderId) {
        return orderMainRepository.findByMemberIdAndOrderId(memberId, orderId);
    }

    public List<OrderMain> getByMember(Integer memberId) {
        return orderMainRepository.findAllByMember(memberId);
    }


    public List<OrderMain> getByMemberId(Integer memberId) {
        return orderMainRepository.findAllByMemberId(memberId);
    }

    public void add(Long orderId, Integer memberId) {

        OrderMain orderMain = new OrderMain();
        orderMain.setOrderId(orderId);
        orderMain.setCreatedAt(DateUtil.now());
        orderMain.setUpdatedAt(DateUtil.now());
        orderMain.setMemberId(memberId);
        orderMain.setOrderAmount(RandomUtil.randomDouble(100, 200, 2, RoundingMode.CEILING));
        orderMain.setOrderQty(RandomUtil.randomInt(1, 5));

        orderMainRepository.save(orderMain);

    }

    @Transactional(rollbackFor = Exception.class)
    @ShardingTransactionType(TransactionType.XA)
    public void addTransaction(Long orderId, Integer memberId, Integer productId) {

        add(orderId, memberId);

        Product product = new Product();
        product.setCreatedAt(DateUtil.now());
        product.setUpdatedAt(DateUtil.now());
        product.setProductId(productId);
        product.setProductName("商品名称: " + productId);
        productRepository.save(product);

    }

}
