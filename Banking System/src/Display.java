import java.util.ArrayList;

public class Display {
    private Swing login;
    private MainMenu menu;
    private transactionScreen trans;
    private Settings setting;
    private Contact contacts;
    private Chequing chequings;
    private ArrayList<Savings> savings;
    private ArrayList<Credit> credit;

    public void displayLogin()
    {
        login = new Swing();
    }

    public void displayMenu()
    {
        menu = new MainMenu(contacts, chequings, savings, credit);
    }

    public void displaySetting()
    {
        setting = new Settings();
    }

    public void setContacts(Contact contacts)
    {
        this.contacts = contacts;
    }

    public void setChequings(Chequing chequing)
    {
        this.chequings = chequing;
    }

    public void setSavings(ArrayList<Savings> saving)
    {
        this.savings = saving;
    }

    public void setCredit(ArrayList<Credit> credit)
    {
        this.credit = credit;
    }

    public Contact getContacts()
    {
        return this.contacts;
    }

    public Chequing getChequing()
    {
        return this.chequings;
    }

    public ArrayList<Savings> getSavings()
    {
        return this.savings;
    }

    public ArrayList<Credit> getCredit()
    {
        return this.credit;
    }
}
