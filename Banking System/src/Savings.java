
public class Savings extends Account{
    final private double interestRate;
    private double interestGained;

    public Savings (double interestGained, int accountNumber, double balance)
    {
        super(accountNumber, balance);
        this.interestRate = 1.0;
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
