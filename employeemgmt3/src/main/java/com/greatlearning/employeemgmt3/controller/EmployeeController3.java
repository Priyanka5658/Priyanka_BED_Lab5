package com.greatlearning.employeemgmt3.controller;

import java.util.List;




import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.ModelAttribute; 
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import com.greatlearning.employeemgmt3.model.Employee3;
import com.greatlearning.employeemgmt3.service.EmployeeService3;

public class EmployeeController3 {
	

EmployeeService3 service;

/*
*Request Mapping
* /employees - GET
* /employees/new
* /employees/edit/{id}
* /employees/delete/{id} 
* * /employees - POST
* /employees/{id} - POST
*
*/


public String getAllEmployees(Model model) {
List<Employee3> result = service.getAllEmployees(); 
model.addAttribute("employees", result);
return "employees";
}

@GetMapping("/employees/new")
public String addNewEmployee(Model model) {
Employee3 emp = new Employee3(); 
model.addAttribute("employee", emp); 
return "create_employee";
}

@GetMapping("/employees/edit/{id}")
public String updateEmployee(Model model, @PathVariable("id") Integer id) { 
Employee3 emp = service.getEmployeeById(id); 
model.addAttribute("employee", emp);
return "edit_employee";
}

@GetMapping("/employees/delete/{id}")
public String deleteEmployee(@PathVariable("id") Integer id) {
service.deleteEmployeeById(id);
return "redirect:/employees";
}


@PostMapping("/employees")
public String addEmployee (@ModelAttribute (name = "employee") Employee3 emp) {
service.saveOrUpdate(emp);
return "redirect:/employees";
}

@PostMapping("/employees/{id}")
public String updateEmployee (@ModelAttribute (name = "employee") Employee3 emp, @PathVariable("id") Integer id) { 
Employee3 exsistingEmp = service.getEmployeeById(id);
if (exsistingEmp.getId() == emp.getId()) {
exsistingEmp.setFirstName (emp.getFirstName());
exsistingEmp.setLastName (emp.getLastName()); 
exsistingEmp.setEmail (emp.getEmail());
}
service.saveOrUpdate (exsistingEmp); 
return "redirect: /employees";

}
}
