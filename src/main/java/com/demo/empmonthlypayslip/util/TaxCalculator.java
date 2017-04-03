package com.demo.empmonthlypayslip.util;

import java.util.ArrayList;
import java.util.List;
import com.demo.empmonthlypayslip.model.TaxItem;
import com.demo.empmonthlypayslip.exception.PaySlipCalculatorException;

/**
 * This class is responsible for calculating the tax for the employee
 * based on the minimum and maximum tax threshold rules
 * 
 *
 * @author Solomon Alexander
 * created on 01/04/2017
 */
public class TaxCalculator {

	/**
	   * This method is responsible for initializing the tax threshold rules for tax
	   * calculation.
	   * 	   
	   * @return List<TaxItem>
	   */
	private static List<TaxItem> initializeTaxItems() {
		List<TaxItem> taxItems = new ArrayList<TaxItem>();

		TaxItem itemOne = new TaxItem(18200, 37000, 0.19, 0);
		TaxItem itemTwo = new TaxItem(37000, 80000, 0.325, 3572);
		TaxItem itemThree = new TaxItem(80000, 180000, 0.37, 17547);
		TaxItem itemFour = new TaxItem(180000, Integer.MAX_VALUE, 0.45, 54547);

		taxItems.add(itemOne);
		taxItems.add(itemTwo);
		taxItems.add(itemThree);
		taxItems.add(itemFour);

		return taxItems;
	}

	/**
	   * This method is responsible for calculating the salary after tax deductions
	   * 	   
	   * @param annualSalary
	   * @return long
	   */
	public static long calculate(long annualSalary) throws PaySlipCalculatorException {
		if (annualSalary < 0) {
			throw new PaySlipCalculatorException("Annual Salary must be greater than zero");
		}
		for (TaxItem item : initializeTaxItems()) {
			if (annualSalary > item.getMinLimit() && annualSalary <= item.getMaxLimit()) {
				return Math.round((item.getAdditionCost() + (annualSalary - item.getMinLimit()) * item.getTaxRate()) / 12);
			}
		}
		return annualSalary;
	}
}
