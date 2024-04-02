package org.sigmaka.gen20javaspringbootpos.repository;

import org.sigmaka.gen20javaspringbootpos.entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepo extends JpaRepository<UsersEntity, Integer> {
    Optional<UsersEntity> findByEmail(String email);
}
