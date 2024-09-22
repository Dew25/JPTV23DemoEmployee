package ee.ivkhkdev.tools;

import ee.ivkhkdev.model.Employee;
import ee.ivkhkdev.model.EmployeeRecord;

import java.util.Scanner;

public class EmployeeInputOutput {
    public void printListEmployees(Employee[] employees) {
        for (int i = 0; i < employees.length; i++) {
            if(employees[i] != null){
                System.out.printf("Работник:%n %s %s%n %d лет%n %s%n %s%n %s%n",
                        employees[i].getPerson().getFirstName(),
                        employees[i].getPerson().getLastName(),
                        employees[i].getPerson().age(),
                        employees[i].getPerson().getPhone(),
                        employees[i].getPerson().getAddress().getCity(),
                        employees[i].getPosition()
                );
            }
        }
    }
    public EmployeeRecord initializeEmployee(Scanner scanner) {
        System.out.print("Имя: ");
        String firstName = scanner.nextLine();
        System.out.print("Фамилия: ");
        String lastName = scanner.nextLine();
        System.out.print("Должность: ");
        String position = scanner.nextLine();
        System.out.print("Зарплата: ");
        String salary = scanner.nextLine();
        System.out.print("День рождения: ");
        int birthDay = this.employeeInput(scanner);
        System.out.print("Месяц рождения: ");
        int birthMonth = this.employeeInput(scanner);
        System.out.print("Год рождения: ");
        int birthYear = this.employeeInput(scanner);
        System.out.print("Телефон: ");
        String phone = scanner.nextLine();
        System.out.println("Адрес");
        System.out.print("Город: ");
        String city = scanner.nextLine();
        System.out.print("Улица: ");
        String street = scanner.nextLine();
        System.out.print("Дом: ");
        String house = scanner.nextLine();
        System.out.print("Квартира: ");
        String room = scanner.nextLine();
        return new EmployeeRecord(
                firstName, lastName, position, salary, birthDay,
                birthMonth, birthYear, phone, city, street, house, room
        );
    }
    public int employeeInput(Scanner scanner) {
        int number;
        do {
            try {
                number = scanner.nextInt();scanner.nextLine();
                break;
            }catch (Exception e){
                System.out.println("Введите число");
                scanner.nextLine();
            }
        }while(true);
        return number;
    }


}
