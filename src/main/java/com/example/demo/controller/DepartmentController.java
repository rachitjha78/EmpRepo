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
import com.example.demo.repository.DepartmentRepository;

@RestController
@RequestMapping("/apid")
public class DepartmentController {
	
	@Autowired
	DepartmentRepository departmentRepository;
	
	@GetMapping("/departments")
	public ResponseEntity<List<Department>> getAllDepartemnts() {
		try {
			List<Department> departments = new ArrayList<Department>();

			
				departmentRepository.findAll().forEach(departments::add);
			

			if (departments.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(departments, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/departments")
	public ResponseEntity<Department> createDepartment(@RequestBody Department department) {
		try {
			departmentRepository
					.save(department);
			return new ResponseEntity<>(department, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/departments/{id}")
	public ResponseEntity<String> removeDepartment(@PathVariable("id") long id) {
		try {
			departmentRepository.deleteById(id);
					
			return new ResponseEntity<>("Dept deleted", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	 @PutMapping("/departments/{id}")
	    public ResponseEntity<Department> updateDepartment(@PathVariable long id,@RequestBody Department department) {
	        
		 try {
		    Department updateDepartment = departmentRepository.findById(id).get();
	           //    .orElseThrow(() -> new ResourceNotFoundException("Department not exist with id: " + id));

	        updateDepartment.setDepartment_name(department.getDepartment_name());
	        updateDepartment.setManager_id(department.getManager_id());
	        departmentRepository.save(updateDepartment);

	        return ResponseEntity.ok(updateDepartment);
		 }
	        
	        catch (Exception e) {
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		 }
	      

	        
	    }


