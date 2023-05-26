package org.example.db.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author liudaojian
 */
@Data
@Entity
@Table
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 更新时间
     */
    private String updatedAt;

    /**
     * 创建时间
     */
    private String createdAt;

    /**
     * 产品ID
     */
    private Integer productId;

    /**
     * 产品名称
     */
    private String productName;

    /**
     * 库存数
     */
    private Integer stockQty;

}
