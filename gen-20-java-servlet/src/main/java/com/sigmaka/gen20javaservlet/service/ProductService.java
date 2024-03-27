package com.sigmaka.gen20javaservlet.service;

import com.sigmaka.gen20javaservlet.DTO.ProductsDTO;
import com.sigmaka.gen20javaservlet.DTO.ProductsResponseDTO;
import com.sigmaka.gen20javaservlet.entity.CategoriesEntity;
import com.sigmaka.gen20javaservlet.entity.ProductsEntity;
import com.sigmaka.gen20javaservlet.repository.CategoriesRepo;
import com.sigmaka.gen20javaservlet.repository.ProductsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private ProductsRepo productsRepo;
    private CategoriesRepo categoriesRepo;

    @Autowired
    public ProductService(ProductsRepo productsRepo, CategoriesRepo categoriesRepo) {
        this.productsRepo = productsRepo;
        this.categoriesRepo = categoriesRepo;
    }

    public List<ProductsResponseDTO> findAll(){
        List<ProductsEntity> product = productsRepo.findAll();
        List<ProductsResponseDTO> result = new ArrayList<>();

        for(ProductsEntity data : product){
            result.add(data.entityToDto());
        }

        return result;
    }

    public void add(ProductsDTO productsDTO){
        ProductsEntity product = productsDTO.dtoToEntity();
        CategoriesEntity categories = categoriesRepo.findById(productsDTO.getCategoryId()).orElse(null);

        product.setCategory(categories);
        productsRepo.save(product);
    }
}
