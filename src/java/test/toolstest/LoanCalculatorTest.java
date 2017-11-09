package toolstest;
import java.time.YearMonth;

import static tools.LoanCalculator.projectLoanData;
import static tools.LoanCalculator.getStatement;
import static tools.LoanCalculator.Statement;

import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class LoanCalculatorTest {

	// Test projectLoanData(double, double, double, int)
	@Test(expected = RuntimeException.class)
	public void testForUnderPayment(){
		
		// Basic formula: ($10,000.00 * 20% = $2,000) > ($120 * 12 = $1,440)
		projectLoanData(10_000.0, 20.0, 120.0);
		
		Assert.fail(); // Should not reach this point.
		
	}
	
	@Test(expected = RuntimeException.class)
	public void testForNoPayment(){
		
		projectLoanData(10_000.0, 5.5, 0.0);
			
		Assert.fail(); // Should not reach this point.
		
	}
	
	@Test
	public void testForNoAPR(){
		
		List<YearMonth> projection = projectLoanData(300.0, 0.0, 100.0);
		
		YearMonth date = null;
		Statement statement = null;
		
		date = projection.get(0);
		statement = getStatement(date);
		Assert.assertTrue(statement.getCredit() == 100.0);
		Assert.assertTrue(statement.getPrincipal() == 200.0);
		Assert.assertTrue(statement.getCapital() == 0.0);
		
		date = projection.get(1);
		statement = getStatement(date);
		Assert.assertTrue(statement.getCredit() == 100.0);
		Assert.assertTrue(statement.getPrincipal() == 100.0);
		Assert.assertTrue(statement.getCapital() == 0.0);
		
		date = projection.get(2);
		statement = getStatement(date);
		Assert.assertTrue(statement.getCredit() == 100.0);
		Assert.assertTrue(statement.getPrincipal() == 0.0);
		Assert.assertTrue(statement.getCapital() == 0.0);
		
	}
	
	//TODO: More tests needed.
	
}
