public class Main {
    public static void main(String[] args) {
        Employee[] employees = new Employee[10];
        employees[0] = new Employee("Волкова Мария Романовна", "1", 300000);
        employees[1] = new Employee("Никитин Никита Платонович", "2", 244362);
        employees[2] = new Employee("Тарасов Максим Даниилович", "3", 323463);
        employees[3] = new Employee("Ушаков Богдан Георгиевич", "4", 32324);
        employees[4] = new Employee("Калачева Николь Кирилловна", "5", 15744);
        employees[5] = new Employee("Сурков Александр Ильич", "1", 25625);
        employees[6] = new Employee("Белов Виктор Тимофеевич", "2", 457774);
        employees[7] = new Employee("Масленников Тихон Артемьевич", "3", 254654);
        employees[8] = new Employee("Зайцева Анастасия Михайловна", "4", 25644);
        employees[9] = new Employee("Антонов Даниил Никитич", "5", 45675);

        System.out.println(getAllEmployees(employees));
        System.out.println("Сумма затрат на ЗП в месяц равна " + sumOfAllRates(employees));
        System.out.println(findMinSalary(employees));
        System.out.println(findMaxSalary(employees));
        System.out.println("Средняя зарплата равна " + averageSalary(employees));
        showFullNames(employees);

        indexTheSalary(employees, 10);
        System.out.println(getAllEmployees(employees));

    }

    public static String getAllEmployees(Employee[] employees){
        if(employees.length == 0) return "Сотрудники не найдены";
        StringBuilder allEmployees = new StringBuilder();
        for(Employee employee : employees){
            allEmployees.append(employee.toString()).append("\n");
        }
        return allEmployees.toString();
    }

    public static int sumOfAllRates(Employee[] employees){
        if(employees.length == 0) return -1;
        int fullRate = 0;
        for(Employee employee : employees){
            fullRate += employee.getSalary();
        }
        return fullRate;
    }

    public static String findMinSalary(Employee[] employees){
        if(employees.length == 0) return "Сотрудники не найдены";
        int min = employees[0].getSalary();
        String employeeWithMinSalary = "";
        for(Employee employee : employees){
            if(employee.getSalary() < min){
                min = employee.getSalary();
                employeeWithMinSalary = employee.getFullName() + ", id = " + employee.getId();
            }
        }
        return "Сотрудник с минимальной ЗП: " + employeeWithMinSalary;
    }

    public static String findMaxSalary(Employee[] employees){
        if(employees.length == 0) return "Сотрудники не найдены";
        int max = 0;
        String employeeWithMinSalary = "";
        for(Employee employee : employees){
            if(employee.getSalary() > max){
                max = employee.getSalary();
                employeeWithMinSalary = employee.getFullName() + ", id = " + employee.getId();
            }
        }
        return "Сотрудник с максимальной ЗП: " + employeeWithMinSalary;
    }

    public static double averageSalary(Employee[] employees){
        return (double) sumOfAllRates(employees) / employees.length;
    }

    public static void showFullNames(Employee[] employees){
        if(employees.length == 0) System.out.println("Сотрудники не найдены");
        else {
            System.out.println("Все сотрудники:");
            for (Employee employee : employees) {
                System.out.println(employee.getFullName());
            }
        }
    }

    public static void indexTheSalary(Employee[] employees, int index){
        for(Employee employee : employees){
            int salary = employee.getSalary();
            int newSalary = salary * (100 + index) / 100;
            employee.setSalary(newSalary);
        }
    }
}