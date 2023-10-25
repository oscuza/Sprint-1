package n1exercici1;

/**
 *
 * @author OCuevas
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Employee employeeOnline = new EmployeeOnline("James", "Bond", 25);
        double salaryEmpOnline = employeeOnline.salaryCalculate(35);
        System.out.println(employeeOnline.toString() + "\n\t\tyour salary this month: " + salaryEmpOnline);

        Employee employeeInPerson = new EmployeeInPerson("Albert", "Right", 35);
        double salaryEmpPerson = employeeInPerson.salaryCalculate(45);
        System.out.println(employeeInPerson.toString() + "\n\t\tyour salary this month: " + salaryEmpPerson);
    }

}
