
public class transactionScreen {
    Savings saving;
    Chequing chequing;
    Credit credit;

    public transactionScreen(Savings saving)
    {
        this.saving = saving;
    }

    public transactionScreen(Chequing chequing)
    {
        this.chequing = chequing;
    }

    public transactionScreen(Credit credit)
    {
        this.credit = credit;
    }
}
