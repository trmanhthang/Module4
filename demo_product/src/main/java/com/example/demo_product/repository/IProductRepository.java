package com.example.demo_product.repository;

import com.example.demo_product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface IProductRepository extends JpaRepository<Product, Long>{

}
