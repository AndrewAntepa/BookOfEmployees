public class EmployeeBook {
    private Employee[] employees;

    public EmployeeBook(){
        employees = new Employee[10];
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
    }

    //получает всех сотрудников
    public String getAllEmployees(){
        if(employees.length == 0) return "Сотрудники не найдены";
        StringBuilder allEmployees = new StringBuilder();
        for(Employee employee : employees){
            allEmployees.append(employee.toString()).append("\n");
        }
        return allEmployees.toString();
    }
    //получает всех сотрудников в отделе
    public void getAllEmployees(String department){
        System.out.println("Сотрудники из отдела " + department + ":");
        for(Employee employee : employees){
            if(employee.getDepartment().equals(department)){
                System.out.println(employee.getFullName() + ", id = " + employee.getId() + ", зарплата: " + employee.getSalary());
            }
        }
    }

    //сумма затрат на зп
    public int sumOfAllRates(){
        if(employees.length == 0) return -1;
        int fullRate = 0;
        for(Employee employee : employees){
            fullRate += employee.getSalary();
        }
        return fullRate;
    }

    //сумма затрат на зп в отделе
    public int sumOfAllRates(String department){
        if(employees.length == 0) return -1;
        int fullSalary = 0;
        for(Employee employee : employees){
            if (employee.getDepartment().equals(department)){
                fullSalary += employee.getSalary();
            }
        }
        return fullSalary;
    }

    //минимальная зарплата
    public String findMinSalary(){
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

    //минимальная зарплата в отделе
    public String findMinSalary(String department){
        if(employees.length == 0) return "Сотрудники не найдены";
        int min = employees[0].getSalary();
        String employeeWithMinSalary = "";
        for(Employee employee : employees){
            if(employee.getSalary() < min && employee.getDepartment().equals(department)){
                min = employee.getSalary();
                employeeWithMinSalary = employee.getFullName() + ", id = " + employee.getId();
            }
        }
        return "Сотрудник с минимальной ЗП в отделе " + department + ": " + employeeWithMinSalary;
    }

    //максимальная зп
    public String findMaxSalary(){
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

    //максимальная зп в отделе
    public String findMaxSalary(String department){
        if(employees.length == 0) return "Сотрудники не найдены";
        int max = 0;
        String employeeWithMinSalary = "";
        for(Employee employee : employees){
            if(employee.getSalary() > max && employee.getDepartment().equals(department)){
                max = employee.getSalary();
                employeeWithMinSalary = employee.getFullName() + ", id = " + employee.getId();
            }
        }
        return "Сотрудник с минимальной ЗП в отделе " + department + ": " + employeeWithMinSalary;
    }

    //средня зп
    public double averageSalary(){
        return (double) sumOfAllRates() / employees.length;
    }

    //средня зп в отделе
    public double averageSalary(String department){
        int fullSalary = sumOfAllRates(department);
        int countEmployees = countEmployeesInDepartment(department);
        return (double) fullSalary / countEmployees;
    }

    //получить имена сотрудников
    public void showFullNames(){
        if(employees.length == 0) System.out.println("Сотрудники не найдены");
        else {
            System.out.println("Все сотрудники:");
            for (Employee employee : employees) {
                System.out.println(employee.getFullName());
            }
        }
    }

    //проиндексировать зп
    public void indexTheSalary(int index){
        for(Employee employee : employees){
            int salary = employee.getSalary();
            int newSalary = salary * (100 + index) / 100;
            employee.setSalary(newSalary);
        }
    }

    //проиндексировать зп в отделе
    public void indexTheSalary(String department, int index){
        for(Employee employee : employees){
            if(employee.getDepartment().equals(department)) {
                int salary = employee.getSalary();
                int newSalary = salary * (100 + index) / 100;
                employee.setSalary(newSalary);
            }
        }
    }

    //посчитать кол-во в отделе
    public int countEmployeesInDepartment(String department){
        int countEmployees = 0;
        for(Employee employee : employees){
            if(employee.getDepartment().equals(department)){
                countEmployees++;
            }
        }
        return countEmployees;
    }

    //у кого зп меньше
    public void employeesWithLessSalary(int salary){
        System.out.println("Сотрудники, чья зарплата меньше " + salary + ":");
        for (Employee employee : employees){
            if(employee.getSalary() < salary){
                System.out.println(employee.getFullName() + ", id = " + employee.getId() + ", зарплата: " + employee.getSalary());
            }
        }
    }

    //у кого зп больше
    public void employeesMoreLessSalary(int salary){
        System.out.println("Сотрудники, чья зарплата больше " + salary + ":");
        for (Employee employee : employees){
            if(employee.getSalary() > salary){
                System.out.println(employee.getFullName() + ", id = " + employee.getId() + ", зарплата: " + employee.getSalary());
            }
        }
    }
}
