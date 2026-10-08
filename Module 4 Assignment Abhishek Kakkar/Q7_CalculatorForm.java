import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Q7_CalculatorForm extends JFrame implements ActionListener {
    private JTextField firstNumber;
    private JTextField secondNumber;
    private JTextField result;

    public Q7_CalculatorForm() {
        setTitle("Simple Calculator");
        setLayout(new FlowLayout());

        firstNumber = new JTextField(10);
        secondNumber = new JTextField(10);
        result = new JTextField(10);
        result.setEditable(false);

        JButton addButton = new JButton("+");
        JButton subtractButton = new JButton("-");
        JButton multiplyButton = new JButton("*");
        JButton divideButton = new JButton("/");

        add(new JLabel("First Number:"));
        add(firstNumber);

        add(new JLabel("Second Number:"));
        add(secondNumber);

        add(addButton);
        add(subtractButton);
        add(multiplyButton);
        add(divideButton);

        add(new JLabel("Result:"));
        add(result);

        addButton.addActionListener(this);
        subtractButton.addActionListener(this);
        multiplyButton.addActionListener(this);
        divideButton.addActionListener(this);

        setSize(350, 220);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            double a = Double.parseDouble(firstNumber.getText());
            double b = Double.parseDouble(secondNumber.getText());
            double answer;

            switch (e.getActionCommand()) {
                case "+":
                    answer = a + b;
                    break;
                case "-":
                    answer = a - b;
                    break;
                case "*":
                    answer = a * b;
                    break;
                case "/":
                    if (b == 0) {
                        JOptionPane.showMessageDialog(this,
                                "Division by zero is not allowed.");
                        return;
                    }
                    answer = a / b;
                    break;
                default:
                    return;
            }

            result.setText(String.valueOf(answer));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "Please enter valid numbers.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Q7_CalculatorForm::new);
    }
}
