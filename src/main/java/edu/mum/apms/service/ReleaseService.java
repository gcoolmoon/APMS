package edu.mum.apms.service;

import edu.mum.apms.dao.ReleaseDao;
import edu.mum.apms.model.Release;

public class ReleaseService {
	
	private ReleaseDao releaseDao;
	
	public Release getReleaseInfo(String version)
	{
		return releaseDao.getRelease(version);
	}
	

}
