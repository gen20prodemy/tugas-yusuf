package org.sigmaka.springboot2.controller;

import org.sigmaka.springboot2.model.Bagi;
import org.sigmaka.springboot2.service.BagiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/bagi")
public class BagiController {

    private BagiService bagiService;

    @Autowired
    public BagiController(BagiService bagiService) {
        this.bagiService = bagiService;
    }

    @PostMapping("/")
    public Bagi division(@RequestBody Bagi bagi){
        bagiService.setBagi(bagi);
        return bagiService.getBagi();
    }
}
