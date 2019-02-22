/*
 * References: http://www.site.uottawa.ca/~anayak/CSI2114S06/labs/Lab2/01%20Stacks/FullStackException.java
 */

/*public class FullStackException extends Exception {

	public FullStackException() {
		// TODO Auto-generated constructor stub
	}

	public FullStackException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public FullStackException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public FullStackException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public FullStackException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}*/

/**
 * Runtime exception thrown when one tries to perform operation push
 * on a full stack.
 */

/*public class FullStackException extends RuntimeException {
  public FullStackException(String err) {
    super(err);
  }
}*/

/*
 * References: https://github.com/careercup/CtCI-6th-Edition/blob/master/Java/Ch%2003.%20Stacks%20and%20Queues/Q3_01_Three_in_One/FullStackException.java
 */
public class FullStackException extends Exception {
	private static final long serialVersionUID = 1L;

	public FullStackException(){
        super();
    }

    public FullStackException(String message){
        super(message);
    }
}
