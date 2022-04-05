import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * This Class Handles all of the Banking System Components, such as login
 * editing info, and checking all of users banking info.
 */
public class MainClass {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Scanner inputFile;
        Scanner checkFile;

        ArrayList<Savings> saving;
        Contact contacts;
        Client client;
        Chequing chequing;
        ArrayList<Credit> credit = null;
        FileRead read;
        String username, password;


        Swing screen = new Swing();
        Display display;

        boolean loginPressed = false;
        boolean loggedIn = false;

        while(!loggedIn)
        {
            while(!loginPressed)
            {
                System.out.flush(); //flushes buffer to set loginPressed
                loginPressed = screen.getLoginPressed();
            }

            if(loginPressed)
            {
                username = screen.getUserText();
                password = screen.getPassText();
                try
                {
                    checkFile = new Scanner(new File("C:\\Users\\smska\\Desktop\\input.txt"));
                    if(checkUser(checkFile, username, password))
                    {
                        inputFile = new Scanner(new File("C:\\Users\\smska\\Desktop\\input.txt"));
                        read = readFile(inputFile, username, password);
                        loggedIn = true;
                        client = read.getClient();
                        contacts = read.getContacts();
                        chequing = read.getChequing();
                        saving = read.getSavings();
                        display = new Display(contacts, chequing, saving, credit);
                        screen.disposeLogin();
                        display.displayMenu();
                    }
                    else
                    {
                        loginPressed = false;
                    }
                }
                catch (FileNotFoundException e)
                {
                    e.printStackTrace();
                }
            }
            else if(screen.getForgetPressed())
            {

            }
        }

    }

    public static boolean checkUser(Scanner input, String username, String password)
    {
        boolean exists = false;
        while(input.hasNext())
        {
            if(username.equals(input.nextLine()))
            {
                if(password.equals(input.nextLine()))
                {
                    exists = true;
                }
            }
        }

        return exists;
    }

    public static FileRead readFile(Scanner input, String username, String password)
    {
        String temp;
        String nickName;
        String email;
        String date;
        String general;
        int clientNum;
        int accNum;
        int cardNum;
        int phone;
        double balance;
        double cost;
        double interestRate;
        double interestGained;
        double creditLimit;
        char c;
        FileRead read;
        ArrayList<Savings> saving = new ArrayList<Savings>();
        ArrayList<Credit> creditCards = new ArrayList<Credit>();
        ArrayList<Transaction> transList = new ArrayList<Transaction>();
        Contact contacts = new Contact();
        Client client = null;
        Chequing chequing = null;
        while(input.hasNext())
        {
             if(username.equals(input.nextLine()))
            {
                if(password.equals(input.nextLine()))
                {
                    temp = input.nextLine();
                    if(temp.equalsIgnoreCase("start client"))
                    {
                        temp = input.nextLine();
                        if(!temp.equalsIgnoreCase("end client"))
                        {
                            clientNum = Integer.parseInt(temp);
                            email = input.nextLine();

                            client = new Client(clientNum, username, password, email);
                        }
                        else //if end client exists then only chequing exists....
                        {
                             /* begin reading chequing info*/
                            cost = Double.parseDouble(temp);
                            temp = input.nextLine();
                            accNum = Integer.parseInt(temp);
                            temp = input.nextLine();
                            balance = Double.parseDouble(temp);

                            chequing = new Chequing(cost, accNum, balance);

                        }
                    }

                    /* reads the ---------- */
                    temp = input.nextLine();

                    /* begin reading chequing info*/
                    temp = input.nextLine(); //read cost from file
                    cost = Double.parseDouble(temp);

                    temp = input.nextLine(); //read account number from file
                    accNum = Integer.parseInt(temp);

                    temp = input.nextLine(); //read balance from file
                    balance = Double.parseDouble(temp);

                    chequing = new Chequing(cost, accNum, balance);
                    /* end reading chequing info*/


                    /* reads the ---------- */
                    temp = input.nextLine();

                    temp = input.nextLine(); //pre loop read
                    /* begin reading savings account*/

                    while (temp.compareTo("----------------") != 0)
                    {
                        interestRate = Double.parseDouble(temp);

                        temp = input.nextLine();
                        interestGained = Double.parseDouble(temp);

                        temp = input.nextLine();
                        accNum = Integer.parseInt(temp);

                        temp = input.nextLine();
                        balance = Double.parseDouble(temp);

                        Savings newSave = new Savings(interestRate, interestGained, accNum, balance);
                        saving.add(newSave);

                        temp = input.nextLine();
                    }

                    /* begin reading transactions*/

                    temp = input.nextLine();
                    while(temp.compareTo("----------------") != 0)
                    {
                        date = temp;
                        temp = input.nextLine();
                        general = temp;
                        temp = input.nextLine();
                        cost = Double.parseDouble(temp);

                        Transaction newTrans = new Transaction(date, general, cost);
                        transList.add(newTrans);

                        temp = input.nextLine();
                    }


                    /* begin reading credit card info*/

                    temp = input.nextLine();
                    while(temp.compareTo("----------------") != 0)
                    {
                        cardNum = Integer.parseInt(temp);
                        temp = input.nextLine();
                        balance = Double.parseDouble(temp);
                        temp = input.nextLine();
                        creditLimit = Double.parseDouble(temp);
                        temp = input.nextLine();
                        interestRate = Double.parseDouble(temp);

                        temp = input.nextLine();

                        //transaction_list = getTransactions(cardNum);

                        Credit credCard = new Credit(balance, creditLimit, interestRate, cardNum, transList);
                        creditCards.add(credCard);

                        temp = input.nextLine();

                    }
                  /* begin reading the payee info*/

                    temp = input.nextLine();
                    while(temp.compareTo("----------------") != 0)
                    {
                        accNum = Integer.parseInt(temp);
                        temp = input.nextLine();

                        c = temp.charAt(0);
                        c = Character.toLowerCase(c);
                        if(c >= 'a' && c <= 'z')
                        {
                            nickName = temp;
                            contacts.addPayee(accNum, nickName);
                        }
                        else
                        {
                            contacts.addPayee(accNum, null);
                        }
                        temp = input.nextLine();
                    }

                    /* begin reading recipient info*/

                    temp = input.nextLine();
                    while(temp.compareTo("----------------") != 0)
                    {
                        email = temp;
                        nickName = input.nextLine();
                        temp = input.nextLine();
                        phone = Integer.parseInt(temp);

                        contacts.addRecipient(email, nickName, phone);

                        temp = input.nextLine();
                    }
                    read = new FileRead(client, chequing, contacts, saving, creditCards);

                    return read;
                }
            }

        }

        return null;
    }

    public static ArrayList<Transaction> getTransactions(int accountNumber)
    {
        Scanner input;
        try
        {
            input = new Scanner(new File("C:J\User\smska\Desktop\transactions.txt"))
        } 
        catch
        {
            e.printStackTrace();
        }

        String target = Integer.toString(accountNumber);
        String temp;
        String date;
        String general;
        double cost;
        ArrayList<Transaction> transList = new ArrayList<Transaction>();
        while(input.hasNext())
        {
            temp = input.nextLine();
            //finds the account number
            while(temp.compareTo(target) != 0)
            {
                temp = input.nextLine();
            }

            temp = input.nextLine();
            // reads subsequent transactions until ----... indicating a new account number
            while(temp.compareTo("----------------") != 0)
            {
                date = temp;
                general = input.nextLine();
                temp = input.nextLine();
                cost = Double.parseDouble(temp);

                Transaction newTrans = new Transaction(date, general, cost);
                transList.add(newTrans);

                temp = input.nextLine();
            }

            return transList;
        }

        return null;

    }

}
