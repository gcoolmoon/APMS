package edu.mum.apms.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.apms.dao.TeamMemberDao;
import edu.mum.apms.model.TeamMember;

@Service
public class TeamMemberServiceImpl implements TeamMemberService {

	@Autowired
	private TeamMemberDao teamDao;

	@Override
	@Transactional
	public TeamMember getTeamMemberById(int memberId) {
		return teamDao.findOne(memberId);
	}

	@Override
	@Transactional
	public List<TeamMember> getAllTeamMember() {
		return teamDao.findAll();
	}

	@Override
	@Transactional
	public void addTeamMember(TeamMember teamMember) {
		//teamDao.add(teamMember);
	//	return null;
	}

	@Override
	@Transactional
	public void updateTeamMember(TeamMember teamMember) {
		//teamDao.edit(teamMember);
	}

	@Override
	@Transactional
	public void deleteMember(int memberId) {
		teamDao.delete(memberId);
	}

}
