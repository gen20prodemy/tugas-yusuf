package com.sigmaka.gen20javaservlet.repository;

import com.sigmaka.gen20javaservlet.entity.CategoriesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriesRepo extends JpaRepository<CategoriesEntity, Integer> {
}
