package n3exercici1.comparatorOrdena;

import java.util.Comparator;
import n3exercici1.Persona;

/**
 *
 * @author OCuevas
 */
public class NombreDescComparator implements Comparator<Persona> {

    @Override
    public int compare(Persona o1, Persona o2) {
        return o2.getNom().compareTo(o1.getNom());
    }

}
