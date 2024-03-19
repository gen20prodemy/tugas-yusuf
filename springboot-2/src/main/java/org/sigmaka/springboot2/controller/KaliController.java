package org.sigmaka.springboot2.controller;

import org.sigmaka.springboot2.model.Kali;
import org.sigmaka.springboot2.service.KaliService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/kali")
public class KaliController {

    private KaliService kaliService;

    @Autowired
    public KaliController(KaliService kaliService) {
        this.kaliService = kaliService;
    }

    @PostMapping("/")
    public Kali multiply(@RequestBody Kali kali){
        kaliService.setKali(kali);
        return kaliService.getKali();
    }
}
