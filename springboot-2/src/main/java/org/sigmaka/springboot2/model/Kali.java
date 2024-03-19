package org.sigmaka.springboot2.model;

public class Kali {
    private int a;
    private int b;
    private int multiply;

    public Kali() {
    }

    public Kali(int a, int b) {
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

    public int getMultiply() {
        return multiply;
    }

    public void setMultiply(){
        this.multiply = a*b;
    }
}
