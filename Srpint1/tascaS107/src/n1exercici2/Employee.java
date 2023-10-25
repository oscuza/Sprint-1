package n1exercici2;
/**
 *
 * @author OCuevas
 */
public class Employee {

    private String name;
    private String lastName;
    private int priceHour;

    public Employee(String name, String lastName, int priceHour) {
        this.name = name;
        this.lastName = lastName;
        this.priceHour = priceHour;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getPriceHour() {
        return priceHour;
    }

    public void setPriceHour(int priceHour) {
        this.priceHour = priceHour;
    }

    
    
    public double salaryCalculate(int workHours) {
        double result;
        result = this.priceHour * workHours;
        return result;
    }
}
