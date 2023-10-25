package n1exercici1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/**
 *
 * @author OCuevas
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Month m1 = new Month("Enero");
        Month m2 = new Month("Febrero");
        Month m3 = new Month("Marzo");
        Month m4 = new Month("Abril");
        Month m5 = new Month("Mayo");
        Month m6 = new Month("Junio");
        Month m7 = new Month("Julio");
        Month m9 = new Month("Septiembre");
        Month m8 = new Month("Agosto");
        Month m10 = new Month("Octubre");
        Month m11 = new Month("Noviembre");
        Month m12 = new Month("Diciembre");

        ArrayList<Month> months = new ArrayList<Month>();
        months.add(m1);
        months.add(m2);
        months.add(m3);
        months.add(m4);
        months.add(m5);
        months.add(m6);
        months.add(m7);
        months.add(m9);
        months.add(m10);
        months.add(m11);
        months.add(m11);
        System.out.println("********************************************************************");
        System.out.println("******* Afegim el mesos sense Agost i els mostrem  *****************");
        System.out.println("********************************************************************");
        for (int i = 0; i < months.size(); i++) {
            System.out.println("posicio" + i + " " + months.get(i).toString());
        }

        System.out.println("********************************************************************");
        System.out.println("******* Afegim el mes Agost a la posicio 7 i els mostrem ***********");
        System.out.println("********************************************************************");
        months.add(7, m8);

        for (int i = 0; i < months.size(); i++) {
            System.out.println("posicio" + i + " " + months.get(i).toString());
        }

        System.out.println("********************************************************************");
        System.out.println("******* Afegim els mesos Novembre repetits i els mostrem ***********");
        System.out.println("********************************************************************");
        months.add(m11);
        months.add(m11);
        for (int i = 0; i < months.size(); i++) {
            System.out.println("posicio" + i + " " + months.get(i).toString());
        }

        System.out.println("************************************************************************************");
        System.out.println("******* Convertim l'arraylist en hashSet i mostrem que no admet duplicats***********");
        System.out.println("************************************************************************************");

        HashSet<Month> hSetMonths = new HashSet<Month>(months);
        System.out.println("***********\n* Con For *\n***********");
        for (int i = 0; i < hSetMonths.size(); i++) {
            System.out.println(months.get(i).toString());
        }
        System.out.println("****************\n* Con Iterator *\n****************");
        Iterator<Month> iterator = hSetMonths.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

}
