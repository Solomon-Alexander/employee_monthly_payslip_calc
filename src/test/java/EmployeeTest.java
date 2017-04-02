import junit.framework.TestCase;
import org.junit.Before;

/**
 * This class is responsible for unit testing the Employee model.
 * 
 *
 * @author Solomon Alexander
 * created on 02/04/2017
 */
public class EmployeeTest extends TestCase {
	private Employee employee;

	@Before
	public void setUp() {
		employee = new Employee("lynn", "chin", 65000, 0.40, "01 March - 31 March");
	}

	public void testIfEmployeeInstanceIsCreated() {
		assertNotNull(employee);
	}

	public void testIfAnnualSalaryIsInvalid() {
		try {
			employee.setAnnualSalary(-100000);
		} catch (PaySlipCalculatorException ex) {
			assertEquals("Invalid salary range. Salary value must be a positive integer", ex.getMessage());
		}
	}

	public void testSuperRateIsInvalid() {
		try {
			employee.setSuperRate(100.0);
		} catch (PaySlipCalculatorException ex) {
			assertEquals("Super rate must be between 0% - 50% inclusive", ex.getMessage());
		}
		try {
			employee.setAnnualSalary(-10000);
			employee.setSuperRate(43.0);
		} catch (PaySlipCalculatorException ex) {
			assertEquals("Invalid salary range. Salary value must be a positive integer", ex.getMessage());
		}
	}
}
