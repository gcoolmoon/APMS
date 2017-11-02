package edu.mum.apms.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.apms.dao.UserDao;
import edu.mum.apms.dao.UserRoleDao;
import edu.mum.apms.dao.UserDao;
import edu.mum.apms.model.User;
import edu.mum.apms.model.UserRole;
import edu.mum.apms.model.User;



//@Service("userService")
@Service
@Transactional
public class UserServiceImpl implements UserService, UserDetailsService{

	@Autowired
	private UserDao userDao;
	
	

	@Transactional
	public void add(User user) {
		userDao.save(user);
	}

	@Transactional
	public void edit(User user) {
		userDao.save(user);
	}

	@Transactional
	public void delete(int userId) {
		userDao.delete(userId);
	}

	@Transactional
	public User get(int userId) {
		return userDao.findOne(userId);
	}

	@Transactional
	public List<User> getAll() {
		return userDao.findAll();
	}

	@Override
	public boolean checkPassword(int userId, String pass) {
		return pass.equals(get(userId).getPassword());
	}

	@Override
	public User checkPassword(String email, String pass) {
		// TODO Auto-generated method stub
		
		List<User> users = this.getAll();
		for (User user : users) {
			if(email.equals(user.getEmail()) && pass.equals(user.getPassword())) {
				return user;
			}
			
		}
		return null;
	}
	
	@Override
	@Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findByEmail(username);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (UserRole role : user.getUserRoles()){
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getRole()));
        }

        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), grantedAuthorities);
    }
	

	

//	//@Autowired
//    //private PasswordEncoder passwordEncoder;
//	
//	
//	/*
//	 * Since the method is running with Transaction, No need to call hibernate update explicitly.
//	 * Just fetch the entity from db and update it with proper values within transaction.
//	 * It will be updated in db once transaction ends. 
//	 */
//	
//
//	public List<User> findAllUsers() {
//		return dao.findAll();
//	}
//
//	public boolean isUserEmpIdUnique(Integer id, String empId) {
//		User user = findByEmployeeId(empId);
//		return ( user == null || ((id != null) && (user.getId() == id)));
//	}
//
//	@Override
//	public User findById(int id) {
//		// TODO Auto-generated method stub
//		return dao.findOne(id);
//	}
//
//	@Override
//	public User findByEmployeeId(String empId) {
//		// TODO Auto-generated method stub
//		if(dao.findByEmployeeId(empId)!= null)
//			return dao.findByEmployeeId(empId).get(0);
//		else
//			return null;
//	}
//
//	@Override
//	public void saveUser(User user) {
//		// TODO Auto-generated method stub
//		//user.setPassword(passwordEncoder.encode(user.getPassword()));
//		user.setPassword(user.getPassword());
//		dao.save(user);
//		
//	}
//
//	@Override
//	public void updateUser(User user) {
//		// TODO Auto-generated method stub
//		User entity = dao.findById(user.getId());
//		if(entity!=null){
//			entity.setEmployeeId(user.getEmployeeId());
//			if(!user.getPassword().equals(entity.getPassword())){
//				//entity.setPassword(passwordEncoder.encode(user.getPassword()));
//				entity.setPassword(user.getPassword());
//			}
//			entity.setFirstName(user.getFirstName());
//			entity.setLastName(user.getLastName());
//			entity.setEmail(user.getEmail());
//			entity.setUserRoles(user.getUserRoles());
//		}
//		
//	}
//
//	@Override
//	public void deleteUserByEmpId(String empId) {
//		// TODO Auto-generated method stub
//		dao.deleteByEmployeeId(empId);
//		
//	}

	
}
