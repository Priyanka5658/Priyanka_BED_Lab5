package com.greatlearning.employeemgmt3.service;

import java.util.List;

import com.greatlearning.employeemgmt3.model.Employee3;

public interface EmployeeService3 {
	public List<Employee3> getAllEmployees(); 
	public void saveOrUpdate(Employee3 emp); 
	public void deleteEmployeeById(int id); 
	public Employee3 getEmployeeById(int id);

}
