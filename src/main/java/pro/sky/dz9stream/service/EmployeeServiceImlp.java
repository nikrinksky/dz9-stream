package pro.sky.dz9stream.service;

import org.springframework.stereotype.Service;
import pro.sky.dz9stream.entity.Employee;
import pro.sky.dz9stream.exception.EmployeeAlreadyAddedException;
import pro.sky.dz9stream.exception.EmployeeNotFoundException;
import pro.sky.dz9stream.exception.EmployeeStorageIsFullException;

import java.util.*;

@Service
public class EmployeeServiceImlp implements EmployeeService {

    private static final int CONSTANT = 10;
    private final Map<String, Employee> employees;

    public EmployeeServiceImlp() {
        this.employees = new HashMap<>();
        addEmployee("Pety", "Petrov");
        addEmployee("Vasya", "Vasichkin");
        addEmployee("Misha", "Mishichkik");
        addEmployee("Masha", "Mishina");
        addEmployee("Vera", "Verina");
        addEmployee("Dasha", "Dashina");

    }

    @Override
    public Employee addEmployee(String firstName, String lastName) {

        if (employees.size() >= CONSTANT) {
            throw new EmployeeStorageIsFullException("Превышен лемит сотрудников");
        }

        String key = getKey(firstName, lastName);
        if (employees.containsKey(key)) {
            throw new EmployeeAlreadyAddedException("Такой сотрудник уже есть");
        }

        Employee empl = new Employee(firstName, lastName);

        employees.put(key, empl);

        return empl;
    }

    @Override
    public Employee remove(String firstName, String lastName) {

        String key = getKey(firstName, lastName);

        if (!employees.containsKey(key)) {
            throw new EmployeeNotFoundException("Удалять некого, нет такого сотрудника: " + key);
        }
        return employees.remove(key);
    }

    @Override
    public Employee searchEmployee(String firstName, String lastName) {
        String key = getKey(firstName, lastName);

        if (!employees.containsKey(key)) {
            throw new EmployeeNotFoundException("Нет такого сотрудника: " + key);
        } else {
            return employees.get(key);
        }
    }

    @Override
    public Collection<Employee> getEmployeesAll() {
        return Collections.unmodifiableCollection(employees.values());
        //return employees.values();
    }

    private String getKey(String firstName, String lastName) {
        return firstName + " " + lastName;
    }

}

