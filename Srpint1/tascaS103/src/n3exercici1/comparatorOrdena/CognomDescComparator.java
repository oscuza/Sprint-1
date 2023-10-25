package n3exercici1.comparatorOrdena;

import java.util.Comparator;
import n3exercici1.Persona;

/**
 *
 * @author OCuevas
 */
public class CognomDescComparator implements Comparator<Persona> {

    @Override
    public int compare(Persona o1, Persona o2) {
        return o2.getCognom().compareTo(o1.getCognom());
    }

}
