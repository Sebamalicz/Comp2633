import java.util.ArrayList;

/*
 * This class deals with the contact portion of the Banking System. Allows the client
 * to add/edit/remove payees and recipients from the given system.
 */
public class Contact {
    private ArrayList<Payee> payees; //Payee array to access various payees
    private ArrayList<Recipient> recipients; //Recipient array to acces various payees

    public Contact()
    {
        this.payees = new ArrayList<Payee>();
        this.recipients = new ArrayList<Recipient>();
    }

    /*
     * This is the constructor for the Contact Class, sets up the Payee array, Recipient
     * array , payeeAmount and Recipient Amount
     */
    public Contact(ArrayList<Payee> payees, ArrayList<Recipient> recipients)
    {
        this.payees = payees;
        this.recipients = recipients;
    }

    /*
     * This is a getter for the Payee array list
     */
    public ArrayList<Payee> getPayees()
    {
        return this.payees;
    }

    public int getPayeeAmount()
    {
        return this.payees.size();
    }

    /*
     * This is a getter for the Recipient array list
     */
    public ArrayList<Recipient> getRecipients()
    {
        return this.recipients;
    }

    public int getRecipientAmount()
    {
        return this.recipients.size();
    }

    /*
     * This method prints out the Payees that exists within the array list as long
     * as there are payees that exist.
     */
    public void viewPayees()
    {
        int payeeAmnt = getPayeeAmount();
        int length;
        if(payeeAmnt > 0) //checks if payee array is empty
        {
            System.out.println("--------------------------------------------------");
            for(length = 0; length <= payeeAmnt; length++)
            {
                if(payees.get(length).getNickName() != null) //as long as the payee nickname exists
                {
                    System.out.println("Nickname: " + payees.get(length).getNickName());
                }
                System.out.println("Account Number: " + payees.get(length).getAccountNumber());
                System.out.println("------------------------------------------------------");
            }
        }

    }

    /*
     * This method prints out the Recipients that exists within the array list as
     * long as there are recipients that exist.
     */
    public void viewRecipients()
    {
        int recipientAmnt = getRecipientAmount();
        int length;
        if(recipients.size() > 0) //checks if recipient array is empty
        {
            for(length = 0; length <= recipientAmnt; length++)
            {
                System.out.println("Email Address: " + recipients.get(length).getEmail());
                if(recipients.get(length).getName() != null) //as long as this recipient name is not null
                {
                    System.out.println("Name: " + recipients.get(length).getName());
                }
                System.out.println("Phone Number" + recipients.get(length).getPhoneNumber());
            }
        }
    }

    /*
     * This method allows the client to edit payees that already exist within the
     * system. If this payee that is specified does not exist within the system
     * then nothing is changed within the array. Allows the editing of Name and
     * accountNumber. Also allows the client to remove the payee if the client
     * chooses to do so.
     */
    public boolean editPayee(int accountNumber, String newName,
                             int newAccountNumber, boolean remove)
    {
        boolean edited = false;
        int length;

        //get location in array of account number if exists
        for(length = 0; payees.get(length).getAccountNumber() == accountNumber; length++)
        ;

        if(remove) //checks whether the client wants to remove the payee
        {
            removePayee(length);
        }
        else
        {
            if(length < getPayeeAmount()) //checks whether the payee exists within the array
            {
                if(newName != null) //checks if client specified new name
                {
                    payees.get(length).setNickName(newName);
                    edited = true;
                }
                if(newAccountNumber != 0) //checks if client specified new accountNumber
                {
                    payees.get(length).setAccountNumber(newAccountNumber);
                    edited = true;
                }
            }
        }

        return edited;
    }

    /*
     * This method allows the client to edit recipients that already exist within the
     * system. If this recipient that is specified does not exist within the system
     * then nothing is changed within the array. Allows the editing of email, name and
     * phoneNumber. Also allows the client to remove the recipient if the client chooses
     * to do so.
     */
    public boolean editRecipient(String email, String newEmail, String newName,
                                 int newPhoneNumber, boolean remove)
    {
        boolean edited = false;
        int length;

        //get location in array of email if exits
        for(length = 0; recipients.get(length).getEmail() == email; length++)
        ;

        if(remove) //checks whether the client wants to remove the recipient
        {
            removeRecipient(length);
        }
        else
        {
            if(length < getPayeeAmount()) //checks whether the recipient exists within the array
            {
                if(newEmail != null) //checks if client specified new email
                {
                    recipients.get(length).setEmail(newEmail);
                    edited = true;
                }
                if(newName != null) //checks if client specified new name
                {
                    recipients.get(length).setName(newName);
                    edited = true;
                }
                if(newPhoneNumber >= 403000000 && newPhoneNumber <= 403999999 ||
                   newPhoneNumber >= 587000000 && newPhoneNumber <= 587999999)
                    //checks whether phone number is within Alberta phone number ranges
                {
                    recipients.get(length).setPhoneNumber(newPhoneNumber);
                    edited = true;
                }
            }
        }

        return edited;
    }

    /*
     * This method allows the client to add a payee with the given accountNumber
     * and a nickname(if chosen by the client), and adds it to the array of
     * payees.
     */
    public void addPayee(int accountNumber, String nickName)
    {
        Payee addNew = new Payee(accountNumber, nickName);
        payees.add(addNew);
    }

    /*
     * This method allows the client to add a recipient with the given email, name
     * and phoneNumber (if chosen by the client), and adds it to the array of
     * recipients;
     */
    public void addRecipient(String email, String name, int phoneNumber)
    {
        Recipient addNew = new Recipient(email, name, phoneNumber);
        recipients.add(addNew);
    }

    /*
     * This method allows the client to reomve a payee from the system and from the
     * payee array.
     */
    public void removePayee(int length)
    {
        payees.remove(length);
    }

    /*
     * This method allwos the client to remove a recipient from the system and from
     * the recipient array.
     */
    public void removeRecipient(int length)
    {
        recipients.remove(length);
    }


}
