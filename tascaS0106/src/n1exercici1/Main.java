package n1exercici1;

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
        Person person2 = new Person("James", "Green", 47);
        Person person3 = new Person("Laura", "Palmer", 21);

        NoGenericMethods<Person> personsGeneric1 = new NoGenericMethods<Person>(person3, person1, person2);
        NoGenericMethods<Person> personsGeneric2 = new NoGenericMethods<Person>(person1, person2, person3);

        Person personExtractPerson3 = personsGeneric1.getObj1();
        System.out.println("Person 3 in personsGeneric1 " + personExtractPerson3.getLastName());

        Person personExtractPerson1 = personsGeneric2.getObj1();
        System.out.println("Person 2 in personsGeneric2 " + personExtractPerson1.getLastName());
    }

    static class Person {

        private String name;
        private String lastName;
        private int age;

        public Person(String name, String lastName, int age) {
            this.name = name;
            this.lastName = lastName;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

    }
}
