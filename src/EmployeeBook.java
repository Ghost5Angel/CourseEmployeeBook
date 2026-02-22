public class EmployeeBook {
    private final Employee[] employees;

    public EmployeeBook() {
        this.employees = new Employee[10];
    }

    public void printAllEmployees() {
        System.out.println("Список всех сотрудников:");
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee);
            }
        }
        System.out.println();
    }

    public double calculateAverageSalary() {
        int sum = 0;
        int count = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                sum += employee.getSalary();
                count++;
            }
        }
        return count > 0 ? (double) sum / count : 0;
    }

    public void printTaxes(String taxType) {
        System.out.println("Расчет налогов (" + taxType + "):");
        for (Employee employee : employees) {
            if (employee != null) {
                int salary = employee.getSalary();
                double tax = 0;

                switch (taxType.toUpperCase()) {
                    case "PROPORTIONAL":
                        tax = salary * 0.13;
                        break;
                    case "PROGRESSIVE":
                        if (salary <= 150) {
                            tax = salary * 0.13;
                        } else if (salary <= 350) {
                            tax = salary * 0.17;
                        } else {
                            tax = salary * 0.21;
                        }
                        break;
                    default:
                        System.out.println("Неизвестный тип налога");
                        return;
                }
                double roundedTax = Math.round(tax * 100.0) / 100.0;
                System.out.println(employee.getFullName() + ": зарплата = " + salary +
                        ", налог = " + roundedTax);
            }
        }
        System.out.println();
    }

    public void indexSalariesByDepartment(int department, int percent) {
        System.out.println("Индексация зарплат сотрудников отдела " + department + " на " + percent + "%:");

        for (Employee employee : employees) {
            if (employee == null) continue;
            if (employee.getDepartment() != department) continue;

            int newSalary = employee.getSalary() * (100 + percent) / 100;
            employee.setSalary(newSalary);
            System.out.println(employee.getFullName() + ": новая зарплата = " + newSalary);
        }
        System.out.println();
    }

    // Найти первого сотрудника с зарплатой больше указанной
    public void findFirstEmployeeWithSalaryGreaterThan(int department, int wage) {
        System.out.println("Поиск первого сотрудника отдела " + department + " с зарплатой > " + wage + ":");

        for (int i = 0; i < employees.length; i++) {
            Employee employee = employees[i];
            if (employee != null &&
                    employee.getDepartment() == department &&
                    employee.getSalary() > wage) {

                System.out.print("Найден на позиции " + (i + 1) + ": ");
                employee.printShortInfo();
                break;
            }
        }
        System.out.println();
    }

    // Найти первых N сотрудников с зарплатой меньше указанной
    public void findEmployeesWithSalaryLessThan(int wage, int employeeNumber) {
        System.out.println("Поиск первых " + employeeNumber + " сотрудников с зарплатой < " + wage + ":");

        int found = 0;
        int index = 0;

        while (found < employeeNumber && index < employees.length) {
            Employee employee = employees[index];
            if (employee != null && employee.getSalary() < wage) {
                employee.printShortInfo();
                found++;
                if (found >= employeeNumber) break;
            }
            index++;
        }

        if (found < employeeNumber) {
            System.out.println("Найдено только " + found + " сотрудников");
        }
        System.out.println();
    }

    // Проверить наличие сотрудника по зарплате (бухгалтерский учет)
    public boolean containsEmployeeBySalary(Employee target) {
        for (Employee employee : employees) {
            if (employee != null && employee.equals(target)) {
                return true;
            }
        }
        return false;
    }

    // Добавить нового сотрудника
    public boolean addEmployee(String fullName, int department, int salary) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = new Employee(fullName, department, salary);
                return true;
            }
        }
        return false;
    }

    // Получить сотрудника по id
    public Employee getEmployeeById(int id) {
        for (Employee employee : employees) {
            if (employee != null && employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }

    // Удалить сотрудника по id
    public boolean removeEmployeeById(int id) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getId() == id) {
                employees[i] = null;
                return true;
            }
        }
        return false;
    }

    // Получить количество сотрудников
    public int getEmployeesCount() {
        int count = 0;
        for (Employee employee : employees) {
            if (employee != null) count++;
        }
        return count;
    }
}