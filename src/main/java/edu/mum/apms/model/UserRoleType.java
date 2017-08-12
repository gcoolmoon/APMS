package edu.mum.apms.model;

import java.io.Serializable;

public enum UserRoleType implements Serializable{
	USER("USER"),
	DEV("DEVELOPER"),
	PM("PROJECT MANAGER"),
	ADMIN("ADMIN");
	
	String userProfileType;
	
	private UserRoleType(String userProfileType){
		this.userProfileType = userProfileType;
	}
	
	public String getUserProfileType(){
		return userProfileType;
	}
	
}
