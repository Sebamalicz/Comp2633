import java.util.ArrayList;

public class FileRead {
    private Client client;
    private Chequing chequing;
    private Contact contacts;
    private ArrayList<Savings> saving;
    private ArrayList<Credit> creditCards;

    public FileRead(Client client, Chequing chequing, Contact contacts, ArrayList<Savings> saving, ArrayList<Credit> cards)
    {
        this.client = client;
        this.chequing = chequing;
        this.contacts = contacts;
        this.saving = saving;
        this.creditCards = cards;
    }

    public Client getClient()
    {
        return this.client;
    }

    public Chequing getChequing()
    {
        return this.chequing;
    }

    public Contact getContacts()
    {
        return this.contacts;
    }

    public ArrayList<Savings> getSavings()
    {
        return this.saving;
    }
    
    public ArrayList<Credit> getCards()
    {
        return this.creditCards;
    }
}
