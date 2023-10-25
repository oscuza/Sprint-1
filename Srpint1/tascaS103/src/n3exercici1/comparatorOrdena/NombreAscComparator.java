
package n3exercici1.comparatorOrdena;

import java.util.Comparator;
import n3exercici1.Persona;

/**
 *
 * @author formacio
 */
public class NombreAscComparator implements Comparator<Persona> {

    @Override
    public int compare(Persona o1, Persona o2) {
        return o1.getNom().compareTo(o2.getNom());
    }
    
}
