public class Main {
    public static void main(String[] args) {
        EmployeeBook book = new EmployeeBook();

        System.out.println("КНИГА СОТРУДНИКОВ\n");

        // Добавление сотрудников
        System.out.println("Добавление сотрудников");
        System.out.println("Добавление Иванова: " + book.addEmployee("Иванов И.И.", 1, 100));
        System.out.println("Добавление Петрова: " + book.addEmployee("Петров П.П.", 2, 200));
        System.out.println("Добавление Сидорова: " + book.addEmployee("Сидоров С.С.", 3, 300));
        System.out.println("Добавление Смирнова: " + book.addEmployee("Смирнов А.А.", 4, 400));
        System.out.println("Добавление Кузнецова: " + book.addEmployee("Кузнецов В.В.", 5, 150));
        System.out.println("Добавление Васильева: " + book.addEmployee("Васильев Г.Г.", 1, 120));
        System.out.println("Добавление Попова: " + book.addEmployee("Попов Д.Д.", 2, 180));
        System.out.println("Добавление Новикова: " + book.addEmployee("Новиков Е.Е.", 3, 250));
        System.out.println("Добавление Федорова: " + book.addEmployee("Федоров Ж.Ж.", 4, 350));
        System.out.println("Добавление Морозова: " + book.addEmployee("Морозов З.З.", 5, 500));
        System.out.println();

        // Список всех сотрудников
        book.printAllEmployees();

        // Среднее значение зарплат
        System.out.println("Средняя зарплата: " + book.calculateAverageSalary());
        System.out.println();

        // Значения налогов
        book.printTaxes("PROPORTIONAL");
        book.printTaxes("PROGRESSIVE");

        // Проиндексация зарплаты
        book.indexSalariesByDepartment(1, 10);

        // Первый сотрудник с зарплатой больше указанной
        book.findFirstEmployeeWithSalaryGreaterThan(2, 150);

        // Первые сотрудники с зарплатой меньше указанной
        book.findEmployeesWithSalaryLessThan(200, 3);

        // Наличие сотрудника по зарплате
        System.out.println("Наличие сотрудника по зарплате");
        Employee testEmployee = new Employee("Тест", 1, 200);
        System.out.println("Есть ли сотрудник с зарплатой 200: " +
                book.containsEmployeeBySalary(testEmployee));

        Employee testEmployee2 = new Employee("Тест2", 1, 999);
        System.out.println("Есть ли сотрудник с зарплатой 999: " +
                book.containsEmployeeBySalary(testEmployee2));
        System.out.println();

        // НАйти сотрудника по id
        System.out.println("Найти сотрудника по id");
        Employee emp = book.getEmployeeById(3);
        if (emp != null) {
            System.out.println("Сотрудник с id=3: " + emp);
        }
        System.out.println("Сотрудник с id=999: " + book.getEmployeeById(999));
        System.out.println();

        // Удаление сотрудника
        System.out.println("Удаление сотрудника");
        System.out.println("Удаление сотрудника с id=3: " + book.removeEmployeeById(3));
        System.out.println("Повторная попытка удаления id=3: " + book.removeEmployeeById(3));
        System.out.println("Удаление несуществующего id=999: " + book.removeEmployeeById(999));
        System.out.println();

        // Проверка после удаления
        System.out.println("Количество сотрудников после удаления: " +
                book.getEmployeesCount());
        System.out.println("Проверка id=3 после удаления: " +
                book.getEmployeeById(3));
        System.out.println();

        // Добавление нового сотрудника на освободившееся место
        System.out.println("Добавление на освободившееся место");
        System.out.println("Добавление нового сотрудника: " +
                book.addEmployee("Соколов Р.Р.", 2, 130));
        book.printAllEmployees();
    }
}