import junit.framework.TestCase;
import org.easymock.EasyMock;
import org.junit.Before;
import java.util.ArrayList;
import java.util.List;

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
		Employee employeeOne = EasyMock.createNiceMock(Employee.class);
		EasyMock.replay(employeeOne);
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(employeeOne);
		writer.writeToFile("output.txt",employees);
	}
}
