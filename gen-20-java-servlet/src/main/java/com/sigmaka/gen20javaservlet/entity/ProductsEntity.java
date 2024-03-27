package com.sigmaka.gen20javaservlet.entity;

import com.sigmaka.gen20javaservlet.DTO.CategoriesDTO;
import com.sigmaka.gen20javaservlet.DTO.ProductsResponseDTO;
import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "products", schema = "public", catalog = "POS")
public class ProductsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "name", nullable = false, length = 255)
    private String name;
    @Basic
    @Column(name = "price", nullable = false)
    private int price;
    @Basic
    @Column(name = "quantity", nullable = false)
    private int quantity;
    @Basic
    @Column(name = "created_at", nullable = true)
    private Timestamp createdAt;
    @Basic
    @Column(name = "updated_at", nullable = true)
    private Timestamp updatedAt;
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private CategoriesEntity category;

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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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

    public CategoriesEntity getCategory() {
        return category;
    }

    public void setCategory(CategoriesEntity categoriesByCategoryId) {
        this.category = categoriesByCategoryId;
    }

    public ProductsResponseDTO entityToDto(){
        ProductsResponseDTO product = new ProductsResponseDTO();
        CategoriesDTO categories = new CategoriesDTO();

        categories.setName(category.getName());

        product.setId(id);
        product.setName(name);
        product.setPrice(price);
        product.setQuantity(quantity);
        product.setCategory(categories);
        return product;
    }
}
