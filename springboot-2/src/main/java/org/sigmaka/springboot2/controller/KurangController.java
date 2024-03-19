package org.sigmaka.springboot2.controller;

import org.sigmaka.springboot2.model.Kurang;
import org.sigmaka.springboot2.service.KurangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/kurang")
public class KurangController {

    private KurangService kurangService;

    @Autowired
    public KurangController(KurangService kurangService) {
        this.kurangService = kurangService;
    }

    @PostMapping("/")
    public Kurang substraction(@RequestBody Kurang kurang){
        kurangService.setKurang(kurang);
        return kurangService.getKurang();
    }
}
