package n2exercici2;

import java.util.ArrayList;
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
        Person person1 = new Person("Alfred", "Clark", 55);
        Person person2 = new Person("Oscar", "Cuevas", 49);
        String name = "Oscar";
        int age = 25;
        List<Person> persons=new ArrayList<Person>();
        persons.add(person2);
        persons.add(person1);
        // GenericMethods.printToScreenObject(person1, name, age);
        GenericMethods.printToScreenObject(persons, name, age);

    }

}
