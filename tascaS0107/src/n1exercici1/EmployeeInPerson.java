package n1exercici1;

/**
 *
 * @author OCuevas
 */
public class EmployeeInPerson extends Employee {

    private static double benzina = 100.25;

    public EmployeeInPerson(String name, String lastName, int priceHour) {
        super(name, lastName, priceHour);

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

  
}
