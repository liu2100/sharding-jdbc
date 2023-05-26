package org.example.db.repository;

import org.example.db.entity.OrderMain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author liudaojian
 */
@Repository
public interface OrderMainRepository extends JpaRepository<OrderMain, Long> {

    /**
     * 根据订单ID查询订单信息
     * @param orderId 订单ID
     * @return  {@link OrderMain}
     */
    OrderMain findByOrderId(Long orderId);

    /**
     * 根据会员ID查询会员所有订单
     * @param memberId 会员ID
     * @return {@link  List<OrderMain>}
     */
    @Query(value = "SELECT * FROM order_main WHERE member_id = :memberId", nativeQuery = true)
    List<OrderMain> findAllByMember(@Param("memberId") Integer memberId);

    /**
     * 根据会员ID查询会员所有订单
     * @param memberId 会员ID
     * @return {@link OrderMain}
     */
    List<OrderMain> findAllByMemberId(Integer memberId);

    /**
     * 根据会员ID和订单ID查询订单信息
     * @param memberId 会员ID
     * @param orderId 订单ID
     * @return {@link OrderMain}
     */
    @Query(value = "SELECT * FROM order_main WHERE order_id = ?2 AND member_id = ?1", nativeQuery = true)
    OrderMain findByMemberOrder(Integer memberId, Long orderId);

    /**
     * 根据会员ID和订单ID查询订单信息
     * @param memberId 会员ID
     * @param orderId 订单ID
     * @return {@link OrderMain}
     */
    OrderMain findByMemberIdAndOrderId(Integer memberId, Long orderId);

}
