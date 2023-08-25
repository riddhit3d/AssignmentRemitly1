package com.cybage.emp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.NotEmpty;

//import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

//import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

 
@Data
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "EMPLOYEE_TBL")
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	 
//   @NotBlank(message = "Name is required")
//    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
	int id;
	@NotBlank(message = "Name is required")
	String name;
	@NotEmpty(message="address cant be emty")
	String address;
	 String number;
	 public Employee(){
		 
	 }
	public Employee get() {
		// TODO Auto-generated method stub
		return null;
	}
	public Employee(int i, String string, int j) {
		// TODO Auto-generated constructor stub
	}
	public boolean isPresent() {
		// TODO Auto-generated method stub
		return false;
	} 
}

