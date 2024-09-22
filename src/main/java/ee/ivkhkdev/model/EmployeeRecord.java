package ee.ivkhkdev.model;

public record EmployeeRecord(
        String firstName,
        String lastName,
        String position,
        String salary,
        int birthDay,
        int birthMonth,
        int birthYear,
        String phone,
        String city,
        String street,
        String house,
        String room
) {
}
