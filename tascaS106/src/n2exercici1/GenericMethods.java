package n2exercici1;

import n1exercici2.*;
import n1exercici1.*;

public class GenericMethods {

    public static  <T> void printToScreenObject(T obj1, T obj2, Person person) {
        System.out.println("Argument obj1: " + obj1);
        System.out.println("Argument obj2: " + obj2);
        System.out.println("Argument obj3: " + person);
    }

}
