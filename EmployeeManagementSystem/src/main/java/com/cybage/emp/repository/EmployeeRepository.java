package com.cybage.emp.repository;

import java.util.List;
import java.util.Optional;

//import java.util.List;
//import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cybage.emp.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer>{

	Employee findByName(String name);

	List<Employee> save(String employees);

	Optional<Employee> findByAddress(String address);

//	Optional<Employee> findByEmployeeAddress(String string);
//
//	Employee findByName(int i);

//	void saveEmployee(Employee a1);
	
	
}
