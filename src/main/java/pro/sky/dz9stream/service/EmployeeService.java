package pro.sky.dz9stream.service;

import pro.sky.dz9stream.entity.Employee;

import java.util.Collection;

public interface EmployeeService {

    Employee addEmployee(String firstName, String lastName, double salary, int department);

    Employee remove(String firstName, String lastName);

    Employee searchEmployee(String firstName, String lastName);

    Collection<Employee> getEmployeesAll();
}
