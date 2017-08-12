package edu.mum.apms.service;

import org.springframework.beans.factory.annotation.Autowired;

import edu.mum.apms.dao.ReleaseDao;
import edu.mum.apms.model.Release;

public class ReleaseService {
	
	@Autowired
	private ReleaseDao releaseDao;
	
	public Release getReleaseInfo(String version)
	{
		//return releaseDao.getRelease(version);
		return null;
	}
	

}
