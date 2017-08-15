package edu.mum.apms.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.mum.apms.dao.SprintDao;
import edu.mum.apms.model.Sprint;

@Service
public class SprintServiceImpl implements SprintService {

	@Autowired
	private SprintDao sprintDao;

	@Transactional
	public void add(Sprint sprint) {
		sprintDao.save(sprint);
	}

	@Transactional
	public void edit(Sprint sprint) {
		sprintDao.save(sprint);
	}

	@Transactional
	public void delete(int sprintId) {
		sprintDao.delete(sprintId);
	}

	@Transactional
	public Sprint get(int sprintId) {
		return sprintDao.findOne(sprintId);
	}

	@Transactional
	public List<Sprint> getAll() {
		return sprintDao.findAll();
	}

}
