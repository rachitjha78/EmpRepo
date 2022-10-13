package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Department {
  
	@Id
    private long department_id;
	
	private String department_name;
	
	private long manager_id;
  
}

