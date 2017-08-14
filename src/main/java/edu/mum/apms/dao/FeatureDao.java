package edu.mum.apms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.mum.apms.model.Feature;
import edu.mum.apms.model.Project;

public interface FeatureDao extends JpaRepository<Feature, Integer>  {
	public  List<Feature> findByProject(Project project);
//	public void edit(Feature feature);
//	public void delete(int featureId);
//	public Feature get(int featureId);
//	public List<Feature> getAll(int projectId);
	
	//@Query("from Feature f where isEmpty(f.backlog) and f.project.projectId = :id")
	//public List<Feature> findEmptyBacklogsById(int id);
	
}
