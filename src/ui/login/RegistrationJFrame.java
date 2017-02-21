package ui.login;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.filechooser.FileNameExtensionFilter;

import ui.DefaultJFrame;
import ui.ViewFactory;

/**
 * @author Vlassis Ioannis, Zagarelos Ioannis
 *
 */
@SuppressWarnings("serial")
public class RegistrationJFrame extends DefaultJFrame implements RegistrationView{
	
	private final JLabel lblEnterUsername = new JLabel("Enter Username");
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JLabel lblNewLabel;
	private RegistrationPresenter presenter;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrationJFrame window = (RegistrationJFrame) ViewFactory.createRegistrationJFrame();
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
	public RegistrationJFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setBounds(100, 100, 271, 310);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		JLabel lblEnterPassword = new JLabel("Enter Password ");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(Color.WHITE);
		
		JButton btnAddImage = new JButton("Add Image");
		btnAddImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				changePicActionPerformed(arg0);
			}
		});
		
		JLabel lblVerifyPassword = new JLabel("Verify Password");
		
		passwordField = new JPasswordField();
		
		passwordField_1 = new JPasswordField();
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				presenter.registerUser();
			}
		});
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startLogin();
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnRegister, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnCancel, GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblVerifyPassword)
								.addComponent(lblEnterUsername, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblEnterPassword)
								.addComponent(btnAddImage))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
								.addComponent(passwordField_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
								.addComponent(textField, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
								.addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE))))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEnterUsername, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEnterPassword)
						.addComponent(passwordField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblVerifyPassword)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnAddImage)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnRegister)
						.addComponent(btnCancel))
					.addContainerGap())
		);
		getContentPane().setLayout(groupLayout);
		setPreferredSize(getPreferredSize());
		validate();
		setResizable(false);
	}
	
	
	public void changePicActionPerformed(ActionEvent e){
		Image pic = null; 
		JFileChooser fc = new JFileChooser(System.getProperty("user.dir"));
		fc.setDialogType(JFileChooser.OPEN_DIALOG);
		fc.setDialogTitle("Select File");
		fc.setFileFilter(new FileNameExtensionFilter("png","png"));
		int result = fc.showOpenDialog(this);
		if (result==JFileChooser.CANCEL_OPTION){
			dispose();
		}
		File file = fc.getSelectedFile();
		if (file == null || file.getName().equals("")){
			dispose();
		}
		if (file != null){
		try {
			pic = ImageIO.read(file);
		} catch (IOException e1) {
	     	e1.printStackTrace();
		}
		Image dimg = pic.getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(),Image.SCALE_SMOOTH);
		ImageIcon icon=new ImageIcon(dimg);
		lblNewLabel.setIcon(icon);
		presenter.setIcon(icon);
		}
	}

	@Override
	public void setPresenter(RegistrationPresenter registrationPresenter) {
		presenter=registrationPresenter;
	}

	@Override
	public String getUsername() {
		return textField.getText();
	}

	@Override
	public String getPassword1() {
		return String.valueOf(passwordField_1.getPassword());
	}

	@Override
	public String getPassword() {
		return String.valueOf(passwordField.getPassword());
	}
	
	@Override
	public void startLogin(){
		dispose();
		LoginPresenter login=new LoginPresenter(ViewFactory.createLoginJFrame());
		login.start();

	}
}
