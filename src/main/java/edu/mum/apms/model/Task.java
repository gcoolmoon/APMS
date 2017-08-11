package edu.mum.apms.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Task {

	@Id
	@GeneratedValue
	private int id;
	private String title;
	private String description;
	
	@OneToMany(mappedBy="task")
	private List<WorkLog> workLog;
	
	@Enumerated(EnumType.STRING)	
	private Status status;
	
	@ManyToOne
	@JoinColumn(name="backlogId")
	private Backlog backlog;
	
	@OneToMany
	@JoinColumn(name="memberId")
	private TeamMember teamMember;
	
	public Task(){}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}	
	public List<WorkLog> getWorkLog() {
		return workLog;
	}
	public void setWorkLog(List<WorkLog> workLog) {
		this.workLog = workLog;
	}
	public Backlog getBacklog() {
		return backlog;
	}
	public void setBacklog(Backlog backlog) {
		this.backlog = backlog;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Backlog getbacklog() {
		return backlog;
	}
	public void setbacklog(Backlog backlog) {
		this.backlog = backlog;
	}
	public TeamMember getTeamMember() {
		return teamMember;
	}
	public void setTeamMember(TeamMember teamMember) {
		this.teamMember = teamMember;
	}
}
