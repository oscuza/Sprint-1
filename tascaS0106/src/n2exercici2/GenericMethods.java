package n2exercici2;

public class GenericMethods {

    public static <T> void printToScreenObject(T... arguments) {
        for (T arg : arguments) {
            System.out.println(arg.toString());
        }
    }

}
