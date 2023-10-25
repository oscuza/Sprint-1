package n1exercici2;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 *
 * @author OCuevas
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Integer> enters = new ArrayList<Integer>();

        for (int i = 1; i <= 5; i++) {
            enters.add(i);
        }
        for (Integer e : enters) {
            System.out.println(e);
        }

        List<Integer> entersInver = new ArrayList<Integer>();

        ListIterator<Integer> listIterator = enters.listIterator(enters.size());
        while (listIterator.hasPrevious()) {
            entersInver.add(listIterator.previous());
        }
        
        for (Integer e : entersInver) {
            System.out.println(e);
        }
    }

}
