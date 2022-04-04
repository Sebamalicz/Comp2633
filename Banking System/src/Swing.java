import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/*
 *
 */
public class Swing {

    private JFrame frame;
    private JLabel label;
    private JButton Login;
    private JButton ForgotPassword;
    private JTextField userName;
    private JTextField pass;
    private boolean loginPressed;
    private boolean forgotPressed;
    private String userInput;
    private String passInput;

    public Swing()
    {
        loginPressed = false;
        forgotPressed = false;
        Color background = new Color(9, 97, 146);
        Login = new JButton("Login");
        ForgotPassword = new JButton("Forgot Password");
        frame = new JFrame();
        label = new JLabel();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(background);
        label.setOpaque(true);
        label.setSize(350,270);
        label.setLocation(150,150);
        label.setBackground(Color.white);
        frame.add(label);

        createInitialButtons();
        createInitialTextInputBoxes();

        frame.setSize(600, 600);
        frame.setLocationRelativeTo(null); //puts frame in center of screen
        frame.setLayout(null); //uses no layout managers
        frame.setVisible(true); //makes the frame visible
        if(frame.isBackgroundSet())
        {
            System.out.println("ok");
        }
    }

    private void createInitialButtons()
    {
        Login.setBounds(200, 400, 200, 40); //x axis, y axis, width, height
        ForgotPassword.setBounds(200, 460, 200, 40);
        Login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                setLoginPressed();
                userInput = userName.getText();
                passInput = pass.getText();
            }
        });
        ForgotPassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                setForgotPressed();
            }
        });
        frame.add(Login);
        frame.add(ForgotPassword);
    }

    private void setLoginPressed()
    {
        this.loginPressed = true;
    }

    private void setForgotPressed()
    {
        this.forgotPressed = true;
    }
    private void createInitialTextInputBoxes()
    {
        userName = new JTextField("Username");
        pass = new JTextField("Password");

        pass.setBounds(150, 300, 300, 40);
        userName.setBounds(150, 240, 300, 40);

        userName.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e)
            {
                 if(userName.getText().equals("Username"))
                 {
                     userName.setText("");
                 }
            }

            @Override
            public void focusLost(FocusEvent e)
            {
                if(userName.getText().equals(""))
                {
                    userName.setText("Username");
                }
            }
        });
        pass.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e)
            {
                if(pass.getText().equals("Password"))
                {
                    pass.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e)
            {
                if(pass.getText().equals(""))
                {
                    pass.setText("Password");
                }
            }
        });
        frame.add(userName);
        frame.add(pass);
    }

    public String getUserText()
    {
        return this.userInput;
    }

    public String getPassText()
    {
        return this.passInput;
    }

    public boolean getLoginPressed()
    {
        return this.loginPressed;
    }

    public boolean getForgetPressed()
    {
        return this.forgotPressed;
    }
}
