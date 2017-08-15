package edu.mum.apms.service;

import java.util.List;

import edu.mum.apms.model.TeamMember;

public interface TeamMemberService {

	public TeamMember getTeamMemberById(int memberId);

	public List<TeamMember> getAllTeamMember();

	public void addTeamMember(TeamMember teamMember);

	public void updateTeamMember(TeamMember teamMember);

	public void deleteMember(int memberId);
	
//	@Query("select tm FROM TeamMember tm join tm.Task t join t.tm u where u.id = :userId")
//	public List<TeamMember> getAllTeamByBacklogId(int backlogId);
}
