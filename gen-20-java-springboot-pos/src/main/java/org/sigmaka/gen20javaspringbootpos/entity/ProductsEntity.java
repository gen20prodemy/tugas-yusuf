package org.sigmaka.gen20javaspringbootpos.entity;

import jakarta.persistence.*;
import org.sigmaka.gen20javaspringbootpos.dto.CategoriesDTO;
import org.sigmaka.gen20javaspringbootpos.dto.ProductsResponseDTO;

import java.sql.Timestamp;
import java.util.Collection;

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
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private CategoriesEntity category;
    @Basic
    @Column(name = "created_at", nullable = true)
    private Timestamp createdAt;
    @Basic
    @Column(name = "updated_at", nullable = true)
    private Timestamp updatedAt;
    @OneToMany(mappedBy = "productsByProductId")
    private Collection<TransactionsItemsEntity> transactionsItemsById;

    public CategoriesEntity getCategory() {
        return category;
    }

    public void setCategory(CategoriesEntity category) {
        this.category = category;
    }

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

    public Collection<TransactionsItemsEntity> getTransactionsItemsById() {
        return transactionsItemsById;
    }

    public void setTransactionsItemsById(Collection<TransactionsItemsEntity> transactionsItemsById) {
        this.transactionsItemsById = transactionsItemsById;
    }
}
