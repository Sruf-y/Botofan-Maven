package Sapt5_ex2;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.ArrayList;

public class PerecheNumere {
    private static int a=0;
    private static int b=0;

    public PerecheNumere(int a, int b) {
        this.a = a;
        this.b = b;
    }
    public PerecheNumere(){};

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
        return "PerecheNumere{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }

    public static final void Scriere(ArrayList<PerecheNumere> lista, String filename) {


        File file = new File("src/main/resources/" + filename + ".json");

        try{
            file.createNewFile();

        }catch (Exception ex){
            ex.printStackTrace();
        }

        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(file, lista);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    public static final ArrayList<PerecheNumere> Citire(String filename) {
        ArrayList<PerecheNumere> lista = new ArrayList<>();

        File file = new File("src/main/resources/"+filename+".json");

        if(file.exists()){
            try{
                ObjectMapper mapper = new ObjectMapper();
                lista=mapper.readValue(file, new TypeReference<>(){});
            }catch (Exception ex){
                System.out.println(ex.getMessage());
            }
        }


        return lista;
    }
    // A utility method that returns true if x is perfect square
    private static boolean isPerfectSquare(int x)
    {
        int s = (int) Math.sqrt(x);
        return (s*s == x);
    }

    // Returns true if n is a Fibonacci Number, else false
    private static boolean isFibonacci(int n)
    {
        // n is Fibonacci if one of 5*n*n + 4 or 5*n*n - 4 or both
        // is a perfect square
        return isPerfectSquare(5*n*n + 4) || isPerfectSquare(5*n*n - 4);
    }

    public static boolean isConsecutiveFibonaci(){

        if(isFibonacci(a) && isFibonacci(b)){
            return isFibonacci(a+b);
        }

        return false;
    }

    public static int findLCM(int a, int b) {
        // Start from the maximum of the two numbers
        int max = Math.max(a, b);

        // Loop until we find the LCM
        while (true) {
            if (max % a == 0 && max % b == 0) {
                return max; // LCM found
            }
            max++; // Increment to check the next number
        }
    }
}
