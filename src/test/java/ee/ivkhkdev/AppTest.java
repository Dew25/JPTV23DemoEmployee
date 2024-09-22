package ee.ivkhkdev;

import ee.ivkhkdev.service.EmployeeService;
import ee.ivkhkdev.model.Address;
import ee.ivkhkdev.model.Employee;
import ee.ivkhkdev.model.Person;
import ee.ivkhkdev.model.EmployeeRecord;
import ee.ivkhkdev.tools.EmployeeInputOutput;
import org.junit.jupiter.api.*;

class AppTest {
    App app;
    EmployeeService employeeService;
    EmployeeInputOutput employeeInputOutput;
    @BeforeEach
    void setUp() {
        app = new App();
        employeeService = new EmployeeService();
        employeeInputOutput = new EmployeeInputOutput();
    }

    @AfterEach
    void tearDown() {
        employeeService =null;
        app = null;
        employeeInputOutput = null;
    }

    @Test
    @DisplayName("Создание работника")
    void createEmployee() {
        EmployeeRecord employeeRecord = new EmployeeRecord(
                "Иван", "Иванов", "Директор", "3000", 10,
                10, 2000, "54545454", "Йыхви", "Кооли", "2", "3"
        );
        Employee employeeActual = employeeService.createEmployee(employeeRecord);
        Address address = new Address(
                employeeRecord.street(),
                employeeRecord.city(),
                employeeRecord.house(),
                employeeRecord.room()
        );
        Person person = new Person(
                employeeRecord.firstName(),
                employeeRecord.lastName(),
                employeeRecord.birthYear(),
                employeeRecord.birthMonth(),
                employeeRecord.birthDay(),
                employeeRecord.phone(),
                address
        );
        Employee employeeExpected = new Employee(
                person,
                employeeRecord.position(),
                employeeRecord.salary()
        );
        Assertions.assertEquals(employeeExpected,employeeActual);
    }
    @Test
    @DisplayName("Сохранение работника")
    public void saveEmployee() {
        EmployeeRecord employeeRecord = new EmployeeRecord(
                "Иван", "Иванов", "Директор", "3000", 10,
                10, 2000, "54545454", "Йыхви", "Кооли", "2", "3"
        );
        Employee employeeActual = App.employees[0];
        Employee employeeExpected = employeeService.createEmployee(employeeRecord);
        App.employees = employeeService.saveEmployee(employeeExpected,App.employees);
        Assertions.assertNotEquals(employeeExpected, employeeActual);
    }
    @Test
    @DisplayName("Изменение работника")
    public void editEmployee() {
        EmployeeRecord employeeRecord = new EmployeeRecord(
                "Иван", "Иванов", "Директор", "3000", 10,
                10, 2000, "54545454", "��ыхви", "Кооли", "2", "3"
        );
        Employee employeeExpected = employeeService.createEmployee(employeeRecord);
        App.employees = employeeService.saveEmployee(employeeExpected, App.employees);
        Employee employeeActual = App.employees[0];
        Assertions.assertEquals(employeeExpected, employeeActual);
    }
}