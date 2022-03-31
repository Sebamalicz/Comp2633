
public class Debit extends Card{
    int holder;

    public Debit (int holder, int cardNumber)
    {
        super(cardNumber);
        this.holder = holder;
    }
}
