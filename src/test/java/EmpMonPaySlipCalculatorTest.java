import junit.framework.TestCase;
import java.util.List;
import org.junit.Before;
import com.demo.empmonthlypayslip.util.EmpMonPaySlipCalculator;
/**
 * This class is responsible for unit testing the PaySlipCalculator implementation.
 *
 * @author Solomon Alexander
 * created on 02/04/2017
 */
public class EmpMonPaySlipCalculatorTest extends TestCase{
	private EmpMonPaySlipCalculator empMonPaySlipCalculator;
	
	@Before
	public void setUp(){
		empMonPaySlipCalculator = new EmpMonPaySlipCalculator();
	}
	
	public void testExecute(){
		boolean result = empMonPaySlipCalculator.execute("input.txt","testOutput.txt");
		assertEquals(true, result);
	}
	
}
