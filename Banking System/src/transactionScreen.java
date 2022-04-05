import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class transactionScreen {
    private Savings saving;
    private Chequing chequing;
    private Credit credit;
    private JFrame frame;
    private JTextArea text;
    private Color backgounrd;


    public transactionScreen(Savings saving)
    {
        this.saving = saving;
    }

    public transactionScreen(Chequing chequing)
    {
        this.chequing = chequing;
    }

    public transactionScreen(Credit credit)
    {
        this.credit = credit;

    }
}
