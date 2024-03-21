package org.sigmaka.gen20javaspringbootpos.service;

import org.sigmaka.gen20javaspringbootpos.dto.CategoriesDTO;
import org.sigmaka.gen20javaspringbootpos.entity.CategoriesEntity;
import org.sigmaka.gen20javaspringbootpos.helper.GlobalHttpResponse;
import org.sigmaka.gen20javaspringbootpos.repository.CategoriesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class CategoriesService {
    private final CategoriesRepo categoriesRepo;

    @Autowired
    public CategoriesService(CategoriesRepo categoriesRepo) {
        this.categoriesRepo = categoriesRepo;
    }

    public GlobalHttpResponse<List<CategoriesEntity>> getAll(){
        return new GlobalHttpResponse<>(200, "Success retrieve data", categoriesRepo.findAll());
    }

    public GlobalHttpResponse<Optional<CategoriesEntity>> getById(int id){
        Optional<CategoriesEntity> result = categoriesRepo.findById(id);
        if (result.isEmpty()) {
            return new GlobalHttpResponse<>(404, "Data not found", result);
        }

        return new GlobalHttpResponse<>(200, "Success retrieve data", result);
    }

    public GlobalHttpResponse<CategoriesEntity> insert(CategoriesDTO categoriesDTO){
        return new GlobalHttpResponse<>(201, "Success insert data", categoriesRepo.save(categoriesDTO.dtoToEntity()));
    }

    public GlobalHttpResponse<CategoriesEntity> updateById(int id, CategoriesDTO categoriesDTO){
        Optional<CategoriesEntity> optional = categoriesRepo.findById(id);
        if (optional.isEmpty()) {
            return new GlobalHttpResponse<>(404, "Data not found", new CategoriesEntity());
        }

        CategoriesEntity category = optional.get();
        category.setName(categoriesDTO.getName());
        category.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        return new GlobalHttpResponse<>(200, "Success update data", categoriesRepo.save(category));
    }

    public GlobalHttpResponse<CategoriesEntity> deleteById(int id){
        Optional<CategoriesEntity> optional = categoriesRepo.findById(id);
        if (optional.isEmpty()) {
            return new GlobalHttpResponse<>(404, "Data not found", new CategoriesEntity());
        }

        CategoriesEntity category = optional.get();
        categoriesRepo.deleteById(id);
        return new GlobalHttpResponse<>(200, "Success delete data", category);
    }
}
