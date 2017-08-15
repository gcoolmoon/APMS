package edu.mum.apms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import edu.mum.apms.dao.ReleaseDao;
import edu.mum.apms.model.Project;
import edu.mum.apms.model.Release;

@Service
public class ReleaseServiceImpl implements ReleaseService {

	@Autowired
	ReleaseDao releaseDao;
	
	

	@Override
	public void add(Release release) {
		// TODO Auto-generated method stub
		releaseDao.save(release);
        
	}

	@Override
	public void edit(Release release) {
		// TODO Auto-generated method stub
		releaseDao.save(release);

	}

	@Override
	public void delete(int releaseId) {
		// TODO Auto-generated method stub
		releaseDao.delete(releaseId);

	}

	@Override
	public Release get(int releaseId) {
		// TODO Auto-generated method stub
		return releaseDao.findOne(releaseId);
	}

	@Override
	public List<Release> getAll() {
		// TODO Auto-generated method stub
		return releaseDao.findAll();
	}

	@Override
	public List<Release> getReleasesByProject(int releaseId) {
		// TODO Auto-generated method stub
		return null;
	}

}
