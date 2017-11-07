package tools;

import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.TimeZone;

public class LoanCalculator {
	
	private static final LinkedHashMap<YearMonth, Statement> statementMap = new LinkedHashMap<>();
	
	/**
	 * 
	 * @author chris
	 *
	 */
	protected static class Statement{
		
		private double credit = 0.0;
		private double capital = 0.0;
		private double principal = 0.0;
		
		Statement(final double credit, final double capital, final double principal){
			this.credit = credit;
			this.capital = capital;
			this.principal = principal;
		}
		
		public double getCredit() {
			return credit;
		}
		
		public double getCapital() {
			return capital;
		}
		
		public double getPrincipal() {
			return principal;
		}
		
	}
	
	/**
	 * 
	 * @param date
	 * @return
	 */
	public static Statement getStatement(YearMonth date){
		
		return statementMap.get(date);
		
	}
	
	//TODO: Add rounding to 10th place decimal for all doubles.
	/**
	 * 
	 * @param principal Amount owed.
	 * @param apr Interests
	 * @param credit Expected credit
	 * @return
	 */
	public static ArrayList<YearMonth> projectLoanData(final double principalAmount, final double avgPercentRate, final double creditAmount) {
		
		final Calendar localCalendar = Calendar.getInstance(TimeZone.getDefault());
		
		YearMonth yearMonthObject = YearMonth.of( localCalendar.get(Calendar.YEAR), localCalendar.get(Calendar.MONTH) );
		ArrayList<YearMonth> dateList = new ArrayList<>();
		
		double principal = principalAmount;
		double credit = creditAmount;
		double apr = avgPercentRate;
		double capital = 0.0;
		
		int processingMonth = yearMonthObject.getMonthValue();
		int processingYear = yearMonthObject.getYear();
		
		try{
			
			while( principal > 0.0 ){
				
				// Process APR for month by DAY-TO-DAY.
				for(int i = 0; i < yearMonthObject.lengthOfMonth(); i++){

					capital += (principal * apr) / yearMonthObject.lengthOfYear();

				}
				
				// Processing END-Of-MONTH changes to principal.
				if( credit < capital ){
					
					throw new RuntimeException("Credit can not be less than capital: CREDIT: $" + credit + ", CAPITAL: $" + capital);
					
				}
				else if( credit > (principal + capital) ){
					
					principal += capital;
					credit = principal;
					principal -= credit;
					
				}
				else{
					
					principal -= credit;
					principal += capital;
					
				}
				
				// Create END-OF-MONTH STATEMENT using TEMPORAL value as KEY.
				statementMap.put(yearMonthObject, new Statement(credit, capital, principal) );
				dateList.add(yearMonthObject);
				
				// Clean up and prepare for next iteration.
				capital = 0.0;
				
				if(yearMonthObject.getMonthValue() == 12){
					
					processingYear++;
					processingMonth = 1;
					
				}
				else{
					
					processingMonth++;
					
				}
				
				yearMonthObject = YearMonth.of( processingYear, processingMonth );
				
			}

			return dateList;
			
		} catch(RuntimeException re){
			
			throw re;
			
		}
		
	}

}
