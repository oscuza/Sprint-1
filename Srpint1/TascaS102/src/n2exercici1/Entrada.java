package n2exercici1;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author formacio
 */
public class Entrada {

    static Scanner sc = new Scanner(System.in);

    //Mètodes a implantar capturant l’excepció de la classe InputMismatchException
    public static byte llegirByte(String missatge) {
        byte num = -1;
        boolean salir = false;
        do {
            try {
                System.out.println(missatge);
                num = sc.nextByte();
                salir = true;
                return num;
            } catch (InputMismatchException e) {
                System.out.println("Error de format");
                sc.nextLine();
            }
        } while (salir == false);
        return num;
    }

    public static int llegirInt(String missatge) {
        int num = -1;
        boolean salir = false;
        do {
            try {
                System.out.println(missatge);
                num = sc.nextInt();
                salir = true;
                return num;
            } catch (InputMismatchException e) {
                System.out.println("Error de format");
                sc.nextLine();
            }
        } while (salir == false);
        return num;
    }

    public static float llegirFloat(String missatge) {
        float num = -1;
        boolean salir = false;
        do {
            try {
                System.out.println(missatge);
                num = sc.nextFloat();
                salir = true;
                return num;
            } catch (InputMismatchException e) {
                System.out.println("Error de format");
                sc.nextLine();
            }
        } while (salir == false);
        return num;
    }

    public static double llegirDouble(String missatge) {
        double num = -1;
        boolean salir = false;
        do {
            try {
                System.out.println(missatge);
                num = sc.nextDouble();
                salir = true;
                return num;
            } catch (InputMismatchException e) {
                System.out.println("Error de format");
                sc.nextLine();
            }
        } while (salir == false);
        return num;
    }

    // Mètodes a implantar capturant l’excepció de la classe Exception:
    public static char llegirChar(String missatge) {
        char c = ' ';
        boolean salir = false;

        do {
            try {
                System.out.println(missatge);
                c = sc.next(".").charAt(0);
                salir = true;
                sc.nextLine();
                return c;

            } catch (Exception e) {
                System.out.println("Error de format");
                sc.nextLine();
            }
        } while (salir == false);

        return c;

    }

    public static String llegirString(String missatge) {
        String s = "";
        boolean salir = false;

        do {
            try {
                System.out.println(missatge);
                s = sc.nextLine();

                if (s.equals("oscar")) {
                    throw new Exception();
                }
                salir = true;
                return s;
            } catch (Exception e) {
                System.out.println("Error de format ");
            }
        } while (salir == false);
        return s;
    }

    /*si l’usuari/ària introdueix “s”, retorna “true”, 
      si l’usuari introdueix “n”, retorna “false”.
     */
    public static boolean llegirSiNo(String missatge) {
        boolean b = true;
        char resposta = ' ';
        do {
            try {
                System.out.println(missatge);
                resposta = sc.next(".").charAt(0);
                switch (resposta) {
                    case 's':
                        break;
                    case 'n':
                        b = false;
                        break;
                    default:
                        System.out.println("Ha de pulsar 's' o 'n' ");
                        break;
                }

            } catch (Exception e) {
                System.out.println("Error de format");
                sc.nextLine();
            }
        } while (resposta != 's' && resposta != 'n');
        return b;
    }
}
