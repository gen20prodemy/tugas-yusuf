package org.sigmaka.gen20javaspringbootpos.entity;

import jakarta.persistence.*;
import org.sigmaka.gen20javaspringbootpos.dto.categories.CategoriesResponseDTO;
import org.sigmaka.gen20javaspringbootpos.dto.products.ProductsResponseDTO;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

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
    @OneToMany(mappedBy = "category")
    private List<ProductsEntity> products;
    @Basic
    @Column(name = "created_at", nullable = true)
    private Timestamp createdAt;
    @Basic
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
