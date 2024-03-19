package org.sigmaka.springboot2.controller;

import org.sigmaka.springboot2.model.Tambah;
import org.sigmaka.springboot2.service.TambahService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/tambah")
public class TambahController {

    private TambahService tambahService;

    @Autowired
    public TambahController(TambahService tambahService) {
        this.tambahService = tambahService;
    }

    @PostMapping("/")
    public Tambah addition(@RequestBody Tambah tambah){
        tambahService.setTambah(tambah);
        return tambahService.getTambah();
    }
}
