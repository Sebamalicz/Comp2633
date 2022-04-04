import java.util.ArrayList;

public class Display {
    private Swing login;
    private MainMenu menu;
    private Contact contacts;
    private Chequing chequings;
    private ArrayList<Savings> savings;
    private ArrayList<Credit> credit;

    public Display(Contact contacts, Chequing chequings, ArrayList<Savings> savings, ArrayList<Credit> credit)
    {
        this.contacts = contacts;
        this.chequings = chequings;
        this.savings = savings;
        this.credit = credit;
    }

    public void displayLogin()
    {
        login = new Swing();
    }

    public void displayMenu()
    {
        menu = new MainMenu(chequings, savings, credit);
    }
}
