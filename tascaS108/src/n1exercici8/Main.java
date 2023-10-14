package n1exercici8;

/**
 *
 * @author Usuario
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        RecivedReturnString reverseString = (String string) -> {

            return new StringBuilder(string).reverse().toString() + " ";

        };

        String name = "Oscar Cuevas";
        System.out.println(name);
        String nameInverse = reverseString.recivedeString(name);
        System.out.println(nameInverse);
    }
}

@FunctionalInterface
interface RecivedReturnString {

    public String recivedeString(String string);
}
