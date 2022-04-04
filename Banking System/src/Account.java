import java.util.ArrayList;

/*
 * This Class allows the user to see all the info about their account including
 * amounts in saving/chequing accounts, as well as pay bills and move money
 * around.
 */
public class Account {
    final private int accountNumber;
    private double balance;
    private ArrayList<Transaction> transactions;


    public Account(int accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return this.accountNumber;
    }

    public double getBalance() {
        return this.balance;
    }

    public ArrayList<Transaction> getTransactions()
    {
        return this.transactions;
    }

    public int getTransactionAmount()
    {
        return this.transactions.size();
    }

    public boolean payBills(Payee payee, double amount, String date) {
        boolean payProcessed = false;
        /*
         * Implement after Contact class && Swing class Will have to display the
         * contact, and contact type (recipient, Payee) to the screen using swing and
         * once a button is pressed by the user a payment to the contact will be
         * completed and the amount sent to the contact will be subtracted from the
         * account selected.
         */
        return payProcessed;
    }


    public void recieveMoney(double amount)
    {
        this.balance += amount;
    }

    public boolean moveMoney(Account account, double amount, String date) {
        boolean moveProcessed = false;

        if (account != null && amount <= this.balance)
        {
            this.balance =- amount;
            account.recieveMoney(amount);
            moveProcessed = true;
        }

        return moveProcessed;
    }

    public boolean eTransfer(Recipient recipient, double amount, String date) {
        boolean moveProcessed = false;

        if (recipient != null && amount <= balance)
        {
            balance =- amount;
            moveProcessed = true;
        }

        return moveProcessed;
    }


    public void viewTransactions() {
        int transactionAmnt = getTransactionAmount();
        int length;
        if (transactionAmnt > 0) // checks if transaction array is empty
        {
            System.out.println("--------------------------------------------------");
            for (length = 0; length <= transactionAmnt; length++) {
                System.out.println("Date of Transaction: " + transactions.get(length).getDate());
                System.out.println("Location of Transaction: " + transactions.get(length).getGeneral());
                System.out.println("$ Spent in Transaction: " + transactions.get(length).getAmountUsed());
                System.out.println("------------------------------------------------------");
            }
        }

    }
}
