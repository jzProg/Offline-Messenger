package ui.mainApp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
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
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;

import ui.DefaultJFrame;
import ui.ViewFactory;
import ui.contacts.BlackListJFrame;
import ui.contacts.BlackListPresenter;

/**
 * the window containing the settings of the active user.
 * @author Vlassis Ioannis, Zagarelos Ioannis
 *
 */
@SuppressWarnings("serial")
public class SettingsJFrame extends DefaultJFrame implements SettingsView {

    private SettingsPresenter presenter;
    private ImageIcon img;
	private String password;
	private JLabel lblNewLabel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SettingsJFrame window = (SettingsJFrame) ViewFactory.createSettingsJFrame();
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
	public SettingsJFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setTitle("Settings");
		setBounds(100, 100, 277, 305);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		
		JButton btnChangePassword = new JButton("Change Password");
		btnChangePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changePasswordActionPerformed(e);
			}
		});
		
		btnChangePassword.setFont(new Font("Tahoma", Font.PLAIN, 13));
		JButton button2 = new JButton("Change Profile Picture");
		button2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changePicActionPerformed(e);
			}
		});
		
		JButton btnNewButton = new JButton("View BlackList");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewBlacklistActionPerformed(e);
			}
		});
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
			}
		});
		
		lblNewLabel = new JLabel(""); 
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setIcon(img);
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel.createSequentialGroup()
								.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(btnChangePassword, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(btnNewButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(button2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE))
								.addContainerGap())
							.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
								.addComponent(btnBack)
								.addContainerGap()))))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(6)
					.addComponent(btnBack)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(2)
							.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)))
					.addComponent(btnChangePassword, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(button2, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addGap(86))
		);
		
		panel.setLayout(gl_panel);
		setPreferredSize(getPreferredSize());
		setResizable(false);
	}
	
	@Override
	public ImageIcon getImage(){
		return img;
	}
	
	@Override
	public void setImage(ImageIcon img){
		this.img = img;
		updateIcon();
	}
	
	@Override
	public void setPresenter(SettingsPresenter presenter) {
        this.presenter = presenter;       
    }
	
	/**
	 * interacts with the user and changes the password
	 * @param e , action event
	 */
	public void changePasswordActionPerformed(ActionEvent e){
		String password;
		password = JOptionPane.showInputDialog("Insert old Password");
		int confirm = presenter.OldPasswordConfirm(password);
		while ( confirm != 0 && confirm != -1 ){
			password = JOptionPane.showInputDialog("Wrong Password! Insert old Password again!");
			confirm = presenter.OldPasswordConfirm(password);
		}
		if (confirm == 0) {
			password = JOptionPane.showInputDialog("Insert new Password"); 
			if (password != null){
		    setPassword(password);
		    presenter.setNewPassword();
			}
		}
	}
	
	
	/**
	 * changes the password of the user.
	 * @param password ,the new password
	 */
	private void setPassword(String password) {
		this.password = password;
		
	}
	
	@Override
	public String getPassword() {
		return password;
	}

	/**
	 * interacts with the user and changes the profile picture.
	 * @param e ,action event
	 */
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
			pic =ImageIO.read(file);
			
		} catch (IOException e1) {
	     	e1.printStackTrace();
		}
		
		Image dimg = pic.getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(),Image.SCALE_SMOOTH);
		ImageIcon icon=new ImageIcon(dimg);
		setImage(icon);
		lblNewLabel.setIcon(img);
		presenter.setprofilepicture();
		}
	}
	
    /**
     * updates the profile picture of the user.
     */
    public void updateIcon(){
    	lblNewLabel.setIcon(img);
	}

	/**
	 * opens a blacklist window in order for the user 
	 * to see the list with the black listed contacts.
	 * @see BlackListJFrame
	 * @see BlackListPresenter
	 * @param e ,action event
	 */
	public void viewBlacklistActionPerformed(ActionEvent e){
		 SwingUtilities.invokeLater(new Runnable() {
             public void run() {
             	 BlackListJFrame inst = (BlackListJFrame) ViewFactory.createBlackListJFrame();
                 BlackListPresenter blPresenter = new BlackListPresenter(inst,presenter.getUser());
                 blPresenter.start();
             }
		 });
	}
}
