package org.sigmaka.gen20javaspringbootpos.repository;

import org.sigmaka.gen20javaspringbootpos.entity.ProductsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepo extends JpaRepository<ProductsEntity, Integer> {
}
