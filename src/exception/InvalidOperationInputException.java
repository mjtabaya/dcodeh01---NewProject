package exception;

public class InvalidOperationInputException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public InvalidOperationInputException() {
		super("Exception: Input not recognized as an operation.");
	}

}