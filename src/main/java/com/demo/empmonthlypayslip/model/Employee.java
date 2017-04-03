package com.demo.empmonthlypayslip.model;

import com.demo.empmonthlypayslip.exception.PaySlipCalculatorException;
/**
 * This class represents the employee model.
 * i.e First Name, Last Name, Annual Salary etc
 * 
 *
 * @author Solomon Alexander
 * created on 01/04/2017
 */
public class Employee {
	
	private String firstName;
	private String lastName;
	private long annualSalary;
	private double superRate;
	private String paymentStartDate;
	private int incomeTax;
	private int superAmount;
	
	public Employee(){
	}
	
	public Employee(String firstName, String lastName, long annualSalary, double superRate, String paymentStartDate){
		this.firstName = firstName;
		this.lastName = lastName;
		this.annualSalary = annualSalary;
		this.superRate = superRate;
		this.paymentStartDate = paymentStartDate;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public long getAnnualSalary() {
		return annualSalary;
	}

	public void setAnnualSalary(long annualSalary) {
		this.annualSalary = annualSalary;
	}

	public double getSuperRate() {
		return superRate;
	}

	public void setSuperRate(double superRate) {
		this.superRate = superRate;
	}

	public String getPaymentStartDate() {
		return paymentStartDate;
	}

	public void setPaymentStartDate(String paymentStartDate) {
		this.paymentStartDate = paymentStartDate;
	}
	
	public void validate() throws PaySlipCalculatorException{
		boolean isValid = false;
		
		if(annualSalary < 0){
			throw new PaySlipCalculatorException("Invalid salary range. Salary value must be a positive integer");
		}else if(superRate < 0.0 || superRate > 50.0){
			throw new PaySlipCalculatorException("Super rate must be between 0% - 50% inclusive");
		}
	}

	public int getIncomeTax() {
		return incomeTax;
	}

	public void setIncomeTax(int incomeTax) {
		this.incomeTax = incomeTax;
	}

	public int getSuperAmount() {
		return superAmount;
	}

	public void setSuperAmount(int superAmount) {
		this.superAmount = superAmount;
	}

	public int grossIncome(){
		return Math.round(annualSalary/12);
	}
	
	public int netIncome(){
		return (grossIncome()-incomeTax);
	}
	
	@Override
	public String toString(){
		return this.getFirstName() + " " + this.getLastName() + "," + getPaymentStartDate() + "," + grossIncome() + "," + incomeTax + "," + netIncome() + "," + superAmount;
	}
	
}
