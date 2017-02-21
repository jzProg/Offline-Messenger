
package ui.contacts;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import ui.DefaultJFrame;
import ui.ViewFactory;
import Domain.Contact;

/**
 * the window containing the contacts of the active user.
 * @author Vlassis Ioannis, Zagarelos Ioannis
 *
 */
@SuppressWarnings("serial")
public class ContactJFrame extends DefaultJFrame implements ContactsView , ActionListener{

	private final JScrollPane scrollPane = new JScrollPane();
	private DefaultListModel<Contact> list;
	private JList<Contact> cList;
	JPopupMenu popupMenu;
	private ContactsPresenter presenter;
	private Contact con;
	private String sortType;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ContactJFrame window = (ContactJFrame) ViewFactory.createContactJFrame();
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
	public ContactJFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setTitle("Contacts");
		setBounds(100, 100, 334, 345);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setRollover(true);
		toolBar.setFloatable(false);
		
		JButton btnNewButton = new JButton("Add Contact     ");
		btnNewButton.setToolTipText("Add new Contact");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addContactToListActionPerformed(e);
			}
		});
		toolBar.add(btnNewButton);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		toolBar.add(comboBox);
		comboBox.setToolTipText("Sort Contacts");
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Alphabetically", "By popularity"}));
		comboBox.setSelectedIndex(0);
		comboBox.addActionListener(this);
		JToolBar toolBar_1 = new JToolBar();
		toolBar_1.setFloatable(false);
		toolBar.add(toolBar_1);
		
		JButton btnBack = new JButton("   Back   ");
		btnBack.setHorizontalAlignment(SwingConstants.RIGHT);
		btnBack.setToolTipText("Back");
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
			}
		});
		toolBar_1.add(btnBack);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
					.addGroup(groupLayout.createSequentialGroup()
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
							.addGroup(groupLayout.createSequentialGroup()
								.addGap(10)
								.addComponent(scrollPane))
							.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
								.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, 217, GroupLayout.PREFERRED_SIZE)
								.addGap(35)
								.addComponent(toolBar_1, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(719, Short.MAX_VALUE))
			);
			groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
					.addGroup(groupLayout.createSequentialGroup()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(toolBar_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 274, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(258, Short.MAX_VALUE))
			);
		getContentPane().setLayout(groupLayout);
		list = new DefaultListModel<Contact>();
		cList = new JList<Contact>(list);
		
		
		JMenuItem jmi1=new JMenuItem("edit");
		jmi1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				con=(Contact) cList.getSelectedValue();
				presenter.editContact();
				
			}
		});
		
		JMenuItem jmi2=new JMenuItem("delete");
		jmi2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				con=(Contact) cList.getSelectedValue();
				presenter.deleteContact();
				list.removeElement(con);
				
			}
		});
		
		JMenuItem jmi3=new JMenuItem("add to blacklist");
		jmi3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				con=(Contact) cList.getSelectedValue();
				presenter.addBL();
				list.removeElement(con);
				
			}
		});
		
		popupMenu = new JPopupMenu();
		popupMenu.add(jmi1);
		popupMenu.add(jmi2);
		popupMenu.add(jmi3);
		
		cList.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent ev) {
				if(SwingUtilities.isRightMouseButton(ev) && !cList.isSelectionEmpty()){
					cList.setSelectedIndex(cList.locationToIndex(ev.getPoint()));
					popupMenu.show(cList, ev.getX(), ev.getY());
				}
			}
		});
		
		scrollPane.setViewportView(cList);
		getContentPane().add(scrollPane);
		getContentPane().setLayout(groupLayout);
		setPreferredSize(getPreferredSize());
		validate();
		setResizable(false);
	}
	
	
	
	/**
	 * interacts with the user and adds a new contact
	 * to list with the chosen username (by the user).
	 * @param e ,action event
	 */
	public void addContactToListActionPerformed(ActionEvent e){
		String username;
		username = JOptionPane.showInputDialog("Insert new Contact's username"); 
		presenter.addContactToList(username);
	}
	

	@Override
	public void setPresenter(ContactsPresenter presenter) {
        this.presenter = presenter;        
    }
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
        JComboBox<String> cb = (JComboBox)e.getSource();
        sortType = (String)cb.getSelectedItem();
        updateList(sortType);
    }

	/**
	 * updates the list of contacts by the sort type.
	 * @param sortType ,the sort type
	 */
	private void updateList(String sortType) {
		presenter.setContactList(sortType);	
	}

	@Override
	public void setContacts(java.util.List<Contact> notBlacklistedContacts) {
		list.clear();
		for (Contact con: notBlacklistedContacts){
			list.addElement(con);
		}
		cList.setModel(list);
	}

	@Override
	public Contact getContact() {
		return con;
	}

	@Override
	public String getSortType(){
		return sortType;
	}

	@Override
	public void setContact(Contact con) {
		this.con = con;		
	}
		
}
