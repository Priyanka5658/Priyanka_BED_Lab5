package com.greatlearning.employeemgmt3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service;
import com.greatlearning.employeemgmt3.service.EmployeeService3;
import com.greatlearning.employeemgmt3.model.Employee3;
import com.greatlearning.employeemgmt3.repository.EmployeeRepository3;

@Service
public class EmployeeServiceImpl3 implements EmployeeService3 {

	@Autowired
    EmployeeRepository3 repository;
	
    @Override
    public List<Employee3> getAllEmployees () {
    	return repository.findAll();
    }

	@Override
	public void saveOrUpdate(Employee3  emp) {
		repository.save(emp);
		
	}

	@Override
	public void deleteEmployeeById(int id) {
		Employee3 emp = getEmployeeById(id); 
		repository.delete(emp);
	}

	@Override
	public Employee3 getEmployeeById(int id) {
		return repository.findById(id).get();
	}
}
