package org.example.db;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.RandomUtil;
import org.example.db.entity.OrderMain;
import org.example.db.entity.Product;
import org.example.db.repository.OrderMainRepository;
import org.example.db.repository.ProductRepository;
import org.example.db.service.MemberService;
import org.example.db.service.OrderService;
import org.example.db.utils.ConsistencyHashUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.RoundingMode;


/**
 * @author 豆贤静
 * @date 2022/12/6 16:56
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CommonTest {

    @Autowired
    private OrderService orderService;

    @Autowired
    private MemberService memberService;

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void test() {

        memberService.addLoginLog();

        //System.out.println(orderService.getByMember(20000003));
        //System.out.println(orderService.getByMemberOrder(20000003, 6000000000003L));
        //System.out.println(orderService.getByMemberIdAndOrderId(20000004, 6000000000004L));
        //System.out.println(orderService.getByMemberIdAndOrderId(20000005, 6000000000003L));

        //orderService.addTransaction(6000000000009L, 20000001, 10000006);

        /*addProduct(10000001);
        addProduct(10000002);
        addProduct(10000003);
        addProduct(10000004);*/

        //getProduct(10000003);
        //getProduct(10000002);

        /*orderService.add(6000000000001L, 20000001);
        orderService.add(6000000000002L, 20000002);
        orderService.add(6000000000003L, 20000003);
        orderService.add(6000000000004L, 20000004);
        orderService.add(6000000000005L, 20000005);
        orderService.add(6000000000006L, 20000005);
        orderService.add(6000000000007L, 20000005);*/

    }

    private void getProduct(Integer productId) {
        System.out.println(productRepository.findByProductId(productId));
    }

    private void addProduct(Integer productId) {

        Product product = new Product();
        product.setCreatedAt(DateUtil.now());
        product.setUpdatedAt(DateUtil.now());
        product.setProductId(productId);
        product.setProductName("商品名称: " + productId);

        productRepository.save(product);

    }

}
