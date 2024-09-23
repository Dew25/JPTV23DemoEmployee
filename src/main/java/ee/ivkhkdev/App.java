package ee.ivkhkdev;

import ee.ivkhkdev.service.EmployeeService;
import ee.ivkhkdev.model.Employee;
import ee.ivkhkdev.tools.EmployeeInputOutput;

import java.lang.reflect.Field;
import java.util.Scanner;

public class App {
    private Scanner scanner = new Scanner(System.in);
    public static Employee[] employees = new Employee[100];
    private EmployeeService employeeService = new EmployeeService();
    private EmployeeInputOutput employeeInputOutput = new EmployeeInputOutput();

    public void run(){
        System.out.println("Демо программа \"Отдел кадров\"");
        boolean repeat = true;
        do {
            System.out.println("Список задач:");
            System.out.println("0. Выйти из программы");
            System.out.println("1. Добавить работника");
            System.out.println("2. Список работников");
            System.out.println("3. Изменить поле работника");
            System.out.print("Выберите задачу: ");
            int task = scanner.nextInt();
            scanner.nextLine();
            switch (task) {
                case 0:
                    System.out.println("Выход из программы");
                    repeat = false;
                    break;
                case 1:
                    System.out.println("Выбрана задача 1");
                    Employee employee = employeeService.createEmployee(employeeInputOutput.initializeEmployee(scanner));
                    if(employee != null){
                        employeeService.saveEmployee(employee,employees);
                    }
                    break;
                case 2:
                    System.out.println("Выбрана задача 2");
                    employeeInputOutput.printListEmployees(employees);
                    break;
                case 3:
                    System.out.println("Выбрана задача 3");
                    employeeService.saveEmployee(employeeInputOutput.editEmployee(scanner),employees);
                    break;
                default:
                    System.out.println("Некоректный выбор задачи. Попробуй еще раз");
            }
        }while (repeat);
        System.out.println("До свидания! :)");
    }

}
