package guess;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class GUI
{
    static JFrame mainFrame;
    static GuessingGame gg;
    static JLabel message;

    public static void main(String[] args)
    {
        gg = new GuessingGame(2); //Will change to have the user select the difficulty
        mainFrame = new JFrame("Guessing Game");
        message = new JLabel(String.valueOf(gg.tries) + " tries", JLabel.CENTER);  
        mainFrame.add(message);

        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(300, 300);
        mainFrame.setVisible(true);

    } 
}
