package org.example.db.repository;

import org.example.db.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author liudaojian
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    /**
     * 根据产品ID查询
     * @param productId 产品ID
     * @return {@link Product}
     */
    Product findByProductId(Integer productId);

}
