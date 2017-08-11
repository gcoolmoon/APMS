package edu.mum.apms.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.mum.apms.model.TeamMember;

@Repository
public class TeamMemberDaoImpl implements TeamMemberDao {

	@Autowired
	private SessionFactory session;

	@Override
	public TeamMember get(int memberId) {
		return (TeamMember) session.getCurrentSession().get(TeamMember.class, memberId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TeamMember> getAll() {
		return session.getCurrentSession().createQuery("FROM TeamMember").list();
	}

	@Override
	public void add(TeamMember member) {
		session.getCurrentSession().save(member);
	}

	@Override
	public void edit(TeamMember member) {
		session.getCurrentSession().save(member);
	}

	@Override
	public void delete(int memberId) {
		session.getCurrentSession().delete(get(memberId));

	}

}
