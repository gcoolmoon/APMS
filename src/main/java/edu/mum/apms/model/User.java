package edu.mum.apms.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class User {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	//@NotEmpty
	@Column(name="Emp_ID", unique=true, nullable=false)
	private String employeeId;
	
	//@NotEmpty
	@Column(name="PASSWORD", nullable=false)
	private String password;
		
	//@NotEmpty
	@Column(name="FIRST_NAME", nullable=false)
	private String firstName;

	//@NotEmpty
	@Column(name="LAST_NAME", nullable=false)
	private String lastName;

	//@NotEmpty
	@Column(name="EMAIL", nullable=false)
	private String email;

	//@NotEmpty
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "USER_USER_ROLE", 
             joinColumns = { @JoinColumn(name = "USER_ID") }, 
             inverseJoinColumns = { @JoinColumn(name = "USER_ROLE_ID") })
	private Set<UserRole> userRoles = new HashSet<UserRole>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public Set<UserRole> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(Set<UserRole> userRoles) {
		this.userRoles = userRoles;
	}


}
