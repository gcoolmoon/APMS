package edu.mum.apms.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Backlog {

	@Id
	@GeneratedValue
	private int id;
	private double hourEstimated;
	private double hourSpent;
	
	@OneToOne
	@JoinColumn(name="featureId")
	private Feature feature;
	
	@Enumerated(EnumType.STRING)	
	private Status status;
	
	@OneToMany(mappedBy="backlog")	
	private List<Task> taskList;
	
	public Backlog(){}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getHourEstimated() {
		return hourEstimated;
	}
	public void setHourEstimated(double hourEstimated) {
		this.hourEstimated = hourEstimated;
	}
	public double getHourSpent() {
		return hourSpent;
	}
	public void setHourSpent(double hourSpent) {
		this.hourSpent = hourSpent;
	}
	public Feature getFeature() {
		return feature;
	}
	public void setFeature(Feature feature) {
		this.feature = feature;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public List<Task> getTaskList() {
		return taskList;
	}
	public void setTaskList(List<Task> taskList) {
		this.taskList = taskList;
	}
	
}
