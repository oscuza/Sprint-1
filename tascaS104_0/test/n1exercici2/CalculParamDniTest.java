
package n1exercici2;


import java.util.Arrays;
import java.util.Collection;
import junit.framework.Assert;
import org.junit.Test;
import org.junit.runners.Parameterized.Parameters;

/**
 *
 * @author OCuevas
 */
public class CalculParamDniTest {
   
    
 @Parameters
    public static  Collection <Object[]> getData(){
                 return Arrays.asList(new Object[][]{
                {12345678, 'Z'},
                {98765432, 'D'},
                {11111111, 'H'},
                {22222222, 'E'},
                {33333333, 'T'},
                {44444444, 'R'},
                {55555555, 'W'},
                {66666666, 'A'},
                {77777777, 'G'},
                {88888888, 'M'}
        });
    }

    @Test
 
    public void testDni(int dni,  String expectedLetter){
     
        CalculDni.calculateLetterDni(dni);
        Assert.assertEquals(expectedLetter, 0, 0);
    }
   
    
}
