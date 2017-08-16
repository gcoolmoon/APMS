package edu.mum.apms.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.apms.dao.BacklogDao;
import edu.mum.apms.dao.FeatureDao;
import edu.mum.apms.dao.ProjectDao;
import edu.mum.apms.dao.TeamMemberDao;
import edu.mum.apms.model.Backlog;
import edu.mum.apms.model.Feature;
import edu.mum.apms.model.TeamMember;

@Service
public class BacklogServiceImpl implements BacklogService{

	@Autowired
	private BacklogDao backlogDao;
	
	@Autowired
	private FeatureDao featureDao;
	
	@Autowired
	private ProjectDao projectDao;
	
	@Autowired
	private TeamMemberDao teamDao;
	
	@Override
	@Transactional
	public Backlog getBacklogById(int backlogId) {
		return backlogDao.findOne(backlogId);
	}

	@Override
	@Transactional
	public List<Backlog> getAllBacklogByProject(int projectId) {
		
		List<Feature> featureList= featureDao.findByProject(projectDao.getOne(projectId));
		List<Backlog> backlogList = new ArrayList<Backlog>();
		
		for(Feature feature: featureList){
			backlogList.addAll(backlogDao.findByFeature(feature));
		}
		 
		return backlogList;		
	}

	@Override
	@Transactional
	public List<Backlog> getAllActiveBacklogByProject(int projectId) {
		return null;
		//return backlogDao.getAllActiveByProject(projectId);
	}

	@Override
	@Transactional
	public void addBacklog(Backlog backlog) {
		backlogDao.save(backlog);
	}

	@Override
	@Transactional
	public void updateBacklog(Backlog backlog) {
		backlogDao.save(backlog);		
	}

	@Override
	@Transactional
	public void deleteBacklog(int backlogId) {
		backlogDao.delete(backlogId);		
	}

	@Override
	@Transactional
	public List<Feature> getAddableFeatures(int projectId) {
		
		return featureDao.findEmptyBacklogsById(projectId);		

//		List<Feature> features = featureDao.findByProject(projectDao.findOne(projectId));
//		List<Feature> featureList = new ArrayList<Feature>();
//		
//		for(Feature feature: features){
//			if(feature.getBacklog()==null){
//				featureList.add(feature);
//			}
//		}
//		return featureList;
	}

	@Override
	@Transactional
	public List<TeamMember> getTeamMemberByBacklogId(int backlogId) {
		// TODO Auto-generated method stub
		return teamDao.getTeamByBacklogId(backlogId);
	}

}
