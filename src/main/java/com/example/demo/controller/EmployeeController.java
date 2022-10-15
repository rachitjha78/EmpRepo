package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Department;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@RestController
@RequestMapping("/apie")
public class EmployeeController {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getAllEmployees() {
		try {
			List<Employee> employees = new ArrayList<Employee>();

			
				employeeRepository.findAll().forEach(employees::add);
			

			if (employees.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(employees, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/employees")
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
		try {
			employeeRepository
					.save(employee);
			return new ResponseEntity<>(employee, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<String> removeEmployee(@PathVariable("id") long id) {
		try {
			employeeRepository.deleteById(id);
					
			return new ResponseEntity<>("Employee deleted", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable long id,@RequestBody Employee employee) {
        
	 try {
	    Employee updateEmployee = employeeRepository.findById(id).get();
          
        updateEmployee.setFirst_name(employee.getFirst_name());
        updateEmployee.setLast_name(employee.getLast_name());
        updateEmployee.setEmail(employee.getEmail());
        updateEmployee.setPhone_number(employee.getPhone_number());
        updateEmployee.setHire_date(employee.getHire_date());
        updateEmployee.setSalary(employee.getSalary());
        updateEmployee.setManager_id(employee.getManager_id());
        employeeRepository.save(updateEmployee);

        return ResponseEntity.ok(updateEmployee);
	 }
        
        catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	 }

}

