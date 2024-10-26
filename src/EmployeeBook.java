public class EmployeeBook {
    private Employee[] employees;

    public EmployeeBook(int n){
        employees = new Employee[n];
    }

    //получает всех сотрудников
    public String getAllEmployees(){
        if(isNoEmployees()) return "Сотрудники не найдены";
        StringBuilder allEmployees = new StringBuilder();
        for(Employee employee : employees){
            allEmployees.append(employee).append("\n");
        }
        return allEmployees.toString();
    }
    //получает всех сотрудников в отделе
    public String getAllEmployees(String department){
        if(isNoEmployees()) return "Сотрудников нет";
        StringBuilder allEmployees = new StringBuilder();
        allEmployees.append("Сотрудники из отдела ").append(department).append(":");
        for(Employee employee : employees){
            if(employee.getDepartment().equals(department)){
                allEmployees.append(employee).append("\n");
            }
        }
        return allEmployees.toString();
    }

    //сумма затрат на зп
    public int sumOfAllRates(){
        if(isNoEmployees()) return -1;
        int fullRate = 0;
        for(Employee employee : employees){
            fullRate += employee.getSalary();
        }
        return fullRate;
    }

    //сумма затрат на зп в отделе
    public int sumOfAllRates(String department){
        if(isNoEmployees()) return -1;
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
        if(isNoEmployees()) return "Сотрудники не найдены";
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
        if(isNoEmployees()) return "Сотрудники не найдены";
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
        if(isNoEmployees()) return "Сотрудники не найдены";
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
        if(isNoEmployees()) return "Сотрудники не найдены";
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
        if(isNoEmployees()) return -1;
        return (double) sumOfAllRates() / employees.length;
    }

    //средня зп в отделе
    public double averageSalary(String department){
        if(isNoEmployees()) return -1;
        int fullSalary = sumOfAllRates(department);
        int countEmployees = countEmployeesInDepartment(department);
        return (double) fullSalary / countEmployees;
    }

    //получить имена сотрудников
    public void showFullNames(){
        if(isNoEmployees()) System.out.println("Сотрудники не найдены");
        else {
            System.out.println("Все сотрудники:");
            for (Employee employee : employees) {
                System.out.println(employee.getFullName());
            }
        }
    }

    //проиндексировать зп
    public void indexTheSalary(int index){
        if(isNoEmployees()) return;
        for(Employee employee : employees){
            int salary = employee.getSalary();
            int newSalary = salary * (100 + index) / 100;
            employee.setSalary(newSalary);
        }
    }

    //проиндексировать зп в отделе
    public void indexTheSalary(String department, int index){
        if(isNoEmployees()) return;
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
        if(isNoEmployees()) return -1;
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
        if(isNoEmployees()) return;
        System.out.println("Сотрудники, чья зарплата меньше " + salary + ":");
        for (Employee employee : employees){
            if(employee.getSalary() < salary){
                System.out.println(employee.getFullName() + ", id = " + employee.getId() + ", зарплата: " + employee.getSalary());
            }
        }
    }

    //у кого зп больше
    public void employeesWithMoreSalary(int salary){
        if(isNoEmployees()) return;
        System.out.println("Сотрудники, чья зарплата больше " + salary + ":");
        for (Employee employee : employees){
            if(employee.getSalary() > salary){
                System.out.println(employee.getFullName() + ", id = " + employee.getId() + ", зарплата: " + employee.getSalary());
            }
        }
    }

    //добавление новых сотрудников
    public void addEmployee(String fullName, String department, int salary){
        for(int i = 0; i < employees.length; i++){
            if (employees[i] == null){
                employees[i] = new Employee(fullName, department, salary);
            }
        }
    }

    //удаление сотрудников
    public void deleteEmployee(int id){
        for(int i = 0; i < employees.length; i++){
            if(employees[i].getId() == id){
                employees[i] = null;
                break;
            }
        }
    }

    public String getEmployeeById(int id){
        for(Employee employee : employees){
            if (employee.getId() == id){
                return employee.toString();
            }
        }
        return "Сотрудников нет";
    }

    public boolean isNoEmployees(){
        for(Employee employee : employees){
            if (employee == null){
                return true;
            }
        }
        return false;
    }
}
