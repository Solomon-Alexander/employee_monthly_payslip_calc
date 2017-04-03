import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import junit.framework.TestCase;
import org.mockito.Mockito;
import com.demo.empmonthlypayslip.model.Employee;
import com.demo.empmonthlypayslip.parser.CSVFileWriter;
/**
 * This class is responsible for unit testing the CSVFileWriter implementation.
 * 
 *
 * @author Solomon Alexander
 * created on 02/04/2017
 */
public class CSVFileWriterTest extends TestCase{
	private CSVFileWriter writer;
	
	@Before
	public void setUp(){
		writer = new CSVFileWriter();
	}
	
	public void testWriteDataToFile(){
		Employee employeeOne = Mockito.mock(Employee.class);
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(employeeOne);
		boolean result = writer.writeToFile("output.txt",employees);
		assertEquals(true,result);
	}
}
