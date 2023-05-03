package com.employee.EmployeeDetails.service.impl;

import com.employee.EmployeeDetails.entity.Employee;
import com.employee.EmployeeDetails.exception.ResourceNotFoundException;
import com.employee.EmployeeDetails.repository.EmployeeRepository;
import com.employee.EmployeeDetails.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository empRepo;

    @Override
    public Employee saveEmployee(Employee employee) {
        return empRepo.save(employee);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return empRepo.findAll();
    }

    @Override
    public Employee getEmployeeById(int id) {
        Optional<Employee> employee = empRepo.findById(id);

        if (employee.isPresent()) {
            return employee.get();
        }
        else {
            throw new ResourceNotFoundException("Employee", "id", id);
        }
    }

    @Override
    public Employee updateEmployee(Employee employee, int id) {
        Employee existingEmployee = empRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "id", id));

        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setAddress(employee.getAddress());
        existingEmployee.setEmail(employee.getEmail());

        empRepo.save(existingEmployee);
        return existingEmployee;
    }

    @Override
    public void deleteEmployee(int id) {
        empRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "id", id));

        empRepo.deleteById(id);
    }

    @Override
    public List<Employee> findByFirstName(String firstName) {
        return empRepo.findByFirstName(firstName);

    }

    @Override
    public List<Employee> findByLastName(String lastName) {
        return empRepo.findByLastName(lastName);
    }


}
