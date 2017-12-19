package com.conceptual.tools.loan;
import java.time.YearMonth;

import com.conceptual.tools.loan.Calculator;

import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 * Class used calculate Loan payoff.
 * 
 * @since 11/30/2017
 * @author Christopher Jepson
 * @see com.conceptual.tools.loan.Calculator
 */
public class CalculatorTest {

	// Test projectLoanData(double, double, double)
	@Test(expected = RuntimeException.class)
	public void testForUnderPayment(){
		
		Calculator calculator = new Calculator();
		
		calculator.projectLoanData(10_000.0, 20.0, 120.0);
		
		Assert.fail(); // Should not reach this point.
		
	}
	
	@Test(expected = RuntimeException.class)
	public void testForNoPayment(){
		
		Calculator calculator = new Calculator();
		
		calculator.projectLoanData(10_000.0, 5.5, 0.0);
			
		Assert.fail(); // Should not reach this point.
		
	}
	
	@Test
	public void testForNoAPR(){
		
		Calculator calculator = new Calculator();
		List<YearMonth> projection = calculator.projectLoanData(300.0, 0.0, 100.0);
		
		YearMonth date = null;
		
		date = projection.get(0);
		Assert.assertTrue(calculator.getCredit(date) == 100.0);
		Assert.assertTrue(calculator.getPrincipal(date) == 200.0);
		Assert.assertTrue(calculator.getCapital(date) == 0.0);
		
		date = projection.get(1);
		Assert.assertTrue(calculator.getCredit(date) == 100.0);
		Assert.assertTrue(calculator.getPrincipal(date) == 100.0);
		Assert.assertTrue(calculator.getCapital(date) == 0.0);
		
		date = projection.get(2);
		Assert.assertTrue(calculator.getCredit(date) == 100.0);
		Assert.assertTrue(calculator.getPrincipal(date) == 0.0);
		Assert.assertTrue(calculator.getCapital(date) == 0.0);
		
	}
	
	@Test
	public void testForMultipleRuns(){
		
		Calculator calculator_1 = new Calculator();
		Calculator calculator_2 = new Calculator();
		
		List<YearMonth> projection_1 = calculator_1.projectLoanData(300.0, 0.0, 100.0);
		List<YearMonth> projection_2 = calculator_2.projectLoanData(600.0, 0.0, 200.0);
		
		YearMonth date = null;
		
		date = projection_2.get(0);
		Assert.assertTrue(calculator_2.getCredit(date) == 200.0);
		Assert.assertTrue(calculator_2.getPrincipal(date) == 400.0);
		Assert.assertTrue(calculator_2.getCapital(date) == 0.0);
		
		date = projection_1.get(0);
		Assert.assertTrue(calculator_1.getCredit(date) == 100.0); // Should fail here if fault exist.
		Assert.assertTrue(calculator_1.getPrincipal(date) == 200.0);
		Assert.assertTrue(calculator_1.getCapital(date) == 0.0);
		
	}
	
}
