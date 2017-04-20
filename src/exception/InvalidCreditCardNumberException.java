package exception;

public class InvalidCreditCardNumberException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidCreditCardNumberException() {
		super("Invalid credit card number.");
	}

}
