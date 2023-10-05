
package n3exercici1.comparatorOrdena;

import java.util.Comparator;
import n3exercici1.Persona;

/**
 *
 * @author OCuevas
 */
public class CognomAscComparator implements Comparator<Persona>{

    @Override
    public int compare(Persona o1, Persona o2) {
        return o1.getCognom().compareTo(o2.getCognom());
    }
    
}
