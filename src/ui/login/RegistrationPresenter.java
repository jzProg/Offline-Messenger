package ui.login;

import javax.swing.ImageIcon;

import DAO.UserDAO;
import Domain.ChatUser;
import Domain.User;
import MemoryDAO.UserMDAO;

/**
 * Registration presenter
 * @author Vlassis Ioannis, Zagarelos Ioannis
 *
 */
public class RegistrationPresenter {

	RegistrationView view;
	UserDAO userdao;
	ImageIcon pic;
	
	/**
	 * Constructor with argument the registration view 
	 * @param view registration view
	 */
	public RegistrationPresenter(RegistrationView view) {
		this.view = view;
		userdao=new UserMDAO();
		this.view.setPresenter(this);
	}
	
	
	/**
	 * Open the view
	 */
	public void start(){
		view.open();
	}


	/**
	 * Register a user 
	 * Checks if username already exists or passwords do not match or are less than 8 characters long
	 */
	public void registerUser() {
		String username=view.getUsername();
		String pass1=view.getPassword1();
		String pass=view.getPassword();
		
		if(username==null || username.trim().equals("")){
			view.showError("Username=null");
			return;
		}
		if(pass==null || pass.trim().equals("")){
			view.showError("Password=null");
			return;
		}
		if(pass1==null || pass1.trim().equals("")){
			view.showError("Password verification=null");
			return;
		}
		if (pass.length()<8){
			view.showError("Password must be at least 8 characters long");
			return;
		}
		User u = userdao.find(username);
		if(u==null){
			if(pass.equals(pass1)){
				ChatUser user=new ChatUser(username,pass);
				user.setProfileImg(pic);
				userdao.save(user);
				view.showInfo("Registration completed successfully");
				view.startLogin();
			}
			else{
				view.showError("Passwords dont match");
				return;
			}
		}
		else {
			view.showError("Username is not available");
			return;
		}	
	}
	
	/**
	 * Set user's profile image
	 * @param icon
	 */
	public void setIcon(ImageIcon icon){
		pic=icon;
	}
}
