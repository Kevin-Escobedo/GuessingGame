package guess;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPanel;

public class GUI extends JFrame implements ActionListener
{
    static JFrame mainFrame;
    static GuessingGame gg;
    static JLabel message;
    static JLabel feedback;
    static JTextField textField;
    static JButton button;

    GUI()
    {

    }

    public static void main(String[] args)
    {
        gg = new GuessingGame(1); //Will change later to have user select difficulty
        mainFrame = new JFrame("Guessing Game");
        message = new JLabel(String.valueOf(gg.tries) + " tries");
        feedback = new JLabel("I'm thinking of a number between 1 and 100");
        button = new JButton("Enter");
        GUI g = new GUI();
        button.addActionListener(g);
        textField = new JTextField(20);
        JPanel p = new JPanel();

        p.add(textField);
        p.add(button);
        p.add(message);
        p.add(feedback);

        mainFrame.add(p);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(300, 300);
        mainFrame.setVisible(true);

    }

    public void actionPerformed(ActionEvent e)
    {
        String s = e.getActionCommand();
        if(s.equals("Enter"))
        {
            int guess = Integer.parseInt(textField.getText());
            int result = gg.compare(guess);
            String status = (gg.tries == 1) ? "1 try" : String.valueOf(gg.tries) + " tries";
            String outcome = (result == 0) ? "You guessed the number!" : (result < 0) ? "Guess higher!" : (result > 0) ? "Guess lower!" : "NULL";
            
            message.setText(status);
            feedback.setText(outcome);
            textField.setText("");
        }
    }
}
