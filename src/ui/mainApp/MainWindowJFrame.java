package ui.mainApp;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Set;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingUtilities;

import ui.DefaultJFrame;
import ui.ViewFactory;
import ui.contacts.ContactsPresenter;
import ui.conversation.ConversationPresenter;
import ui.conversation.NewMessagePresenter;
import ui.login.LoginPresenter;
import Domain.Conversation;

/**
 * @author Vlassis Ioannis, Zagarelos Ioannis
 *
 */
@SuppressWarnings("serial")
public class MainWindowJFrame extends DefaultJFrame implements MainWindowView{

	private final JScrollPane scrollPane = new JScrollPane();
	JPopupMenu popupMenu;
	JList<Conversation> list;
	MainWindowPresenter presenter;
	DefaultListModel<Conversation> listModel;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindowJFrame window = (MainWindowJFrame) ViewFactory.createMainWindowJFrame();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindowJFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setBounds(100, 100, 337, 363);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setFloatable(false);
		
		JButton btnNewMessage = new JButton("New Message");
		btnNewMessage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*SwingUtilities.invokeLater(new Runnable(){
					public void run() {*/
						NewMessagePresenter pre=new NewMessagePresenter(ViewFactory.createNewMessageJFrame());
						pre.setUser(presenter.getUser());
						pre.setMainPresenter(presenter);
						pre.start();
					/*}
				});*/
			}
		});
		toolBar.add(btnNewMessage);
		
		JButton btnContacts = new JButton("Contacts");
		btnContacts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SwingUtilities.invokeLater(new Runnable(){
					public void run() {
						ContactsPresenter cpresenter=new ContactsPresenter(ViewFactory.createContactJFrame(),presenter.getUser());
						cpresenter.start();
					}
				});
			}
		});
		toolBar.add(btnContacts);
		
		JButton btnSettings = new JButton("Settings");
		btnSettings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SwingUtilities.invokeLater(new Runnable(){
					public void run() {
						SettingsPresenter spresenter=new SettingsPresenter(ViewFactory.createSettingsJFrame());
						spresenter.setUser(presenter.getUser());
						spresenter.start();
					}
				});
			}
		});
		toolBar.add(btnSettings);

		JToolBar toolBar_1 = new JToolBar();
		toolBar_1.setFloatable(false);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						LoginPresenter login=new LoginPresenter(ViewFactory.createLoginJFrame());
						login.start();
					}
				});
			}
		});
		toolBar_1.add(btnLogout);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 111, Short.MAX_VALUE)
							.addComponent(toolBar_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(10)
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(toolBar_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JMenuItem jmi1=new JMenuItem("delete");
		jmi1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Conversation conv=(Conversation) list.getSelectedValue();
				presenter.deleteConversation(conv);
				listModel.removeElement(conv);
				
			}
		});
		
		popupMenu = new JPopupMenu();
		popupMenu.add(jmi1);
		list = new JList<Conversation>();
		listModel=new DefaultListModel<Conversation>();
		list.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent ev) {
				if(SwingUtilities.isRightMouseButton(ev) && !list.isSelectionEmpty()){
					list.setSelectedIndex(list.locationToIndex(ev.getPoint()));
					popupMenu.show(list, ev.getX(), ev.getY());
				}
				else if (ev.getClickCount() == 2 && SwingUtilities.isLeftMouseButton(ev)){
					if (!list.isSelectionEmpty())
						startConversationPresenter(list.getSelectedValue());
				}
				else if (ev.getClickCount() == 3 && SwingUtilities.isLeftMouseButton(ev)){
					if (!list.isSelectionEmpty())
						startConversationPresenter(list.getSelectedValue());
				}
			}
		});
		scrollPane.setViewportView(list);
		getContentPane().setLayout(groupLayout);
		setPreferredSize(getPreferredSize());
		validate();
		setResizable(false);
	}

	@Override
	public void setConvList(Set<Conversation> s) {
		listModel.clear();
		for(Conversation conv: s)
			listModel.addElement(conv);
		list.setModel(listModel);
	}

	public void setPresenter(MainWindowPresenter presenter) {
		this.presenter = presenter;
	}
	
	public void startConversationPresenter(final Conversation conversation) {
		SwingUtilities.invokeLater(new Runnable(){
			public void run() {
				ConversationPresenter convPres=new ConversationPresenter(ViewFactory.createConversationJFrame());
				convPres.setConversation(conversation);
				convPres.setUser(presenter.getUser());
				convPres.start();
			}
		});
	}
	
}
