package com.training.keyCKBackend.service;

import com.training.keyCKBackend.entity.Employee;
import com.training.keyCKBackend.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

   public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
   }

   public Employee getEmployeeById(int id){
       return employeeRepository.findById(id).orElse(null);
   }

   public Employee createNewEmp(Employee emp){
        return employeeRepository.save(emp);
   }

   public Employee updateEmployee(int id, Employee emp){
        if(employeeRepository.existsById(id)){
            emp.setId(id);
            return employeeRepository.save(emp);
        }
        return null;
   }

   public boolean deleteEmployee(int id){
        if(employeeRepository.existsById(id)){
            employeeRepository.deleteById(id);
            return true;
        }
        return false;
   }
}
