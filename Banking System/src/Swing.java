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

    private JFrame frame; //The actual screen frame
    private JButton Login; //Button for Login
    private JButton ForgotPassword; //Button for Forgot Password
    private JTextField userName; //A text field to input username
    private JTextField pass; //A text field to input password
    private boolean loginPressed; //check if pressed
    private boolean forgotPressed; //check if pressed
    private String userInput; //Hold username
    private String passInput; //Hold password

    public Swing()
    {
        loginPressed = false;
        forgotPressed = false;
        Color background = new Color(9, 97, 146); //professional blue
        Login = new JButton("Login");
        ForgotPassword = new JButton("Forgot Password");
        frame = new JFrame();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(background);//set background Color

        createInitialButtons();
        createInitialTextInputBoxes();

        frame.setSize(600, 600);
        frame.setLocationRelativeTo(null); //puts frame in center of screen
        frame.setLayout(null); //uses no layout managers
        frame.setVisible(true); //makes the frame visible
    }

    /*
     * This function creates the initial Login page layout for the Banking system,
     * filled with a login button, forgot password button, and two text boxes to
     * input the username and password of the client
     */
    private void createInitialButtons()
    {
        Login.setBounds(200, 400, 200, 40); //x axis, y axis, width, height
        ForgotPassword.setBounds(200, 460, 200, 40); //x axis, y axis, width, height

        Login.addActionListener(new ActionListener() {
            //allows the clicking of Login button to perform events
            @Override
            public void actionPerformed(ActionEvent e)
            {
                setLoginPressed();
                userInput = userName.getText();
                passInput = pass.getText();
            }
        });

        ForgotPassword.addActionListener(new ActionListener() {
            //allows the clicking of Forgot Password button to perform events
            @Override
            public void actionPerformed(ActionEvent e)
            {
                setForgotPressed();
            }
        });

        frame.add(Login);
        frame.add(ForgotPassword);
    }

    private void createInitialTextInputBoxes()
    {
        userName = new JTextField("Username");
        pass = new JTextField("Password");

        pass.setBounds(150, 300, 300, 40); //x, y, width, height
        userName.setBounds(150, 240, 300, 40); //x, y, width, height

        userName.addFocusListener(new FocusListener() {
            //If focus is gained (clicked textbox) perform actions
            @Override
            public void focusGained(FocusEvent e)
            {
                 if(userName.getText().equals("Username"))
                 {
                     userName.setText("");
                 }
            }

            //if focus is lost (clicked away) perform actions
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
            //if focus is gained (clicked textbox) perform actions
            @Override
            public void focusGained(FocusEvent e)
            {
                if(pass.getText().equals("Password"))
                {
                    pass.setText("");
                }
            }

            //if focus is lost (clicked away) perform actions
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

    private void setLoginPressed()
    {
        this.loginPressed = true;
    }

    private void setForgotPressed()
    {
        this.forgotPressed = true;
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
