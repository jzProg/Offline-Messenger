package ui.contacts;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;

import ui.DefaultJFrame;
import ui.ViewFactory;
import Domain.Contact;

/**
 * the window containing the black list of the user
 * @author Vlassis Ioannis, Zagarelos Ioannis
 *
 */
@SuppressWarnings("serial")
public class BlackListJFrame extends DefaultJFrame implements BlackListView{
	
	private DefaultListModel<Contact> list;
	private BlackListPresenter presenter;
	private JList<Contact> blList;
	private Contact con;
	JPopupMenu popupMenu;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BlackListJFrame window = (BlackListJFrame) ViewFactory.createBlackListJFrame();
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
	public BlackListJFrame(){
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(){
		setTitle("BlackList");
		setBounds(100, 100, 330, 280);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		list = new DefaultListModel<Contact>();
		blList = new JList<Contact>(list);
	      
        blList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        blList.setSelectedIndex(0);
        blList.setVisibleRowCount(8);
        
        JMenuItem jmi1=new JMenuItem("delete");
		jmi1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				con=(Contact) blList.getSelectedValue();
				presenter.deleteBlContact();
				list.removeElement(con);
			}
		});
		popupMenu = new JPopupMenu();
		popupMenu.add(jmi1);
		
		blList.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent ev) {
				if(SwingUtilities.isRightMouseButton(ev) && !blList.isSelectionEmpty()){
					blList.setSelectedIndex(blList.locationToIndex(ev.getPoint()));
					popupMenu.show(blList, ev.getX(), ev.getY());
				}
			}
		});
		
        JScrollPane listScroller = new JScrollPane(blList);
        listScroller.setPreferredSize(new Dimension(300, 180));
        
        JButton btnBack = new JButton("Back");
        btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
			}
		});
        GroupLayout gl_panel = new GroupLayout(panel);
        gl_panel.setHorizontalGroup(
        	gl_panel.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_panel.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
        				.addComponent(btnBack)
        				.addComponent(listScroller, GroupLayout.PREFERRED_SIZE, 290, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap(7, Short.MAX_VALUE))
        );
        gl_panel.setVerticalGroup(
        	gl_panel.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_panel.createSequentialGroup()
        			.addGap(6)
        			.addComponent(btnBack)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(listScroller, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)
        			.addGap(19))
        );
        panel.setLayout(gl_panel);
	}

	@Override
	public void setPresenter(BlackListPresenter blackListPresenter) {
		this.presenter = blackListPresenter;
	}

	@Override
	public void setBLContactList(List<Contact> blacklistedContacts) {
		list.clear();
		for(Contact con: blacklistedContacts){
			list.addElement(con);
		}
		blList.setModel(list);
	}

	@Override
	public Contact getBLContact() {
		return con;
	}
	
	@Override
	public void setBLContact(Contact con){
		this.con = con;
	}
	
}
