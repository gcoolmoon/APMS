package edu.mum.apms.dao;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import edu.mum.apms.model.Feature;

@Repository
public class FeatureDaoImpl implements FeatureDao {
	@Autowired
	private SessionFactory session;

	@Override
	public void add(Feature feature) {
		session.getCurrentSession().save(feature);		
	}

	@Override
	public void edit(Feature feature) {
		session.getCurrentSession().update(feature);
	}

	@Override
	public void delete(int featureId) {
		session.getCurrentSession().delete(get(featureId));;
	}

	@Override
	public Feature get(int featureId) {		
		return (Feature)session.getCurrentSession().get(Feature.class, featureId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Feature> getAll() {
		return session.getCurrentSession().createQuery("FROM Feature").list();
	}
}
