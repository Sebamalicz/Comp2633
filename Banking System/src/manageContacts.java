import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


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

  
  public manageContacts(Contact contact)
  {
      Color background = new Color(9, 97, 146);
      frame = new JFrame();
      back = new JButton("Go Back");
      edit = new ArrayList<JButton>();

      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().setBackground(background);

      // list contacts both payees and recipients
      createInitialButtons();

      frame.setSize(600, 600);
      frame.setLocationRelativeTo(null); //puts frame in center of screen
      frame.setLayout(null); //uses no layout managers
      frame.setVisible(true); //makes the frame visible
    
  }
  
   private void createInitialButtons(ArrayList<Payee> payees, ArrayList<Recipient> recipients)
   {
      int sumSize = payees.size() + recipients.size();
     
      listPayees(payees, payees.size());
      listRecipients(recipients, recipients.size());
        
   }
  
  public void listPayees(ArrayList<Payee> payees, int size)
  {
      int i = 0;
      payeeName = new ArrayList<JTextField>();
      payeeAccNum = new ArrayList<JTextField>();
      //add a back button to the screen
      back.setBounds(440, 40, 100, 30);
      back.addActionListener(new ActionListener() {
        //allows the go back button to bring back to main menu
        @Override
        public void actionPerformed(ActionEvent e)
        {
          frame.dispose();
          MainMenu menu = new MainMenu();
          screen.setChequings(getChequing());
          screen.setContacts(getContacts());
          screen.setCredit(getCredit());
          screen.setSavings(getSavings());
          
        }
      });
      frame.add(back);
      
      //add a Label that says "Payees"
      label = new JLabel("Payee(s)");
      label.setBounds(30, 80, 100, 60);
      frame.add(label);
      while(i < size + 1)
      {
          payeeName(i).add(new JTextField(payees(i).getNickName()));
          payeeName(i).setBounds();
          frame.add(payeeName(i));
          payeeAccNum(i).add(new JTextField(payees(i).getAccountNumber()));
          payeeAccNum(i).setBounds();
          frame.add(payeeAccNum(i));
              
       
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
                  
                  if(selected < payees.size())
                  {
                    payees(selected).setNickName(payeeName(selected));
                    payees(selected).setAccountNumber(payeeAccNum(selected));
                  }
                       
              }
          
          });
    
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
            recipientName(i).add(new JTextField(recipients(i).getName()));
            recipientName(i).setBounds();
            frame.add(recipientName(i));
            recipientEmail(i).add(new JTextField(recipients(i).getEmail()));
            recipientEmail(i).setBounds();
            frame.add(recipientEmail(i));
            if(recipients(i).getPhoneNumber != null)
            {
                String phone = Integer.toString(recipients(i).getPhoneNumber);
                recipientPhone(i).add(new JTextField(phone));
                recipientPhone(i).setBounds();
                frame.add(recipientPhone(i));
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
                      recipients(selected).setName(recipientName(selected));
                      recipients(selected).setEmail(recipientEmail(selected));
                      recipients(selected).setPhone(recipientPhone(selected));
                  }
                
                  
              }
        }
    }
}
