package DAO;

import java.util.Set;

import Domain.User;

/**
 * DAO for class {@link User}
 * @author Vlassis Ioannis, Zagarelos Ioannis
 *
 */
public interface UserDAO {

	
	/**
	 * Find user by his username
	 * @param username username of user
	 * @return found user or null
	 */
	User find(String username );
    
    /**
     * Saves a user to an external data source
     * The user may be new user or an updated status of an existing user
     * @param entity user to be saved
     * @return true if completed successfully
     */
    boolean save(User entity);

    /**
     * Delete a user from the external data source
     * @param entity user to be deleted
     * @return true if completed successfully
     */
    boolean delete(User entity);
    
    /**
     * Return a set of all users from the external data source
     * @return set of all users
     */
    Set<User> findAll();
	
	/**
	 * Search data source if contains a user
	 * @param user user to search 
	 * @return true if data source contains the user
	 */
	boolean contains(User user);

	/**
	 * Delete all entries in data source
	 */
	void clear();
}
