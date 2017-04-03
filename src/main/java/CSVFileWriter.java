import java.io.IOException;
import java.util.List;
import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.FileWriter;
/**
 * This class is responsible for writing the employee monthly salary
 * slip details into a CSV file
 * 
 * @author Solomon Alexander
 * created on 01/04/2017
 */
public class CSVFileWriter {
	
	/**
	   * This method is responsible for writing the calculated employee monthly payslip details
	   * into CSV/Txt File.
	   * @param fileName
	   * @param List<Employee> employees
	   * @return boolean.
	   * @throws PaySlipCalculatorException
	   */
	public boolean writeToFile(String fileName, List<Employee> employees) {
		try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(fileName)))
		{
			for (Employee employee : employees) {
				writer.append(employee.toString());
				writer.append("\n");
			}
		}
		catch (IOException e) {
			throw new PaySlipCalculatorException("Unable to write to file");
		}
		return true;
	}
}
