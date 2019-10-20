package com.cloudy9101.Assignment3_PartA;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class TestSalaryCalcImpl {
	
	int WEEKS_PER_YEAR = 52;
	double INCOME = 70000;
	
	SalaryCalcImpl impl;
	SalaryCalc calc;
	Employee employee;
	
	double actual, expected;
	double weeklySalaryActual, weeklySalaryExpected;
	double fortnightSalaryActual, fortnightSalaryExpected;
	double kiwiSaverActual, kiwiSaverExpected;


	@Before
	public void setUp() throws Exception {
		impl = new SalaryCalcImpl();
		employee = new Employee();
		
		calc = Mockito.mock(SalaryCalc.class);

		setupForComputeTax();
		setupForWeeklySalary();
		setupForFortnightSalary();
		setupForComputeKiwiSaver();
	}
	
	private void setupForComputeTax() {
		Mockito.when(calc.computeTax(INCOME)).thenReturn(INCOME * 0.33);
		impl.setCalc(calc);
		expected = INCOME * 0.33;
		actual = impl.computeTax(INCOME);
	}
	
	private void setupForWeeklySalary() {
		Mockito.when(calc.weeklySalary(employee)).thenReturn(employee.weeklySalary);
		
		impl.setCalc(calc);
		weeklySalaryExpected = employee.weeklySalary;
		weeklySalaryActual = impl.weeklySalary(employee);
	}
	
	private void setupForFortnightSalary() {
		Mockito.when(calc.fortnightSalary(employee)).thenReturn(employee.fortnightSalary);
		
		impl.setCalc(calc);
		fortnightSalaryExpected = employee.fortnightSalary;
		fortnightSalaryActual = impl.fortnightSalary(employee);
	}
	
	private void setupForComputeKiwiSaver() {
		Mockito.when(calc.computeKiwiSaver(employee)).thenReturn(employee.weeklySalary * WEEKS_PER_YEAR * employee.kiwiSaverPercentage);
		
		impl.setCalc(calc);
		kiwiSaverExpected = employee.weeklySalary * WEEKS_PER_YEAR * employee.kiwiSaverPercentage;
		kiwiSaverActual = impl.computeKiwiSaver(employee);
	}

	@After
	public void tearDown() throws Exception {
		impl = null;
		employee = null;
	}

	@Test
	public void testComputeTax() {
		assertEquals(actual, expected, 1);
	}
	
	@Test
	public void testWeeklySalary() {
		assertEquals(weeklySalaryActual, weeklySalaryExpected, 1);
	}
	
	@Test
	public void testFortnightSalary() {
		assertEquals(fortnightSalaryActual, fortnightSalaryExpected, 1);
	}
	
	@Test
	public void testForComputeKiwiSaver() {
		assertEquals(kiwiSaverActual, kiwiSaverExpected, 1);
	}

}
