package com.cybage.emp;
//import static org.junit.Assert.assertFalse;
//import static org.junit.Assert.assertTrue;
//import org.mokito.junit.MockitoJunitRunner;
import java.util.List;

import javax.validation.Validator;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest;

import com.cybage.emp.entity.Employee;
import com.cybage.emp.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;

import org.junit.jupiter.api.BeforeEach;

   
    // ...
import org.junit.jupiter.api.BeforeEach;

@SpringBootTest
public class EmployeeManagementSystemApplicationTests {
	 @Autowired
	  

//private List<Employee> employees;

//EmployeeRepository erepo;
//	@Test
//	
////public void testCreate()
////{
////	Employee e=new Employee(0, null, null, null);
////	e.setId(23);
////	e.setName("riddhi");
////	e.setAddress("MP");
////	e.setNumber("8796541230");
////	erepo.save(e);
////	assertNotNull(erepo.findByName("riddhi").get());
////		
////}
//	void testSum()
//	{	Employee e=new Employee(0, null, null, null);
//		int expectedresult=17;
//		int actualResult=e.();
//		
//	}
//@Test
//public void DemoTest()
//{
//	AssertTrue(true);
//}

//@Test
//public void assertTrueWithNoMessage() {
//	EmployeeService repository = new EmployeeService();
//
//	List<Employee> listOfEmployees = repository.saveEmployees(employees);
//	
//	assertTrue(listOfEmployees.isEmpty());
//	
//}
//@Test
//public void assertTrueWithBooleanSupplierAndMessageSupplier() {
//	EmployeeService employeeService = new EmployeeService();
//	
//	Employee headFirstJavaEmployee = new Employee("1", "Head First Java", "wrox");
//
//	List<Employee> listOfEmployees = employeeService.getEmployees();
//	
//	assertTrue(() -> listOfEmployees.isEmpty(), () -> "List of books is not empty!");
//}
}


