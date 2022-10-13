package com.example.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
	  

}
