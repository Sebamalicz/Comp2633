/*
 * This is the generic card class for both credit and debit cards.
 */
public class Card {
    final private int cardNumber;

    public Card(int cardNumber)
    {
        this.cardNumber = cardNumber;
    }

    public int getCardNumber()
    {
        return this.cardNumber;
    }

    public void viewTransactions(Transaction transaction)
    {
        /*
         * To implement after transactions
         */
    }
}
