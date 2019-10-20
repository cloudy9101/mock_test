package com.cloudy9101.Assignment3_PartA;

public interface SalaryCalc {
	public double computeTax(double income);
	public double weeklySalary(Employee income);
	public double fortnightSalary(Employee income);
	public double computeKiwiSaver(Employee income);

}

class Employee {
	public double weeklySalary = 1000;
	public double fortnightSalary = 2000;
	public double kiwiSaverPercentage = 0.4;
}
