package edu.mum.apms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class WorkLog {

	@Id
	@GeneratedValue
	private int id;
	private String description;
	private double hourLogged;

	@ManyToOne
	@JoinColumn(name = "taskId")
	private Task task;

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
