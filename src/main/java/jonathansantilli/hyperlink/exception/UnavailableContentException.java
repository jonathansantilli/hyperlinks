package jonathansantilli.hyperlink.exception;

/**
 * This Exception class represents errors getting HTML static content
 * 
 * @author Jonathan Santilli
 *
 */
public class UnavailableContentException extends Exception {
	private static final long serialVersionUID = 1249855852581323787L;

	public UnavailableContentException(Throwable cause) {
		 super(cause);
	}
}
