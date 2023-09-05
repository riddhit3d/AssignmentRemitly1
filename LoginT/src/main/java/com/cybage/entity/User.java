package com.cybage.entity;

import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
@Entity
@Table(name ="user",uniqueConstraints = @UniqueConstraint(columnNames="email"))

public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private Long id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
    private String lastName;
	private String email;
	private String pasword;
	@ManyToMany(fetch=FetchType.EAGER,cascade= CascadeType.ALL)
	@JoinTable(name="user_roles",
	
	joinColumns=@JoinColumn(
			name="user_id",referencedColumnName="id"))
	
	private Collection<Role> roles;
	public Long getId() {
		return id;
	}
	public User(Long id, String firstName, String lastName, String email, String pasword, Collection<Role> roles) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.pasword = pasword;
		this.roles = roles;
	}
	public User(String firstName2, String lastName2, String email2, String password, List<Role> asList) {
		// TODO Auto-generated constructor stub
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPasword() {
		return pasword;
	}
	public void setPasword(String pasword) {
		this.pasword = pasword;
	}
	public Collection<Role> getRoles() {
		return roles;
	}
	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}

}
