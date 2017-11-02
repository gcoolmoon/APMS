package edu.mum.apms.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.apms.dao.TeamMemberDao;
import edu.mum.apms.model.TeamMember;
import edu.mum.apms.model.User;

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
		teamDao.save(teamMember);
	}

	@Override
	@Transactional
	public void updateTeamMember(TeamMember teamMember) {
		teamDao.save(teamMember);
	}

	@Override
	@Transactional
	public void deleteMember(int memberId) {
		teamDao.delete(memberId);
	}

	@Override
	public List<TeamMember> getTeamMembersByPosition(String position) {
		// TODO Auto-generated method stub
		return teamDao.getTeamByPosition(position);
	}

	@Override
	public TeamMember getTeamMemberByUser(User user) {
		// TODO Auto-generated method stub
		return teamDao.getTeamMemberByUser(user);
	}

}
