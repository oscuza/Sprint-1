
package n3exercici1;

/**
 *
 * @author OCuevas
 */
public class Butaca {
    private int nombreFila;
    private int nombreSeient;
    private String nomPersona;

    public Butaca(int nombreFila, int nombreSeient, String nomPersona) {
        this.nombreFila = nombreFila;
        this.nombreSeient = nombreSeient;
        this.nomPersona = nomPersona;
    }

    public int getNombreFila() {
        return nombreFila;
    }

    public void setNombreFila(int nombreFila) {
        this.nombreFila = nombreFila;
    }

    public int getNombreSeient() {
        return nombreSeient;
    }

    public String getNomPersona() {
        return nomPersona;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object altreButaca) {
      Butaca butaca=(Butaca) altreButaca;
      boolean iguals;
      
      if(this.nombreFila==butaca.nombreFila&& this.nombreSeient==butaca.nombreSeient){
          iguals=true;
      }else{
          iguals=false;
      }
        return iguals;
    }

    @Override
    public String toString() {
        return "Fila: " + this.nombreFila + ", Seient: " + this.nombreSeient + ", Persona: " + this.nomPersona;
    }

   
    
    
    
}
