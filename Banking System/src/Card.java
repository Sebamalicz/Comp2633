import java.util.ArrayList;

/*
 * This is the generic card class for both credit and debit cards.
 */
public class Card {
    final private int cardNumber;
    private ArrayList<Transaction> transactions;

    public Card(int cardNumber, ArrayList<Transaction> transactions)
    {
        this.cardNumber = cardNumber;
        this.transactions = transactions;
    }

    public int getCardNumber()
    {
        return this.cardNumber;
    }

    public ArrayList<Transaction> getTransactions()
    {
        return this.transactions;
    }

    public int getTransactionAmount()
    {
        return transactions.size();
    }
    /*
        Displays all the transactions related to the card. Includes date, location and
        amount of money spent within the transaction.
    */
    public void viewTransactions()
    {
        int transAmnt = getTransactionAmount();
        int length;
        if(transAmnt > 0) //checks if transaction array is empty
        {
            System.out.println("--------------------------------------------------");
            for(length = 0; length <= transAmnt; length++)
            {
                System.out.println("Date of Transaction: " + transactions.get(length).getDate());
                System.out.println("Location of Transaction: " + transactions.get(length).getGeneral());
                System.out.println("$ Spent in Transaction: " + transactions.get(length).getAmountUsed());
                System.out.println("------------------------------------------------------");
            }
        }
    }
}
