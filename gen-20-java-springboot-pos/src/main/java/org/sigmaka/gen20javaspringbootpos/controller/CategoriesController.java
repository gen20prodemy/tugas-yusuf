package org.sigmaka.gen20javaspringbootpos.controller;

import org.sigmaka.gen20javaspringbootpos.dto.categories.CategoriesDTO;
import org.sigmaka.gen20javaspringbootpos.entity.CategoriesEntity;
import org.sigmaka.gen20javaspringbootpos.helper.GlobalHttpResponse;
import org.sigmaka.gen20javaspringbootpos.service.CategoriesService;
import org.sigmaka.gen20javaspringbootpos.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/category")
public class CategoriesController {
    private final CategoriesService categoriesService;
    private final KafkaProducerService kafkaProducerService;

    @Autowired
    public CategoriesController(CategoriesService categoriesService, KafkaProducerService kafkaProducerService) {
        this.categoriesService = categoriesService;
        this.kafkaProducerService = kafkaProducerService;
    }

    @Scheduled(cron = "55 * * * * *")
    public void sendMessageProduct(){
        String message = "message category @time " + new Date(System.currentTimeMillis());
        kafkaProducerService.sendMessage("category-topic", message);
        System.out.println("Message Sent: " + message);
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
