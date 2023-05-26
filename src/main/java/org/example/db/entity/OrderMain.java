package org.example.db.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author liudaojian
 */
@Data
@Entity
@Table
public class OrderMain {

    @Id
    private Long orderId;

    /**
     * 更新时间
     */
    private String updatedAt;

    /**
     * 创建时间
     */
    private String createdAt;

    /**
     * 会员ID
     */
    private Integer memberId;

    /**
     * 订单金额
     */
    private Double orderAmount;

    /**
     * 订单商品数
     */
    private Integer orderQty;

}
