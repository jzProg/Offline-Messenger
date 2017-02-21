package Util;

/**
 * @author Vlassis Ioannis, Zagarelos Ioannis
 *
 */
@SuppressWarnings("serial")
public class MessengerException extends RuntimeException {

	public MessengerException() { }
    
    public MessengerException(String message) {
        super(message);
    }

    public MessengerException(String message, Throwable cause) {
        super(message, cause);
    }

    public MessengerException(Throwable cause) {
        super(cause);
    }
}
