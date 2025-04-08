package Sapt_6;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Main {
    public static void main(String args[]){

        List<Angajat> lista_angajati=new ArrayList<>();

        System.out.println("Ex 1:");
        lista_angajati.add(new Angajat("Andrei Botofan",2800F,"Programator", LocalDate.now().minusMonths(50)));
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





        System.out.println("\nEx 6:");



        lista_angajati.stream()
                .filter(p->p.getSalariu()<3000)
                .map(p->p.getSalariu())
                .forEach(System.out::println);



        System.out.println("\nEx 7:");



        //lista_angajati.clear();

        lista_angajati.stream()
                .min((a,b)->a.getData_angajarii().compareTo(b.getData_angajarii()))
                .ifPresentOrElse(System.out::println, new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("No elements present");
                    }
                });



        System.out.println("\nEx 8:");


        System.out.println("Minim: "+ lista_angajati.stream()
                .collect(Collectors.summarizingDouble(Angajat::getSalariu))
                .getMin());


        System.out.println("Average: "+lista_angajati.stream()
                .collect(Collectors.summarizingDouble(Angajat::getSalariu))
                .getAverage());

        System.out.println("Maxim: "+ lista_angajati.stream()
                .collect(Collectors.summarizingDouble(Angajat::getSalariu))
                .getMax());





        System.out.println("\nEx 9:");


        lista_angajati.stream()
                .filter(p->p.getNume().toLowerCase().contains("ion"))
                .findAny()
                .ifPresentOrElse(new Consumer<Angajat>() {
                    @Override
                    public void accept(Angajat angajat) {
                        System.out.println("Firma are cel puțin un Ion angajat");
                    }
                }, new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("Firma nu are nici un Ion angajat");
                    }
                });



        System.out.println("\nEx 10:");


        System.out.println("Nr angajati din vara anului precedent: "+lista_angajati.stream()
                .filter(p->p.getData_angajarii().isAfter(
                        LocalDate.of(LocalDate.now().getYear(), Month.JUNE,1))
                        &&
                        p.getData_angajarii().isBefore(LocalDate.of(LocalDate.now().getYear(), Month.AUGUST,31)))
                .count());


    }
}
