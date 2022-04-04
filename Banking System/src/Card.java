/*
 * This is the generic card class for both credit and debit cards.
 */
public class Card {
    final private int cardNumber;
    private ArrayList<Transaction> transactions;
    private int transactionAmount;

    public Card(int cardNumber, ArrayList<Transaction> transactions)
    {
        this.cardNumber = cardNumber;
        this.transactions = transactions;
        this.transactionAmount = transactions.size();
    }

    public int getCardNumber()
    {
        return this.cardNumber;
    }
    
    /* 
        Displays all the transactions related to the card. Includes date, location and
        amount of money spent within the transaction.
    */
    public void viewTransactions(Transaction transaction)
    {
        int length;
        if(transactionAmount > 0) //checks if transaction array is empty
        {
            System.out.println("--------------------------------------------------");
            for(length = 0; length <= transactionAmount; length++)
            {
                System.out.println("Date of Transaction: " + transaction.get(length).getDate());
                System.out.println("Location of Transaction: " + transaction.get(length).getGeneral());
                System.out.println("$ Spent in Transaction: " + transaction.get(length).getAmountUsed());
                System.out.println("------------------------------------------------------");
            }
        } 
    }
}
