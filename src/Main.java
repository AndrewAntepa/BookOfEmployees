import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EmployeeBook employeeBook = new EmployeeBook(10);

        employeeBook.addEmployee(new Employee("Andrew", "A", 1000));
        employeeBook.addEmployee(new Employee("John", "B", 2000));
        employeeBook.addEmployee(new Employee("Mark", "C", 3000));
        employeeBook.addEmployee(new Employee("Jack", "A", 4000));
        employeeBook.addEmployee(new Employee("Bob", "B", 5000));
        employeeBook.addEmployee(new Employee("Tom", "C", 6000));
        employeeBook.addEmployee(new Employee("Lily", "A", 7000));
        employeeBook.addEmployee(new Employee("Alex", "B", 8000));
        employeeBook.addEmployee(new Employee("Max", "C", 9000));
        employeeBook.addEmployee(new Employee("Maxim", "C", 10000));

        employeeBook.deleteEmployee(4);
        employeeBook.addEmployee(new Employee("Marina", "C", 11000));
        employeeBook.getAllEmployees();

        employeeBook.showFullNames();

        System.out.println(employeeBook.addEmployee(new Employee("Maxim", "C", 9000)));

        System.out.println("\nВся информация о сотрудниках:");
        employeeBook.getAllEmployees();
        System.out.println("\nВся информация о сотрудниках в отделе C:\n" +employeeBook.getAllEmployees("C"));

        System.out.println("\nСумма затрат на зарплату: " + employeeBook.sumOfAllRates());
        System.out.println("\nСумма затрат на зарплату в отделе A: " + employeeBook.sumOfAllRates("A") + "\n");

        System.out.println(employeeBook.findMinSalary());
        System.out.println(employeeBook.findMinSalary("B") + "\n");

        System.out.println(employeeBook.findMaxSalary());
        System.out.println(employeeBook.findMaxSalary("A") + "\n");

        System.out.println("Средняя зарплата: " + employeeBook.averageSalary());
        System.out.println("Средняя зарплата в отделе C: " + employeeBook.averageSalary("C") + "\n");

        employeeBook.indexTheSalary(15);
        employeeBook.getAllEmployees();
        employeeBook.indexTheSalary("A", 10);
        employeeBook.getAllEmployees();

        System.out.println("Количество сотрудников в отделе C: " + employeeBook.countEmployeesInDepartment("C") + "\n");

        employeeBook.employeesWithMoreSalary(7000);
        employeeBook.employeesWithLessSalary(4000);
        System.out.println();

        System.out.println(employeeBook.getEmployeeById(9));
    }
}