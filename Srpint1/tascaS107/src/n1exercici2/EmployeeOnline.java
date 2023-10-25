package n1exercici2;

/**
 *
 * @author OCuevas
 */
public class EmployeeOnline extends Employee {

    final double INTERNETRATE = 45.50;

    public EmployeeOnline(String name, String lastName, int priceHour) {
        super(name, lastName, priceHour);
    }

    @Override
    public double salaryCalculate(int workMonth) {
        double result;
        result = (super.getPriceHour() * workMonth) + INTERNETRATE;
        return result;
    }

    @Override
    public String toString() {
        return "EmployeeOnline: Mr/Miss " + super.getLastName() + ", your hourly price is " + super.getPriceHour() + " and price to flat rate is " + INTERNETRATE;
    }
    
    @Deprecated
    public String exampleDeprecated(){
        String result;
       result="This funtion is deprectated.";
       return result;
    }
}
