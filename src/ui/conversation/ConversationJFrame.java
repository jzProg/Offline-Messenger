package ui.conversation;

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
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingUtilities;

import ui.DefaultJFrame;
import ui.ViewFactory;
import Domain.Message;

/**
 * @author Vlassis Ioannis, Zagarelos Ioannis
 *
 */
@SuppressWarnings("serial")
public class ConversationJFrame extends DefaultJFrame implements ConversationView{

	private final JScrollPane scrollPane = new JScrollPane();
	JEditorPane editorPane;
	JList<Message> list;
	DefaultListModel<Message> listModel;
	ConversationPresenter presenter;
	JPopupMenu popupMenu;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConversationJFrame window = (ConversationJFrame) ViewFactory.createConversationJFrame();
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
	public ConversationJFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setBounds(100, 100, 321, 433);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JButton btnSend = new JButton("Send");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				presenter.sendMessage();
				editorPane.setText("");
			}
		});
		
		editorPane = new JEditorPane();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(editorPane, GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnSend)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 288, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnSend)
						.addComponent(editorPane, GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE))
					.addContainerGap())
		);
		
		JMenuItem jmi1=new JMenuItem("delete");
		jmi1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Message message=(Message) list.getSelectedValue();
				presenter.deleteMessage(message);
				listModel.removeElement(message);
				
			}
		});
		popupMenu = new JPopupMenu();
		popupMenu.add(jmi1);
		
		
		list = new JList<Message>();
		listModel=new DefaultListModel<Message>();
		list.setModel(listModel);
		list.setSelectedIndex(listModel.getSize());
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
	public String getMessage() {
		return editorPane.getText();
	}

	@Override
	public void setMessageList(List<Message> messages) {
		listModel.clear();
		for(Message m: messages)
			listModel.addElement(m);
	}
	@Override
	public void setPresenter(ConversationPresenter presenter) {
		this.presenter = presenter;
	}
	
	@Override
	public void addMessageToList(Message m) {
		listModel.addElement(m);
	}
}
