package ee.ivkhkdev.service;

import ee.ivkhkdev.model.Address;
import ee.ivkhkdev.model.EmployeeRecord;
import ee.ivkhkdev.model.Employee;
import ee.ivkhkdev.model.Person;

public class EmployeeService {

    public Employee createEmployee(EmployeeRecord employeeRecord) {

        Address address = new Address(employeeRecord.street(), employeeRecord.city(),
                employeeRecord.house(), employeeRecord.room()
        );
        Person person = new Person(
                employeeRecord.firstName(), employeeRecord.lastName(),
                employeeRecord.birthYear(), employeeRecord.birthMonth(), employeeRecord.birthDay(),
                employeeRecord.phone(), address
        );

        Employee employee = new Employee(employeeRecord.firstName(), employeeRecord.lastName(), employeeRecord.position(), person);
        employee.setPosition(employeeRecord.position());
        employee.setSalary(employeeRecord.salary());
        employee.setPerson(person);

        return employee;
    }


    public void editEmployee(Employee editEmployee, String editField, Employee[] employees) {
        editEmployee(editEmployee, editField, employees, false);
    }

    public Employee[] editEmployee(Employee editEmployee, String editField, Employee[] employees, Boolean save) {
        if(save){
            return this.saveEmployee(editEmployee, employees);
        }else{
            return this.replaceEmployee(editEmployee, employees);
        }
    }
    public Employee findEmployee(String firstName, String lastName, Employee[] employees) {
        for (Employee employee : employees) {
            if (employee != null && employee.getPerson().getFirstName().equals(firstName) && employee.getPerson().getLastName().equals(lastName)) {
                return employee;
            }else {
                continue;
            }
        }
        return null;
    }
    public Employee[]  saveEmployee(Employee employee, Employee[] employees) {
        for (int i = 0; i < employees.length; i++) {
            if(i == 0) {employees[i] = employee; break;}
            if(employees[i] != null){
                continue;
            }
            employees[i] = employee;
            break;
        }
        return employees;
    }
    public Employee[] replaceEmployee(Employee replaceEmployee, Employee[] employees) {
        for (int i = 0; i < employees.length; i++) {
            if(employees.length == 0) {
                System.out.println("Нет сохраненных работников");
                return employees;
            }
            if(employees[i] != null && employees[i].hashCode() == replaceEmployee.hashCode()){
                employees[i] = replaceEmployee;
                System.out.println("Работник отредактирован");
                return employees;
            }
        }
        System.out.println("Не найден работкник");
        return employees;
    }
}
