import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class manageContacts extends Display{

  private JFrame frame;
  private JButton back;
  private ArrayList<JButton> edit;
  // used for payees
  private JLabel label;
  private ArrayList<JTextField> payeeName;
  private ArrayList<JTextField> payeeAccNum;
  private ArrayList<JTextField> recipientName;
  private ArrayList<JTextField> recipientEmail;
  private ArrayList<JTextField> recipientPhone;
  private ArrayList<Payee> payees;
  private ArrayList<Recipient> recipients;
  int initialX, initialY;


  public manageContacts(Contact contact)
  {
      Color background = new Color(9, 97, 146);
      frame = new JFrame();
      back = new JButton("Go Back");
      edit = new ArrayList<JButton>();
      payees = contact.getPayees();
      recipients = contact.getRecipients();
      initialX = 30;
      initialY = 80;

      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().setBackground(background);

      // list contacts both payees and recipients
      createInitialButtons();

      frame.setSize(600, 600);
      frame.setLocationRelativeTo(null); //puts frame in center of screen
      frame.setLayout(null); //uses no layout managers
      frame.setVisible(true); //makes the frame visible

  }

   private void createInitialButtons()
   {
      int sumSize = payees.size() + recipients.size();

      createBack();
      listPayees(payees, payees.size());
     // listRecipients(recipients, recipients.size());

   }

   private void createBack()
   {
       back.setBounds(440, 40, 100, 30);
       back.addActionListener(new ActionListener() {
           @Override
        public void actionPerformed(ActionEvent e)
           {
               frame.dispose();
               Settings screen = new Settings();
               screen.setChequings(getChequing());
               screen.setContacts(getContacts());
               screen.setCredit(getCredit());
               screen.setSavings(getSavings());
               frame.dispose();
           }
       });
       frame.add(back);
   }

  public void listPayees(ArrayList<Payee> payees, int size)
  {
      int i = 0;
      payeeName = new ArrayList<JTextField>();
      payeeAccNum = new ArrayList<JTextField>();

      //add a Label that says "Payees"
      label = new JLabel("Payee(s)");
      label.setBounds(initialX, initialY - 50, 100, 30);
      frame.add(label);
      while(i < size)
      {
          payeeName.add(new JTextField(payees.get(i).getNickName()));
          payeeName.get(i).setBounds(initialX, initialY + (i * 50), 100, 30);
          frame.add(payeeName.get(i));
          payeeAccNum.add(new JTextField(Integer.toString(payees.get(i).getAccountNumber())));
          payeeAccNum.get(i).setBounds(initialX + 120, initialY + (i * 50), 100, 30);
          frame.add(payeeAccNum.get(i));


          edit.add(new JButton("Edit"));
          edit.get(i).setBounds(initialX + 240, initialY + (i * 50), 100, 30);
          edit.get(i).addActionListener(new ActionListener(){

              //allows the clicking of edit for Contacts
              @Override
              public void actionPerformed(ActionEvent e) {

                  int k, selected = 0;
                  for(k = 0; k < edit.size(); k++)
                  {
                    if(e.getSource().equals(edit.get(k)))
                    {
                      selected = k;
                      k = edit.size();
                    }
                  }

                  if(selected < payees.size())
                  {
                    payees.get(selected).setNickName(payeeName.get(selected).getText());
                    payees.get(selected).setAccountNumber(Integer.parseInt(payeeAccNum.get(selected).getText()));
                  }

              }

          });
          frame.add(edit.get(i));
          i++;
      }
    }

    public void listRecipients(ArrayList<Recipient> recipients, int size)
    {

        int i = 0;
        recipientName = new ArrayList<JTextField>();
        recipientEmail = new ArrayList<JTextField>();
        recipientPhone = new ArrayList<JTextField>();
        label = new JLabel("Recipient(s)");
        label.setBounds(30, 80, 100, 60);
        frame.add(label);
        while(i < size + 1)
        {
            recipientName.get(i).add(new JTextField(recipients.get(i).getName()));
            recipientName.get(i).setBounds(initialX, initialY + (i * 50), 100, 30);
            frame.add(recipientName.get(i));
            recipientEmail.get(i).add(new JTextField(recipients.get(i).getEmail()));
            recipientEmail.get(i).setBounds(initialX, initialY + (i * 50), 100, 30);
            frame.add(recipientEmail.get(i));
            if(recipients.get(i).getPhoneNumber() != 0)
            {
                String phone = Integer.toString(recipients.get(i).getPhoneNumber());
                recipientPhone.get(i).add(new JTextField(phone));
                recipientPhone.get(i).setBounds(initialX, initialY + (i * 50), 100, 30);
                frame.add(recipientPhone.get(i));
            }

            edit.add(new JButton("Edit"));
            edit.get(i).setBounds(initialX, initialY + (i * 50) + 50, 100, 30);
            edit.get(i).addActionListener(new ActionListener(){

              //allows the clicking of edit for Contacts
              @Override
              public void actionPerformed(ActionEvent e) {

                  int k, selected = 0;
                  for(k = 0; k < edit.size(); k++)
                  {
                    if(e.getSource().equals(edit.get(k)))
                    {
                      selected = k;
                      k = edit.size();
                    }
                  }

                  if(selected < recipients.size())
                  {
                      recipients.get(selected).setName(recipientName.get(selected).getText());
                      recipients.get(selected).setEmail(recipientEmail.get(selected).getText());
                      recipients.get(selected).setPhoneNumber(Integer.parseInt(recipientPhone.get(selected).getText()));
                  }


              }
            });
        }
    }
}
