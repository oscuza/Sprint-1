package n1Exercici1;

import java.util.List;

/**
 *
 * @author OCuevas
 */
public class Venda {

    private List<Producte> productes;
    private double preuTotal;

    public Venda(List<Producte> productes) {
        this.productes = productes;

    }

    public List<Producte> getProductes() {
        return productes;
    }

    public void setProductes(List<Producte> productes) {
        this.productes = productes;
    }

    public double getPreuTotal() {
        return this.preuTotal;
    }

    public void setPreuTotal(double preuTotal) {
        this.preuTotal = preuTotal;
    }

    @Override
    public String toString() {
        return "Venda{" + "productes=" + productes + ", preuTotal=" + this.preuTotal + '}';
    }

    public void calcularTotal() throws VendaBuidaException {
        if (!this.productes.isEmpty()) {
            for (Producte p : this.productes) {
                this.preuTotal += p.getPreu();
            }
        } else {
            throw new VendaBuidaException("Per fer una venda primer has d’afegir productes.");
        }

    }
}
