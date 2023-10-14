/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author oscuz
 */
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> llistaDeCadenes = Arrays.asList("cotxe", "porta", "taula", "ordinador", "lluna");

        // Utilitzant Java Lambdas and Streams per filtrar les cadenes que contenen la lletra 'o'
        List<String> cadenesAmbO = filtrarCadenesAmbO(llistaDeCadenes);

        // Imprimint el resultat
        System.out.println("Cadenes que contenen la lletra 'o': " + cadenesAmbO);
    }

    public static List<String> filtrarCadenesAmbO(List<String> llistaDeCadenes) {
        // Utilitzant Lambdas and Streams per filtrar les cadenes amb la lletra 'o'
        return llistaDeCadenes.stream()
                .filter(cadena -> cadena.contains("o"))
                .collect(Collectors.toList());
    }
}

