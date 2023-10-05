package n3exercici1;

import java.util.ArrayList;

/**
 *
 * @author OCuevas
 */
public class GestioButaques {

    private ArrayList<Butaca> butaques;

    public GestioButaques() {
        this.butaques = new ArrayList<Butaca>();
    }

    public ArrayList<Butaca> getButaques() {
        return butaques;
    }

    /**
     * encarregat d’afegir una butaca al vector de butaques. Rebrà com a
     * paràmetre un objecte de la classe Butaca i l’afegirà a l’ArrayList. Si la
     * fila i el seient de la butaca rebuda com a paràmetre coincideixen amb el
     * d’una butaca que ja es trobi a l’ArrayList (s’utilitzarà el mètode
     * cercarButaca), es llençarà l’excepció personalitzada
     * ExcepcioButacaOcupada.
     */
    public void afegirButaca(Butaca butaca) throws ExcepcioButacaOcupada {
        int ocupada;
        ocupada = cercarButaca(butaca.getNombreFila(), butaca.getNombreSeient());
        if (ocupada != -1) {
            throw new ExcepcioButacaOcupada("Butaca ocupada");
        } else {
            this.butaques.add(butaca);

        }
    }

    /**
     * serà l’encarregat d’eliminar una butaca de l’ArrayList de butaques. Rebrà
     * com a paràmetres el número de fila i el seient i l’eliminarà de
     * l’ArrayList. Si la fila i el seient no coincideixen amb el d’una butaca
     * reservada (s’utilitzarà el mètode cercarButaca), llençarà una excepció
     * personalitzada ExcepcioButacaLliure.
     */
    public void eliminarButaca(int fila, int seient) throws ExcepcioButacaLliure {
        int ocupada;
        ocupada = cercarButaca(fila, seient);
        if (ocupada == -1) {
            throw new ExcepcioButacaLliure("Butaca lliure");
        } else {
            this.butaques.remove(ocupada);

        }
    }

    /**
     * Cerca a l’ArrayList de butaques, la butaca que coincideixi amb les dades
     * rebudes com a paràmetre (fila i seient). Si la troba retornarà la posició
     * de la butaca a l’ArrayList i si no la troba retornarà -1.
     */
    public int cercarButaca(int fila, int seient) {
        int posicio = -1;
        for (int i = 0; i < this.butaques.size(); i++) {
            if (butaques.get(i).getNombreFila() == fila && butaques.get(i).getNombreSeient() == seient) {
                posicio = i;
            }
        }
        return posicio;
    }

    public class ExcepcioButacaOcupada extends Exception {

        public ExcepcioButacaOcupada(String message) {
            super(message);
        }

    }

    public class ExcepcioButacaLliure extends Exception {

        public ExcepcioButacaLliure(String message) {
            super(message);
        }

    }
}
