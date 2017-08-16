package edu.mum.apms.service;

import java.util.List;

import edu.mum.apms.model.TeamMember;
import edu.mum.apms.model.User;

public interface TeamMemberService {

	public TeamMember getTeamMemberById(int memberId);

	public List<TeamMember> getAllTeamMember();

	public void addTeamMember(TeamMember teamMember);

	public void updateTeamMember(TeamMember teamMember);

	public void deleteMember(int memberId);

	public List<TeamMember> getTeamMembersByPosition(String position);
	
	public TeamMember getTeamMemberByUser(User user);
}
