package n1exercici4;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author OCuevas
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       List<String> months= Arrays.asList("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");

        months.forEach(System.out::println);
    }
    
}
