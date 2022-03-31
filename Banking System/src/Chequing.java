
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
         * Implement later
         */
    }

    public double getAnnualCost()
    {
        return this.annualCost;
    }
}
