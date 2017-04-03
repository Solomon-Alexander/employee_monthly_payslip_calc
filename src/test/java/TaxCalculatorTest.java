import junit.framework.TestCase;
import com.demo.empmonthlypayslip.util.TaxCalculator;
/**
 * This class is responsible for unit testing the TaxCalculator implementation.
 * 
 *
 * @author Solomon Alexander
 * created on 02/04/2017
 */
public class TaxCalculatorTest extends TestCase {
	
	public void testWithInvalidAnnualIncome() {
		try {
			TaxCalculator.calculate(-1000);
		} catch (Exception ex) {
			assertEquals(ex.getMessage(), "Annual Salary must be greater than zero");
		}
	}

	public void testCalculateTaxableIncome()
	throws Exception {
		double result = TaxCalculator.calculate(60050);
		assertEquals(922, (long) result);
	}
}
