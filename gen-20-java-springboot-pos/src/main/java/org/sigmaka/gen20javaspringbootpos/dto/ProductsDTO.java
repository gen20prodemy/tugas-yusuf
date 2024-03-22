package org.sigmaka.gen20javaspringbootpos.dto;

import org.sigmaka.gen20javaspringbootpos.entity.CategoriesEntity;
import org.sigmaka.gen20javaspringbootpos.entity.ProductsEntity;

import java.sql.Timestamp;

public class ProductsDTO {
    private String name;
    private int price;
    private int categoryId;
    private int quantity;

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

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public ProductsEntity dtoToEntity(){
        ProductsEntity product = new ProductsEntity();
        CategoriesEntity categories = new CategoriesEntity();
        categories.setId(categoryId);

        product.setName(name);
        product.setPrice(price);
//        product.(categoryId);
        product.setQuantity(quantity);
        product.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        product.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        return product;
    }
}
