package n3exercici1;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author OCuevas
 */
public class Cine {

    private int nombreFiles;
    private int nombreSeientsFila;
    private GestioButaques gestioButaques;

    public Cine() {
        gestioButaques = new GestioButaques();
        demanarDadesInicials();
    }

    public void iniciar() {
        int opc = -1;

        do {
            opc = menu();
            switch (opc) {

                case 1:
                    mostrarButaques();
                    break;
                case 2:
                    mostrarButaquesPersona();
                    break;
                case 3:
                    reservarButaca();
                    break;
                case 4:
                    anularReserva();
                    break;
                case 5:
                    anularReservaPersona();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opcio no valida.");
            }
        } while (opc != 0);

    }

    /**
     * mostrarà les opcions del menú principal a l’usuari/ària, li demanarà el
     * número de l’opció escollida i el retornarà.
     *
     * @return int amb el numero seleccionat
     */
    public int menu() {
        int sel = -1;
        Scanner sc = new Scanner(System.in);

        System.out.println("1.- Mostrar totes les butaques reservades.\n"
                + "2.- Mostrar les butaques reservades per una persona.\n"
                + "3.- Reservar una butaca.\n"
                + "4.- Anul·lar la reserva d’una butaca.\n"
                + "5.- Anul·lar totes les reserves d’una persona.\n"
                + "0.- Sortir.\n"
                + "**** Seleccionar una opcio ****");
        sel = sc.nextInt();

        return sel;
    }

    /**
     * Mostra les butques reservades
     */
    public void mostrarButaques() {
        if (!gestioButaques.getButaques().isEmpty()) {
            for (Butaca b : gestioButaques.getButaques()) {
                System.out.println(b.toString());
            }
        } else {
            System.out.println("Cap butaca reservada.");
        }

    }

    /**
     * Demana el nom de la persona que ha fet la reserva i mostra totes les
     * butaques reservades per aquesta persona.
     */
    public void mostrarButaquesPersona() {
        String nom;
        boolean exist = false;
        Scanner sc = new Scanner(System.in);
        if (!gestioButaques.getButaques().isEmpty()) {
            System.out.println("Nom de la persona que ha fet la reserva");
            nom = sc.nextLine();
            for (Butaca b : gestioButaques.getButaques()) {
                if (b.getNomPersona().equals(nom)) {
                    System.out.println(b.toString());
                    exist = true;
                }
            }
            if (exist == false) {
                System.out.println("No hi cap butaca reservada per aquest nom.");
            }
        } else {
            System.out.println("Cap butaca reservada.");
        }

    }

    /**
     * Demana a l’usuari/ària un número de fila (crida al mètode introduirFila),
     * un número de seient (crida al mètode introduirSeient), el nom de la
     * persona que fa la reserva (crida al mètode introduirPersona) i reserva la
     * butaca.
     */
    public void reservarButaca() {

        int numFila, numSeient;
        String nom;
        Butaca b;
        try {
            numFila = introduirFila();
            numSeient = introduirSeient();
            nom = introduirPersona();
            b = new Butaca(numFila, numSeient, nom);

            this.gestioButaques.afegirButaca(b);
        } catch (GestioButaques.ExcepcioButacaOcupada | ExcepcioFilaIncorrecta | ExcepcioSeientIncorrecte | ExcepcioNomPersonaIncorrecte ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Demana a l’usuari/ària un número de fila (crida al mètode introduirFila),
     * un número de seient (crida al mètode introduirSeient) i elimina la
     * reserva de la butaca.
     */
    public void anularReserva() {

        try {
            int numFila, numSeient;
            numFila = introduirFila();
            numSeient = introduirSeient();
            this.gestioButaques.eliminarButaca(numFila, numSeient);
        } catch (ExcepcioFilaIncorrecta | ExcepcioSeientIncorrecte | GestioButaques.ExcepcioButacaLliure ex) {
            System.out.println(ex.getMessage());
        }

    }

    /**
     * Demana a l’usuari/ària el nom de la persona (crida al mètode
     * introduirPersona) i elimina les butaques reservades per la persona
     * introduïda.
     */
    public void anularReservaPersona() {
        try {
            String nom;
            int i;

            if (!this.gestioButaques.getButaques().isEmpty()) {
                i = 0;
                nom = introduirPersona();

                while (i < this.gestioButaques.getButaques().size()) {
                    if (nom.equals(this.gestioButaques.getButaques().get(i).getNomPersona())) {
                        System.out.println("Eliminant.... " + this.gestioButaques.getButaques().get(i).toString());
                        this.gestioButaques.getButaques().remove(i);
                    } else {
                        i++;
                    }
                }
            } else {
                System.out.println("No hi ha cap reserva de butaques en aquest cine.");
            }

        } catch (ExcepcioNomPersonaIncorrecte ex) {
            System.out.println(ex.getMessage());
        }

    }

    /**
     * demana a l’usuari/ària el nom de la persona i el retorna si és correcte.
     * Si conté números, llença una excepció personalitzada
     * ExcepcioNomPersonaIncorrecte.
     */
    public String introduirPersona() throws ExcepcioNomPersonaIncorrecte {
        String nom;
        boolean seguir = false;
        Scanner sc = new Scanner(System.in);
        do {

            System.out.println("Nom de la persona que fa la reserva:");
            nom = sc.nextLine();

            for (char c : nom.toCharArray()) {
                if (Character.isDigit(c)) {
                    seguir = true;
                    throw new ExcepcioNomPersonaIncorrecte("El nom solament pot contenir lletres");
                }
            }
            return nom;
        } while (!seguir);

    }

    /**
     * Demana a l’usuari/ària el nombre de files i seients i els guarda en els
     * atributs corresponents.
     */
    public void demanarDadesInicials() {
        int numFiles, numSeients;
        boolean seguir = false;
        Scanner sc = new Scanner(System.in);
        do {
            seguir=false;
            try {
                System.out.println("Nombre de files totals que tindra el Cinema?");
                numFiles = sc.nextInt();
                this.nombreFiles = numFiles;
                System.out.println("Nombre de seints per fila que tindra el Cinema?");
                numSeients = sc.nextInt();
                this.nombreSeientsFila = numSeients;
            } catch (InputMismatchException i) {
                System.out.println("Nomes es pot intrudir numeros.");
                sc.nextLine();
                seguir = true;
            }

        } while (seguir);
    }

    /**
     * Demana el nombre de fila, si aquest està entre 1 i el nombre de files
     * totals, el retorna. Si no, retorna una excepció personalitzada
     * ExcepcioFilaIncorrecta.
     */
    public int introduirFila() throws ExcepcioFilaIncorrecta {
        int numF, fila = -1;
        Scanner sc = new Scanner(System.in);
        System.out.println("Numero de Fila?");
        numF = sc.nextInt();
        if (numF >= 1 && numF <= this.nombreFiles) {
            fila = numF;

        } else {
            throw new ExcepcioFilaIncorrecta("Aquest num de fila no existeix en aquest cine.");

        }
        return fila;
    }

    /**
     * Demana el seient, si el número està entre 1 i el nombre total de seients,
     * el retorna. Si no, retorna una excepció del tipus
     * ExcepcioSeientIncorrecte.
     */
    public int introduirSeient() throws ExcepcioSeientIncorrecte {
        int numS, fila = -1;
        Scanner sc = new Scanner(System.in);
        System.out.println("Numero de Seient?");
        numS = sc.nextInt();
        if (numS >= 1 && numS <= this.nombreSeientsFila) {
            fila = numS;
        } else {
            throw new ExcepcioSeientIncorrecte("Aquest num de seient no existeix en aquest cine.");
        }
        return fila;
    }

    public class ExcepcioNomPersonaIncorrecte extends Exception {

        public ExcepcioNomPersonaIncorrecte(String missatge) {
            super(missatge);
        }
    }

    public class ExcepcioFilaIncorrecta extends Exception {

        public ExcepcioFilaIncorrecta(String missatge) {
            super(missatge);
        }
    }

    public class ExcepcioSeientIncorrecte extends Exception {

        public ExcepcioSeientIncorrecte(String missatge) {
            super(missatge);
        }
    }
}
