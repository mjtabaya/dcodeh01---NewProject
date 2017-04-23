package exception;

public class InvalidRemoveException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public InvalidRemoveException() {
		super("Exception: Cannot checkout with an empty cart.");
	}

}