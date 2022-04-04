/*
This class contains information related to a client's debit card.
*/
public class Debit extends Card{
    int holder;

    public Debit (int holder, int cardNumber, ArrayList<Transaction> transactions)
    {
        super(cardNumber, transactions);
        this.holder = holder;
    }
}
