package edu.mum.apms.dao;

import java.util.List;

import edu.mum.apms.model.TeamMember;

public interface TeamMemberDao {

	public TeamMember get(int memberId);

	public List<TeamMember> getAll();

	public void add(TeamMember member);

	public void edit(TeamMember member);

	public void delete(int memberId);

}
