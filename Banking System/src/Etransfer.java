import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Etransfer extends Display{
    private JFrame frame;
    private JLabel label;
    private ArrayList<JButton> button;
    private Color background;
    private int initialX, initialY;

    public Etransfer(Contact contact)
    {
        frame = new JFrame();
        background = new Color(9, 97, 146);
        initialX = 20;
        initialY = 180;
        button = new ArrayList<JButton>();

        BufferedImage image;

        try { //print the header onto the screen
            image = ImageIO.read(new File("C:\\Users\\smska\\Desktop\\mainMenuHeader.png"));
            JLabel label = new JLabel(new ImageIcon(image));
            label.setBounds(0, 0, 600, 130);
            frame.add(label);
        } catch (IOException e) {
            e.printStackTrace();
        }

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(background);

        createBackButton();
        displayInfo(contact);
        labelInfo();

        frame.setSize(600, 600);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    private void createBackButton()
    {
        JButton back;
        back = new JButton("Go Back");
        back.setBounds(440, 40, 100, 30);
        back.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                Settings screen = new Settings();
                screen.setChequings(getChequing());
                screen.setContacts(getContacts());
                screen.setCredit(getCredit());
                screen.setSavings(getSavings());
            }
        });
        frame.add(back);
    }

    private void labelInfo()
    {
        label = new JLabel("Names:");
        label.setBounds(initialX, initialY - 50, 200, 30);
        frame.add(label);
        label = new JLabel("Email:");
        label.setBounds(initialX + 220, initialY - 50, 200, 30);
        frame.add(label);
    }

    private void displayInfo(Contact contact)
    {
        ArrayList<Recipient> recipient = contact.getRecipients();
        int i = 0;

        while(i < recipient.size())
        {
            label = new JLabel(recipient.get(i).getName());
            label.setBounds(initialX, initialY + (i * 50), 200, 30);
            frame.add(label);
            label = new JLabel(recipient.get(i).getEmail());
            label.setBounds(initialX + 220, initialY + (i * 50), 200, 30);
            frame.add(label);
            button.add(new JButton("Send"));
            button.get(i).setBounds(initialX + 420, initialY + (i * 50), 100, 30);
            button.get(i).addActionListener(new ActionListener() {
               @Override
            public void actionPerformed(ActionEvent e) {
                   int i, recNum = 0;
                   for(i = 0; i < button.size(); i++)
                   {
                       if(e.getSource().equals(button.get(i)))
                       {
                           recNum = i;
                           i = button.size();
                       }
                   }
                   JOptionPane amount = new JOptionPane();
                   double money;
                   String input = amount.showInputDialog("Enter amount to send to: " + recipient.get(recNum).getName());
                   if(input != null)
                   {
                       money = Double.parseDouble(input);
                       Chequing chequing = getChequing();
                       DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM dd, yyyy");
                       LocalDateTime now = LocalDateTime.now();
                       chequing.eTransfer(chequing, recipient.get(recNum), money, dtf.format(now));
                       JOptionPane.showMessageDialog(frame, "Money Sent!");
                   }
               }
            });
            frame.add(button.get(i));
            i++;
        }
    }
}
