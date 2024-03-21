package org.sigmaka.gen20javaspringbootpos.controller;

import org.sigmaka.gen20javaspringbootpos.dto.CategoriesDTO;
import org.sigmaka.gen20javaspringbootpos.entity.CategoriesEntity;
import org.sigmaka.gen20javaspringbootpos.helper.GlobalHttpResponse;
import org.sigmaka.gen20javaspringbootpos.service.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/category")
public class CategoriesController {
    private final CategoriesService categoriesService;

    @Autowired
    public CategoriesController(CategoriesService categoriesService) {
        this.categoriesService = categoriesService;
    }

    @GetMapping("/")
    public GlobalHttpResponse<List<CategoriesEntity>> getAll(){
        return categoriesService.getAll();
    }

    @GetMapping("/{id}")
    public GlobalHttpResponse<Optional<CategoriesEntity>> getById(@PathVariable("id") int id){
        return categoriesService.getById(id);
    }

    @PostMapping("/")
    public GlobalHttpResponse<CategoriesEntity> insert(@RequestBody CategoriesDTO categoriesDTO){
        return categoriesService.insert(categoriesDTO);
    }

    @PutMapping("/{id}")
    public GlobalHttpResponse<CategoriesEntity> updateById(@PathVariable("id") int id, @RequestBody CategoriesDTO categoriesDTO){
        return categoriesService.updateById(id, categoriesDTO);
    }

    @DeleteMapping("/{id}")
    public GlobalHttpResponse<CategoriesEntity> deleteById(@PathVariable("id") int id){
        return categoriesService.deleteById(id);
    }
}
