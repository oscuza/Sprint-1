package n3exercici1;

import n3exercici1.comparatorOrdena.NombreAscComparator;
import n3exercici1.comparatorOrdena.NombreDescComparator;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import n3exercici1.comparatorOrdena.CognomAscComparator;
import n3exercici1.comparatorOrdena.CognomDescComparator;
import n3exercici1.comparatorOrdena.DniAscComparator;
import n3exercici1.comparatorOrdena.DniDescComparator;

/**
 *
 * @author OCuevas
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int opc = -1;
        ArrayList<Persona> persones;
        Scanner sc = new Scanner(System.in);

        do {

            System.out.println("1.- Introduir persona.\n"
                    + "2.- Mostrar les persones ordenades per nom (A-Z).\n"
                    + "3.- Mostrar les persones ordenades per nom (Z-A).\n"
                    + "4.- Mostrar les persones ordenades per cognoms (A-Z).\n"
                    + "5.- Mostrar les persones ordenades per cognoms (Z-A).\n"
                    + "6.- Mostrar les persones ordenades per DNI (1-9).\n"
                    + "7.- Mostrar les persones ordenades per DNI (9-1).\n"
                    + "0.- Sortir.");
            opc = sc.nextInt();
            switch (opc) {
                case 1:
                    introduirPersona();
                    break;
                case 2:
                    //llegim les dades del CSV i les afegim a una arryList<Persona> i mostrem per pantalla
                    persones = llegirArxiuCSV();
                    mostrarPersonasNomAZ(persones);
                    break;
                case 3:
                    persones = llegirArxiuCSV();
                    mostrarPersonasNomZA(persones);
                    break;
                case 4:
                    persones = llegirArxiuCSV();
                    mostrarPersonasCognomAZ(persones);
                    break;
                case 5:
                    persones = llegirArxiuCSV();
                    mostrarPersonasCognomZA(persones);
                    break;
                case 6:
                    persones = llegirArxiuCSV();
                    mostrarDniAsc(persones);
                    break;
                case 7:
                    persones = llegirArxiuCSV();
                    mostrarDniDesc(persones);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opcio no valida!!!");

            }
        } while (opc != 0);
    }

    /**
     * Funcio que llegeix arxiu CSV i retorna una llista amb les dades de cada
     * persona.
     *
     * @return ArrayList<Persona>
     */
    private static ArrayList<Persona> llegirArxiuCSV() {
        ArrayList<Persona> persones = new ArrayList<Persona>();
        try {

            String linea;
            File f = new File("dadesCSV.csv");
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            System.out.println("aquiii");
            while ((linea = br.readLine()) != null) {
                String arrayP[] = linea.split(";");
                String nom = arrayP[0];
                String cognom = arrayP[1];
                String DNI = arrayP[2];
                Persona p = new Persona(nom, cognom, DNI);
                persones.add(p);
            }
            fr.close();
            br.close();

        } catch (Exception e) {
            System.out.println("Error amb la lectura del arxiu.");
            System.out.println(e.getMessage());
        }
        return persones;
    }

    /**
     * Demanara nom,cognmo i DNI i guardara les dades al arxiu CSV
     */
    private static void introduirPersona() {
        String nom, cognom, DNI, separador = ";";
        Scanner sc = new Scanner(System.in);

        System.out.println("Nom:");
        nom = sc.nextLine();
        System.out.println("Cognom:");
        cognom = sc.nextLine();
        System.out.println("DNI");
        DNI = sc.nextLine();

        try {
            BufferedWriter fw = new BufferedWriter(new FileWriter("dadesCSV.csv", true));
            fw.write("\n");
            fw.write(nom);
            fw.write(separador);
            fw.write(cognom);
            fw.write(separador);
            fw.write(DNI);

            fw.close();
        } catch (Exception e) {
            System.out.println("Error amb la escritura del arxiu.");
        }
    }

    private static void mostrarListPersones(ArrayList<Persona> persones) {
        for (Persona p : persones) {
            System.out.println(p.toString());
        }
    }

    private static void mostrarPersonasNomAZ(ArrayList<Persona> persones) {
        Collections.sort(persones, new NombreAscComparator());
        mostrarListPersones(persones);

    }

    private static void mostrarPersonasNomZA(ArrayList<Persona> persones) {
        Collections.sort(persones, new NombreDescComparator());
        mostrarListPersones(persones);
    }

    private static void mostrarPersonasCognomAZ(ArrayList<Persona> persones) {
        Collections.sort(persones, new CognomAscComparator());
        mostrarListPersones(persones);
    }

    private static void mostrarPersonasCognomZA(ArrayList<Persona> persones) {
        Collections.sort(persones, new CognomDescComparator());
        mostrarListPersones(persones);
    }

    private static void mostrarDniAsc(ArrayList<Persona> persones) {
        Collections.sort(persones, new DniAscComparator());
        mostrarListPersones(persones);
    }

    private static void mostrarDniDesc(ArrayList<Persona> persones) {
        Collections.sort(persones, new DniDescComparator());
        mostrarListPersones(persones);
    }
}
