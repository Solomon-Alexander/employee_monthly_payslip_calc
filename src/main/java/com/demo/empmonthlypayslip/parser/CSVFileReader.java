package com.demo.empmonthlypayslip.parser;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.FileNotFoundException;
import com.demo.empmonthlypayslip.model.Employee;
import com.demo.empmonthlypayslip.exception.PaySlipCalculatorException;

/**
 * This class is responsible for reading and processing a CSV
 * file containing employee salary slip details
 *
 * @author Solomon Alexander
 * created on 01/04/2017
 */
public class CSVFileReader {
	
	private static final String SEPERATOR_COMMA = ",";
	
	private static final String PERCENT = "%";
	
	/**
	   * This method is responsible for reading the CSV/Txt File containing the employee
	   * input data, parse and convert it into list of employee objects.
	   * @param fileName.
	   * @return List<Employee>.
	   * @throws PaySlipCalculatorException
	   */
	public List<Employee> readFrom(String fileName) throws PaySlipCalculatorException{
		List<Employee> employees = new ArrayList<Employee>();
		//Use try-with-resource to get auto-closeable BufferedReader instance
		try (BufferedReader br = Files.newBufferedReader(Paths.get(fileName))) {
			br.lines().map(line -> Arrays.asList(line.split(SEPERATOR_COMMA))).forEach(employeeDetails -> {
				Employee employee = new Employee();
				employee.setFirstName(employeeDetails.get(0));
				employee.setLastName(employeeDetails.get(1));
				employee.setAnnualSalary(Long.parseLong(employeeDetails.get(2)));
				employee.setPaymentStartDate(employeeDetails.get(4));
				employee.setSuperRate(fromPercentageStringToDouble(employeeDetails.get(3)));
				employees.add(employee);
			});
		}
		catch(Exception ex){
			throw new PaySlipCalculatorException("File does not exists or Unable to read from file");
		}
		return employees;
	}
	
	/**
	   * This method is responsible for converting the value into percentage.
	   * @param String.
	   * @return double.
	   * @throws PaySlipCalculatorException
	   */
	public double fromPercentageStringToDouble(String value) throws PaySlipCalculatorException{
		if(!value.endsWith(PERCENT)) {
			throw new PaySlipCalculatorException("value must ends with %");
		}

		return Double.parseDouble(value.substring(0, value.length() - 1)) / 100;
	}
	
}
