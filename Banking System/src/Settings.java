import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Settings extends Display{

    private JFrame frame;
    private JButton back;
    private JButton etransfer;
    private JButton manage;
    private JButton recurring;
    private JLabel label;

    public Settings()
    {
        Color background = new Color(9, 97, 146);
        frame = new JFrame();
        back = new JButton("Go Back");
        etransfer = new JButton("E-Transfer");
        manage = new JButton("Manage Contacts");
        recurring = new JButton("Recurring Payments");

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

        createInitialButtons();

        frame.setSize(600, 600);
        frame.setLocationRelativeTo(null); //puts frame in center of screen
        frame.setLayout(null); //uses no layout managers
        frame.setVisible(true); //makes the frame visible
    }

    private void createInitialButtons()
    {
        //add a back button to the screen
        back.setBounds(440, 40, 100, 30);
        back.addActionListener(new ActionListener() {
            //allows the go back button to bring back to main menu
            @Override
            public void actionPerformed(ActionEvent e)
            {
                frame.dispose();
                displayMenu();
            }
        });
        frame.add(back);

        //add a Label that says "More"
        label = new JLabel("More");
        label.setBounds(30, 80, 100, 60);
        frame.add(label);

        //Add a button for managing Contacts
        manage.setBounds(400, 160, 150, 30);
        manage.addActionListener(new ActionListener() {
            //allows the user to go and view contacts (add, edit, remove)
            @Override
            public void actionPerformed(ActionEvent e)
            {

            }
        });
        frame.add(manage);
        label = new JLabel("Add, edit or remove payees & recipients");
        label.setBounds(30, 160, 300, 30);
        frame.add(label);

        //Add a button and description for recurring payment
        recurring.setBounds(400, 210, 150, 30);
        recurring.addActionListener(new ActionListener() {
            //allows the user to go and view recurring payments (add, edit, remove)
            @Override
            public void actionPerformed(ActionEvent e)
            {

            }
        });
        frame.add(recurring);
        label = new JLabel("Add, edit or remove recurring Payments");
        label.setBounds(30, 210, 300, 30);
        frame.add(label);

        //Add a button and description for e-transferring
        etransfer.setBounds(400, 260, 150, 30);
        etransfer.addActionListener(new ActionListener() {
            //allows the user to go and process a e-transfer request
            @Override
            public void actionPerformed(ActionEvent e)
            {
                frame.dispose();
                Etransfer screen = new Etransfer(getContacts());
                screen.setChequings(getChequing());
                screen.setContacts(getContacts());
                screen.setCredit(getCredit());
                screen.setSavings(getSavings());
            }
        });
        frame.add(etransfer);
        label = new JLabel("Send E-Transfer to Recipient of choice");
        label.setBounds(30, 260, 300, 30);
        frame.add(label);

    }
}
