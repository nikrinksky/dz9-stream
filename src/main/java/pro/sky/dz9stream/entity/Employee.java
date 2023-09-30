package pro.sky.dz9stream.entity;

import java.util.Objects;
import java.util.Random;

public class Employee {
    private final String firstName;
    private final String lastName;
    private final double salary;
    private final int department;


    public Employee(String firstName, String lastName, double salary, int department) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.department = department;
    }

//    public Employee(String firstName, String lastName, Integer department) {
//        Random random = new Random();
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.salary = random.nextInt(10000) + 1000;
//        this.department = random.nextInt(2) + 1;
//    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", department=" + department +
                ", salary=" + salary +
                '}';
    }
}

