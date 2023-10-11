package n2exercici1;

/**
 *
 * @author formacio
 */
public class Main {

    public static void main(String[] args) {
        Entrada e = new Entrada();

        //InputMismatchException
        e.llegirByte("Quina es la seva edat?-byte-");
        e.llegirInt("Quina es la seva edat?-int-");
        e.llegirFloat("Quina es la seva edat?-float-");
        e.llegirDouble("Qina es la seva edat?-double");

        //exceptions
        e.llegirChar("Escriba un caracter:-char-");
        e.llegirString("Introdueix una paraula:-String- ");
        System.out.println(e.llegirSiNo("Escriu s o n"));

    }

}
