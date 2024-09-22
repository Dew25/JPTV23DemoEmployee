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
                    System.out.print("Введите название поля, которое нужно изменить: ");
                    String  editField = scanner.nextLine();
                    System.out.print("Введите новое значени этого поля: ");
                    String  newFieldValue = scanner.nextLine();
                    System.out.print("Введите имя работника: ");
                    String firstName = scanner.nextLine();
                    System.out.print("Введите фамилию работника: ");
                    String lastName = scanner.nextLine();
                    Employee replaceEmployee = employeeService.findEmployee(firstName,lastName,employees);
                    Field field=null;
                    try {
                        // Получаем доступ к полю по его имени через рефлексию
                        field = replaceEmployee.getClass().getDeclaredField(editField);
                        field.setAccessible(true);
                        if (field.getType() == String.class){
                            // Изменяем значение поля
                            try {
                                field.set(replaceEmployee,newFieldValue);
                            } catch (IllegalAccessException e) {
                                System.out.println("Что то пошло не так: "+e);
                            }
                        }
                    }catch (Exception e) {
                        try {
                            field = replaceEmployee.getPerson().getClass().getDeclaredField(editField);
                            field.setAccessible(true);
                            if (field.getType() == String.class){
                                // Изменяем значение поля
                                try {
                                    field.set(replaceEmployee.getPerson(),newFieldValue);
                                } catch (IllegalAccessException e1) {
                                    System.out.println("Что то пошло не так: "+e1);
                                }
                            }
                            if(field.getType() == int.class){
                                // Изменяем значение поля с преобразованеи в int
                                try {
                                    field.set(replaceEmployee.getPerson(),Integer.parseInt(newFieldValue));
                                } catch (IllegalAccessException e2) {
                                    System.out.println("Что то пошло не так: "+e2);
                                }
                            }

                        } catch (Exception ex) {
                            try {
                                field = replaceEmployee.getPerson().getAddress().getClass().getDeclaredField(editField);
                                // Разрешаем доступ к приватному полю
                                field.setAccessible(true);
                                if (field.getType() == String.class){
                                    // Изменяем значение поля
                                    try {
                                        field.set(replaceEmployee.getPerson().getAddress(),newFieldValue);
                                    } catch (IllegalAccessException e3) {
                                        System.out.println("Что то пошло не так: "+e3);
                                    }
                                }
                                if(field.getType() == int.class){
                                    // Изменяем значение поля с преобразованеи в int
                                    try {
                                        field.set(replaceEmployee.getPerson().getAddress(),Integer.parseInt(newFieldValue));
                                    } catch (IllegalAccessException e4) {
                                        System.out.println("Что то пошло не так: "+e4);
                                    }
                                }

                            } catch (NoSuchFieldException exc) {
                                System.out.println("Что то пошло не так: "+exc);
                            }
                        }
                    }
//                        // Разрешаем доступ к приватному полю
//                    field.setAccessible(true);
//                    if (field.getType() == String.class){
//                        // Изменяем значение поля
//                        try {
//                            field.set(replaceEmployee,newFieldValue);
//                        } catch (IllegalAccessException e) {
//                            System.out.println("Что то пошло не так: "+e);
//                        }
//                    }
//                    if(field.getType() == int.class){
//                        // Изменяем значение поля с преобразованеи в int
//                        try {
//                            field.set(replaceEmployee.getPerson(),Integer.parseInt(newFieldValue));
//                        } catch (IllegalAccessException e) {
//                            System.out.println("Что то пошло не так: "+e);
//                        }
//                    }

                    if(replaceEmployee != null){
                        employeeService.editEmployee(replaceEmployee, editField, employees, Boolean.FALSE);
                    }else{
                        System.out.println("Работник не найден");
                    }
                    break;
                default:
                    System.out.println("Некоректный выбор задачи. Попробуй еще раз");
            }
        }while (repeat);
        System.out.println("До свидания! :)");
    }

}
