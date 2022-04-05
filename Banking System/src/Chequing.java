import java.util.ArrayList;

public class Chequing extends Account{
    final private double annualCost;

    public Chequing(double annualCost, int accountNumber, double balance, ArrayList<Transaction> transactions)
    {
        super(accountNumber, balance, transactions);
        this.annualCost = annualCost;
    }

    public double getAnnualCost()
    {
        return this.annualCost;
    }
}
