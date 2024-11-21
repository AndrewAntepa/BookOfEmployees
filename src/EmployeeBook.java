public class EmployeeBook {
    private Employee[] employees;
    private int size = 0;

    public EmployeeBook(int n){
        employees = new Employee[n];
    }

    //получает всех сотрудников
    public void getAllEmployees(){
        if(isNoEmployees()) {
            System.out.println("Сотрудники не найдены");
            return;
        }
        StringBuilder allEmployees = new StringBuilder();
        for(Employee employee : employees){
            if(employee == null) continue;
            allEmployees.append(employee).append("\n");
        }
        System.out.println(allEmployees);
    }
    //получает всех сотрудников в отделе
    public String getAllEmployees(String department){
        if(isNoEmployees()) return "Сотрудников нет";
        StringBuilder allEmployees = new StringBuilder();
        allEmployees.append("Сотрудники из отдела ").append(department).append(":");
        for(Employee employee : employees){
            if(employee == null) continue;
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
            if(employee == null) continue;
            fullRate += employee.getSalary();
        }
        return fullRate;
    }

    //сумма затрат на зп в отделе
    public int sumOfAllRates(String department){
        if(isNoEmployees()) return -1;
        int fullSalary = 0;
        for(Employee employee : employees){
            if(employee == null) continue;
            if (employee.getDepartment().equals(department)){
                fullSalary += employee.getSalary();
            }
        }
        return fullSalary;
    }

    //минимальная зарплата
    public String findMinSalary(){
        if(isNoEmployees()) return "Сотрудники не найдены";
        int min = Integer.MAX_VALUE;
        String employeeWithMinSalary = "";
        for(Employee employee : employees){
            if(employee == null) continue;
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
        int min = Integer.MAX_VALUE;
        String employeeWithMinSalary = "";
        for(Employee employee : employees){
            if(employee == null) continue;
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
            if(employee == null) continue;
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
            if(employee == null) continue;
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
        return (double) sumOfAllRates() / size;
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
                if(employee == null) continue;
                System.out.println(employee.getFullName());
            }
        }
    }

    //проиндексировать зп
    public void indexTheSalary(int index){
        if(isNoEmployees()) return;
        for(Employee employee : employees){
            if(employee == null) continue;
            int salary = employee.getSalary();
            int newSalary = salary * (100 + index) / 100;
            employee.setSalary(newSalary);
        }
    }

    //проиндексировать зп в отделе
    public void indexTheSalary(String department, int index){
        if(isNoEmployees()) return;
        for(Employee employee : employees){
            if(employee == null) continue;
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
            if(employee == null) continue;
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
            if(employee == null) continue;
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
            if(employee == null) continue;
            if(employee.getSalary() > salary){
                System.out.println(employee.getFullName() + ", id = " + employee.getId() + ", зарплата: " + employee.getSalary());
            }
        }
    }

    //добавление новых сотрудников
    public boolean addEmployee(Employee employee){
        for(int i = 0; i < employees.length; i++){
            if (employees[i] == null){
                employees[i] = employee;
                size++;
                return true;
            }
        }
        return false;
    }

    //удаление сотрудников
    public void deleteEmployee(int id){
        for(int i = 0; i < employees.length; i++){
            if(employees[i].getId() == id){
                employees[i] = null;
                size--;
                return;
            }
        }
        throw new RuntimeException("Сотрудник с этим id не найден");
    }

    public String getEmployeeById(int id){
        for(Employee employee : employees){
            if (employee.getId() == id){
                return employee.toString();
            }
        }
        return "Сотрудника с таким id нет";
    }

    public boolean isNoEmployees(){
        for(Employee employee : employees){
            if (employee != null){
                return false;
            }
        }
        return true;
    }

    public int getAmountOfEmployees() {
        return size;
    }
}
