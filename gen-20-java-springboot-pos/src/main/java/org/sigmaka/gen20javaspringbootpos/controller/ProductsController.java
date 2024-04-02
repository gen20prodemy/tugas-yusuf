package org.sigmaka.gen20javaspringbootpos.controller;

import org.sigmaka.gen20javaspringbootpos.dto.products.ProductsDTO;
import org.sigmaka.gen20javaspringbootpos.dto.products.ProductsResponseDTO;
import org.sigmaka.gen20javaspringbootpos.helper.GlobalHttpResponse;
import org.sigmaka.gen20javaspringbootpos.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/products")
public class ProductsController {
    private final ProductsService productsService;

    @Autowired
    public ProductsController(ProductsService productsService) {
        this.productsService = productsService;
    }

    @GetMapping("/")
    public ResponseEntity<GlobalHttpResponse<List<ProductsResponseDTO>>> getAll(){
        GlobalHttpResponse<List<ProductsResponseDTO>> result = productsService.getAll();
        return new ResponseEntity<>(result, HttpStatusCode.valueOf(result.getStatusCode()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GlobalHttpResponse<ProductsResponseDTO>> getById(@PathVariable("id") int id){
        GlobalHttpResponse<ProductsResponseDTO> response = productsService.getById(id);
        return new ResponseEntity<>(response, HttpStatusCode.valueOf(response.getStatusCode()));
    }

    @PostMapping("/")
    public ResponseEntity<GlobalHttpResponse<ProductsResponseDTO>> insert(@RequestBody ProductsDTO productsDTO){
        GlobalHttpResponse<ProductsResponseDTO> result = productsService.insert(productsDTO);
        return new ResponseEntity<>(result, HttpStatusCode.valueOf(result.getStatusCode()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<GlobalHttpResponse<ProductsResponseDTO>> updateById(@PathVariable("id") int id, @RequestBody ProductsDTO productsDTO){
        GlobalHttpResponse<ProductsResponseDTO> result = productsService.updateById(productsDTO, id);
        return new ResponseEntity<>(result, HttpStatusCode.valueOf(result.getStatusCode()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GlobalHttpResponse<ProductsResponseDTO>> deleteById(@PathVariable("id") int id){
        GlobalHttpResponse<ProductsResponseDTO> result = productsService.deleteById(id);
        return new ResponseEntity<>(result, HttpStatusCode.valueOf(result.getStatusCode()));
    }
}
