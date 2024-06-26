package org.sigmaka.gen20javaspringbootpos.dto.products;

import org.sigmaka.gen20javaspringbootpos.dto.categories.CategoriesDTO;

public class ProductsResponseDTO {
    private int id;
    private String name;
    private int price;
    private int quantity;
    private CategoriesDTO category;

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

    public CategoriesDTO getCategory() {
        return category;
    }

    public void setCategory(CategoriesDTO category) {
        this.category = category;
    }
}
