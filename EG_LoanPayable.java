/**
 * Program Name:EG_LoanPayable.java
 * Purpose: This interface holds the constant monthly rate and abstract method to convert whatever annual prime interest rate the user enters to the equivalents monthly rate decimal equivalent
 * Coder: Eraj Gillani 0858887
 * Date: Apr. 3, 2020
 */
public interface EG_LoanPayable
{
	 double ANNUAL_RATE_TO_MONTHLY_RATE = 1.0/1200.0;
	 
		abstract double calculateLoanPayment(double OSLOrCSLAmount, double annualPrimeIntRate, int amortizationMonths);
}
//end class