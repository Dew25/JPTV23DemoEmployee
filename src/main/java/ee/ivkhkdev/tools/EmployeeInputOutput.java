package ee.ivkhkdev.tools;

import ee.ivkhkdev.App;
import ee.ivkhkdev.model.Employee;
import ee.ivkhkdev.model.EmployeeRecord;
import ee.ivkhkdev.service.EmployeeService;

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
        int birthDay = this.inputNumber(scanner);
        System.out.print("Месяц рождения: ");
        int birthMonth = this.inputNumber(scanner);
        System.out.print("Год рождения: ");
        int birthYear = this.inputNumber(scanner);
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
    public int inputNumber(Scanner scanner) {
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


    public Employee editEmployee(Scanner scanner) {
        System.out.println("Введите имя работника");
        String firstNameFind = scanner.nextLine();
        System.out.print("Введите фамилию работника: ");
        String lastNameFind = scanner.nextLine();
        EmployeeService employeeService = new EmployeeService();
        Employee employee = employeeService.findEmployee(firstNameFind,lastNameFind, App.employees);

        System.out.print("Имя: "+employee.getPerson().getFirstName());
        System.out.println("Заменить? 1-да/0-нет");
        if(this.inputNumber(scanner)==1){
            System.out.println("Введите новое значение: ");
            employee.getPerson().setFirstName(scanner.nextLine());
        }
        String firstName = scanner.nextLine();
        System.out.print("Фамилия: "+employee.getPerson().getLastName());
        System.out.println("Заменить? 1-да/0-нет");
        if(this.inputNumber(scanner)==1){
            System.out.println("Введите новое значение: ");
            employee.getPerson().setLastName(scanner.nextLine());
        }

        System.out.print("Должность: "+employee.getPosition());
        System.out.println("Заменить? 1-да/0-нет");
        if(this.inputNumber(scanner)==1){
            System.out.println("Введите новое значение: ");
            employee.setPosition(scanner.nextLine());
        }

        System.out.print("Зарплата: "+employee.getSalary());
        System.out.println("Заменить? 1-да/0-нет");
        if(this.inputNumber(scanner)==1){
            System.out.println("Введите новое значение: ");
            employee.setSalary(scanner.nextLine());
        }
        System.out.print("День рождения: "+employee.getPerson().getBirthDay());
        System.out.println("Заменить? 1-да/0-нет");
        if(this.inputNumber(scanner)==1){
            System.out.println("Введите новое значение: ");
            employee.getPerson().setBirthDay(this.inputNumber(scanner));
        }

        System.out.print("Месяц рождения: "+employee.getPerson().getBirthMonth());
        System.out.println("Заменить? 1-да/0-нет");
        if(this.inputNumber(scanner)==1){
            System.out.println("Введите новое значение: ");
            employee.getPerson().setBirthMonth(this.inputNumber(scanner));
        }

        System.out.print("Год рождения: "+employee.getPerson().getBirthYear());
        System.out.println("Заменить? 1-да/0-нет");
        if(this.inputNumber(scanner)==1){
            System.out.println("Введите новое значение: ");
            employee.getPerson().setBirthYear(this.inputNumber(scanner));
        }

        System.out.print("Телефон: "+employee.getPerson().getPhone());
        System.out.println("Заменить? 1-да/0-нет");
        if(this.inputNumber(scanner)==1){
            System.out.println("Введите новое значение: ");
            employee.getPerson().setPhone(scanner.nextLine());
        }
        System.out.println("Адрес");
        System.out.print("Город: "+employee.getPerson().getAddress().getCity());
        System.out.println("Заменить? 1-да/0-нет");
        if(this.inputNumber(scanner)==1){
            System.out.println("Введите новое значение: ");
            employee.getPerson().getAddress().setCity(scanner.nextLine());
        }

        System.out.print("Улица: "+employee.getPerson().getAddress().getStreet());
        System.out.println("Заменить? 1-да/0-нет");
        if(this.inputNumber(scanner)==1){
            System.out.println("Введите новое значение: ");
            employee.getPerson().getAddress().setStreet(scanner.nextLine());
        }

        System.out.print("Дом: "+employee.getPerson().getAddress().getHouse());
        System.out.println("Заменить? 1-да/0-нет");
        if(this.inputNumber(scanner)==1){
            System.out.println("Введите новое значение: ");
            employee.getPerson().getAddress().setHouse(scanner.nextLine());
        }

        System.out.print("Квартира: "+employee.getPerson().getAddress().getRoom());
        System.out.println("Заменить? 1-да/0-нет");
        if(this.inputNumber(scanner)==1){
            System.out.println("Введите новое значение: ");
            employee.getPerson().getAddress().setRoom(scanner.nextLine());
        }

        return employee;
    }
}
