import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class MainMenu extends Display{

    private JFrame frame;
    private ArrayList<JButton> view;
    private JTextArea text;
    private Color background;
    private int initialX, initialY;

    public MainMenu(Contact contacts, Chequing chequing, ArrayList<Savings> saving, ArrayList<Credit> credit)
    {
        setContacts(contacts);
        setChequings(chequing);
        setSavings(saving);
        setCredit(credit);
        initialX = 450;
        initialY = 200;
        view = new ArrayList<JButton>();
        background = new Color(9, 97, 146);
        frame = new JFrame();
        BufferedImage image;

        try { //print the header onto the login screen
            image = ImageIO.read(new File("C:\\Users\\smska\\Desktop\\mainMenuHeader.png"));
            JLabel label = new JLabel(new ImageIcon(image));
            label.setBounds(0, 0, 600, 130);
            frame.add(label);
        } catch (IOException e) {
            e.printStackTrace();
        }

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(background);

        createInitialButtons(chequing, saving, credit);

        frame.setSize(600, 600);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    private void createInitialButtons(Chequing chequing, ArrayList<Savings> saving, ArrayList<Credit> credit)
    {
        int i = 0;
        i = createChequing(chequing, i);
        i = createSaving(saving, i);
        createCredit(credit, i);

    }

    private int createChequing(Chequing chequing, int i)
    {

        //Add chequing account view Button to screen
        view.add(new JButton("View"));
        view.get(i).setBounds(initialX, initialY + (i * 50), 100, 30);
        view.get(i).addActionListener(new ActionListener()
        {
            //allows the clicking of view for chequing
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                transactionScreen screen = new transactionScreen(chequing);
                screen.setChequings(getChequing());
                screen.setContacts(getContacts());
                screen.setCredit(getCredit());
                screen.setSavings(getSavings());
            }
        });
        text = new JTextArea("Chequing Account");
        text.setBounds(30, initialY - (i * 50) - 50, 100, 30);
        frame.add(text);
        text = new JTextArea("Account Number: " + String.valueOf(chequing.getAccountNumber()));
        text.setBounds(30, initialY + (i * 50), 200, 30);
        frame.add(text);
        text = new JTextArea("Balance: " + String.valueOf(chequing.getBalance()));
        text.setBounds(240, initialY + (i * 50), 200, 30);
        frame.add(text);
        frame.add(view.get(i));
        i++;
        return i;
    }

    private int createSaving(ArrayList<Savings> saving, int i)
    {
        //add savings account view buttons to screen (if multiple exist/ or single)
        if(saving != null)
        {
            int savings = 0;
            text = new JTextArea("Saving Accounts");
            text.setBounds(30, initialY + (i * 50), 100, 30);
            frame.add(text);
            while(i < (saving.size() + 1))
            {
                view.add(new JButton("View"));
                view.get(i).setBounds(initialX, initialY + (i * 50) + 50, 100, 30);
                view.get(i).addActionListener(new ActionListener()
                {
                    //allows the clicking of view for savings accounts
                    @Override
                    public void actionPerformed(ActionEvent e) {
                       int i, savingNumber = 0;
                       for(i = 0; i < saving.size(); i++)
                       {
                           if(e.getSource() == saving.get(i))
                           {
                               savingNumber = i;
                               i = saving.size();
                           }
                       }
                       frame.dispose();
                       transactionScreen screen = new transactionScreen(saving.get(savingNumber));
                       screen.setChequings(getChequing());
                       screen.setContacts(getContacts());
                       screen.setCredit(getCredit());
                       screen.setSavings(getSavings());
                    }
                });
                text = new JTextArea("Account Number: " + String.valueOf(saving.get(savings).getAccountNumber()));
                text.setBounds(30, initialY + (i * 50) + 50, 200, 30);
                frame.add(text);
                text = new JTextArea("Balance: " + String.valueOf(saving.get(savings).getBalance()));
                text.setBounds(240, initialY + (i * 50) + 50, 200, 30);
                frame.add(text);
                frame.add(view.get(i));
                i++;
                savings++;
            }
        }

        return i;
    }

    private void createCredit(ArrayList<Credit> credit, int i)
    {
        //add credit card account view buttons to screen (if multiple exist/ or single)
        int temp = i;
        if(credit != null)
        {
            int credits = 0;
            text = new JTextArea("Credit Cards");
            text.setBounds(30, initialY + (i * 50) + 50, 100, 30);
            frame.add(text);
            while(i < (temp + credit.size()))
            {
                view.add(new JButton("View"));
                view.get(i).setBounds(initialX, initialY + (i * 50) + 100, 100, 30);
                view.get(i).addActionListener(new ActionListener()
                {
                    //allows the clicking of view for credit accounts
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int i, creditNumber = 0;
                        for(i = 0; i < credit.size(); i++)
                        {
                            if(e.getSource() == credit.get(i))
                            {
                                creditNumber = i;
                                i = credit.size();
                            }
                        }
                        frame.dispose();
                        transactionScreen screen = new transactionScreen(credit.get(creditNumber));
                        screen.setChequings(getChequing());
                        screen.setContacts(getContacts());
                        screen.setCredit(getCredit());
                        screen.setSavings(getSavings());
                    }
                });
                text = new JTextArea("Credit Card #: " + String.valueOf(credit.get(credits).getCardNumber()));
                text.setBounds(30, initialY + (i * 50) + 100, 200, 30);
                frame.add(text);
                text = new JTextArea("Balance: " + String.valueOf(credit.get(credits).getBalanceToPay()));
                text.setBounds(240, initialY + (i * 50) + 100, 200, 30);
                frame.add(text);
                frame.add(view.get(i));
                i++;
                credits++;
            }
        }
    }
}
