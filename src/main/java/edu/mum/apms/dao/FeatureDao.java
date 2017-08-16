package edu.mum.apms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.mum.apms.model.Feature;
import edu.mum.apms.model.Project;

public interface FeatureDao extends JpaRepository<Feature, Integer> {
	public List<Feature> findByProject(Project project);

	@Query(" from Feature f where f.project.projectId = ?1 and f.backlog IS EMPTY")
	public List<Feature> findEmptyBacklogsById(int id);

}
