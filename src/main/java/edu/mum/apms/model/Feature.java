package edu.mum.apms.model;

import javax.persistence.*;

@Entity
@Table (name = "feature")
public class Feature {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int featureId;
	private String title;
	private String description;
	private String priority;
	@ManyToOne
	@JoinColumn(name="projectId", nullable=false)
	private Project project;
	@Enumerated(EnumType.STRING)
	private Status status;
	
	@OneToOne(mappedBy="feature")	
	private Backlog backlog;
	
	public Feature() {}
	
	public Feature(int featureId, String title, String description, String priority, Project project, Status status) {
		this.featureId = featureId;
		this.title = title;
		this.description = description;
		this.priority = priority;
		this.project = project;
		this.status = status;
	}

	public int getFeatureId() {
		return featureId;
	}

	public void setFeatureId(int featureId) {
		this.featureId = featureId;
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

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Backlog getBacklog() {
		return backlog;
	}

	public void setBacklog(Backlog backlog) {
		this.backlog = backlog;
	}
	
	
}
