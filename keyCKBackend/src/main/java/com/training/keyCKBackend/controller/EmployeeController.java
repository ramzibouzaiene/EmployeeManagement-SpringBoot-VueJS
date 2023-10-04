package com.training.keyCKBackend.controller;

import com.training.keyCKBackend.entity.Employee;
import com.training.keyCKBackend.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
@CrossOrigin(origins = "http://localhost:3000")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/all")
    public List<Employee> getAll(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee getById(@PathVariable int id) {
        return employeeService.getEmployeeById(id);
    }

    @PostMapping("create")
    public Employee create(@RequestBody Employee emp){
        return employeeService.createNewEmp(emp);
    }

    @PutMapping("update/{id}")
    public Employee update(@RequestBody Employee emp, @PathVariable int id){
        return employeeService.updateEmployee(id, emp);
    }
    @DeleteMapping("delete/{id}")
    public boolean delete(@PathVariable int id){
        return employeeService.deleteEmployee(id);
    }

}
