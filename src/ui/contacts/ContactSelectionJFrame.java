package ui.contacts;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.DefaultListSelectionModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;

import ui.DefaultJFrame;
import ui.ViewFactory;
import Domain.Contact;
import Util.CheckboxListCellRenderer;

/**
 * @author Vlassis Ioannis, Zagarelos Ioannis
 *
 */
@SuppressWarnings("serial")
public class ContactSelectionJFrame extends DefaultJFrame implements ContactSelectionView {
	private JScrollPane scrollPane;
	private ContactSelectionPresenter presenter;
	private DefaultListModel<Contact> listModel;
	private JList<Contact> list;
	private JButton btnCancel;
	private JButton btnOk;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ContactSelectionJFrame dialog = (ContactSelectionJFrame) ViewFactory.createContactSelectionJFrame();			
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ContactSelectionJFrame() {
		
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setTitle("Select Contacts");
		setBounds(100, 100, 318, 350);
		{
			scrollPane = new JScrollPane();
		}
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				presenter.setSelectedContacts(getSelectedContacts());
				close();
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(btnOk, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnCancel))
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancel)
						.addComponent(btnOk))
					.addContainerGap())
		);
		listModel=new DefaultListModel<Contact>();
		
		list = new JList<Contact>(listModel);
		list.setCellRenderer(new CheckboxListCellRenderer<Contact>());
		list.setSelectionModel(new DefaultListSelectionModel() {
		    @Override
		    public void setSelectionInterval(int index0, int index1) {
		        if(super.isSelectedIndex(index0)) {
		            super.removeSelectionInterval(index0, index1);
		        }
		        else {
		            super.addSelectionInterval(index0, index1);
		        }
		    }
		});
		scrollPane.setViewportView(list);
		getContentPane().setLayout(groupLayout);
	}
	
	
	@Override
	public void setContactsList(List<Contact> l){
		listModel.clear();
		for(Contact c: l)
			listModel.addElement(c);
	}
	
	@Override
	public List<Contact> getSelectedContacts(){
		return list.getSelectedValuesList();
	}

	@Override
	public void setPresenter(ContactSelectionPresenter contactSelectionPresenter) {
		presenter=contactSelectionPresenter;
	}
}
