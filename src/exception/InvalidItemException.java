package exception;

public class InvalidItemException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public InvalidItemException() {
		super("Invalid item passed to process.");
	}

}