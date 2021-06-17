package edu.mum.apms.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table (name = "releases")
public class Release {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private int releaseId;
	
	private String version;
	private String description;

    @DateTimeFormat(pattern = "yyyy-mm-dd")
	@Temporal(TemporalType.DATE)
	private Date releaseDate;
	
	@OneToMany(mappedBy="release")
	 @JsonManagedReference
	private List<Sprint> sprint = new ArrayList<>();
	
	
	public Release() {
		
	}
	
	// constructor for release
	public Release(int releaseId, String version, String description, Date releaseDate, List<Sprint> sprint) {
		
		this.releaseId = releaseId;
		this.version = version;
		this.description = description;
		this.releaseDate = releaseDate;
		this.sprint = sprint;
	}
	
	public int getReleaseId() {
		return releaseId;
	}
	public void setReleaseId(int releaseId) {
		this.releaseId = releaseId;
	}
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
