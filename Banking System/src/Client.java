/*
 * This class handles all of the Clients purposes
 */
public class Client {
    final private int clientNumber;
    private String userName;
    private String passWord;
    private String email;

    public Client(String userName, String passWord, String email)
    {
        this.clientNumber = (int)Math.floor(Math.random()*(999999999-100000000+1)+100000000);
        this.userName = userName;
        this.passWord = passWord;
        this.email = email;

    }

    public Client(int clientNumber, String userName, String passWord, String email)
    {
        this.clientNumber = clientNumber;
        this.userName = userName;
        this.passWord = passWord;
        this.email = email;
    }

    public int getClientNumber()
    {
        return this.clientNumber;
    }

    public String getUserNmae()
    {
        return this.userName;
    }

    public String getEmail()
    {
        return this.email;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public boolean setPassword(String newPassword, String oldPassword)
    {
        boolean isChanged = false;
        if(oldPassword == this.passWord)
        {
            this.passWord = newPassword;
            isChanged = true;
        }
        return isChanged;
    }

}
