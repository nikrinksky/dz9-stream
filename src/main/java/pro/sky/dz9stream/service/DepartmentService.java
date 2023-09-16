package pro.sky.dz9stream.service;

import pro.sky.dz9stream.entity.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface DepartmentService {

    Employee getEmployeeWithMaxSalary(Integer departmentId);

    Employee getEmployeeWithMinSalary(Integer departmentId);

    Collection<Employee> getEmployees(Integer departmentId);

    Map<Integer, List<Employee>> getEmployees();
}
