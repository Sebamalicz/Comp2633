/*
 * Payee deals the contacts in form of Payee's, mainly companies
 */
public class Payee extends Contact{
    final private int accountNumber;
    private String nickName;

    public Payee(int accountNumber, String nickName, Payee payees[],
                 Recipient recipients[], int payeeAmount, int recipientAmount)
    {
        super(payees, recipients, payeeAmount, recipientAmount);
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

}
