package exception;

public class InvalidQuantityException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public InvalidQuantityException() {
		super("Invalid quantity in process.");
	}

}