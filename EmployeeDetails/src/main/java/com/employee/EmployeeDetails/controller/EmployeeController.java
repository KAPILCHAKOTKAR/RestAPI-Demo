package com.employee.EmployeeDetails;

import com.employee.EmployeeDetails.entity.Employee;
import com.employee.EmployeeDetails.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService empService;

    @PostMapping
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee emp){
        return new ResponseEntity<Employee>(empService.saveEmployee(emp), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return new ResponseEntity<List<Employee>>(empService.getAllEmployee(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable int id) {
        return new ResponseEntity<Employee>(empService.getEmployeeById(id), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable int id, @RequestBody Employee employee) {
        return new ResponseEntity<Employee>(empService.updateEmployee(employee, id), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable int id) {
        empService.deleteEmployee(id);
        return new ResponseEntity<String>("Employee deleted successfully..!", HttpStatus.OK);
    }

    @GetMapping("/firstname/{firstName}")
    public ResponseEntity<List<Employee>> getEmployeeByName(@PathVariable String firstName) {
        return new ResponseEntity<List<Employee>>(empService.findByFirstName(firstName), HttpStatus.OK);
    }

    @GetMapping("/lastname/{lastName}")
    public ResponseEntity<List<Employee>> getEmployeeByLastName(@PathVariable String lastName) {
        return new ResponseEntity<List<Employee>>(empService.findByLastName(lastName), HttpStatus.OK);
    }

}
