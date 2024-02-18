import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ATMInterface extends JFrame {

    private double balance;

    private JTextField amountField;
    private JTextArea transactionArea;

    public ATMInterface() {
        // Set up the JFrame
        setTitle("ATM Interface");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Initialize balance
        balance = 1000.0;

        // Create components
        JLabel balanceLabel = new JLabel("Current Balance: ₹" + balance);
        JLabel amountLabel = new JLabel("Enter Amount:");
        amountField = new JTextField(10);
        JButton withdrawButton = new JButton("Withdraw");
        JButton depositButton = new JButton("Deposit");
        transactionArea = new JTextArea(10, 30);
        JScrollPane scrollPane = new JScrollPane(transactionArea);

        // Add ActionListener to the withdrawButton
        withdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performWithdraw();
            }
        });

        // Add ActionListener to the depositButton
        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performDeposit();
            }
        });

        // Set up the layout
        setLayout(new BorderLayout());
        JPanel topPanel = new JPanel(new FlowLayout());
        topPanel.add(balanceLabel);
        add(topPanel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        centerPanel.add(amountLabel);
        centerPanel.add(amountField);
        centerPanel.add(withdrawButton);
        centerPanel.add(depositButton);
        add(centerPanel, BorderLayout.CENTER);

        add(scrollPane, BorderLayout.SOUTH);
    }

    private void performWithdraw() {
        try {
            double amount = Double.parseDouble(amountField.getText());
            if (amount > 0 && amount <= balance) {
                balance -= amount;
                updateBalanceLabel();
                appendTransaction("Withdraw: -₹" + amount);
            } else {
                JOptionPane.showMessageDialog(this, "Invalid withdrawal amount or insufficient funds.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid input. Please enter a valid amount.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void performDeposit() {
        try {
            double amount = Double.parseDouble(amountField.getText());
            if (amount > 0) {
                balance += amount;
                updateBalanceLabel();
                appendTransaction("Deposit: +₹" + amount);
            } else {
                JOptionPane.showMessageDialog(this, "Invalid deposit amount.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid input. Please enter a valid amount.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateBalanceLabel() {
        // Update the balance label with the new balance
        ((JLabel) ((JPanel) getContentPane().getComponent(0)).getComponent(0)).setText("Current Balance: ₹" + balance);
    }

    private void appendTransaction(String transaction) {
        // Append the transaction to the transaction area
        transactionArea.append(transaction + "\n");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ATMInterface().setVisible(true);
            }
        });
    }
}

