/*
 This class contains information about a transaction that the client made. Information included is the date the transaction was made,
 the location the transaction was made, and the amount spent in the transaction.
 */
public class Transaction {

    final private String date; //date of transaction
    final private String general; //generalization of place
    final private double amountUsed; //amount that was spent/used

    /*
     * This is the constructor for the Transaction class, sets ups the
     * date, generalization and the amount that was used/spent
     */
    public Transaction(String date, String general, double amountUsed)
    {
        this.date = date;
        this.general = general;
        this.amountUsed = amountUsed;
    }

    public String getDate()
    {
        return this.date;
    }

    public String getGeneral()
    {
        return this.general;
    }

    public double getAmountUsed()
    {
        return this.amountUsed;
    }
}
