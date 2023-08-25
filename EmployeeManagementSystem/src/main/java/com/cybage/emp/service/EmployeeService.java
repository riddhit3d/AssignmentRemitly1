package com.cybage.emp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cybage.emp.entity.Employee;
import com.cybage.emp.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository repository;
	
	public Employee saveEmployee(Employee employee) {
		return repository.save(employee);
	}
	
	public List<Employee>saveEmployees(String employees) {
		return repository.save(employees);
	}
	
	public List<Employee> getEmployees() {
		return repository.findAll();
	}
	
	public Employee getEmployeeById(int id) {
		return repository.findById((int) id).orElse(null);
	}
	
	public Employee getEmployeeByName(String name) {
		return repository.findByName(name);
	}
	
	public String deleteEmployee(int id) {
		repository.deleteById((int) id);
		return "employee removed !!"+id;
	}
	
	public Employee updateEmployee(Employee employee) {
		Employee existingEmployee=repository.findById((int) employee.getId()).orElse(null);
		existingEmployee.setName(employee.getName());
		existingEmployee.setAddress(employee.getAddress());
		existingEmployee.setNumber(employee.getNumber());
		return repository.save(existingEmployee);
	}

	public Employee getEmployeeByAdress(String address) {
		// TODO Auto-generated method stub
		return null;
	}
}
