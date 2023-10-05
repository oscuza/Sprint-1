package n2exercici1;

import java.util.HashSet;

/**
 *
 * @author OCuevas
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         HashSet<Restaurant> restaurants = new HashSet<>();

        Restaurant restaurant1 = new Restaurant("Restaurant A", 5);
        Restaurant restaurant2 = new Restaurant("Restaurant B", 4);
        Restaurant restaurant3 = new Restaurant("Restaurant A", 3); // Mateix nom, diferent puntuació
        Restaurant restaurant4 = new Restaurant("Restaurant A", 5); // Mateix nom i puntuació

        // Afegim els restaurants al HashSet
        restaurants.add(restaurant1);
        restaurants.add(restaurant2);
        restaurants.add(restaurant3);
        restaurants.add(restaurant4);

        // Imprimim els restaurants afegits al HashSet
        for (Restaurant restaurant : restaurants) {
            System.out.println("Nom: " + restaurant.getNom() + ", Puntuació: " + restaurant.getPuntuacio());
        }
    }
    
    
}
