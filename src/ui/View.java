package ui;


/**
 * View interface
 * @author Vlassis Ioannis, Zagarelos Ioannis
 *
 */
public interface View {

    /**
     * Open the view 
     */
    void open();
    
    /**
     * Close the view
     */
    void close();
    
    /**
     * Display an error message
     * @param message error message
     */
    void showError(String message);
    
    /**
     * Display an information message
     * @param message information message
     */
    void showInfo(String message);
}
