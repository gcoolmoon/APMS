package edu.mum.apms.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.apms.dao.FeatureDao;
import edu.mum.apms.dao.ProjectDao;
import edu.mum.apms.model.Feature;

@Service
public class FeatureServiceImpl implements FeatureService {

	@Autowired
	private FeatureDao featureDao;
	@Autowired
	private ProjectDao projectDao;

	@Transactional
	public void add(Feature feature) {
		featureDao.save(feature);
	}

	@Transactional
	public void edit(Feature feature) {
		featureDao.save(feature);
	}

	@Transactional
	public void delete(int featureId) {
		featureDao.delete(featureId);
	}

	@Transactional
	public Feature get(int featureId) {
		return featureDao.getOne(featureId);
	}

	@Transactional
	public List<Feature> getAll(int projectId) {
		
		return featureDao.findByProject(projectDao.getOne(projectId));
	}

}
