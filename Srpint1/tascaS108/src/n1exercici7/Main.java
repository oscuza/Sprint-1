/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package n1exercici7;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;

/**
 *
 * @author Usuario
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
        }).reversed()).forEach(System.out::println);
                
        
    }
    
}
