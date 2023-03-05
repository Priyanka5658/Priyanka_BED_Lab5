package com.greatlearning.employeemgmt3.model;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue; 
import javax.persistence. GenerationType; 
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "employees")
@Data

public class Employee3 {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "emp_id")
    private int id;
	@Column(name = "emp_first_name")
	private String firstname;
	@Column(name = "emp_last_name")
	private String lastname;
	@Column(name = "emp_email")
	private String email;


public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstname;
	}
	public void setFirstName(String firstName) {
		this.firstname = firstName;
	}
	public String getLastName() {
		return lastname;
	}
	public void setLastName(String lastName) {
		this.lastname = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;

}
}
