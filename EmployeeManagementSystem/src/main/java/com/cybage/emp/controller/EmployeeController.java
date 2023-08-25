package com.cybage.emp.controller;
import org.springframework.validation.annotation.Validated;

//import org.springframework.validation.BindingResult;
import org.springframework.http.ResponseEntity;



import java.util.List;
//
//import javax.validation.Valid;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cybage.emp.entity.Employee;
import com.cybage.emp.repository.EmployeeRepository;
import com.cybage.emp.service.EmployeeService;



//import org.springframework.http.ResponseEntity;


@RestController
@Validated
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private  EmployeeService service;
  
	 private final EmployeeRepository employeeRepository;

	    public EmployeeController(EmployeeRepository employeeRepository) {
	        this.employeeRepository = employeeRepository;
	    }
	@PostMapping("/addEmployee")
	public ResponseEntity<String> addEmployee(@Valid @RequestBody Employee employee) {
		service.saveEmployee(employee);
		return  ResponseEntity.ok("User created successfully");

		
}
	 @GetMapping("/empall")
	    public List<Employee> getAllEmployees() {
	        return employeeRepository.findAll();
	    }

	@PostMapping("/addEmployees")
	public List <Employee> addEmployees(@RequestBody String employees) {
	return service.saveEmployees(employees);
//	return  ResponseEntity.ok("User created successfully")
		
	}

	
	@GetMapping("/employees")
	public List<Employee> findAllEmployees() {
		return service.getEmployees();
	}
	
	@GetMapping("/employeeById/{id}")
	public Employee findEmployeeById(@PathVariable int id) {
		return service.getEmployeeById(id);
	}
	
	@GetMapping("/employee/{name}")
	public Employee findEmployeeByName(@PathVariable String name) {
		return service.getEmployeeByName(name);
	}
	@GetMapping("/employee/ADDRESS{address}")
	public Employee findEmployeeByAddress(@PathVariable String address) {
		return service.getEmployeeByAdress(address);
	}

	@PutMapping("/update")
	public Employee updateEmployee(@RequestBody Employee employee) {
		return service.updateEmployee(employee);
	}

//	@DeleteMapping("/delete/{id}")
//	public String deleteEmployee(@PathVariable int id) {
//		return service.deleteEmployee(id);
//	}
//	@DeleteMapping("/delete{id}")
//	public ResponseEntity<String> deleteProduct(@PathVariable int id) {
//		service.deleteEmployee(id);
//		Employee employee = service.getEmployeeById(id);
//		
//		return new ResponseEntity<String>(" del successfully", HttpStatus.CREATED);
//
//	}
	 @DeleteMapping("/deleter/{id}")
	    public ResponseEntity<String> deleteEnployee(@PathVariable int id) {

   
		 service.deleteEmployee(id);
	        return ResponseEntity.ok("User deleted successfully");
	    }

}








