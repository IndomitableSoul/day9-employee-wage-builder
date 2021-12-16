package com.emp;

public interface EmpWageBuilderInterface {
	 int IS_PART_TIME = 1;
	 int IS_FULL_TIME = 2;
	 
	 public void addCompanyEmpWage(String company, int empRatePerHour, 
			 					   int numOfWorkingDays, int maxHrsPerMonth);
	 
	 
}
