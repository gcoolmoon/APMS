package edu.mum.apms.service;

import java.util.List;
import edu.mum.apms.model.Feature;

public interface FeatureService {
	public void add(Feature feature);
	public void edit(Feature feature);
	public void delete(int featureId);
	public Feature get(int featureId);
	public List<Feature> getAll(int projectId);
}
