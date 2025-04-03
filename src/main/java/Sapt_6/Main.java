package Sapt_6;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String args[]){

        List<Angajat> lista_angajati=new ArrayList<>();

        System.out.println("Ex 1:");
        lista_angajati.add(new Angajat("Andrei Botofan",4400F,"Programator", LocalDate.now().minusMonths(50)));
        lista_angajati.add(new Angajat("Alex Matei",4700F,"Programator Junior", LocalDate.now().minusMonths(2)));
        lista_angajati
                .stream()
                .forEach(System.out::println);





        System.out.println("\nEx 2:");

        lista_angajati
                .stream()
                .filter(p -> p.getSalariu() > 2500F)
                .forEach(System.out::println);




        System.out.println("\nEx 3:");

        List<Angajat> angajati_an_trecut =
                (List<Angajat>) lista_angajati
                        .stream()
                        .filter(p->p.getData_angajarii().isBefore(LocalDate.of(LocalDate.now().getYear(),4,30)))
                        .filter(p->!p.getPost().toLowerCase().contains("sef") && !p.getPost().toLowerCase().contains("director") )
                        .sorted((a,b)->b.getSalariu().compareTo(a.getSalariu()))
                        .collect(Collectors.toList());

        angajati_an_trecut
                .stream()
                .forEach(System.out::println);





        System.out.println("\nEx 4.5(scriere/citire):");

        Functii.saveAsJson("Lista_Angajati",lista_angajati);
        List<Angajat> listaang2=Functii.loadFromJson("Lista_Angajati");





        System.out.println("\nEx 5:");

        List<String>  lista_noua =  lista_angajati.stream()
                .map(p->p.getNume().toUpperCase())
                .collect(Collectors.toList());


        lista_noua
                .stream()
                .forEach(System.out::println);
        
        



    }
}
