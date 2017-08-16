package edu.mum.apms.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="USER_ROLE")
public class UserRole {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;	

	@Column(name="ROLE", length=15, unique=true, nullable=false)
	private String role;

    @ManyToMany(mappedBy = "userRoles")
    private Set<User> users;
	
	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		role = role;
	}

	
	




}
