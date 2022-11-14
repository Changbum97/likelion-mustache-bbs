package com.mustache.springbootmustachebbs.product_exercise.repository;

import com.mustache.springbootmustachebbs.product_exercise.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
