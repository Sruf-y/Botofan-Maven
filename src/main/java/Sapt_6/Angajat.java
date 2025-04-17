package Sapt_6;

import java.time.LocalDate;
import java.util.Objects;


public class Angajat {
    private String nume="Default";
    private String post="Default";
    private LocalDate data_angajarii=LocalDate.now();
    private Float salariu=0F;

    public Angajat(String nume, Float salariu, String post, LocalDate data_angajarii) {
        this.nume = nume;
        this.salariu = salariu;
        this.post = post;
        this.data_angajarii = data_angajarii;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public LocalDate getData_angajarii() {
        return data_angajarii;
    }

    public void setData_angajarii(LocalDate data_angajarii) {
        this.data_angajarii = data_angajarii;
    }

    public Float getSalariu() {
        return salariu;
    }

    public void setSalariu(Float salariu) {
        this.salariu = salariu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Angajat angajat = (Angajat) o;
        return Objects.equals(nume, angajat.nume) && Objects.equals(post, angajat.post) && Objects.equals(data_angajarii, angajat.data_angajarii) && Objects.equals(salariu, angajat.salariu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nume, post, data_angajarii, salariu);
    }

    @Override
    public String toString() {
        return nume+" "+post+" "+salariu+" "+data_angajarii;
    }
}
