package n1exercici1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

/**
 *
 * @author OCuevas
 */
public class Month {

    
   
    public static ArrayList<String> addMonths() {
        ArrayList<String> listMonths = new ArrayList<String>();
        listMonths.add("January");
        listMonths.add("February");
        listMonths.add("March");
        listMonths.add("April");
        listMonths.add("May");
        listMonths.add("June");
        listMonths.add("July");
        listMonths.add("August");
        listMonths.add("September");
        listMonths.add("October");
        listMonths.add("November");
        listMonths.add("December");
        return listMonths;

     
    }

    
    public static void monthsOrdered(ArrayList<String> months, String month) {
        int i = 0;
        while (i < months.size() && month.compareTo(months.get(i)) > 0) {
            i++;
        }
        months.add(i, month);
    }
    public static void showList(ArrayList<String> months) {
        for (String m : months) {
            System.out.println(m);
        }
        System.out.println("\n");
    }

}
