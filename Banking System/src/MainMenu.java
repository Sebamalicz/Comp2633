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
        createChequing(chequing, i);
        createSaving(saving, i);
        createCredit(credit, i);

    }

    private void createChequing(Chequing chequing, int i)
    {

        //Add chequing account view Button to screen
        view.add(new JButton("View"));
        view.get(i).setBounds(initialX, initialY + (i * 40), 100, 30);
        view.get(i).addActionListener(new ActionListener()
        {
            //allows the clicking of view for chequing
            @Override
            public void actionPerformed(ActionEvent e) {
                /*
                 * Selected account will be the singular chequing account
                 */
            }
        });
        frame.add(view.get(i));
    }

    private void createSaving(ArrayList<Savings> saving, int i)
    {
        //add savings account view buttons to screen (if multiple exist/ or single)
        if(saving != null)
        {
            for(i = 1; i < saving.size(); i++)
            {
                view.get(i).add(new JButton("View"));
                view.get(i).setBounds(initialX, initialY + (i * 40), 100, 30);
                view.get(i).addActionListener(new ActionListener()
                {
                    //allows the clicking of view for savings accounts
                    @Override
                    public void actionPerformed(ActionEvent e) {
                       int s = view.indexOf(e.getSource());
                       selectedS = saving.get(s);
                    }
                });
                frame.add(view.get(i));
            }
        }
    }

    private void createCredit(ArrayList<Credit> credit, int i)
    {
        //add credit card account view buttons to screen (if multiple exist/ or single)
        int temp = i;
        if(credit != null)
        {
            while(i < (temp + credit.size()))
            {
                view.get(i).add(new JButton("View"));
                view.get(i).setBounds(initialX, initialY + (i * 40), 100, 30);
                view.get(i).addActionListener(new ActionListener()
                {
                    //allows the clicking of view for credit accounts
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int c = view.indexOf(e.getSource());
                        selectedCr = credit.get(c);
                    }
                });
                frame.add(view.get(i));
            }
        }
    }
}
