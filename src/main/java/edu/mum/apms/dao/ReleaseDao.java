package edu.mum.apms.dao;

import edu.mum.apms.model.Release;

public interface ReleaseDao {
	
	void addRelease(Release release);
	
	Release getRelease(String releaseVersion);
	

}
