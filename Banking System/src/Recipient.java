
public class Recipient {
    private String email;
    private String name;
    private int phoneNumber;

    public Recipient(String email, String name, int phoneNumber)
    {
        this.email = email;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getEmail()
    {
        return this.email;
    }

    public String getName()
    {
        return this.name;
    }

    public int getPhoneNumber()
    {
        return this.phoneNumber;
    }

    public boolean setEmail(String email)
    {
        boolean isChanged = false;

        if(isEmailValid(email))
        {
            isChanged = true;
            this.email = email;
        }

        return isChanged;
    }

    public boolean setName(String name)
    {
        boolean isChanged = false;

        if(name.length() <= 20)
        {
            this.name = name;
            isChanged = true;
        }

        return isChanged;
    }

    public boolean setPhoneNumber(int phoneNumber)
    {
        boolean isChanged = false;

        if(phoneNumber >= 403000000 && phoneNumber <= 403999999 ||
           phoneNumber >= 587000000 && phoneNumber <= 587999999)
        {
            this.phoneNumber = phoneNumber;
            isChanged = true;
        }

        return isChanged;
    }

    private boolean isEmailValid(String email)
    {
        boolean isValid = false;

        if(email.contains("@gmail.com"))
        {
            isValid = true;
        }
        else if(email.contains("@hotmail.com"))
        {
            isValid = true;
        }
        else if(email.contains("@icloud.com"))
        {
            isValid = true;
        }

        return isValid;
    }
}

