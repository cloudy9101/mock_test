package com.cloudy9101.Assignment3_PartA;

public class SalaryCalcImpl implements SalaryCalc {
	SalaryCalc calc;
	Employee employee;

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public void setCalc(SalaryCalc calc) {
		this.calc = calc;
	}

	public double computeTax(double income) {
		return calc.computeTax(income);
	}

	public double weeklySalary(Employee income) {
		return calc.weeklySalary(income);
	}

	public double fortnightSalary(Employee income) {
		return calc.fortnightSalary(income);
	}

	public double computeKiwiSaver(Employee income) {
		return calc.computeKiwiSaver(income);
	}

}
