import java.util.File;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * This Class Handles all of the Banking System Components, such as login
 * editing info, and checking all of users banking info.
 */
public class MainClass {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner inputFile = new Scanner(new File("input.txt"));
        ArrayList<Savings> saving;
        readFile(inputFile, saving);
        Swing screen = new Swing();
    }

    public void readFile(Scanner input, ArrayList<Savings> saving)
    {
        Contact contacts = new Contact();
        String temp;
        String temp2;
        String nickName;
        String userName;
        String password;
        String email;
        int clientNum;
        int accNum;
        int phone;
        double balance;
        double cost;
        double interestRate;
        double interestGained;
        char c;
        while(input.hasNext())
        {
            temp = input.nextLine();
            if(temp.equalsIgnoreCase("start client"))
            {
                temp = input.nextLine();
                if(!temp.equalsIgnoreCase("end client"))
                {
                    clientNum = Integer.parseInt(temp);
                    userName = input.nextLine();
                    password = input.nextLine();
                    email = input.nextLine();
                    Client newClient = new Client(clientNum, userName, password, email);
                }
                /* reads the ---------- */
                temp = input.nextLine();
            }
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


            /* begin reading savings account*/
            temp = input.nextLine();
            while(temp != "-----------------")
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
    }

}
