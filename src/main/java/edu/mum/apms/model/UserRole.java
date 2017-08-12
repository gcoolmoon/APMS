package edu.mum.apms.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USER_ROLE")
public class UserRole {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;	

	@Column(name="TYPE", length=15, unique=true, nullable=false)
	private String type = UserRoleType.USER.getUserProfileType();
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	




}
