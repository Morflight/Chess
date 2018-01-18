package business;

public class InvalidBoxFormatException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5641054116846516855L;
	
	public InvalidBoxFormatException() {
		super();
	}
	
	public InvalidBoxFormatException(String msg) {
		super(msg);
	}
	
	public InvalidBoxFormatException(Throwable cause) {
		super(cause);
	}
	
	public InvalidBoxFormatException(String msg, Throwable cause) {
		super(msg, cause);
	}
	
}
