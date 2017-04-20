package exception;

public class InvalidPurchaseQuantityException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public InvalidPurchaseQuantityException() {
		super("Your cart is empty.");
	}

}