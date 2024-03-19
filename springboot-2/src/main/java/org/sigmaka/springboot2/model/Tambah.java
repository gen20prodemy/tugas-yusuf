package org.sigmaka.springboot2.model;

public class Tambah {
    private int a;
    private int b;
    private int addition;

    public Tambah() {
    }

    public Tambah(int a, int b) {
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

    public void setAddition(){
        this.addition = a+b;
    }

    public int getAddition(){
        return addition;
    }
}
