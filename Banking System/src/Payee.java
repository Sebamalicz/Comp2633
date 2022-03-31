/*
 * Payee deals the contacts in form of Payee's, mainly companies
 */
public class Payee {
    final private int accountNumber;
    private String nickName;

    public Payee(int accountNumber, String nickName)
    {
        this.accountNumber = accountNumber;
        this.nickName = nickName;
    }

    public int getAccountNumber()
    {
        return this.accountNumber;
    }

    public String getNickName()
    {
        return this.nickName;
    }

    public boolean setNickName(String nickName)
    {
        boolean isChanged = false;

        if(nickName.length() <= 20)
        {
            this.nickName = nickName;
        }

        return isChanged;
    }
    
    public boolean setAccountNumber(int newAccountNumber)
    {
        if(newAccountNumber > 99999999 && newAccountNumber < 1000000000)
        {
            this.accountNumber = newAccountNumber;
            return true;
        }
        return false;
    }

}
