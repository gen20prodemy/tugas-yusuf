package com.sigmaka.gen20javaservlet.service;

import com.sigmaka.gen20javaservlet.entity.ProductEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {

    private static List<ProductEntity> products = Arrays.asList(
            new ProductEntity(1, "karton", 500000, 20),
            new ProductEntity(2, "kardus", 50000, 200),
            new ProductEntity(3, "buku", 5000, 2),
            new ProductEntity(4, "bolpen", 500, 200),
            new ProductEntity(5, "Potlot", 50, 250),
            new ProductEntity(6, "Koentji", 5000000, 9999)
    );

    public List<ProductEntity> findAll(){
        return products;
    }

    public void add(ProductEntity product){
        product.setId(products.getLast().getId()+1);
        products.add(product);
    }
}
