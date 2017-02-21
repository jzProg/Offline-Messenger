package ui;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


/**
 * @author Vlassis Ioannis, Zagarelos Ioannis
 *
 */
public class DefaultJFrame extends JFrame implements View {


    private static final long serialVersionUID = -1026655302725303603L;


    public void open() {
        setVisible(true);
        
    }


    public void close() {
       dispose();
    }


    public void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Messenger", JOptionPane.ERROR_MESSAGE);
    }


    public void showInfo(String message) {
        JOptionPane.showMessageDialog(this,message,"Messenger", JOptionPane.INFORMATION_MESSAGE);
    }

}
