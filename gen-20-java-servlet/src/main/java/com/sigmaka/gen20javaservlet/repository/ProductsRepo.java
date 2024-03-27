package com.sigmaka.gen20javaservlet.repository;

import com.sigmaka.gen20javaservlet.entity.ProductsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepo extends JpaRepository<ProductsEntity, Integer> {
}
