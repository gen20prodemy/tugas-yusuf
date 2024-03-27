package com.sigmaka.gen20javaservlet.controllers;

import com.sigmaka.gen20javaservlet.DTO.ProductsDTO;
import com.sigmaka.gen20javaservlet.service.CategoriesService;
import com.sigmaka.gen20javaservlet.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("products")
public class ProductControllers {

    private ProductService productService;
    private CategoriesService categoriesService;

    @Autowired
    public ProductControllers(ProductService productService, CategoriesService categoriesService) {
        this.productService = productService;
        this.categoriesService = categoriesService;
    }

    @GetMapping("")
    public String index(Model model){
        String message = "Welcome to Products Spring MVC!";
        model.addAttribute("msg", message);
        model.addAttribute("products", productService.findAll());
        return "product";
    }

    @GetMapping("/add")
    public String add(Model model){
        String message = "Add new Product";
        model.addAttribute("msg", message);
        model.addAttribute("categories", categoriesService.findAll());
        model.addAttribute("product", new ProductsDTO());
        return "addProduct";
    }

    @PostMapping("/save")
    public String save(ProductsDTO productsDTO, Model model){
        productService.add(productsDTO);
        return "redirect:/products";
    }
}
