package exception;

public class RemoveCoinFailedException extends Exception {

	private static final long serialVersionUID = 1L;
	public String message;
	
	public RemoveCoinFailedException(String message) {
		this.message = message;
	}
}