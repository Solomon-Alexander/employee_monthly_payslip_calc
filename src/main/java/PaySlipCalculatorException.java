/**
 * This is the custom exception class to be thrown when the employee pay slip calculation
 * fails. 
 * 
 *
 * @author Solomon Alexander
 * created on 01/04/2017
 */
public class PaySlipCalculatorException extends RuntimeException{
	private String message;
	
	public PaySlipCalculatorException(String message){
		super(message);
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
}
