package edu.mum.apms.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.mum.apms.model.Release;

public interface ReleaseDao extends JpaRepository<Release, Integer> {
	
//	void addRelease(Release release);
	
	

}
