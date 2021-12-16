package com.emp;

public class CompanyEmpWage {
	 String company;
	 int empRatePerHour;
	 int numOfWorkingDays;
	 int maxHrsPerMonth;
	 public int totalEmpWage;

	public CompanyEmpWage(String company, int empRatePerHour, int numOfWorkingDays, int maxHrsPerMonth) {
		super();
		this.company = company;
		this.empRatePerHour = empRatePerHour;
		this.numOfWorkingDays = numOfWorkingDays;
		this.maxHrsPerMonth = maxHrsPerMonth;
	}
	
	public void setTotalEmpWage(int totalEmpWage) {
		this.totalEmpWage = totalEmpWage;
	}
	
	@Override
	public String toString() {
		
		return company+" has a total wage of " +totalEmpWage;
	}
}
