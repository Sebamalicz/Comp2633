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
    private boolean autoDeposit;
    private Contact contacts; 


    public Account(int accountNumber, double balance, ArrayList<Transaction> transactions) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.autoDeposit = false;
        this.contacts = null;
        this.transactions = transactions;
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

    public boolean payBill(Payee payee, double amount, String date) {
        boolean payProcessed = false;

        if (payee != null && amount <= this.balance)
        {
            this.balance =- amount;
            if (payee.getNickName() != null)
            {
                Transaction newTrans = new Transaction(date, "Bill paid to: " + payee.getNickName(), amount);
                this.transactions.add(newTrans);
            } else
            {
                Transaction newTrans = new Transaction(date, "Bill paid to account number: " + payee.getAccountNumber(), amount);
                this.transactions.add(newTrans);
            }
            payProcessed = true;
        }


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
            Transaction newTrans = new Transaction(date, "Moved money to account: " + account.getAccountNumber(), amount);
            this.transactions.add(newTrans);
            moveProcessed = true;
        }

        return moveProcessed;
    }

    public boolean eTransfer(Account account, Recipient recipient, double amount, String date) {
        boolean moveProcessed = false;

        if (recipient != null && amount <= account.getBalance)
        {
            if(account instanceof Saving)
            {
                account.subBalance(amount);
                Transaction newTrans = new Transaction(date, recipient.getName(), amount);
                account.transactions.add(newTrans);
                moveProcessed = true;
            }
            else if(account instanceof Chequing)
            {
                account.subBalance(amount);
                Transaction newTrans = new Transaction(date, recipient.getName(), amount);
                account.transactions.add(newTrans);
                moveProcessed = true;
            }
            else
            {
                moveProcessed = false;
            }
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
    
    public boolean setUpRecurrPayments(Payee payee, double amount, String date)
    {
        boolean setUpSuccess = false;
        if (payee != null)
        {
            System.out.println("Recurring payment successfully set up.");
            if (payee.getNickName() != null)
            {
                System.out.println("A payment of " + amount + "will be made to " + payee.getNickName() + " every month after " + date);
            } else
            {
                System.out.println("A payment of " + amount + "will be made to account number " + payee.getAccountNumber() + " every month after " + date);
            }
        }

        return setUpSuccess;
    }
    
    public void enableAutoDeposit()
    {
        this.autoDeposit = true;
        return;
    }
    
    public void setContacts(Contact contacts)
    {
        this.contacts = contacts;
        return;
    }
    
    public void subBalance(double amount)
    {
        this.balance -= amount;
        return;
    }
    
}
