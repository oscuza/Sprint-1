package n2exercici2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import n2exercici1.*;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 *
 * @author OCuevas
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Set<Restaurant> restaurants = new TreeSet<Restaurant>();

        Restaurant restaurant1 = new Restaurant("Restaurant A", 5);
        Restaurant restaurant2 = new Restaurant("Restaurant B", 4);
        Restaurant restaurant3 = new Restaurant("Restaurant A", 3); 
        Restaurant restaurant4 = new Restaurant("Restaurant A", 5); 
        Restaurant restaurant5 = new Restaurant("Restaurant B", 2);
        Restaurant restaurant6 = new Restaurant("Restaurant A", 9);
        // Afegim els restaurants al HashSet
        restaurants.add(restaurant1);
        restaurants.add(restaurant2);
        restaurants.add(restaurant3);
        restaurants.add(restaurant4);
        restaurants.add(restaurant5);
        restaurants.add(restaurant6);

        // Imprimim els restaurants afegits al HashSet
        for (Restaurant restaurant : restaurants) {
            System.out.println("Nom: " + restaurant.getNom() + ", Puntuació: " + restaurant.getPuntuacio());
        }
    }

}
