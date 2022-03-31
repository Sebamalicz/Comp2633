
public class Credit extends Card{
    private double balanceToPay;
    private double creditLimit;
    final private double interestRate;

    public Credit (double balanceToPay, double creditLimit, double interestRate, int cardNumber) {
        super(cardNumber);
        this.balanceToPay = balanceToPay;
        this.creditLimit = creditLimit;
        this.interestRate = interestRate;
    }

    public double getBalanceToPay()
    {
        return this.balanceToPay;
    }

    public double getCreditLimit()
    {
        return this.creditLimit;
    }

    public double getInterestRate()
    {
        return this.interestRate;
    }
    
    public void calculateBalanceToPay()
    {
        int interestAmount = this.balanceToPay * this.interestRate;
        this.balanceToPay += interestAmount;
    }
}
