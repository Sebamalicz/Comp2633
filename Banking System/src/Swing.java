import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

/*
 *
 */
public class Swing {

    private JFrame frame;
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
        Color background = new Color(103, 146, 103);
        Login = new JButton("Login");
        ForgotPassword = new JButton("Forgot Password");
        frame = new JFrame();

        createInitialButtons();
        createInitialTextInputBoxes();

        frame.setSize(600, 600);
        frame.setBackground(background);
        frame.setLocationRelativeTo(null); //puts frame in center of screen
        frame.setLayout(null); //uses no layout managers
        frame.setVisible(true); //makes the frame visible
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
               /* System.out.println(userInput);
                System.out.println(passInput);
                if(getLoginPressed())
                {
                    System.out.println("True");
                }*/
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
