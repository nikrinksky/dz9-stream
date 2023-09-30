package pro.sky.dz9stream.service;

import org.springframework.stereotype.Service;
import pro.sky.dz9stream.entity.Employee;
import pro.sky.dz9stream.exception.EmployeeNotFoundException;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee getEmployeeWithMaxSalary(Integer department) {

        return employeeService.getEmployeesAll()
                .stream()
                .filter(e -> e.getDepartment() == department)
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(() -> new EmployeeNotFoundException("Такого сотрудника нет"));
    }

    @Override
    public Employee getEmployeeWithMinSalary(Integer department) {
        return employeeService.getEmployeesAll()
                .stream()
                .filter(e -> e.getDepartment() == department)
                .min(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(() -> new EmployeeNotFoundException("Такого сотрудника нет"));
    }

    @Override
    public Collection<Employee> getEmployees(Integer department) {
        return employeeService.getEmployeesAll()
                .stream()
                .filter(e -> e.getDepartment() == department)
                .collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<Employee>> getEmployees() {
        return employeeService.getEmployeesAll()
                .stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }
}
