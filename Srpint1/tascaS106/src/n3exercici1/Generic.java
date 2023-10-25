package n3exercici1;

/**
 *
 * @author OCuevas
 */
public class Generic {
    
    public <T extends Telephone> void method1(T telephone){
        telephone.call();
        
    }
    
    public <T extends Smartphone> void metho2(T smartphone){
        smartphone.call();
        smartphone.takePictures();
    }
}
