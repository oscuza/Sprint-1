package n1exercici5;

/**
 *
 * @author OCuevas
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PiValue piValue = () -> 3.1415;
        double result = piValue.getPiValue();
        System.out.println(result);
    }

}
