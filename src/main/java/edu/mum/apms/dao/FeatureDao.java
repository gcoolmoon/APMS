package edu.mum.apms.dao;

import edu.mum.apms.model.Feature;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FeatureDao extends JpaRepository<Feature, Integer>  {
	public  List<Feature> findByProject(int projectId);
//	public void edit(Feature feature);
//	public void delete(int featureId);
//	public Feature get(int featureId);
//	public List<Feature> getAll(int projectId);
}
