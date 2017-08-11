package edu.mum.apms.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.mum.apms.dao.FeatureDao;
import edu.mum.apms.model.Feature;

@Service
public class FeatureServiceImpl implements FeatureService {

	@Autowired
	private FeatureDao featureDao;

	@Transactional
	public void add(Feature feature) {
		featureDao.add(feature);
	}

	@Transactional
	public void edit(Feature feature) {
		featureDao.edit(feature);
	}

	@Transactional
	public void delete(int featureId) {
		featureDao.delete(featureId);
	}

	@Transactional
	public Feature get(int featureId) {
		return featureDao.get(featureId);
	}

	@Transactional
	public List<Feature> getAll() {
		return featureDao.getAll();
	}

}
