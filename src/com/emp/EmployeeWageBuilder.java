package com.emp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class EmployeeWageBuilder implements EmpWageBuilderInterface{
	
	public ArrayList<CompanyEmpWage> companyWageArrayList ;
	private int numberOfCompany = 0;
	
	
	public EmployeeWageBuilder() {
		super();
		companyWageArrayList = new ArrayList<>();
	}

	@Override
	public void addCompanyEmpWage(String company, int empRatePerHour, int numOfWorkingDays, int maxHrsPerMonth) {
		companyWageArrayList.add(new CompanyEmpWage(company, empRatePerHour, numOfWorkingDays, maxHrsPerMonth)) ;
		numberOfCompany++;
	}
	

	public void computeEmpWage() {
		for(int i=0; i<numberOfCompany; i++) {

			companyWageArrayList.get(i).setTotalEmpWage(this.computeEmpWage(companyWageArrayList.get(i)));
			System.out.println(companyWageArrayList.get(i));
			
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
		     int dailyWage=0;
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
	public void getTotalWage(String companyName) {
		Iterator<CompanyEmpWage> iter = companyWageArrayList.iterator();
		
		
		while(iter.hasNext()) {
			CompanyEmpWage company = iter.next();
			if(companyName.equalsIgnoreCase(company.company))
				System.out.println(company);
		}
		
		
	}
	 
	 public static void main(String[] args) {
			
		EmployeeWageBuilder employeeWageBuilder = new EmployeeWageBuilder();
		employeeWageBuilder.addCompanyEmpWage("DMart", 20, 2, 10);
		employeeWageBuilder.addCompanyEmpWage("Reliance", 25, 20, 10);
		employeeWageBuilder.computeEmpWage();
		Scanner sc = new Scanner(System.in);
		System.out.println("Which company's total wage do you want Dmart or Reliance");
		String companyName = sc.next();
		employeeWageBuilder.getTotalWage(companyName);
	
		
		
	}
	
}
