package com.example.product_service.repository;

import com.example.product_service.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {
    Product findByTitle(String title);
    Product findByTitleAndDescription(String title, String description);
    Product findByTitleOrDescription(String title, String description);

    @Query(value = "select * from product where title like :title and id = :id", nativeQuery = true)
    Product findProductByTitleLike(String title);

    @Query(value = "select * from Products", nativeQuery = true)
    Product findAllProducts(String title, UUID id);

    // custom SQL queries can also be done in JPA
}