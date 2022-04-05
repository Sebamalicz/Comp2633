import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class transactionScreen extends Display{
    private Savings saving;
    private Chequing chequing;
    private Credit credit;
    private ArrayList<Transaction> transactions;
    private JFrame frame;
    private JTextArea text;
    private JButton button;
    private Color background;
    private int initialX, initialY;

    public transactionScreen(Savings saving)
    {
        this.saving = saving;
        this.transactions = saving.getTransactions();
        displayTransactions();
    }

    public transactionScreen(Chequing chequing)
    {
        this.chequing = chequing;
        this.transactions = chequing.getTransactions();
        displayTransactions();
    }

    public transactionScreen(Credit credit)
    {
        this.credit = credit;
        this.transactions = credit.getTransactions();
        displayTransactions();
    }

    private void displayTransactions()
    {
        frame = new JFrame();
        initialX = 20;
        initialY = 80;
        background = new Color(9, 97, 146);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(background);

        createBackButton();
        displayTrans();

        frame.setSize(600, 600);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    private void createBackButton()
    {
        button = new JButton("Go Back");
        button.setBounds(480, 20, 100, 30);
        button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                displayMenu();
            }
        });
        frame.add(button);
    }

    public void displayTrans()
    {
        if(transactions != null)
        {
            int i = 0;
            while(i < transactions.size() && i * 50 < 600)
            {
                text = new JTextArea(transactions.get(i).getGeneral());
                text.setBounds(initialX, initialY + (i * 50), 100, 30);
                frame.add(text);
                text = new JTextArea(transactions.get(i).getDate());
                text.setBounds(initialX + 120, initialY + (i * 50), 100, 30);
                frame.add(text);
                text = new JTextArea(String.valueOf(transactions.get(i).getAmountUsed()));
                text.setBounds(initialX + 240, initialY + (i * 50), 100, 30);
                frame.add(text);
                i++;
            }
        }
    }
}
