package com.SpringDataMongo.SpringDataMongo.EmployeeController;

import com.SpringDataMongo.SpringDataMongo.EmployeeRepository.EmployeeRepository;
import com.SpringDataMongo.SpringDataMongo.Model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping("/saveEmployee")
    public ResponseEntity<String> saveEmployee(@RequestBody Employee employee) {
        employeeRepository.save(employee);
        return ResponseEntity.ok("Employee saved successfully");
    }

    @GetMapping("/displayAll")
    public ResponseEntity<List<Employee>> displayAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/display/{id}")
    public ResponseEntity<Employee> displayEmployeeById(@PathVariable("id") String id) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isPresent()) {
            return ResponseEntity.ok(optionalEmployee.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}