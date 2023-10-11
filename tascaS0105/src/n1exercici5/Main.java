package n1exercici5;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author OCuevas
 */
public class Main {

    public static void main(String[] args) {

        if (args.length != 1) {
            System.out.println("Usage: DirectoryList <name of file to save>");
        }
        String result = args[0] + ".ser";
        File file = new File(result);

        Employee employee1 = new Employee("Peter", "Parker", 28);
        Employee employee2 = new Employee("Alfred", "Tired", 31);
        Employee employee3 = new Employee("Mary", "Acount", 38);
        Employee employee4 = new Employee("Oscar", "Cuevas", 49);

        List<Employee> listEmployees = new ArrayList<Employee>();

        listEmployees.add(employee1);
        listEmployees.add(employee2);
        listEmployees.add(employee3);
        listEmployees.add(employee4);

        fileSerialization(listEmployees);
        fileDesSerialization();

    }

    public static void fileSerialization(List<Employee> listEmployee) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("fitxer.ser"));
            for (Employee e : listEmployee) {
                oos.writeObject(e);
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void fileDesSerialization() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("fitxer.ser"));
            while (true) {
                Employee employee = (Employee) ois.readObject();
                System.out.println(employee.getName() + " " + employee.getFirstName() + " " + employee.getAge());

            }
        } catch (IOException e) {

        } catch (ClassNotFoundException ex) {
        }

    }

    public static class Employee implements Serializable {

        private String name;
        private String firstName;
        private int age;

        public Employee(String name, String firstName, int age) {
            this.name = name;
            this.firstName = firstName;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Employee{" + "name=" + name + ", firstName=" + firstName + ", age=" + age + '}';
        }

    }

}
