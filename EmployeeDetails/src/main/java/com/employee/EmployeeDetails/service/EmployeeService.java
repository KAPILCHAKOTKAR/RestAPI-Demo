package com.employee.EmployeeDetails.service;

import com.employee.EmployeeDetails.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    Employee saveEmployee(Employee employee);

    List<Employee> getAllEmployee();

    Employee getEmployeeById(int id);

    Employee updateEmployee(Employee employee, int id);

    void deleteEmployee(int id);

    List<Employee> findByFirstName(String firstName);

    List<Employee> findByLastName(String lastName);
}
