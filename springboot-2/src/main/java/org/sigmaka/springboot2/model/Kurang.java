package org.sigmaka.springboot2.model;

public class Kurang {
    private int a;
    private int b;
    private int substraction;

    public Kurang() {
    }

    public Kurang(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public void setSubstraction(){
        this.substraction = a-b;
    }

    public int getSubstraction() {
        return substraction;
    }
}
