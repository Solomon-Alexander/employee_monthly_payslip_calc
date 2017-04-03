import java.util.List;

/**
 * This entry point class is responsible for calculating the pay slip information
 * for the employee and writing the details into the CSV/TXT file
 * 
 *
 * @author Solomon Alexander
 * created on 01/04/2017
 */
public class PaySlipCalculator {
	
	/**
	   * This method is responsible for calculating the monthly employee payslip details
	   * into CSV/Txt File.
	   * @param inputFile, outputFile
	   * @return void.
	   * @throws PaySlipCalculatorException
	   */
	public boolean execute(String inputFile, String outputFile){
		 CSVFileReader reader = new CSVFileReader();
		 List<Employee> employees = reader.readFrom(inputFile);
		
		 employees.forEach ( employee -> {
			 employee.setIncomeTax((int)calculateIncomeTax(employee.getAnnualSalary()));
			 employee.setSuperAmount((int)calculateSuper(employee.grossIncome(),employee.getSuperRate()));
		 });
		
		CSVFileWriter writer = new CSVFileWriter();
		return writer.writeToFile(outputFile,employees);
	}
	
	/**
	   * This main method is responsible for running within the jar file built using
	   * gradle to generate the monthly employee salary slip details.
	   * into the output CSV/Txt File.
	   * 
	   * @param String[]
	   * @return void.
	   * @throws PaySlipCalculatorException
	   */
	public static void main(String[] args){
		if(args.length < 2){
			System.out.println("Command:java -jar employee_monthly_payslip_calc-1.0-SNAPSHOT.jar <input file> <output file>");
		}
		PaySlipCalculator paySlipCalculator = new PaySlipCalculator();
		if(paySlipCalculator.execute(args[0],args[1]))
		System.out.println("Employee Monthly Salary Slip Details are calculated as per the provided input data and written into output.txt file. Please check.");
	}
	
	/**
	   * This method is responsible for calculating the income tax for the employee
	   * based on the annual salary
	   * 	   
	   * @param annualSalary
	   * @return long.
	   */
	public long calculateIncomeTax(long annualSalary){
		return TaxCalculator.calculate(annualSalary);
	}
	/**
	   * This method is responsible for calculating the super for the employee
	   * based on the grossIncome and superRate
	   * 
	   * @param annualSalary
	   * @return long.
	   */	
	public double calculateSuper(int grossIncome, double superRate){
		return SuperCalculator.calculate(grossIncome,superRate);
	}
}
