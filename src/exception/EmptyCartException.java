package exception;

public class EmptyCartException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public EmptyCartException() {
		super("Exception: Cannot remove from empty cart.");
	}

}