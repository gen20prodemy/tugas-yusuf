package org.sigmaka.springboot2.model;

public class Bagi {
    private int a;
    private int b;
    private double division;

    public Bagi() {
    }

    public Bagi(int a, int b) {
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

    public double getDivision() {
        return division;
    }

    public void setDivision(){
        this.division = (double) a/b;
    }
}
