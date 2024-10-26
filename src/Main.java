import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Сколько сотрудников будет?");

        EmployeeBook employeeBook = new EmployeeBook(scanner.nextInt());

        System.out.println("""
                1. Добавление сотрудника
                2. Удаление сотрудника
                3. Получить все данные сотрудников
                4. Получить имена сотрудников
                5. Сумма всех расходов на ЗП
                6. Минимальная ЗП
                7. Максимальная ЗП
                8. Средняя ЗП
                9. Проиндексировать ЗП
                10. Количество сотрудников в отделе
                11. Сотрудники, чья ЗП меньше...
                12. Сотрудники, чья ЗП Больше...
                13. Найти сотрудника по ID
                14. Выйти""");

        int mainAction = scanner.nextInt();
        while (mainAction != 0){
            switch (mainAction){
                case 1:{
                    System.out.println("Введите ФИО, отдел и зарплату:");
                    String fullName = scanner.nextLine(), department = scanner.nextLine();
                    int salary = scanner.nextInt();
                    employeeBook.addEmployee(fullName, department, salary);
                    break;
                }
                case 2:{
                    System.out.println("Введите ID");
                    int id = scanner.nextInt();
                    employeeBook.deleteEmployee(id);
                    break;
                }
                case 3:{
                    System.out.println("1. Всех сотрудников\n2.Сотрудников из отдела");
                    int action = scanner.nextInt();
                    if(action == 1){
                        System.out.println(employeeBook.getAllEmployees());
                    } else {
                        System.out.println("Какой отдел?");
                        String department = scanner.nextLine();
                        System.out.println(employeeBook.getAllEmployees(department));
                    }
                    break;
                }
                case 4:{
                    employeeBook.showFullNames();
                    break;
                }
                case 5:{
                    System.out.println("1. Всех сотрудников\n2.Сотрудников из отдела");
                    int action = scanner.nextInt();
                    if(action == 1) {
                        System.out.println("Все расходы на ЗП: \n" + employeeBook.sumOfAllRates());
                    } else {
                        System.out.println("Какой отдел?");
                        String department = scanner.nextLine();
                        System.out.println("Все расходы на ЗП: \n" + employeeBook.sumOfAllRates(department));
                    }
                    break;
                }
                case 6:{
                    System.out.println("1. Всех сотрудников\n2.Сотрудников из отдела");
                    int action = scanner.nextInt();
                    if(action == 1){
                        System.out.println(employeeBook.findMinSalary());
                    } else {
                        System.out.println("Какой отдел?");
                        String department = scanner.nextLine();
                        System.out.println(employeeBook.findMinSalary(department));
                    }
                    break;
                }
                case 7:{
                    System.out.println("1. Всех сотрудников\n2.Сотрудников из отдела");
                    int action = scanner.nextInt();
                    if(action == 1){
                        System.out.println(employeeBook.findMaxSalary());
                    } else {
                        System.out.println("Какой отдел?");
                        String department = scanner.nextLine();
                        System.out.println(employeeBook.findMaxSalary(department));
                    }
                    break;
                }
                case 8:{
                    System.out.println("1. Всех сотрудников\n2.Сотрудников из отдела");
                    int action = scanner.nextInt();
                    if(action == 1){
                        System.out.println(employeeBook.averageSalary());
                    } else {
                        System.out.println("Какой отдел?");
                        String department = scanner.nextLine();
                        System.out.println(employeeBook.averageSalary(department));
                    }
                    break;
                }
                case 9:{
                    System.out.println("1. Всех сотрудников\n2.Сотрудников из отдела");
                    int action = scanner.nextInt();
                    System.out.println("На какой процент?");
                    int index = scanner.nextInt();
                    if(action == 1){
                        employeeBook.indexTheSalary(index);
                    } else {
                        String department = scanner.nextLine();
                        employeeBook.indexTheSalary(department, index);
                    }
                    break;
                }
                case 10:{
                    System.out.println("В каком отделе?");
                    String department = scanner.nextLine();
                    System.out.println(employeeBook.countEmployeesInDepartment(department));
                    break;
                }
                case 11:{
                    System.out.println("Меньше какой зп?");
                    int salary = scanner.nextInt();
                    employeeBook.employeesWithLessSalary(salary);
                    break;
                }
                case 12:{
                    System.out.println("больше какой зп?");
                    int salary = scanner.nextInt();
                    employeeBook.employeesWithMoreSalary(salary);
                    break;
                }
                case 13:{
                    System.out.println("Введите ID");
                    int id = scanner.nextInt();
                    System.out.println(employeeBook.getEmployeeById(id));
                }
                case 14:{
                    mainAction = 0;
                }
            }
        }
    }
}