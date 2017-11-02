package edu.mum.apms.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class WorkLog {

	@Id
	@GeneratedValue
	private int id;
	@NotNull(message = "Description cannot be blank!")
	@Size(min=10, max=2000,message="Worklog description must be between 10 and 2000 characters!")
	private String description;
	
	@NotNull(message = "Hour can not be blank!")
	@Digits(integer=6, fraction=2, message="Hour logged format is not valid!")
	private double hourLogged;
	
//	@NotNull
//	@Future(message = "Logged date can not be future date!")
	@Temporal(TemporalType.DATE)
	private Date loggedDate;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "taskId")
	private Task task;

	//@NotNull
	@OneToOne
	@JoinColumn(name = "memberId")
	private TeamMember teamMember;

	public WorkLog(){}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getHourLogged() {
		return hourLogged;
	}

	public void setHourLogged(double hourLogged) {
		this.hourLogged = hourLogged;
	}

	public Date getLoggedDate() {
		return loggedDate;
	}

	public void setLoggedDate(Date loggedDate) {
		this.loggedDate = loggedDate;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public TeamMember getTeamMember() {
		return teamMember;
	}

	public void setTeamMember(TeamMember teamMember) {
		this.teamMember = teamMember;
	}

}
