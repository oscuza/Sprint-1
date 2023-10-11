package n3exercici1;

/**
 *
 * @author OCuevas
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Smartphone smartphone1 = new Smartphone();
        smartphone1.call();
        smartphone1.takePictures();

        System.out.println("El mètode limitat per la interfície Telefon, de la classe Generica, pot cridar al mètode ferFotos()?");
        System.out.println("No, perquè el mètode fer fotos és propi dels objectes creats de la classe smartphone ");
    }

}
