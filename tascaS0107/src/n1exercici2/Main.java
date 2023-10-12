
import n1exercici2.Employee;
import n1exercici2.EmployeeInPerson;
import n1exercici2.EmployeeOnline;

/**
 *
 * @author OCuevas
 */
public class Main {

    @SuppressWarnings("deprecation")
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        double calculateBenzinaByYear;
        EmployeeInPerson empinperson = new EmployeeInPerson("Pep", "Albert", 25);
        calculateBenzinaByYear = empinperson.calculateBenzinaByYear(25);
        System.out.println("Calculating benzine cost total in "+25+ " years ...."+calculateBenzinaByYear+" €.");

        String message;
        EmployeeOnline empOnline = new EmployeeOnline("Charles", "Burton", 25);
        message = empOnline.exampleDeprecated();
        System.out.println(message);
    }

}
