package MemoryDAO;

import java.util.HashSet;
import java.util.Set;

import DAO.ConversationDAO;
import Domain.ChatUser;
import Domain.Conversation;

/**
 * @author Vlassis Ioannis, Zagarelos Ioannis
 *
 */
public class ConversationMDAO implements ConversationDAO  {

	protected static Set<Conversation> conversations=new HashSet<Conversation>();
	
	public boolean save(Conversation entity) {
		return conversations.add(entity);
	}

	public boolean delete(Conversation entity) {
		return conversations.remove(entity);
	}

	public boolean delete(int id) {
		return conversations.remove(find(id));
	}
	
	public Set<Conversation> findAll() {
		return new HashSet<Conversation>(conversations);
	}

	public boolean contains(Conversation entity) {
		return conversations.contains(entity);
	}
	
	public Set<Conversation> findConvOfUser(ChatUser u){
		Set<Conversation> c=new HashSet<Conversation>();
		for (Conversation conv: conversations)
			if (conv.getReceivers().contains(u))
				c.add(conv);
		return c;
	}
	
	public Conversation find(int id) {
		for (Conversation conv: conversations)
			if (conv.getID()==id)
				return conv;
		return null;
	}

	public void clear(){
		conversations.clear();
	}
}
