import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MainMenu {

    private JFrame frame;
    private ArrayList<JButton> view;
    private Savings selectedS;
    private Credit selectedCr;
    private Color background;
    private int initialX, initialY;

    public MainMenu(Chequing chequing, ArrayList<Savings> saving, ArrayList<Credit> credit)
    {
        initialX = 450;
        initialY = 30;
        view = new ArrayList<JButton>();
        background = new Color(9, 97, 146);
        frame = new JFrame();

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
            }
        });
        frame.add(view.get(i));
        i++;
        return i;
    }

    private int createSaving(ArrayList<Savings> saving, int i)
    {
        //add savings account view buttons to screen (if multiple exist/ or single)
        if(saving != null)
        {
            while(i < (saving.size() + 1))
            {
                view.add(new JButton("View"));
                view.get(i).setBounds(initialX, initialY + (i * 50), 100, 30);
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
                    }
                });
                frame.add(view.get(i));
                i++;
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
            while(i < (temp + credit.size()))
            {
                view.add(new JButton("View"));
                view.get(i).setBounds(initialX, initialY + (i * 40), 100, 30);
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
                    }
                });
                frame.add(view.get(i));
            }
        }
    }
}
