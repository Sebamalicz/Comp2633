import java.util.ArrayList;

public class FileRead {
    private Client client;
    private Chequing chequing;
    private Contact contacts;
    private ArrayList<Savings> saving;

    public FileRead(Client client, Chequing chequing, Contact contacts, ArrayList<Savings> saving)
    {
        this.client = client;
        this.chequing = chequing;
        this.contacts = contacts;
        this.saving = saving;
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
}
