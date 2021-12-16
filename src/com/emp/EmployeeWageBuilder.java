package com.emp;

public class EmployeeWageBuilder implements EmpWageBuilderInterface{
	//constants
	
	public CompanyEmpWage[] companyWageArray  ;
	private int numberOfCompany = 0;
	
	
	public EmployeeWageBuilder() {
		super();
		companyWageArray = new CompanyEmpWage[5];
	}

	@Override
	public void addCompanyEmpWage(String company, int empRatePerHour, int numOfWorkingDays, int maxHrsPerMonth) {
		 companyWageArray[numberOfCompany] = new CompanyEmpWage(company, empRatePerHour, numOfWorkingDays, maxHrsPerMonth);
		 numberOfCompany++;
	}
	

	public void computeEmpWage() {
		for(int i=0; i<numberOfCompany; i++) {

			companyWageArray[i].setTotalEmpWage(this.computeEmpWage(companyWageArray[i]));
			System.out.println(companyWageArray[i]);
		}
	}
	

	public int computeEmpWage(CompanyEmpWage companyEmpWage) {
		  //variables
		  int totalEmpHrs = 0, totalEmpWage = 0;
		  int totalWorkingDays = 0;
				
		  //Computation
		  while (totalEmpHrs<=companyEmpWage.maxHrsPerMonth && 
				  totalWorkingDays < companyEmpWage.numOfWorkingDays) {
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
		     int empWage = empHrs * companyEmpWage.empRatePerHour;
		     totalEmpWage += empWage;		
		}
		 return totalEmpWage;
	 }
	 
	 public static void main(String[] args) {
			
		EmployeeWageBuilder employeeWageBuilder = new EmployeeWageBuilder();
		employeeWageBuilder.addCompanyEmpWage("DMart", 20, 2, 10);
		employeeWageBuilder.addCompanyEmpWage("Reliance", 25, 20, 10);
		employeeWageBuilder.computeEmpWage();
	
		
		
	}
	
}
