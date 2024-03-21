package org.sigmaka.gen20javaspringbootpos.controller;

import org.sigmaka.gen20javaspringbootpos.dto.ProductsDTO;
import org.sigmaka.gen20javaspringbootpos.entity.ProductsEntity;
import org.sigmaka.gen20javaspringbootpos.helper.GlobalHttpResponse;
import org.sigmaka.gen20javaspringbootpos.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/products")
public class ProductsController {
    private final ProductsService productsService;

    @Autowired
    public ProductsController(ProductsService productsService) {
        this.productsService = productsService;
    }

    @GetMapping("/")
    public GlobalHttpResponse<List<ProductsEntity>> getAll(){
        return productsService.getAll();
    }

    @GetMapping("/{id}")
    public GlobalHttpResponse<Optional<ProductsEntity>> getById(@PathVariable("id") int id){
        return productsService.getById(id);
    }

    @PostMapping("/")
    public GlobalHttpResponse<ProductsEntity> insert(@RequestBody ProductsDTO productsDTO){
        return productsService.insert(productsDTO);
    }

    @PutMapping("/{id}")
    public GlobalHttpResponse<ProductsEntity> updateById(@PathVariable("id") int id, @RequestBody ProductsDTO productsDTO){
        return productsService.updateById(productsDTO, id);
    }

    @DeleteMapping("/{id}")
    public GlobalHttpResponse<ProductsEntity> deleteById(@PathVariable("id") int id){
        return productsService.deleteById(id);
    }
}
