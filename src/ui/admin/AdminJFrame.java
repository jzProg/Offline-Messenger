package ui.admin;

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
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingUtilities;

import ui.DefaultJFrame;
import ui.ViewFactory;
import ui.login.LoginPresenter;
import Domain.User;

/**
 * @author Vlassis Ioannis, Zagarelos Ioannis
 *
 */
@SuppressWarnings("serial")
public class AdminJFrame extends DefaultJFrame implements AdminView{

	
	private final JScrollPane scrollPane = new JScrollPane();
	JList<User> list;
	AdminPresenter presenter;
	DefaultListModel<User> listModel;
	JPopupMenu popupMenu;
	JTextField password,username;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminJFrame window = (AdminJFrame) ViewFactory.createAdminJFrame();
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
	public AdminJFrame() {
		
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				LoginPresenter login=new LoginPresenter(ViewFactory.createLoginJFrame());
				login.start();;
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnLogout)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnLogout)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		
		JMenuItem jmi1=new JMenuItem("edit");
		jmi1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				User user=(User) list.getSelectedValue();
				username = new JTextField(user.getUsername());
				password = new JTextField(user.getPassword());
				Object[] message = {
				    "Username:", username,
				    "Password:", password
				};

				int option = JOptionPane.showConfirmDialog(null, message, "Login", JOptionPane.OK_CANCEL_OPTION);
				if (option == JOptionPane.OK_OPTION) {
					presenter.changeUserPassword(user);
					presenter.changeUserUsername(user);
				}
			}
		});
		JMenuItem jmi2=new JMenuItem("delete");
		jmi2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				User user=(User) list.getSelectedValue();
				presenter.deleteUser(user);
				
			}
		});
		
		popupMenu = new JPopupMenu();
		popupMenu.add(jmi1);
		popupMenu.add(jmi2);
		
		list = new JList<User>();
		listModel=new DefaultListModel<User>();
		list.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent ev) {
				if(SwingUtilities.isRightMouseButton(ev) && !list.isSelectionEmpty()){
					list.setSelectedIndex(list.locationToIndex(ev.getPoint()));
					popupMenu.show(list, ev.getX(), ev.getY());
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
	public void setUserList(Set<User> users) {
		for(User user: users)
			listModel.addElement(user);
		list.setModel(listModel);
	}

	@Override
	public void setPresenter(AdminPresenter adminPresenter) {
		presenter=adminPresenter;
	}


	@Override
	public String getUsername() {
		return username.getText();
	}

	@Override
	public String getPassword() {
		return password.getText();
	}
	
	

}
