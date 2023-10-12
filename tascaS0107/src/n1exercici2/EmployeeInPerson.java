package n1exercici2;

/**
 *
 * @author OCuevas
 */
public class EmployeeInPerson extends Employee {

    private static double benzina ;

    public EmployeeInPerson(String name, String lastName, int priceHour) {
        super(name, lastName, priceHour);
        this.benzina=100.25;

    }

    @Override
    public double salaryCalculate(int workMonth) {
        double result;
        result = (super.getPriceHour() * workMonth) + benzina;
        return result;
    }

    @Override
    public String toString() {
        return "EmployeeInPerson: Mr/Miss " + super.getLastName() + ", your hourly price is " + super.getPriceHour() + " and price of benzine is " + benzina;
    }

    @Deprecated
    public double calculateBenzinaByYear(int years) {
        double result;
        result = benzina * years;
        return result;
    }

   
}
