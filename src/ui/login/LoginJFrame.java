package ui.login;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingUtilities;

import ui.DefaultJFrame;
import ui.ViewFactory;
import Util.Initializer;

/**
 * @author Vlassis Ioannis, Zagarelos Ioannis
 *
 */
@SuppressWarnings("serial")
public class LoginJFrame extends DefaultJFrame implements LoginView {

	private JTextField textField;
	private JPasswordField passwordField;
	private LoginPresenter presenter;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Initializer.initialize();
					LoginJFrame window = (LoginJFrame) ViewFactory.createLoginJFrame();
					window.presenter = new LoginPresenter(window);
					window.presenter.start();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginJFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setTitle("Login");
		setBounds(100, 100, 346, 149);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel lblUsername = new JLabel("Username :");
		lblUsername.setFont(new Font("Liberation Mono", Font.PLAIN, 14));

		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setFont(new Font("Liberation Mono", Font.PLAIN, 14));

		textField = new JTextField();
		textField.setColumns(10);

		JButton btnSignIn = new JButton("Sign In");
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				close();
				presenter.loginUser(getUsername(), getPassword());
			}
		});
		btnSignIn.setFont(new Font("Calibri", Font.PLAIN, 14));

		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				RegistrationPresenter pr=new RegistrationPresenter(ViewFactory.createRegistrationJFrame());
				pr.start();
			}
		});
		btnRegister.setFont(new Font("Calibri", Font.PLAIN, 14));

		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				System.exit(0);
			}
		});
		btnExit.setFont(new Font("Calibri", Font.PLAIN, 14));

		passwordField = new JPasswordField();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING,false)
						.addGroup(groupLayout.createSequentialGroup().addComponent(lblUsername).addPreferredGap(ComponentPlacement.UNRELATED).addComponent(textField))
						.addGroup(groupLayout.createSequentialGroup().addComponent(lblPassword).addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING,false)
						.addGroup(groupLayout.createSequentialGroup().addComponent(btnSignIn)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnRegister)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnExit))
						.addComponent(passwordField)))).addContainerGap(65, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout.createSequentialGroup()
										.addContainerGap().addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblUsername)
										.addComponent(textField,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(ComponentPlacement.UNRELATED).addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblPassword).addComponent(passwordField,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(ComponentPlacement.UNRELATED).addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(btnSignIn).addComponent(btnRegister).addComponent(btnExit))
										.addContainerGap(164, Short.MAX_VALUE)));
		getContentPane().setLayout(groupLayout);
		setPreferredSize(getPreferredSize());
		setResizable(false);
		validate();
	}

	@Override
	public String getUsername() {
		return textField.getText();
	}

	@Override
	public String getPassword() {
		return String.valueOf(passwordField.getPassword());
	}

	@Override
	public void startApp() {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				presenter.startAppForUser();
			}
		});
	}

	@Override
	public void setPresenter(LoginPresenter loginUIPresenter) {
		presenter=loginUIPresenter;
	}
	
}
