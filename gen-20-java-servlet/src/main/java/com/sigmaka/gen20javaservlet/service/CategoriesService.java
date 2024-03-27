package com.sigmaka.gen20javaservlet.service;

import com.sigmaka.gen20javaservlet.DTO.CategoriesDTO;
import com.sigmaka.gen20javaservlet.entity.CategoriesEntity;
import com.sigmaka.gen20javaservlet.repository.CategoriesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoriesService {
    @Autowired
    private CategoriesRepo categoriesRepo;

    public List<CategoriesEntity> findAll(){
        return categoriesRepo.findAll();
    }
}
