package com.demo.empmonthlypayslip.util;

/**
 * This class is responsible for calculating the super for the employee
 * based on the gross income and super rate.
 * 
 *
 * @author Solomon Alexander
 * created on 01/04/2017
 */
public class SuperCalculator {
	
	/**
	   * This method is responsible for calculating the super for the employee
	   * based on the grossIncome and superRate
	   * 	   
	   * @param grossIncome
	   * @param superRate
	   * @return long.
	   */
	public static int calculate(double grossIncome, double superRate){
		return (int)Math.round(grossIncome * superRate);
	}
}
