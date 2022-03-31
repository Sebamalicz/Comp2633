/*
*This is a fucking class
*/
/*
 * This Class allows the user to see all the info about their account including
 * amounts in saving/chequing accounts, as well as pay bills and move money
 * around.
 */
public class Account {
    final private int accountNumber;
    private double balance;

    public Account(int accountNumber, double balance)
    {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public int getAccountNumber()
    {
        return this.accountNumber;
    }

    public double getBalance()
    {
        return this.balance;
    }

    public boolean payBills(Contact contact, double amount, String date)
    {
        boolean payProcessed = false;
        /*
         * Implement after Contact class
         */
        return payProcessed;
    }

    public boolean moveMoney(Account account, double amount, String date)
    {
        boolean moveProcessed = false;
        /*
         * Implement soon
         */
        return moveProcessed;
    }

    public void viewTransactions(Transaction transaction)
    {
        /*
         * Implement After transaction class
         */
    }
}
