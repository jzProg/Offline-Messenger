package ui.conversation;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

import ui.DefaultJFrame;
import ui.ViewFactory;
import ui.contacts.ContactSelectionPresenter;
import ui.mainApp.MainWindowPresenter;

/**
 * @author Vlassis Ioannis, Zagarelos Ioannis
 *
 */
@SuppressWarnings("serial")
public class NewMessageJFrame extends  DefaultJFrame implements NewMessageView{

	JEditorPane editorPane;
	NewMessagePresenter presenter;
	ContactSelectionPresenter contactSelectionPresenter =new ContactSelectionPresenter(ViewFactory.createContactSelectionJFrame());
	MainWindowPresenter mainPresenter;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewMessageJFrame window = (NewMessageJFrame) ViewFactory.createNewMessageJFrame();
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
	public NewMessageJFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setBounds(100, 100, 343, 170);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JLabel lblTo = new JLabel("To :");
		
		JButton btnSend = new JButton("Send");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				presenter.setContactsToSend(contactSelectionPresenter.getSelectedContacts());
				presenter.sendMessage();
				
			}
		});
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				close();	
			}
		});
		editorPane = new JEditorPane();
		
		JButton btnAddContacts = new JButton("add Contacts");
		btnAddContacts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				contactSelectionPresenter.setUser(presenter.getUser());
				contactSelectionPresenter.start();
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblTo)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnAddContacts, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addComponent(editorPane, GroupLayout.PREFERRED_SIZE, 243, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnSend, GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
						.addComponent(btnCancel, GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTo)
						.addComponent(btnAddContacts))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(btnSend)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnCancel))
						.addComponent(editorPane, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(23, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
		setPreferredSize(getPreferredSize());
		validate();
		setResizable(false);
	}

	@Override
	public String getMessage() {
		return editorPane.getText();
	}

	@Override
	public void setPresenter(NewMessagePresenter newMessagePresenter) {
		presenter=newMessagePresenter;
	}
	
}
