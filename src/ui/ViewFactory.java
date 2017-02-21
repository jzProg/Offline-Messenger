package ui;

import ui.admin.AdminJFrame;
import ui.admin.AdminView;
import ui.contacts.BlackListJFrame;
import ui.contacts.BlackListView;
import ui.contacts.ContactDetailsJFrame;
import ui.contacts.ContactDetailsView;
import ui.contacts.ContactJFrame;
import ui.contacts.ContactSelectionJFrame;
import ui.contacts.ContactSelectionView;
import ui.contacts.ContactsView;
import ui.conversation.ConversationJFrame;
import ui.conversation.ConversationView;
import ui.conversation.NewMessageJFrame;
import ui.conversation.NewMessageView;
import ui.login.LoginJFrame;
import ui.login.LoginView;
import ui.login.RegistrationJFrame;
import ui.login.RegistrationView;
import ui.mainApp.MainWindowJFrame;
import ui.mainApp.MainWindowView;
import ui.mainApp.SettingsJFrame;
import ui.mainApp.SettingsView;

/**
 * @author Vlassis Ioannis, Zagarelos Ioannis
 *
 */
public class ViewFactory {

	private static LoginView loginStub;
	private static MainWindowView mainStub;
	private static BlackListView blistStub;
	private static AdminView adminStub;
	private static ContactDetailsView contdetStub;
	private static ContactsView contStub;
	private static ContactSelectionView contselStub;
	private static ConversationView convStub;
	private static NewMessageView messageStub;
	private static RegistrationView regStub;
	private static SettingsView settingsStub;
	
	
	
	public static LoginView createLoginJFrame() {
		return loginStub==null ? new LoginJFrame() : loginStub;
	}

	public static MainWindowView createMainWindowJFrame() {
		return mainStub==null? new MainWindowJFrame() : mainStub;
	}

	public static BlackListView createBlackListJFrame() {
		return blistStub==null ? new BlackListJFrame() : blistStub;
	}

	public static AdminView createAdminJFrame() {
		return adminStub==null ? new AdminJFrame() : adminStub;
	}

	public static ContactDetailsView createContactDetailsJFrame() {
		return contdetStub==null ? new ContactDetailsJFrame(): contdetStub;
	}

	public static ContactsView createContactJFrame() {
		return contStub==null ? new ContactJFrame(): contStub;
	}

	public static ContactSelectionView createContactSelectionJFrame() {
		return contselStub==null ? new ContactSelectionJFrame(): contselStub;
	}

	public static ConversationView createConversationJFrame() {
		return convStub==null ? new ConversationJFrame() : convStub;
	}

	public static NewMessageView createNewMessageJFrame() {
		return messageStub==null ? new NewMessageJFrame() : messageStub;
	}

	public static RegistrationView createRegistrationJFrame() {
		return regStub==null ? new RegistrationJFrame(): regStub;
	}

	public static SettingsView createSettingsJFrame() {
		return settingsStub==null ? new SettingsJFrame(): settingsStub;
	}

	public static void setLogin(LoginView login) {
		ViewFactory.loginStub = login;
	}

	public static void setMain(MainWindowView main) {
		ViewFactory.mainStub = main;
	}

	public static void setBlist(BlackListView blist) {
		ViewFactory.blistStub = blist;
	}

	public static void setAdmin(AdminView admin) {
		ViewFactory.adminStub = admin;
	}

	public static void setContdet(ContactDetailsView contdet) {
		ViewFactory.contdetStub = contdet;
	}

	public static void setCont(ContactsView cont) {
		ViewFactory.contStub = cont;
	}

	public static void setContsel(ContactSelectionView contsel) {
		ViewFactory.contselStub = contsel;
	}

	public static void setConv(ConversationView conv) {
		ViewFactory.convStub = conv;
	}

	public static void setMessage(NewMessageView message) {
		ViewFactory.messageStub = message;
	}

	public static void setReg(RegistrationView reg) {
		ViewFactory.regStub = reg;
	}

	public static void setSet(SettingsView set) {
		ViewFactory.settingsStub = set;
	}
	
	public void reset(){
		loginStub=null;
		mainStub=null;
		blistStub=null;
		adminStub=null;
		contdetStub=null;
		contStub=null;
		contselStub=null;
		convStub=null;
		messageStub=null;
		regStub=null;
		settingsStub=null;
	}

}
