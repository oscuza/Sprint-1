package n2exercici1;

import n1exercici2.*;
import n1exercici1.*;

/**
 *
 * @author OCuevas
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Person person1 = new Person("Alfred", "Clark", 55);
        String name = "Oscar";
        int age = 25;
        Person person2 = new Person("Oscar", "Cuevas", 49);

     // GenericMethods.printToScreenObject(person1, name, age);
        GenericMethods.printToScreenObject(person1, name, person2);

    }

}
