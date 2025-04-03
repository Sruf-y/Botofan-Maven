package Sapt_6;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Functii {


    public static final <T> void saveAsJson(String filename, List<T> lista){

        File file = new File("src/main/resources/" + filename + ".json");

        try{
            file.createNewFile();

        }catch (Exception ex){
            ex.printStackTrace();
        }

        try {
            ObjectMapper mapper = new ObjectMapper();

            mapper.registerModule(new JavaTimeModule());

            mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

            mapper.writeValue(file, lista);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static final <T> List<T> loadFromJson(String filename) {
        File file = new File("src/main/resources/" + filename + ".json");

        ArrayList<T> lista = new ArrayList<>();

        if (file.exists()) {

            try {

                ObjectMapper mapper = new ObjectMapper();

                mapper.registerModule(new JavaTimeModule());

                lista = mapper.readValue(file, new TypeReference<>(){});

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return lista;
    }
}
