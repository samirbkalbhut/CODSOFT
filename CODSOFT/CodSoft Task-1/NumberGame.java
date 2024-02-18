import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NumberGame extends JFrame {

    private int randomNumber;
    private JTextField guessField;
    private JLabel resultLabel;

    public NumberGame() {
        // Set up the JFrame
        setTitle("Number Guessing Game");
        setSize(400, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Generate a random number between 1 and 100
        randomNumber = (int) (Math.random() * 100) + 1;

        // Create components
        JLabel titleLabel = new JLabel("Guess the number between 1 - 100:");
        guessField = new JTextField(10);
        JButton guessButton = new JButton("Guess");
        resultLabel = new JLabel("");

        // Add ActionListener to the guessButton
        guessButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkGuess();
            }
        });

        // Set up the layout
        setLayout(new FlowLayout());
        add(titleLabel);
        add(guessField);
        add(guessButton);
        add(resultLabel);
    }

    private void checkGuess() {
        try {
            // Get the user's guess
            int userGuess = Integer.parseInt(guessField.getText());

            // Compare the guess with the random number
            if (userGuess == randomNumber) {
                resultLabel.setText("Congratulations! You guessed the correct number.");
            } else if (userGuess < randomNumber) {
                resultLabel.setText("Too low! Try again.");
            } else {
                resultLabel.setText("Too high! Try again.");
            }
        } catch (NumberFormatException ex) {
            resultLabel.setText("Invalid input. Please enter a number.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new NumberGame().setVisible(true);
            }
        });
    }
}

