
public class Savings extends Account{
    final private double interestRate;
    private double interestGained;

    public Savings (double interestRate, double interestGained, int accountNumber, double balance)
    {
        super(accountNumber, balance);
        this.interestRate = interestRate;
        this.interestGained = interestGained;
    }

    public double getInterestRate()
    {
        return this.interestRate;
    }

    public double getInterestGained()
    {
        return this.interestGained;
    }
}
