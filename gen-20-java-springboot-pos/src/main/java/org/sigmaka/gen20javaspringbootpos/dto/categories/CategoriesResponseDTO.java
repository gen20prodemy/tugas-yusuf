package org.sigmaka.gen20javaspringbootpos.dto.categories;

import org.sigmaka.gen20javaspringbootpos.dto.products.ProductsResponseDTO;

import java.util.List;

public class CategoriesResponseDTO {
    private  int id;
    private String name;
    private List<ProductsResponseDTO> products;

    public List<ProductsResponseDTO> getProducts() {
        return products;
    }

    public void setProducts(List<ProductsResponseDTO> products) {
        this.products = products;
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

}
