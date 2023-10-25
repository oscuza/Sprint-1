
package n3exercici1;

/**
 *
 * @author OCuevas
 */
public class Smartphone implements Telephone {

    @Override
    public void call() {
        System.out.println("Smartphone calling......");
    }
    
    public void takePictures(){
        System.out.println("Smartphone taking a picture....");
    }
}
