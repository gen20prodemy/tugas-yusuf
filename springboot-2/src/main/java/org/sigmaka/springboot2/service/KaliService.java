package org.sigmaka.springboot2.service;

import org.sigmaka.springboot2.model.Kali;
import org.springframework.stereotype.Service;

@Service
public class KaliService {
    private Kali kali;

    public KaliService() {
        this.kali = new Kali();
    }

    public Kali getKali() {
        return kali;
    }

    public void setKali(Kali kali) {
        this.kali.setA(kali.getA());
        this.kali.setB(kali.getB());
        this.kali.setMultiply();
    }
}
