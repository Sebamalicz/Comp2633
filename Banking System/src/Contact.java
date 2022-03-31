
public class Contact {
    private Payee payees[];
    private Recipient recipients[];
    private int payeeAmount;
    private int recipientAmount;

    public Contact(Payee payees[], Recipient recipients[], int payeeAmount,
                   int recipientAmount)
    {
        this.payees = payees;
        this.recipients = recipients;
        this.payeeAmount = payeeAmount;
        this.recipientAmount = recipientAmount;
    }

    public void viewPayees()
    {
        int length;
        System.out.println("--------------------------------------------------");
        for(length = 0; length <= payeeAmount; length++)
        {
            if(payees[length].getNickName() != null)
            {
                System.out.println("Nickname: " + payees[length].getNickName());
            }
            System.out.println("Account Number: " + payees[length].getAccountNumber());
            System.out.println("------------------------------------------------------");
        }
    }

    public void viewRecipients()
    {
        int length;
        for(length = 0; length <= recipientAmount; length++)
        {
            System.out.println("Email Address: " + recipients[length].getEmail());
            if(recipients[length].getName() != null)
            {
                System.out.println("Name: " + recipients[length].getName());
            }
            System.out.println("Phone Number" + recipients[length].getPhoneNumber());
        }
    }

    public boolean editPayee(int accountNumber)
    {
        boolean edited = false;
        int length;

        //get location in array of account number if exists
        for(length = 0; payees[length].getAccountNumber() == accountNumber; length++)
        ;

        if(length < payeeAmount)
        {
            System.in.
        }

        return edited;
    }

    public boolean editRecipient(String email)
    {
        boolean edited = false;
        /*
         * integrate editing of recipients
         */
        return edited;
    }

    public boolean addPayee(int accountNumber, String nickName)
    {
        boolean added = false;
        /*
         * integrate adding of payees
         */
        return added;
    }

    public boolean addRecipient(String email, String name, int phoneNumber)
    {
        boolean added = false;
        /*
         * integrate adding of recipients
         */
        return added;
    }
}
