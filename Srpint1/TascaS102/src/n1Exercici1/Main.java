package n1Exercici1;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author OCuevas
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            List<Producte> productes = new ArrayList<Producte>();
            //productes.add(new Producte("Televisor", 1500.25));
            //productes.add(new Producte("Pilas", 25.26));
            //productes.add(new Producte("MicroHondas", 87.99));

            Venda venda = new Venda(productes);

            venda.calcularTotal();
            System.out.println(venda.getPreuTotal());
            
        } catch (VendaBuidaException ex) {
            System.out.println(ex.getMessage());
        }

    }

}
