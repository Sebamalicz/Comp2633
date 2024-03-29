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
import javax.swing.JOptionPane;

public class MainMenu extends Display{

    private JFrame frame;
    private ArrayList<JButton> view;
    private JButton settings;
    private JLabel text;
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
            image = ImageIO.read(new File("mainMenuHeader.png"));
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
        int savingSize = saving.size();
        i = createChequing(chequing, i);
        i = createSaving(saving, i);
        createCredit(credit, i, savingSize);
        createSettings();

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
                if(chequing.getTransactionAmount() != 0)
                {
                    frame.dispose();
                    transactionScreen screen = new transactionScreen(chequing);
                    screen.setChequings(getChequing());
                    screen.setContacts(getContacts());
                    screen.setCredit(getCredit());
                    screen.setSavings(getSavings());
                }
                else
                {
                    JOptionPane.showMessageDialog(frame, "No Transactions for " +
                            chequing.getAccountNumber());
                }
            }
        });
        text = new JLabel("Chequing Account");
        text.setBounds(30, initialY - (i * 50) - 50, 200, 30);
        frame.add(text);
        text = new JLabel("Account Number: " + String.valueOf(chequing.getAccountNumber()));
        text.setBounds(30, initialY + (i * 50), 200, 30);
        frame.add(text);
        text = new JLabel("Balance: " + String.valueOf(chequing.getBalance()));
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
            text = new JLabel("Saving Accounts");
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
                       for(i = 0; i < view.size(); i++)
                       {
                           if(e.getSource().equals(view.get(i)))
                           {
                               savingNumber = i - 1;
                               i = view.size();
                          }
                       }
                       //checks if transaction exits, if yes display
                       if(saving.get(savingNumber).getTransactionAmount() != 0)
                       {
                           frame.dispose();
                           transactionScreen screen = new transactionScreen(saving.get(savingNumber));
                           screen.setChequings(getChequing());
                           screen.setContacts(getContacts());
                           screen.setCredit(getCredit());
                           screen.setSavings(getSavings());
                       }
                       else //if no display message that no transactions exit for saving account number
                       {
                           JOptionPane.showMessageDialog(frame, "No Transactions for " +
                                   saving.get(savingNumber).getAccountNumber());
                       }
                    }
                });
                text = new JLabel("Account Number: " + String.valueOf(saving.get(savings).getAccountNumber()));
                text.setBounds(30, initialY + (i * 50) + 50, 200, 30);
                frame.add(text);
                text = new JLabel("Balance: " + String.valueOf(saving.get(savings).getBalance()));
                text.setBounds(240, initialY + (i * 50) + 50, 200, 30);
                frame.add(text);
                frame.add(view.get(i));
                i++;
                savings++;
            }
        }

        return i;
    }

    private void createCredit(ArrayList<Credit> credit, int i, int saving)
    {
        //add credit card account view buttons to screen (if multiple exist/ or single)
        int temp = i;
        if(credit != null)
        {
            int credits = 0;
            text = new JLabel("Credit Cards");
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
                        for(i = 0; i < view.size(); i++)
                        {
                            if(e.getSource().equals(view.get(i)))
                            {
                                creditNumber = i - (1 + saving);
                                i = view.size();
                            }
                        }
                        //checks if transactions exist, if yes display
                        if(credit.get(creditNumber).getTransactionAmount() != 0)
                        {
                            frame.dispose();
                            transactionScreen screen = new transactionScreen(credit.get(creditNumber));
                            screen.setChequings(getChequing());
                            screen.setContacts(getContacts());
                            screen.setCredit(getCredit());
                            screen.setSavings(getSavings());
                        }
                        else //if no display no transactions message for credit card number
                        {
                            JOptionPane.showMessageDialog(frame, "No Transactions for " +
                                                            credit.get(creditNumber).getCardNumber());
                        }
                    }
                });
                text = new JLabel("Credit Card #: " + String.valueOf(credit.get(credits).getCardNumber()));
                text.setBounds(30, initialY + (i * 50) + 100, 200, 30);
                frame.add(text);
                text = new JLabel("Balance: " + String.valueOf(credit.get(credits).getBalanceToPay()));
                text.setBounds(240, initialY + (i * 50) + 100, 200, 30);
                frame.add(text);
                frame.add(view.get(i));
                i++;
                credits++;
            }
        }
    }

    private void createSettings()
    {
        settings = new JButton("Settings");
        settings.setBounds(440, 40, 100, 30);
        settings.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                Settings screen = new Settings();
                screen.setChequings(getChequing());
                screen.setContacts(getContacts());
                screen.setCredit(getCredit());
                screen.setSavings(getSavings());
                frame.dispose();

            }
        });

        frame.add(settings);
    }


}
