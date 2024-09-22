package ee.ivkhkdev.model;

import java.util.Objects;

public class Employee {
    private Person person;
    private String position;
    private String salary;

    public Employee(String s, String string, String position, Person person) {
    }

    public Employee(Person person, String position, String salary) {
        this.person = person;
        this.position = position;
        this.salary = salary;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getPosition() {
        return this.position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(person, employee.person) && Objects.equals(position, employee.position) && Objects.equals(salary, employee.salary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(person, position, salary);
    }
}
