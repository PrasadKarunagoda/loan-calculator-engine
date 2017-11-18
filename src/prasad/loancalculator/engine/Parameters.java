package prasad.loancalculator.engine;

public class Parameters
{
  private int totalLoanInCents;

  private double annualInterestRate;

  private int loanPeriodInMonths;

  public Parameters(int totalLoanAmount, double annualInterestRate, int loanPeriodInMonths)
  {
    this.totalLoanInCents = totalLoanAmount * 100;
    this.annualInterestRate = annualInterestRate;
    this.loanPeriodInMonths = loanPeriodInMonths;
  }

  public int getTotalLoanInCents()
  {
    return totalLoanInCents;
  }

  public double getAnnualInterestRate()
  {
    return annualInterestRate;
  }

  public int getLoanPeriodInMonths()
  {
    return loanPeriodInMonths;
  }
}
