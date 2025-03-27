package Sapt5_ex1;

import java.io.File;
import java.util.ArrayList;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


public class Main {
    public static void main(String[] args){

        ArrayList<Persoana> lista = Citire();

        for(Persoana pers:lista){
            System.out.println(pers.toString());
        }

        //lista.add(new Persoana("Alex",13));
        Scriere(lista);

    }






    public static void Scriere(ArrayList<Persoana> lista){

        try{
            ObjectMapper mapper = new ObjectMapper();
            File fila = new File("src/main/resources/persoane.json");
            mapper.writeValue(fila,lista);
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }


    }
    public static ArrayList<Persoana> Citire(){
        ArrayList<Persoana> lista = new ArrayList<>();

        if(new File("src/main/resources/persoane.json").exists()) {
            try {
                ObjectMapper mapper = new ObjectMapper();
                File fila = new File("src/main/resources/persoane.json");
                lista = mapper.readValue(fila, new TypeReference<>() {
                });
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }

        return lista;
    }
}
