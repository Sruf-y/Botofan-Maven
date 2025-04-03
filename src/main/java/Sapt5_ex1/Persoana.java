package Sapt5_ex1;

import java.io.Serializable;

public class Persoana implements Serializable {
    private String nume;
    private int varsta;


    public Persoana(String nume, int varsta) {
        super();
        this.nume = nume;
        this.varsta = varsta;
    }

    public Persoana() {}

    @Override
    public String toString() {
        return nume+" "+ varsta;
    }

}
