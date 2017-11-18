package prasad.loancalculator.engine;

public class Calculator
{
  private Parameters parameters;

  private Installment[] installments;

  public int calculateInstallment(Parameters parameters)
  {
    this.parameters = parameters;
    initializeInstallmentsArray();

    int installmentAmount = parameters.getTotalLoanInCents() / parameters.getLoanPeriodInMonths();
    int remainingLoanAmount = 0;
    do
    {
      installmentAmount = installmentAmount + remainingLoanAmount / parameters.getLoanPeriodInMonths();
      remainingLoanAmount = calculateSchedule(installmentAmount);
      //System.out.println("remainingLoanAmount = " + remainingLoanAmount);
    }
    while (remainingLoanAmount / parameters.getLoanPeriodInMonths() != 0);

    return installments[0].getInstallmentInCents();
  }

  private void initializeInstallmentsArray()
  {
    installments = new Installment[parameters.getLoanPeriodInMonths()];
    for (int i = 0; i < installments.length; i++)
    {
      installments[i] = new Installment();
    }
  }

  private int calculateSchedule(int installmentAmountInCents)
  {
    for (int i = 0; i < installments.length; i++)
    {
      installments[i] = new Installment();
      installments[i].setInstallmentInCents(installmentAmountInCents);
      if (i == 0)
      {
        installments[i].setRemainingLoanInCentsBeforeThisInstallment(parameters.getTotalLoanInCents());
      }
      else
      {
        installments[i].setRemainingLoanInCentsBeforeThisInstallment(
            installments[i-1].getRemainingLoanInCentsBeforeThisInstallment()
                - (installments[i-1].getInstallmentInCents() - installments[i-1].getInterestInCents()));
      }
      installments[i].setInterestInCents(
          (int) (installments[i].getRemainingLoanInCentsBeforeThisInstallment() * parameters.getAnnualInterestRate() / 12)); //TODO Change if daily interest

    }
    Installment lastInstallment = installments[installments.length - 1];
    return lastInstallment.getRemainingLoanInCentsBeforeThisInstallment()
        - (lastInstallment.getInstallmentInCents() - lastInstallment.getInterestInCents());
  }

  public static void main(String[] args)
  {
    Calculator calculator = new Calculator();
    int installmentInCents = calculator.calculateInstallment(new Parameters(500000, 0.14, 30));
    System.out.println(">>>>> installment = " + installmentInCents / 100 + "." + installmentInCents % 100);
  }
}
