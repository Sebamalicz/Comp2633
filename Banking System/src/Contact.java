
public class Contact {
    private Payee payees[]; //Payee array to access various payees
    private Recipient recipients[]; //Recipient array to acces various payees
    private int payeeAmount; //Amount of Payees within the Payee Array
    private int recipientAmount; //Amount of recipients within the Recipient Array

    /*
     * This is the constructor for the Contact Class, sets up the Payee array, Recipient
     * array , payeeAmount and Recipient Amount
     */
    public Contact(Payee payees[], Recipient recipients[])
    {
        this.payees = payees;
        this.recipients = recipients;
        this.payeeAmount = payees.length;
        this.recipientAmount = recipients.length;
    }

    /*
     *
     */
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

    /*
     *
     */
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

    /*
     *
     */
    public boolean editPayee(int accountNumber, String newName, int newAccountNumber)
    {
        boolean edited = false;
        int length;

        //get location in array of account number if exists
        for(length = 0; payees[length].getAccountNumber() == accountNumber; length++)
        ;

        if(length < payeeAmount)
        {
            if(newName != null)
            {
                payees[length].setNickName(newName);
                edited = true;
            }
            if(newAccountNumber != 0)
            {
                payees[length].setAccountNumber(newAccountNumber);
                edited = true;
            }
        }

        return edited;
    }

    /*
     *
     */
    public boolean editRecipient(String email, String newEmail, String newName, int newPhoneNumber)
    {
        boolean edited = false;
        int length;

        //get location in array of email if exits
        for(length = 0; recipients[length].getEmail() == email; length++)
        ;

        if(length < recipientAmount)
        {
            if(newEmail != null)
            {
                recipients[length].setEmail(newEmail);
                edited = true;
            }
            if(newName != null)
            {
                recipients[length].setName(newName);
                edited = true;
            }
            if(newPhoneNumber >= 403000000 && newPhoneNumber <= 403999999 ||
               newPhoneNumber >= 587000000 && newPhoneNumber <= 587999999)
            {
                recipients[length].setPhoneNumber(newPhoneNumber);
                edited = true;
            }
        }
        return edited;
    }

    /*
     *
     */
    public void addPayee(int accountNumber, String nickName)
    {
        payees[payeeAmount] = new Payee(accountNumber, nickName);
        payeeAmount++;
    }

    /*
     *
     */
    public void addRecipient(String email, String name, int phoneNumber)
    {
        recipients[recipientAmount] = new Recipient(email, name, phoneNumber);
        recipientAmount++;
    }
}
