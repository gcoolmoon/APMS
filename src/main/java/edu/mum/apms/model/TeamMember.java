package edu.mum.apms.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class TeamMember {

	@Id
	@GeneratedValue
	private int id;
	@NotNull(message = "Position cannot be blank!")
	private String position;
	
	@OneToMany(mappedBy="teamMember",cascade = CascadeType.REMOVE)
	private List<Task> tasksAssigned ;
	
	@NotEmpty(message = "User can not be empty")
	@OneToOne
	@JoinColumn(name="userId")
	private User user;

	public TeamMember(){}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
 
	//@OneToMany
	public List<Task> getTasksAssigned() {
		return tasksAssigned;
	}

	public void setTasksAssigned(List<Task> tasksAssigned) {
		this.tasksAssigned = tasksAssigned;
	}
	
	
	
}
