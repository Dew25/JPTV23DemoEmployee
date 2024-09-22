package ee.ivkhkdev.model;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public class Person {
    private String firstName;
    private String lastName;
    private int birthYear;
    private int birthMonth;
    private int birthDay;
    private String phone;
    private Address address;

    public Person(String s, String string, String position, int i, int birthMonth, int birthDay, String phone, Address address) {}

    public Person(String firstName, String lastName, int birthYear, int birthMonth, int birthDay, String phone, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthYear = birthYear;
        this.birthMonth = birthMonth;
        this.birthDay = birthDay;
        this.phone = phone;
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(int birthDay) {
        this.birthDay = birthDay;
    }

    public int getBirthMonth() {
        return birthMonth;
    }

    public void setBirthMonth(int birthMonth) {
        this.birthMonth = birthMonth;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return birthYear == person.birthYear && birthMonth == person.birthMonth && birthDay == person.birthDay && Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName) && Objects.equals(phone, person.phone) && Objects.equals(address, person.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, birthYear, birthMonth, birthDay, phone, address);
    }

    public int age(){
        // Дата рождения
        LocalDate birthDate = LocalDate.of(birthYear, birthMonth, birthDay);
        // Текущая дата
        LocalDate currentDate = LocalDate.now();
        return  Period.between(birthDate, currentDate).getYears();
    }
}
