package n1exercici2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author OCuevas
 */
public class Main {

    public static void main(String[] args) {
        List<String> listStrings = new ArrayList<String>();
        listStrings.add("hola");
        listStrings.add("Pepe");
        listStrings.add("Mesa");
        listStrings.add("Pajaro");
        listStrings.add("Calcetin");
        listStrings.add("Caracol");
        
        List<String> listFilterd=filterCharacter(listStrings);
        
        for(String s:listFilterd){
            System.out.println(s.toString());
        }
            }

    public static List<String> filterCharacter(List<String> listStrings) {

        return listStrings.stream()
                .filter(cadena -> cadena.contains("o")&&cadena.length()>5)
                .collect(Collectors.toList());

    }
}
