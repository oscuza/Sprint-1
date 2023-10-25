package n1exercici6;

import java.util.Arrays;
import java.util.Comparator;
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
        List<Object> list = Arrays.asList("James Bond", 25, "Table", 68, 7, 95, -5, "Apple", -11, "Phantom");

        list.stream().sorted(Comparator.comparingInt(obj -> {
            if (obj instanceof String) {
                return ((String) obj).length();
            } 
            return 0;
        })).forEach(System.out::println);

      
    }

}
