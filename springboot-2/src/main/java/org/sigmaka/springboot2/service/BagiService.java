package org.sigmaka.springboot2.service;

import org.sigmaka.springboot2.model.Bagi;
import org.springframework.stereotype.Service;

@Service
public class BagiService {
    private Bagi bagi;

    public BagiService() {
        this.bagi = new Bagi();
    }

    public Bagi getBagi() {
        return bagi;
    }

    public void setBagi(Bagi bagi) {
        this.bagi.setA(bagi.getA());
        this.bagi.setB(bagi.getB());
        this.bagi.setDivision();
    }
}
