package ui.mainApp;

import javax.swing.ImageIcon;

import ui.View;



/**
 * the view of the settings window
 * @see SettingsJFrame
 * @author Vlassis Ioannis, Zagarelos Ioannis
 *
 */
public interface SettingsView extends View{
	
	/**
	 * Sets the presenter of the view.
	 * @param presenter ,the new presenter
	 */
	void setPresenter(SettingsPresenter presenter);
	
	/**
	 * returns the profile picture of the user.
	 * @return the profile picture
	 */
	ImageIcon getImage();
	
	/**
	 * returns the password of the user.
	 * @return the password
	 */
	String getPassword();
	
	/**
	 * changes the profile picture of the user.
	 * @param profileImg ,the new profile picture
	 */
	void setImage(ImageIcon profileImg);
}
