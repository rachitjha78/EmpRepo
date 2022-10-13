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

}

