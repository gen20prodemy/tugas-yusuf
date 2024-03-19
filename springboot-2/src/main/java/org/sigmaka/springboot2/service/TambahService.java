package org.sigmaka.springboot2.service;

import org.sigmaka.springboot2.model.Tambah;
import org.springframework.stereotype.Service;

@Service
public class TambahService {
    private Tambah tambah;

    public TambahService() {
        this.tambah = new Tambah();
    }

    public Tambah getTambah() {
        return tambah;
    }

    public void setTambah(Tambah tambah) {
        this.tambah.setA(tambah.getA());
        this.tambah.setB(tambah.getB());
        this.tambah.setAddition();
    }
}
