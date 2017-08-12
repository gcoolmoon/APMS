package edu.mum.apms.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Release {
	
	@Id @GeneratedValue
	private int releaseId;
	private String version;
	private String description;
	
	@Temporal(TemporalType.DATE)
	private Date releaseDate;
	
	@OneToMany(mappedBy="release")
	private List<Sprint> sprint = new ArrayList<>();
	
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	public List<Sprint> getSprint() {
		return sprint;
	}
	public void setSprint(List<Sprint> sprint) {
		this.sprint = sprint;
	} 
	
	

}
