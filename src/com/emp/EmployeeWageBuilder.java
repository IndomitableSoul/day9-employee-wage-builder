package com.emp;

public class EmployeeWageBuilder {
	//constants
	public static final int IS_PART_TIME = 1;
	public static final int IS_FULL_TIME = 2;
	
	
	public static int computeEmpWage(String company, int empRate, 
									int numOfDays, int maxHrs) {
		  //variables
		  int totalEmpHrs = 0, totalEmpWage = 0;
		  int totalWorkingDays = 0;
				
		  //Computation
		  while (totalEmpHrs<=maxHrs && 
				  totalWorkingDays < numOfDays) {
					
		     int empHrs = 0;
		     totalWorkingDays++;
					
		     int empCheck = (int)Math.floor(Math.random()*10)%3;
		     switch(empCheck) {
					case IS_FULL_TIME:
						empHrs = 8;
						break;
					case IS_PART_TIME:
						empHrs = 4;
						break;
					default:
						empHrs = 0;
					}
					
		     totalEmpHrs += empHrs;
		     int empWage = empHrs * empRate;
		     totalEmpWage += empWage;		
		}
				
		 System.out.println("Total Emp Wage "+totalEmpWage);
				return totalEmpWage;
	 }
	 public static void main(String[] args) {
			/* UC-8
			 * Compute Employee Wage for multiple companies - Note: Each Company has its own
			 * wage, number of working days and working hours per month - Use Class Method
			 * with function parameters instead of Class Variables
			 */
		computeEmpWage("DMart", 20, 2, 10);
		computeEmpWage("Reliance Retail",10, 4,20);
	}
	
}
