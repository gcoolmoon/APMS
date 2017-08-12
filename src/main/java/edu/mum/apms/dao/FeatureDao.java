package edu.mum.apms.dao;

import edu.mum.apms.model.Feature;
import java.util.List;

public interface FeatureDao {
	public void add(Feature feature);
	public void edit(Feature feature);
	public void delete(int featureId);
	public Feature get(int featureId);
	public List<Feature> getAll(int projectId);
}
