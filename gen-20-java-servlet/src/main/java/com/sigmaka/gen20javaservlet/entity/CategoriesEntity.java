package com.sigmaka.gen20javaservlet.entity;

import com.sigmaka.gen20javaservlet.DTO.CategoriesResponseDTO;
import com.sigmaka.gen20javaservlet.DTO.ProductsResponseDTO;
import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "categories", schema = "public", catalog = "POS")
public class CategoriesEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "name", nullable = false, length = 50)
    private String name;
    @Basic
    @Column(name = "created_at", nullable = true)
    private Timestamp createdAt;
    @Basic
    @Column(name = "updated_at", nullable = true)
    private Timestamp updatedAt;
    @OneToMany(mappedBy = "category")
    private Collection<ProductsEntity> products;

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

    public Collection<ProductsEntity> getProducts() {
        return products;
    }

    public void setProducts(Collection<ProductsEntity> productsById) {
        this.products = productsById;
    }

    public CategoriesResponseDTO entityToDto(){
        CategoriesResponseDTO categories = new CategoriesResponseDTO();
        List<ProductsResponseDTO> products = new ArrayList<>();

        for(ProductsEntity data : this.products){
            products.add(data.entityToDto());
        }

        categories.setId(id);
        categories.setName(name);
        categories.setProducts(products);
        return categories;
    }
}
