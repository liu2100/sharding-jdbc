package org.example.db.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author liudaojian
 * Date: 2023/5/26 14:16
 * Description:
 */
@Data
@Entity
@Table
public class MemberLoginLog {

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
     * 会员ID
     */
    private Integer memberId;

}
