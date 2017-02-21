package ui.contacts;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import ui.DefaultJFrame;
import ui.ViewFactory;

/**
 * the window containing the details of each contact of the active user.
 * @author Vlassis Ioannis, Zagarelos Ioannis
 *
 */
@SuppressWarnings("serial")
public class ContactDetailsJFrame extends DefaultJFrame implements ContactDetailsView{
	private JTextField nameTf;
	private JTextField surNameTf;
	private JTextField emailTf;
	private JTextField countryTf;
	private JTextField routeTf;
	private JTextField numberTf;
	private JTextField postalTf;
	private JButton btnNewButton;
    private ContactDetailsPresenter presenter;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ContactDetailsJFrame window = (ContactDetailsJFrame) ViewFactory.createContactDetailsJFrame();
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
	public ContactDetailsJFrame() {
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize(){
		setBounds(100, 100, 509, 203);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setTitle("Contact Details");
		
		JLabel lblNewLabel_1 = new JLabel("SurName :");
		
		JLabel lblEmail = new JLabel("E-mail :");
		
		JLabel lblCountry = new JLabel("Country :");
		
		JLabel lblRoute = new JLabel("Route :");
		
		JLabel lblNumber = new JLabel("Number :");
		
		JLabel lblPostalCode = new JLabel("Postal Code :");
		
		nameTf = new JTextField();
		
		nameTf.setColumns(10);
		nameTf.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				presenter.setName();	
			}
		});
		
		surNameTf = new JTextField();
		
		surNameTf.setColumns(10);
		surNameTf.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				presenter.setSurName();		
			}
		});
		JLabel lblNewLabel = new JLabel("FirstName :");
		
		emailTf = new JTextField();
		
		emailTf.setColumns(10);
		emailTf.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				presenter.setEmail();
			}
		});
		countryTf = new JTextField();
		
		countryTf.setColumns(10);
		countryTf.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				presenter.setCountry();
			}
		});
		routeTf = new JTextField();
		
		routeTf.setColumns(10);
		routeTf.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				presenter.setRoute();
				
			}
		});
		numberTf = new JTextField();
	
		numberTf.setColumns(10);
		numberTf.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				presenter.setNumber();	
			}
		});
		postalTf = new JTextField();
		
		postalTf.setColumns(10);
		postalTf.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				presenter.setPostal();	
			}
		});
		
		btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
			}
		});
		
		JButton btnNewButton_1 = new JButton("Apply");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nameTf.postActionEvent();
				surNameTf.postActionEvent();
				emailTf.postActionEvent();
				countryTf.postActionEvent();
				routeTf.postActionEvent();
				numberTf.postActionEvent();
				postalTf.postActionEvent();
				close();		
			}
		});
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
						.addComponent(lblEmail, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblNumber, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(nameTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(surNameTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(emailTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblCountry, GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
								.addComponent(lblRoute, GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
								.addComponent(lblPostalCode, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(routeTf, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
										.addComponent(postalTf, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
										.addComponent(countryTf, GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnNewButton_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnNewButton))))
						.addComponent(numberTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(countryTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(nameTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCountry))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(routeTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(surNameTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblRoute))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(postalTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(emailTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPostalCode))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNumber, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(numberTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
		setPreferredSize(getPreferredSize());
		setResizable(false);
		validate();
	}


	@Override
	public void setPresenter(ContactDetailsPresenter contactDetailsPresenter) {
		presenter = contactDetailsPresenter;
		
	}

	@Override
	public String getNameText() {
		return nameTf.getText();
	}

	@Override
	public String getSurNameText() {
		return surNameTf.getText();
	}

	@Override
	public String getEmailText() {
		return emailTf.getText();
	}

	@Override
	public String getCountryText() {
		return countryTf.getText();
	}

	@Override
	public String getRouteText() {
		return routeTf.getText();
	}

	@Override
	public String getNumberText() {
		return numberTf.getText();
	}

	@Override
	public String getPostalText() {
		return postalTf.getText();
	}

	@Override
	public void setNameText(String name) {
		nameTf.setText(name);	
	}

	@Override
	public void setSurNameText(String surname) {
		surNameTf.setText(surname);
	}

	@Override
	public void setEmailText(String email) {
		emailTf.setText(email);
	}

	@Override
	public void setCountryText(String country) {
		countryTf.setText(country);
	}

	@Override
	public void setRouteText(String route) {
		routeTf.setText(route);
	}

	@Override
	public void setNumberText(int number) {
		numberTf.setText(String.valueOf(number));
	}

	@Override
	public void setPostalText(int postalCode) {
		postalTf.setText( String.valueOf(postalCode));
	}
}
