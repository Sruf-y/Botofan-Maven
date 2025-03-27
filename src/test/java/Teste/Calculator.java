package Teste;

public class Calculator {
    private int a=0;
    private int b=0;

    Calculator(){};

    public Calculator(int a, int b) {
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

    @Override
    public String toString() {
        return a+" "+b;
    }

    public int Suma(){
        return a+b;
    }

}
