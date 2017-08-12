package edu.mum.apms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.mum.apms.model.TeamMember;

public interface TeamMemberDao extends JpaRepository<TeamMember, Integer>{

//	public TeamMember get(int memberId);
//
//	public List<TeamMember> getAll();

//	public void add(TeamMember member);
//
//	public void edit(TeamMember member);
//
//	public void delete(int memberId);

}
