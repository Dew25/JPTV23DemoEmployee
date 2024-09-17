package ee.ivkhkdev;

import java.util.Scanner;

public class App {

    private Scanner scanner = new Scanner(System.in);
    private Employee[] employees = new Employee[100];

    public void run(){
        System.out.println("Демо программа \"Отдел кадров\"");
        boolean repeat = true;
        do {
            System.out.println("Список задач:");
            System.out.println("0. Выйти из программы");
            System.out.println("1. Добавить работника");
            System.out.println("2. Список работников");
            System.out.println("3. Работник по имени и фамилии");
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
                    createEmployee();
                    break;
                case 2:
                    System.out.println("Выбрана задача 2");
                    listEmployees();
                    break;
                case 3:
                    System.out.println("Выбрана задача 3");
                    break;
                default:
                    System.out.println("Некоректный выбор задачи. Попробуй еще раз");
            }
        }while (repeat);
        System.out.println("До свидания! :)");
    }

    private void listEmployees() {
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

    private void createEmployee() {
        System.out.println("Имя");
        String firstName = scanner.nextLine();
        System.out.println("Фамилия");
        String lastName = scanner.nextLine();
        System.out.println("Должность");
        String position = scanner.nextLine();
        System.out.println("Зарплата");
        String salary = scanner.nextLine();
        System.out.println("День рождения");
        int birthDay = scanner.nextInt();scanner.nextLine();
        System.out.println("Месяц рождения");
        int birthMonth = scanner.nextInt();scanner.nextLine();
        System.out.println("Год рождения");
        int birthYear = scanner.nextInt();scanner.nextLine();
        System.out.println("Телефон");
        String phone = scanner.nextLine();
        System.out.println("Адрес:");
        System.out.print("Город: ");
        String city = scanner.nextLine();
        System.out.print("Улица: ");
        String street = scanner.nextLine();
        System.out.print("Дом: ");
        String house = scanner.nextLine();
        System.out.print("Квартира: ");
        String room = scanner.nextLine();


        Address address = new Address(street,city,house,room);
        Person person = new Person(firstName,lastName, birthYear, birthMonth, birthDay, phone, address);

        Employee employee = new Employee();
        employee.setPosition(position);
        employee.setSalary(salary);
        employee.setPerson(person);

        System.out.printf("Работник:%n %s %s%n %d лет%n %s%n %s%n %s%n",
                employee.getPerson().getFirstName(),
                employee.getPerson().getLastName(),
                employee.getPerson().age(),
                employee.getPerson().getPhone(),
                employee.getPerson().getAddress().getCity(),
                employee.getPosition()
        );
        saveEmployee(employee);
    }
    private void saveEmployee(Employee employee) {
        for (int i = 0; i < employees.length; i++) {
            if(employees.length == 0) {employees[i] = employee;}
            if(employees[i] != null){
                continue;
            }
            employees[i] = employee;
            break;
        }
    }
}
