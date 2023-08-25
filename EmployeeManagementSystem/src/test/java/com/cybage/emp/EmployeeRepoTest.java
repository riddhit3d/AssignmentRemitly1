package com.cybage.emp;

//import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Optional;
import java.util.Set;

//import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.cybage.emp.entity.Employee;
import com.cybage.emp.repository.EmployeeRepository;

//import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class EmployeeRepoTest {

	@Autowired
	EmployeeRepository employeeRepository;
	  Validator validator;

	@Test
	@Rollback(value = false)
	@Order(1)
	 public void addEmployeetest() {
		
		Employee employee = Employee.builder()
				.name("siddhi")
				.address("amt")
				.number("8876233400")
				.build();
		
		employeeRepository.save(employee);
		Assertions.assertThat(employee.getId()).isGreaterThan(0);
		
		
		
} 
//	@Test
//    public void testNameValidation() {
//        Employee employee = new Employee();
//        employee.setName("Riddhi");
//        Object validator;
//		// Here, "name" is not set, so validation should fail
//        Set<ConstraintViolation<Employee>> violations = validator.validate(employee);
//        assertEquals(1, violations.size());
//        ConstraintViolation<Employee> violation = violations.iterator().next();
//        assertEquals("Name is required", violation.getMessage());
//    }

	@Test
	@Rollback(value = false)
	@Order(2)
	public void getListOfEmployeesTest() {
		List<Employee> employee = employeeRepository.findAll();
		Assertions.assertThat(employee.size()).isGreaterThan(0);
	}
	
//	@Test
//	@Rollback(value = false)
//	@Order(3)
//    public void updateEmployeeTest() {
//	Employee employee = employeeRepository.findById(1L).get();
//	employee.setAddress("amravati");
//	Employee employeeUpdated = employeeRepository.save(employee);
//	
//	Assertions.assertThat(employeeUpdated.getAddress()).isEqualTo(0);	}
	@Test
	@Rollback(value = false)
	@Order(4)
    public void DeleteTest() {
	Employee employee = employeeRepository.findById(1).get();
	employeeRepository.delete(employee);
	Employee employee1 = null;
	Optional<Employee> optionalEmployee =employeeRepository.findById(13);
	if(optionalEmployee.isPresent()) {
		employee1 = optionalEmployee.get();
		
	}

	Assertions.assertThat(employee1).isNull();	}
}
