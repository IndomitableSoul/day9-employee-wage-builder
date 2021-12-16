package com.emp;

public class EmployeeWageBuilder {
	//constants
	public static final int IS_PART_TIME = 1;
	public static final int IS_FULL_TIME = 2;
	
	private String company;
	private int empRatePerHour;
	private int numOfWorkingDays;
	private int maxHrsPerMonth;
	
	
	
	public EmployeeWageBuilder(String company, int empRatePerHour, int numOfWorkingDays, int maxHrsPerMonth) {
		super();
		this.company = company;
		this.empRatePerHour = empRatePerHour;
		this.numOfWorkingDays = numOfWorkingDays;
		this.maxHrsPerMonth = maxHrsPerMonth;
	}
	public int computeEmpWage() {
		  //variables
		  int totalEmpHrs = 0, totalEmpWage = 0;
		  int totalWorkingDays = 0;
				
		  //Computation
		  while (totalEmpHrs<=maxHrsPerMonth && 
				  totalWorkingDays < numOfWorkingDays) {
					
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
		     int empWage = empHrs * empRatePerHour;
		     totalEmpWage += empWage;		
		}
		 return totalEmpWage;
	 }
	 public static void main(String[] args) {
			/* UC-9
			 * Ability to save the Total Wage for Each Company - 
			 * Note: You can Create EmpWageBuilder for each Company
			 * Use Instance Variable instead of function parameters
			 */
		EmployeeWageBuilder dMart = new EmployeeWageBuilder("DMart", 20, 2, 10);
		System.out.println("Total Emp Wage for Company "+dMart.company+" is "+dMart.computeEmpWage());
		EmployeeWageBuilder bigBasket = new EmployeeWageBuilder("BigBasket", 10, 2, 10);
		System.out.println("Total Emp Wage for Company "+bigBasket.company+" is "+bigBasket.computeEmpWage());
		
	}
	
}
