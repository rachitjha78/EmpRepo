package com.example.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Entity
public class Employee {
	
	   @Id
	   private long employee_id;
	   
	   @NotNull(message = "Please provide firstname")
	   @Size(min=2, message = "First Name should be atleast 2 characters")
	   private String first_name;
	 
	   @NotNull(message = "Please provide lastname")
	   @Size(min=2, message = "Last Name should be atleast 2 characters")
	   private String last_name;
	   
	   private String email;
	   
	   private String phone_number;
	   
	   private Date hire_date;
	   
	   @Min(value = 1 , message = "Value should be greater then then equal to 1")
	   private double salary;
	  
	   private long manager_id;
	   
	   private long department_id;
	  
	   public long getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(long employee_id) {
		this.employee_id = employee_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public Date getHire_date() {
		return hire_date;
	}

	 @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	public void setHire_date(Date hire_date) {
		this.hire_date = hire_date;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public long getManager_id() {
		return manager_id;
	}

	public void setManager_id(long manager_id) {
		this.manager_id = manager_id;
	}

	public long getDepartment_id() {
		return department_id;
	}

	public void setDepartment_id(long department_id) {
		this.department_id = department_id;
	}

	
	  

}
