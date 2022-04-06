import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Recurring extends Display{
  
    private JFrame frame;
    private JButton back;
    private ArrayList<JButton> pay;
    // used for payees
    private JLabel label;
    private int initialX, initialY;
    

    public Recurring(Contact contact)
    {
        Color background = new Color(9, 97, 146);
        frame = new JFrame();
        back = new JButton("Go Back");
        pay = new ArrayList<JButton>();

        initialX = 450;
        initialY = 200;
      
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(background);

        // list contacts both payees and recipients
        createInitialButtons(contact.getPayees());

        frame.setSize(600, 600);
        frame.setLocationRelativeTo(null); //puts frame in center of screen
        frame.setLayout(null); //uses no layout managers
        frame.setVisible(true); //makes the frame visible

    }

     private void createInitialButtons(ArrayList<Payee> payees)
     {

        setUpPay(payees, payees.size());

     }
  
     public void setUpPay(ArrayList<Payee> payees, int size)
     {
        int i = 0;
        String num;
        
        while(i < payees.size())
        {
            label = new JLabel(payees.get(i).getNickName());
            label.setBounds(initialX, initialY + (i * 50), 200, 30);
            frame.add(label);
            num = Integer.toString(payees.get(i).getAccountNumber());
            label = new JLabel(num);
            label.setBounds(initialX + 220, initialY + (i * 50), 200, 30);
            frame.add(label);
            pay.add(new JButton("Pay"));
            pay.get(i).setBounds(initialX + 420, initialY + (i * 50), 100, 30);
            pay.get(i).addActionListener(new ActionListener() {
               @Override
            public void actionPerformed(ActionEvent e) {
                   int i, payNum = 0;
                   for(i = 0; i < pay.size(); i++)
                   {
                       if(e.getSource().equals(pay.get(i)))
                       {
                           payNum = i;
                           i = pay.size();
                       }
                   }
                   JOptionPane amount = new JOptionPane();
                   JOptionPane date = new JOptionPane();
                   double money;
                   String input = amount.showInputDialog("Enter amount to send to: " + payees.get(payNum).getName());
                   String sendDate = date.showInputDialog("Enter date to send: ");
                   if(input != null && sendDate != null)
                   {
                       money = Double.parseDouble(input);
                       Credit newCard = getCredit();
                       newCard.transactions.add(new Transaction(sendDate, payees.get(payNum).getName(), money));
                       JOptionPane.showMessageDialog(frame, "Payment set up!");
                   }

               }
            });
            frame.add(pay.get(i));
            i++;
        }
     }

}
