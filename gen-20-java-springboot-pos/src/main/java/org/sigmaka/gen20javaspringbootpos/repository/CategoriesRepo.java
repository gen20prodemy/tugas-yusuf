package org.sigmaka.gen20javaspringbootpos.repository;

import org.sigmaka.gen20javaspringbootpos.entity.CategoriesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriesRepo extends JpaRepository<CategoriesEntity, Integer> {
}
