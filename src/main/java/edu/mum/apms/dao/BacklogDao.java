package edu.mum.apms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.mum.apms.model.Backlog;
import edu.mum.apms.model.Feature;

public interface BacklogDao extends JpaRepository<Backlog, Integer> {

	public List<Backlog> findByFeature(Feature feature);

}
