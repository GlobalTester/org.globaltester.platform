package org.globaltester.platform;

/**
 * This exception is thrown, if the requirements for the execution are not met.
 * @author mboonk
 *
 */
public class ExecutionRequirementsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String reason;
	private String usermessage;

	public ExecutionRequirementsException(Exception e) {
		this(e.getMessage(), "Exception: " + e.getMessage(), e);
	}
	
	public ExecutionRequirementsException(String reason, String usermessage, Exception e) {
		super(reason, e);
		this.reason = reason;
		this.usermessage = usermessage;
	}

	public ExecutionRequirementsException(String reason, String usermessage) {
		super(reason);
		this.reason = reason;
		this.usermessage = usermessage;
	}
	
	public String getReason() {
		return reason;
	}
	
	public String getUserMessage() {
		return usermessage;
	}

}
