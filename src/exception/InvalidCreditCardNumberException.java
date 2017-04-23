package exception;

public class InvalidCreditCardNumberException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidCreditCardNumberException() {
		super("Exception: Invalid credit card number.");
	}

}
