package Teste;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import Teste.Calculator;

public class MathTest {
    @Test
    void test1_suma(){
        Calculator c=new Calculator(4,5);
        assertEquals(9,c.Suma());
    }
    @Test
    void test2_suma(){
        Calculator c = new Calculator(7,10);
        assertTrue(c.Suma()==17);
    }
    @Test
    void test3_suma(){
        Calculator c=new Calculator(9,2);
        assertFalse(c.Suma()==92);
    }

}
