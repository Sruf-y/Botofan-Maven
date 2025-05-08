package Sapt_7;


import Sapt_7.Functii;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {


        Map<Integer,Carte> lista = new HashMap<>();
        lista =  Functii.loadFromJson("Carti");

        lista.entrySet().stream().forEach(
                System.out::println);











        System.out.println("\n\n\n");
        lista.remove("3");

        lista.entrySet().stream().forEach(
                System.out::println);









        System.out.println("\n\n\n");
        lista.putIfAbsent(8,new Carte("Moara cu noroc","I. L. Caragiale",1986));

        lista.entrySet().stream().forEach(
                System.out::println);








        Functii.saveAsJson("Carti Noi",lista);







        System.out.println("\n\n\n");
        Set<Carte> set_de_carti=lista.values().stream()
                .filter(p->p.autorul().equals("Yuval Noah Harari"))
                .collect(Collectors.toSet());



        set_de_carti.stream().forEach(System.out::println);



        System.out.println("\n\n\n");
        set_de_carti.stream().sorted((a,b)-> a.anul()-b.anul()).forEach(System.out::println);

    }
}
