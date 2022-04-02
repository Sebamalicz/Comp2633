/*
 * This payee class deals the contacts in form of Payee's, mainly companies
 */
public class Payee {
    private int accountNumber; //account number of payee (credit card, company, etc...)
    private String nickName; //nickname of given credit card, company, etc...

    /*
     * This is the constructor for the Payee class, sets up the accountNumber, and the
     * nickName of the Payee
     */
    public Payee(int accountNumber, String nickName)
    {
        if(accountNumber > 99999999 && accountNumber < 1000000000)
            //checks if account number is 9 digits long
        {
            this.accountNumber = accountNumber;
        }
        if(nickName.length() <= 20) //if the name size is 20 or under
        {
            this.nickName = nickName;
        }
        else
        {
            this.nickName = null;
        }
    }

    /*
     * This is the getter for the account number
     */
    public int getAccountNumber()
    {
        return this.accountNumber;
    }

    /*
     * This is the getter for the nickname
     */
    public String getNickName()
    {
        return this.nickName;
    }

    /*
     * This method allows the client to change the nickname
     */
    public boolean setNickName(String nickName)
    {
        boolean isChanged = false;

        if(nickName.length() <= 20) //if the name size is 20 or under
        {
            this.nickName = nickName;
        }

        return isChanged;
    }

    /*
     * This method allows the client to change the account number
     */
    public boolean setAccountNumber(int newAccountNumber)
    {
        if(newAccountNumber > 99999999 && newAccountNumber < 1000000000)
            //if the account number is 9 digits long
        {
            this.accountNumber = newAccountNumber;
            return true;
        }
        return false;
    }

}
