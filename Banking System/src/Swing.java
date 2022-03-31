import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Swing implements ActionListener{
    public Swing()
    {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        JButton button = new JButton("Login");
        JLabel label = new JLabel("Number of Clicks: 0");

        button.addActionListener();

        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0 , 1));
        panel.add(button);
        panel.add(label);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Banking System");
        frame.pack();
        frame.setVisible(true);
    }
}
