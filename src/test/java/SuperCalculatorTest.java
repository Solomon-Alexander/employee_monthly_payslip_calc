import junit.framework.TestCase;
import org.junit.Before;

/**
 * This class is responsible for unit testing the SuperCalculator implementation.
 * 
 *
 * @author Solomon Alexander
 * created on 02/04/2017
 */
public class SuperCalculatorTest extends TestCase {
	
	public void testCalculateSuper(){
		int result = SuperCalculator.calculate(5004,0.09);
		assertEquals(450, result);
	}
}
