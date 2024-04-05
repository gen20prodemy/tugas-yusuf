package org.sigmaka.gen20javaspringbootpos.entity;

import jakarta.persistence.*;
import org.sigmaka.gen20javaspringbootpos.dto.CustomersDTO;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "customers", catalog = "POS", schema = "public")
@RedisHash("Customer")
public class CustomerEntity implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "name", nullable = false, length = 255)
    private String name;
    @Basic
    @Column(name = "created_at", nullable = true)
    private Timestamp createdAt;
    @Column(name = "updated_at", nullable = true)
    private Timestamp updatedAt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public CustomersDTO entityToDto(){
        CustomersDTO customers = new CustomersDTO();

        customers.setName(name);
        return customers;
    }
}
