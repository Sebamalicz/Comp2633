import java.awt.Color;
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

        frame.setSize(600, 600);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    private void createBackButton()
    {

    }
}
