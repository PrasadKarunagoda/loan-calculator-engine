package prasad.loancalculator.engine;

class Installment
{
  private int installmentInCents;

  private int remainingLoanInCentsBeforeThisInstallment;

  private int interestInCents;

  int getInstallmentInCents()
  {
    return installmentInCents;
  }

  void setInstallmentInCents(int installmentInCents)
  {
    this.installmentInCents = installmentInCents;
  }

  int getRemainingLoanInCentsBeforeThisInstallment()
  {
    return remainingLoanInCentsBeforeThisInstallment;
  }

  void setRemainingLoanInCentsBeforeThisInstallment(int remainingLoanInCentsBeforeThisInstallment)
  {
    this.remainingLoanInCentsBeforeThisInstallment = remainingLoanInCentsBeforeThisInstallment;
  }

  int getInterestInCents()
  {
    return interestInCents;
  }

  void setInterestInCents(int interestInCents)
  {
    this.interestInCents = interestInCents;
  }
}
