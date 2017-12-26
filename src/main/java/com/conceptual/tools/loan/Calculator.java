package com.conceptual.tools.loan;

import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.TimeZone;

public class Calculator {
	
	private final LinkedHashMap<YearMonth, Statement> statementMap = new LinkedHashMap<>();

	/**
	 * Class used calculate Loan payoff.
	 * 
	 * @since 11/30/2017
	 * @author Christopher Jepson
	 */
	protected static class Statement{
		
		private double credit = 0.0;
		private double capital = 0.0;
		private double principal = 0.0;
		
		protected Statement(final double credit, final double capital, final double principal){
			this.credit = credit;
			this.capital = capital;
			this.principal = principal;
		}
		
		protected double getCredit() {
			return credit;
		}
		
		protected double getCapital() {
			return capital;
		}
		
		protected double getPrincipal() {
			return principal;
		}
		
	}
	
	private Statement getStatement(YearMonth date){
		
		return statementMap.get(date);
		
	}
	
	/**
	 * 
	 * @param date Year and Month of statement.
	 * @return Credit recorded within statement.
	 */
	public double getCredit(final YearMonth date) {
		
		return getStatement(date).getCredit();
		
	}
	
	/**
	 * 
	 * @param date Year and Month of statement.
	 * @return Capital recorded within statement.
	 */
	public double getCapital(final YearMonth date) {
		
		return getStatement(date).getCapital();
		
	}

	/**
	 * 
	 * @param date Year and Month of statement.
	 * @return Principal recorded within statement.
	 */
	public double getPrincipal(final YearMonth date) {
		
		return getStatement(date).getPrincipal();
		
	}
	
	/**
	 * 
	 * @param principalAmount Amount owed.
	 * @param avgPercentRate Interests
	 * @param creditAmount Expected credit
	 * @return List of prjections by YearMonth
	 * @throws RuntimeException
	 */
	public ArrayList<YearMonth> projectLoanData(final double principalAmount, final double avgPercentRate, final double creditAmount) {
		
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
