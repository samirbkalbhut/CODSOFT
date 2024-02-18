import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentGradeCalculator extends JFrame {
   
    private JTextField Subject1Field, Subject2Field, Subject3Field, Subject4Field, Subject5Field;
    private JLabel resultLabel;

    public StudentGradeCalculator() {
        setTitle("Student Grade Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(690, 300);
        setLocationRelativeTo(null);

        initUI();
    }

    private void initUI() {
        setLayout(new GridLayout(8, 10));    
       
        JLabel Subject1Label = new JLabel(" Subject 1:");
        Subject1Field = new JTextField();

        JLabel Subject2Label = new JLabel(" Subject 2:");
        Subject2Field = new JTextField();

        JLabel Subject3Label = new JLabel(" Subject 3:");
        Subject3Field = new JTextField();  

        JLabel Subject4Label = new JLabel(" Subject 4:");
        Subject4Field = new JTextField();

        JLabel Subject5Label = new JLabel(" Subject 5:");
        Subject5Field = new JTextField();

        

        JButton calculateButton = new JButton("Calculate Grade");
        resultLabel = new JLabel("");

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateGrade();
            }
        });

        add(Subject1Label);
        add(Subject1Field);
        add(Subject2Label);
        add(Subject2Field);
        add(Subject3Label);
        add(Subject3Field);
        add(Subject4Label);
        add(Subject4Field);
        add(Subject5Label);
        add(Subject5Field);
        add(new JLabel()); // Empty label for spacing
        add(calculateButton);
        add(new JLabel()); // Empty label for spacing
        add(resultLabel);
    }

    private void calculateGrade() {
        try {
            double Subject1 = Double.parseDouble(Subject1Field.getText());
            double Subject2 = Double.parseDouble(Subject2Field.getText());
            double Subject3 = Double.parseDouble(Subject3Field.getText());
            double Subject4 = Double.parseDouble(Subject4Field.getText());
            double Subject5 = Double.parseDouble(Subject5Field.getText());
            

            double totalMarks =  Subject1 +  Subject2 +  Subject3 +  Subject4 +  Subject5;
            double averagePercentage = totalMarks / 5;

            String grade;

            if (averagePercentage >= 90) {
                grade = "A";
            } else if (averagePercentage >= 70) {
                grade = "B";
            } else if (averagePercentage >= 50) {
                grade = "C";
            } else if (averagePercentage >= 35) {
                grade = "D";
            } else {
                grade = "F";
            }

            resultLabel.setText("Total Marks: " + totalMarks +
                    "   Average Percentage: " + averagePercentage + "%" +
                    "   Grade: " + grade);
        } catch (NumberFormatException ex) {
            resultLabel.setText("Please enter valid numeric values.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run()  {
                new StudentGradeCalculator().setVisible(true);
            }
        });
    }
}
