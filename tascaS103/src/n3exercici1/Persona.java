
package n3exercici1;

/**
 *
 * @author OCuevas
 */
public class Persona {
    
    private String nom;
    private String cognom;
    private String DNI;
    
    //Constructor

    public Persona(String nom, String cognom, String DNI) {
        this.nom = nom;
        this.cognom = cognom;
        this.DNI = DNI;
    }
    
    //Getters & Setters

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCognom() {
        return cognom;
    }

    public void setCognom(String cognom) {
        this.cognom = cognom;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    @Override
    public String toString() {
        return "Persona{" + "nom=" + nom + ", cognom=" + cognom + ", DNI=" + DNI + '}';
    }

   
  

}
