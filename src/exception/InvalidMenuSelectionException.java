package exception;

public class InvalidMenuSelectionException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public InvalidMenuSelectionException() {
		super("Exception: Input not recognized as an operation.");
	}

}