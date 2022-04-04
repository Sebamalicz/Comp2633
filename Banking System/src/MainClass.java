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

        while(!loginPressed)
        {
            loginPressed = screen.getLoginPressed();
            System.out.println();
        }


        if(loginPressed)
        {
            username = screen.getUserText();
            password = screen.getPassText();
            try
            {
                inputFile = new Scanner(new File("C:\\Users\\smska\\Desktop\\input.txt"));
                readFile (inputFile, saving, username, password);
                System.out.println(saving.get(0).getAccountNumber());
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

    public static boolean readFile(Scanner input, ArrayList<Savings> saving, String username, String password)
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
                        else
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
                    System.out.println(temp);
                    
                    /* begin reading chequing info*/
                    temp = input.nextLine();
                    cost = Double.parseDouble(temp);
                    temp = input.nextLine();
                    accNum = Integer.parseInt(temp);
                    temp = input.nextLine();
                    balance = Double.parseDouble(temp);

                    Chequing newCheq = new Chequing(cost, accNum, balance);
                    
                    /* reads the ---------- */
                    temp = input.nextLine();
                    System.out.println(temp);


                    /* begin reading savings account*/
                    temp = input.nextLine();
                    System.out.println(temp);
                    while(temp != "----------------")
                    {
                        if(temp != "----------------")
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
                    }

                    /* begin reading the payee info*/

                    temp = input.nextLine();
                    while(temp != "-----------------")
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
                    while(temp != "-----------------")
                    {
                        email = temp;
                        nickName = input.nextLine();
                        temp = input.nextLine();
                        phone = Integer.parseInt(temp);

                        contacts.addRecipient(email, nickName, phone);

                        temp = input.nextLine();
                    }

                }
                else
                {
                    read = false;
                }
            }
            else
            {
                read = false;
            }
        }
        return read;
    }


}
