package edu.mum.apms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.mum.apms.model.TeamMember;

public interface TeamMemberDao extends JpaRepository<TeamMember, Integer> {

	@Query("SELECT DISTINCT tm FROM TeamMember tm JOIN tm.tasksAssigned task JOIN task.backlog b where b.id = ?1")
	List<TeamMember> getTeamByBacklogId(int id);	
	
	@Query("Select t from TeamMember t where t.position like %?1%")
	List<TeamMember> getTeamByPosition(String position);
}
