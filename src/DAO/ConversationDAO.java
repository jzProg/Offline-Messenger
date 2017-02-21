package DAO;

import java.util.Set;

import Domain.ChatUser;
import Domain.Conversation;


/**
 * DAO for class {@link Conversation}
 * @author Vlassis Ioannis, Zagarelos Ioannis
 *
 */
public interface ConversationDAO {
	
	/**
	 * Saves a conversation to an external data source
     * The conversation may be new conversation or an updated status of an existing conversation
     * @param entity conversation to be saved
     * @return true if completed successfully
	 */
	boolean save(Conversation entity);

	/**
     * Delete a conversation from the external data source
     * @param entity conversation to be deleted
     * @return true if completed successfully
     */
	boolean delete(Conversation entity);
    
	/**
     * Return a set of all conversations from the external data source
     * @return set of all conversations
     */
    Set<Conversation> findAll();

    /**
     * Search by id for a conversation and delete it
     * @param id id of conversation 
     * @return true if completed successfully
     */
    boolean delete(int id);

    /**
     * Search by id for a conversation and return it
     * @param id id of conversation 
     * @return true if completed successfully
     */
	Conversation find(int id);
	
	/**
	 * Return a set of all the conversations that have 
	 * the given chat user in their receivers set
	 * @param user chat user
	 * @return set of conversations
	 */
	Set<Conversation> findConvOfUser(ChatUser user);

	/**
	 * Search data source if contains a conversation
	 * @param entity conversation to search 
	 * @return true if data source contains the user
	 */
	boolean contains(Conversation entity);

	/**
	 * Delete all entries in data source
	 */
	void clear();
	
}
