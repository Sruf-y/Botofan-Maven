package Sapt5;

public class Persoana {
    private String nume;
    private int age;

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Persoana(String nume, int age) {
        super();
        this.nume = nume;
        this.age = age;
    }

    public Persoana() {}

    @Override
    public String toString() {
        return nume+age;
    }

}
