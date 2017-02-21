package MemoryDAO;

import java.util.HashSet;
import java.util.Set;

import DAO.UserDAO;
import Domain.User;

/**
 * @author Vlassis Ioannis, Zagarelos Ioannis
 *
 */
public class UserMDAO implements UserDAO {

	protected static Set<User> users = new HashSet<User>();

	
	public boolean save(User entity) {
		return users.add(entity);
	}

	public boolean delete(User entity) {
		return users.remove(entity);
	}

	public Set<User> findAll() {
		return new HashSet<User>(users);
	}

	public User find(String username) {
		for(User user : users)
			if (user.getUsername().equals(username))
				return user;
		return null;
				
	}


	public boolean contains(User chatUser) {
		return users.contains(chatUser);
	}

	public void clear() {
		users.clear();
	}

	

}
