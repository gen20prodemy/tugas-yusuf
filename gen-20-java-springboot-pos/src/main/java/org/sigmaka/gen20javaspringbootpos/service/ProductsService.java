package org.sigmaka.gen20javaspringbootpos.service;

import org.sigmaka.gen20javaspringbootpos.dto.ProductsDTO;
import org.sigmaka.gen20javaspringbootpos.dto.ProductsResponseDTO;
import org.sigmaka.gen20javaspringbootpos.entity.CategoriesEntity;
import org.sigmaka.gen20javaspringbootpos.entity.ProductsEntity;
import org.sigmaka.gen20javaspringbootpos.helper.GlobalHttpResponse;
import org.sigmaka.gen20javaspringbootpos.repository.CategoriesRepo;
import org.sigmaka.gen20javaspringbootpos.repository.ProductsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductsService {
    private final ProductsRepo productsRepo;
    private final CategoriesRepo categoriesRepo;

    @Autowired
    public ProductsService(ProductsRepo productsRepo, CategoriesRepo categoriesRepo) {
        this.productsRepo = productsRepo;
        this.categoriesRepo = categoriesRepo;
    }

    public GlobalHttpResponse<List<ProductsResponseDTO>> getAll(){
        List<ProductsEntity> products = productsRepo.findAll();
        List<ProductsResponseDTO> result = new ArrayList<>();
        for(ProductsEntity data : products){
            result.add(data.entityToDto());
        }
        return new GlobalHttpResponse<>(200, "Success retrieve data", result);
    }

    public GlobalHttpResponse<ProductsResponseDTO> getById(int id){
        Optional<ProductsEntity> result = productsRepo.findById(id);
        if (result.isEmpty()) {
            return new GlobalHttpResponse<>(404, "Data not found", result.get().entityToDto());
        }
        return new GlobalHttpResponse<>(200,"Success retrieve data", result.get().entityToDto());
    }

    public GlobalHttpResponse<ProductsResponseDTO> insert(ProductsDTO productsDTO){
        ProductsEntity product = productsDTO.dtoToEntity();
        CategoriesEntity categories = categoriesRepo.findById(productsDTO.getCategoryId()).orElse(null);

        if (categories == null) {
            return new GlobalHttpResponse<>(404, "Category data not found", new ProductsEntity().entityToDto());
        }

        product.setCategory(categories);
        ProductsEntity result = productsRepo.save(product);
        return new GlobalHttpResponse<>(201, "Data has been created", result.entityToDto());
    }
    
    public GlobalHttpResponse<ProductsResponseDTO> updateById(ProductsDTO productsDTO, int id){
        Optional<ProductsEntity> optional = productsRepo.findById(id);
        if (optional.isEmpty()) {
            return new GlobalHttpResponse<>(404, "Data not found", new ProductsEntity().entityToDto());
        }
        CategoriesEntity categories = categoriesRepo.findById(productsDTO.getCategoryId()).orElse(null);
        if (categories == null) {
            return new GlobalHttpResponse<>(404, "Category data not found", new ProductsEntity().entityToDto());
        }

        ProductsEntity product = optional.get();
        product.setName(productsDTO.getName());
        product.setPrice(productsDTO.getPrice());
        product.setCategory(categories);
        product.setQuantity(productsDTO.getQuantity());
        product.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        ProductsEntity result = productsRepo.save(product);
        return new GlobalHttpResponse<>(200, "Success update data", result.entityToDto());
    }

    public GlobalHttpResponse<ProductsResponseDTO> deleteById(int id){
        Optional<ProductsEntity> optional = productsRepo.findById(id);
        if (optional.isEmpty()) {
            return new GlobalHttpResponse<>(404, "Data not found", new ProductsEntity().entityToDto());
        }
        ProductsEntity product = optional.get();
        productsRepo.deleteById(id);
        return new GlobalHttpResponse<>(200, "Success delete data", product.entityToDto());
    }
}
