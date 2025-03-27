package Sapt5_ex2;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args){

        ArrayList<PerecheNumere> lista = new ArrayList<>();
        lista.add(new PerecheNumere(2,5));
        lista.add(new PerecheNumere(-5,7));

        PerecheNumere.Scriere(lista,"ListaNumere");

        lista=PerecheNumere.Citire("ListaNumere");

        for(PerecheNumere aux:lista){
            System.out.println(aux.toString());
        }

    }

}
