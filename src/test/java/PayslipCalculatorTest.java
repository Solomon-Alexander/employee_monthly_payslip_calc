import junit.framework.TestCase;
import java.util.List;
import org.junit.Before;

/**
 * This class is responsible for unit testing the PaySlipCalculator implementation.
 *
 * @author Solomon Alexander
 * created on 02/04/2017
 */
public class PayslipCalculatorTest extends TestCase{
	private PaySlipCalculator paySlipCalculator;
	
	@Before
	public void setUp(){
		paySlipCalculator = new PaySlipCalculator();
	}
	
	public void testExecute(){
		boolean result = paySlipCalculator.execute("input.txt","testOutput.txt");
		assertEquals(true, result);
	}
	
}
