package org.sigmaka.gen20javaspringbootpos.repository;

import org.sigmaka.gen20javaspringbootpos.entity.RolesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepo extends JpaRepository<RolesEntity, Integer> {
}
