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
        ArrayList<Savings> saving = new ArrayList<Savings>();
        Swing screen = new Swing();
        String username, password;
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
                    inputFile = new Scanner(new File("C:\\Users\\smska\\Desktop\\input.txt"));
                    if(checkUser(inputFile, username, password))
                    {
                        readFile (inputFile, saving, username, password);
                        loggedIn = true;
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

        System.out.println("logged in finally!");

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

    public static void readFile(Scanner input, ArrayList<Savings> saving, String username, String password)
    {
        Contact contacts = new Contact();
        String temp;
        String temp2;
        String nickName;
        String email;
        int clientNum;
        int accNum;
        int phone;
        double balance;
        double cost;
        double interestRate;
        double interestGained;
        boolean read = true;
        char c;
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

                            Client newClient = new Client(clientNum, username, password, email);
                        }
                        else //if end client exists then only chequing exists....
                        {
                             /* begin reading chequing info*/
                            cost = Double.parseDouble(temp);
                            temp = input.nextLine();
                            accNum = Integer.parseInt(temp);
                            temp = input.nextLine();
                            balance = Double.parseDouble(temp);

                            Chequing newCheq = new Chequing(cost, accNum, balance);

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

                    Chequing newCheq = new Chequing(cost, accNum, balance);
                    /* end reading chequing info*/


                    /* reads the ---------- */
                    temp = input.nextLine();


                    temp = input.nextLine(); //pre loop read
                    /* begin reading savings account*/
                    while (temp.compareTo("----------------") != 0)
                    {
                        interestRate = Double.parseDouble(temp);

                        temp = input.nextLine();
                        System.out.println(temp);
                        interestGained = Double.parseDouble(temp);

                        temp = input.nextLine();
                        System.out.println(temp);
                        accNum = Integer.parseInt(temp);

                        temp = input.nextLine();
                        System.out.println(temp);
                        balance = Double.parseDouble(temp);

                        Savings newSave = new Savings(interestRate, interestGained, accNum, balance);
                        saving.add(newSave);

                        temp = input.nextLine();
                        System.out.println(temp);
                    }

                    /* begin reading the payee info*/

                    temp = input.nextLine();
                    System.out.println(temp + '\n');
                    while(temp.compareTo("----------------") != 0)
                    {
                        accNum = Integer.parseInt(temp);
                        temp = input.nextLine();
                        System.out.println(temp + '\n');

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
                        System.out.println(temp + '\n');
                    }

                    /* begin reading recipient info*/
                    temp = input.nextLine();
                    System.out.println(temp + '\n');
                    while(temp.compareTo("----------------") != 0)
                    {
                        email = temp;
                        nickName = input.nextLine();
                        temp = input.nextLine();
                        phone = Integer.parseInt(temp);

                        contacts.addRecipient(email, nickName, phone);

                        temp = input.nextLine();
                    }

                }
            }

        }
    }


}
