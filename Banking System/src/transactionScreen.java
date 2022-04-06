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

public class transactionScreen extends Display{
    private Savings saving;
    private Chequing chequing;
    private Credit credit;
    private ArrayList<Transaction> transactions;
    private JFrame frame;
    private JLabel label;
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
        initialY = 180;
        background = new Color(9, 97, 146);

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

        createBackButton();
        displayInfo();
        displayTrans();

        frame.setSize(600, 600);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    private void createBackButton()
    {
        button = new JButton("Go Back");
        button.setBounds(440, 40, 100, 30);
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

    private void displayInfo()
    {
        label = new JLabel("Location");
        label.setBounds(initialX, initialY - 50, 200, 30);
        frame.add(label);
        label = new JLabel("Date");
        label.setBounds(initialX + 220, initialY - 50, 200, 30);
        frame.add(label);
        label = new JLabel("Amount");
        label.setBounds(initialX + 420, initialY - 50, 100, 30);
        frame.add(label);
    }

    private void displayTrans()
    {
        if(transactions != null)
        {
            int i = 0;
            while(i < transactions.size() && i * 50 < 600)
            {
                label = new JLabel(transactions.get(i).getGeneral());
                label.setBounds(initialX, initialY + (i * 50), 200, 30);
                frame.add(label);
                label = new JLabel(transactions.get(i).getDate());
                label.setBounds(initialX + 220, initialY + (i * 50), 200, 30);
                frame.add(label);
                label = new JLabel(String.valueOf(transactions.get(i).getAmountUsed()));
                label.setBounds(initialX + 420, initialY + (i * 50), 100, 30);
                frame.add(label);
                i++;
            }
        }
    }
}
