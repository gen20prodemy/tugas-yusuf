package org.sigmaka.gen20javaspringbootpos.service;

import org.sigmaka.gen20javaspringbootpos.dto.ProductsDTO;
import org.sigmaka.gen20javaspringbootpos.entity.ProductsEntity;
import org.sigmaka.gen20javaspringbootpos.helper.GlobalHttpResponse;
import org.sigmaka.gen20javaspringbootpos.repository.ProductsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class ProductsService {
    private final ProductsRepo productsRepo;

    @Autowired
    public ProductsService(ProductsRepo productsRepo) {
        this.productsRepo = productsRepo;
    }

    public GlobalHttpResponse<List<ProductsEntity>> getAll(){
        List<ProductsEntity> result = productsRepo.findAll();
        return new GlobalHttpResponse<>(200, "Success retrieve data", result);
    }

    public GlobalHttpResponse<Optional<ProductsEntity>> getById(int id){
        Optional<ProductsEntity> result = productsRepo.findById(id);
        return new GlobalHttpResponse<>(200,"Success retrieve data", result);
    }

    public GlobalHttpResponse<ProductsEntity> insert(ProductsDTO productsDTO){
        ProductsEntity result = productsRepo.save(productsDTO.dtoToEntity());
        return new GlobalHttpResponse<>(201, "Data has been created", result);
    }
    
    public GlobalHttpResponse<ProductsEntity> updateById(ProductsDTO productsDTO, int id){
        Optional<ProductsEntity> optional = productsRepo.findById(id);
        if (optional.isEmpty()) {
            return new GlobalHttpResponse<>(404, "Data not found", new ProductsEntity());
        }
        ProductsEntity product = optional.get();
        product.setName(productsDTO.getName());
        product.setPrice(productsDTO.getPrice());
        product.setCategoryId(productsDTO.getCategoryId());
        product.setQuantity(productsDTO.getQuantity());
        product.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        ProductsEntity result = productsRepo.save(product);
        return new GlobalHttpResponse<>(200, "Success update data", result);
    }

    public GlobalHttpResponse<ProductsEntity> deleteById(int id){
        Optional<ProductsEntity> optional = productsRepo.findById(id);
        if (optional.isEmpty()) {
            return new GlobalHttpResponse<>(404, "Data not found", new ProductsEntity());
        }
        ProductsEntity product = optional.get();
        productsRepo.deleteById(id);
        return new GlobalHttpResponse<>(200, "Success delete data", product);
    }
}
