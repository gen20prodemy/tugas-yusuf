package org.sigmaka.springboot2.service;

import org.sigmaka.springboot2.model.Kurang;
import org.springframework.stereotype.Service;

@Service
public class KurangService {
    private Kurang kurang;

    public KurangService() {
        kurang = new Kurang();
    }

    public Kurang getKurang() {
        return kurang;
    }

    public void setKurang(Kurang kurang) {
        this.kurang.setA(kurang.getA());
        this.kurang.setB(kurang.getB());
        this.kurang.setSubstraction();
    }
}
