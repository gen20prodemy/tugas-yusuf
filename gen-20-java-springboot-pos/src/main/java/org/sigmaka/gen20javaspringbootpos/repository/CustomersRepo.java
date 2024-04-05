package org.sigmaka.gen20javaspringbootpos.repository;

import jakarta.transaction.Transactional;
import org.sigmaka.gen20javaspringbootpos.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
@Transactional
public interface CustomersRepo extends JpaRepository<CustomerEntity, Integer> {
    @Modifying
    @Query(value = "INSERT INTO customers (name, created_at, updated_at) VALUES (:name, :createdAt, :updatedAt)", nativeQuery = true)
    void insertCustomerNative(String name, Timestamp createdAt, Timestamp updatedAt); // Native

    @Query("SELECT c from CustomerEntity c ORDER BY c.name")
    List<CustomerEntity> findAllCustomersJPQL(); // JPQL
}
