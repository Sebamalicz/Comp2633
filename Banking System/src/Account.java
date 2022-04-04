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
         * Implement after Contact class && Swing class
         * Will have to display the contact, and contact type (recipient, Payee)
         * to the screen using swing and once a button is pressed by the user
         * a payment to the contact will be completed and the amount sent to the
         * contact will be subtracted from the account selected.
         */
        return payProcessed;
    }

    public boolean moveMoney(Account account, double amount, String date)
    {
        boolean moveProcessed = false;
        /*
         * Implement after both chequing and savings accounts are completed
         * Will move money from the account that is currently being displayed
         * to the screen (chequing/savings), to the account that is selected.
         * If the initial account is chequing, only one chequing is available per
         * account, meaning that you cannot move from chequing to chequing, only
         * chequing to a choice of savings (multiple savings accounts allowed)
         */
        return moveProcessed;
    }

    public void viewTransactions(Transaction transaction)
    {
        /*
         * Implement After transaction class
         * Will display the transactions of the given account (savings/chequing)
         * if that account exists.
         */
    }
}
