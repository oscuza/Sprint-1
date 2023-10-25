package n1exercici3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author OCuevas
 */
/**
 * Donat el fitxer countrties.txt (revisa l'apartat recursos) que conté països i
 * capitals. El programa ha de llegir el fitxer i guardar les dades en un
 * HashMap<String, String>. El programa demana el nom de l’usuari/ària, i
 * després ha de mostrar un país de forma aleatòria, guardat en el HashMap. Es
 * tracta de què l’usuari/ària ha d’escriure el nom de la capital del país en
 * qüestió. Si l’encerta se li suma un punt. Aquesta acció es repeteix 10
 * vegades. Un cop demanades les capitals de 10 països de forma aleatòria,
 * llavors s’ha de guardar en un fitxer anomenat classificacio.txt, e l nom de
 * l’usuari/ària i la seva puntuació.
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int aletarioPais, encerts = 0;
        String nom;
        HashMap<String, String> paisCapital = new HashMap<String, String>();

        paisCapital = hashMapPaisos();
        //demanem el nom
        System.out.println("Digui el seu nom:");
        nom = sc.nextLine();
        for (int i = 0; i < 5; i++) {
            aletarioPais = aleatoriPaisCapital(paisCapital);
            encerts = menuEncerta(paisCapital, aletarioPais);
            encerts++;
        }

       guardaFileJogador(nom,encerts);
    }

    /**
     * funcio que obre un ficher de text. Agafa linea per linea i d'aquesta
     * linea amb la funcio split de String la divideis en dues i la guarda en
     * una array. Seguidament anem afegint a la coleccio els dos element que es
     * van formant en cada array que es va generant.
     *
     * @return hashMap<String,String> amb key que emmagatzema el pais i value la
     * capital
     */
    public static HashMap<String, String> hashMapPaisos() {
        HashMap<String, String> hsMapPaisCapital = new HashMap<String, String>();
        try {
            File fichero = new File("countries.txt");
            FileReader fr = new FileReader(fichero);
            BufferedReader br = new BufferedReader(fr);

            String linea = "";
            while ((linea = br.readLine()) != null) {
                String array[] = linea.split(" ");
                hsMapPaisCapital.put(array[0], array[1]);
            }
            br.close();
        } catch (Exception e) {
            System.out.println("Error de lectura del arxiu");
        }

        return hsMapPaisCapital;
    }

    /**
     * Funcio que agafa una coleccio i retorna una posicio aleatoria en aquesta.
     *
     * @param paisCapital
     * @return un int que sera el index de la posicio a la coleccio que
     * mostrarem
     */
    public static int aleatoriPaisCapital(HashMap<String, String> paisCapital) {
        //Agafem el total de paiso i fem un random d'aquesta quantitat
        Random r = new Random();
        int numPaisos = paisCapital.size();
        int numRandom = r.nextInt(numPaisos);

        return numRandom;
    }

    /**
     * funcio que mostrar un pais aleatori que es troba a dins de la
     * colleccio.Pregunta quina es la capital del pais que es va preguntant
     * aleatoriament.Si encerta mostra missatge de felicitacions i conta las
     * vegades que ha encertat.
     *
     * @param paisCapital
     * @param aleatori
     * @return int numero d'encerts
     */
    public static int menuEncerta(HashMap<String, String> paisCapital, int aleatori) {
        int contador = 0;
        String capital;

        /*
         El numero aleatori que sur del random en donara la posicio 
         del pais que volem mostrar 
         */
        String pais = (String) paisCapital.keySet().toArray()[aleatori];
        System.out.println(pais);
        System.out.println(paisCapital.get(pais));

        // El usuari respon la capital.
        System.out.println("Quina es la capital de " + pais);
        capital = sc.nextLine();

        if (capital.equalsIgnoreCase(paisCapital.get(pais))) {
            System.out.println("Ha encertat!!!");
            contador++;
            System.out.println(contador);
        } else {
            System.out.println("Error!!!");
        }
        return contador;
    }

    private static void guardaFileJogador(String nom, int encerts) {
        try{
            File file=new File("puntuacio.txt");
            if(file.createNewFile()){
                System.out.println("Arxiu creat "+file.getName());
            }
            FileWriter fw= new FileWriter("puntuacio.txt",true);
            fw.write("Jugador= ");
            fw.write(nom);
            fw.write(", Nombre d'encerts: ");
            fw.write(encerts);
            fw.write("\n");
            fw.close();
            
        }catch(Exception e){
            System.out.println("Error al crear l'arxiu");
        }
        
    }

}
