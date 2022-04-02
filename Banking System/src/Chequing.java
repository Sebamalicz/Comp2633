
public class Chequing extends Account{
    final private double annualCost;

    public Chequing(double annualCost, int accountNumber, double balance)
    {
        super(accountNumber, balance);
        this.annualCost = annualCost;
    }

    public void getCheque()
    {
        /*
         * Gets cheque and sends it to the email address that is written under
         * the account, to be further processed by the
         */
    }

    public double getAnnualCost()
    {
        return this.annualCost;
    }
}
