package Util;

import java.util.Arrays;
import java.util.HashSet;

import DAO.ConversationDAO;
import DAO.UserDAO;
import Domain.Admin;
import Domain.ChatUser;
import Domain.Contact;
import Domain.Conversation;
import Domain.Message;
import MemoryDAO.ConversationMDAO;
import MemoryDAO.UserMDAO;

/**
 * Initializer
 * @author Vlassis Ioannis, Zagarelos Ioannis
 *
 */
public class Initializer {
	
	
	/**
	 * Initialize data and store it in Memory Dao for junit testing
	 * 
	 *  Users : 
	 *  
	 *  Username	Password	Contacts
	 *  mhtsos		12345678	giannhs,nikos,athina,paulos,anastasia
	 *  giannhs		12345678	mhtsos,nikos
	 *  nikos		12345678	mhtsos,paulos
	 *  paulos		12345678	giannhs,mhtsos
	 *  anastasia	12345678	
	 *  athina		12345678	mhtsos,paulos
	 *  mhtsos13	12345678
	 *  
	 *  admin		12345678
	 *  admin2		12345678
	 *  
	 *  
	 */
	public static void initialize(){
		
		
		ChatUser user1=new ChatUser("mhtsos","12345678");
		ChatUser user2=new ChatUser("giannhs","12345678");
		ChatUser user3=new ChatUser("nikos","12345678");
		ChatUser user4=new ChatUser("paulos","12345678");
		ChatUser user5=new ChatUser("anastasia","12345678");
		ChatUser user6=new ChatUser("athina","12345678");
		ChatUser user7=new ChatUser("mhtsos13","12345678");
		Admin ad=new Admin("admin", "12345678");
		Admin ad2=new Admin("admin2", "12345678");
		
		user1.addContact(new Contact("giannhs"));
		user1.addContact(new Contact("nikos"));
		user1.addContact(new Contact("athina"));
		user1.addContact(new Contact("paulos"));
		user2.addContact(new Contact("mhtsos"));
		user2.addContact(new Contact("nikos"));
		user4.addContact(new Contact("giannhs"));
		user4.addContact(new Contact("mhtsos"));
		user3.addContact(new Contact("mhtsos"));
		user3.addContact(new Contact("paulos"));
		user6.addContact(new Contact("mhtsos"));
		user6.addContact(new Contact("paulos"));
		Contact anastasia = new Contact("anastasia");
		anastasia.setName("anastasia");
		user1.addContact(anastasia);
		
		Conversation con1=new Conversation();
		con1.addUsers(new HashSet<ChatUser>(Arrays.asList(user1,user2)));
		Conversation con2=new Conversation();
		con2.addUsers(new HashSet<ChatUser>(Arrays.asList(user1,user4,user6)));
		Conversation con3=new Conversation();
		con3.addUsers(new HashSet<ChatUser>(Arrays.asList(user3,user1,user4)));
		
		
		con1.addConversationToUsers();
		con2.addConversationToUsers();
		con3.addConversationToUsers();
		con1.sendMessage(new Message("mhtsos", "test1",new SimpleCalendar(2015,3,12)));
		con1.sendMessage(new Message("giannhs", "test2",new SimpleCalendar(2015,4,15)));
		con1.sendMessage("mhtsos", "test3");

		ConversationDAO convDao=new ConversationMDAO();
		UserDAO userdao = new UserMDAO();
		userdao.clear();
		convDao.clear();
		
		convDao.save(con1);
		convDao.save(con2);
		convDao.save(con3);
		userdao.save(user1);
		userdao.save(user2);
		userdao.save(user3);
		userdao.save(user5);
		userdao.save(user4);
		userdao.save(user6);
		userdao.save(user7);
		userdao.save(ad);
		userdao.save(ad2);
	}

}
