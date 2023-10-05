package n1exercici2;

import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author OCuevas
 */
public class CalculDni {

    public static void main(String[] args) {
        String letter;
        letter = calculateLetterDni(88888888);
        System.out.println("Letter of your document is: " + letter);
    }

    public static String calculateLetterDni(int dni) {
        int mod;
        HashMap<Integer, String> letterDni = new HashMap<Integer, String>();
        String letter = "";

        letterDni = assignletterToDni(letterDni);
        mod = dni % 23;

        for (HashMap.Entry<Integer, String> l : letterDni.entrySet()) {
            if (l.getKey() == mod) {
                letter = l.getValue();
            }
        }

        return letter;
    }

    public static HashMap<Integer, String> assignletterToDni(HashMap<Integer, String> letraDni) {

        String[] letter = {"T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B", "N", "J", "Z", "S", "Q", "V", "H", "L", "C", "K", "E"};
        for (int i = 0; i < 23; i++) {
            letraDni.put(i, letter[i]);
        }
        return letraDni;
    }

}
