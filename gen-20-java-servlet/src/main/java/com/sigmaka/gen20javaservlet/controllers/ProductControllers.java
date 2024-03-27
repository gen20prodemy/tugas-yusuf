package com.sigmaka.gen20javaservlet.controllers;

import com.sigmaka.gen20javaservlet.entity.ProductEntity;
import com.sigmaka.gen20javaservlet.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("products")
public class ProductControllers {

    @Autowired
    private ProductService productService;

    @GetMapping("")
    public String index(Model model){
        String message = "Welcome to Products Spring MVC!";
        model.addAttribute("msg", message);
        model.addAttribute("products", productService.findAll());
        return "product";
    }

    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("product", new ProductEntity());
        return "addProduct";
    }
}
