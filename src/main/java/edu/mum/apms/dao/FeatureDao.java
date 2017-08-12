package edu.mum.apms.dao;

import edu.mum.apms.model.Feature;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FeatureDao extends JpaRepository<Feature, Integer> {
//	public void add(Feature feature);
//	public void edit(Feature feature);
//	public void delete(int featureId);
}
