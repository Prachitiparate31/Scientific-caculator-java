import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ScientificCalculator extends JFrame implements ActionListener {
    // GUI components
    private JTextField display;
    private JButton[] numberButtons = new JButton[10];
    private JButton[] operatorButtons = new JButton[10];
    private JButton sinButton, cosButton, tanButton, expButton, logButton, sqrtButton;

    // Calculator logic
    private double number1, number2, result;
    private char operation;

    public ScientificCalculator() {
        // Initialize GUI components
        display = new JTextField(20);
        display.setEditable(false);

        // Create number buttons
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
        }

        // Create operator buttons
        String[] operators = {"+", "-", "*", "/", "^", "sin", "cos", "tan", "exp", "log", "sqrt"};
        for (int i = 0; i < operators.length; i++) {
            operatorButtons[i] = new JButton(operators[i]);
            operatorButtons[i].addActionListener(this);
        }

        // Create trigonometric function buttons
        sinButton = new JButton("sin");
        cosButton = new JButton("cos");
        tanButton = new JButton("tan");
        sinButton.addActionListener(this);
        cosButton.addActionListener(this);
        tanButton.addActionListener(this);

        // Create exponential function buttons
        expButton = new JButton("exp");
        logButton = new JButton("log");
        sqrtButton = new JButton("sqrt");
        expButton.addActionListener(this);
        logButton.addActionListener(this);
        sqrtButton.addActionListener(this);

        // Set up GUI layout
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 4));
        panel.add(display);

        for (int i = 0; i < 10; i++) {
            panel.add(numberButtons[i]);
        }

        for (int i = 0; i < operators.length; i++) {
            panel.add(operatorButtons[i]);
        }

        panel.add(sinButton);
        panel.add(cosButton);
        panel.add(tanButton);
        panel.add(expButton);
        panel.add(logButton);
        panel.add(sqrtButton);

        add(panel, BorderLayout.CENTER);

        // Set up calculator logic
        number1 = 0;
        number2 = 0;
        result = 0;
        operation = ' ';
    }

    public void actionPerformed(ActionEvent e) {
        // Handle number button clicks
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                display.setText(display.getText() + i);
            }
        }

        // Handle operator button clicks
        for (int i = 0; i < operatorButtons.length; i++) {
            if (e.getSource() == operatorButtons[i]) {
                number1 = Double.parseDouble(display.getText());
                operation = operatorButtons[i].getText().charAt(0);
                display.setText("");
            }
        }

        // Handle trigonometric function button clicks
        if (e.getSource() == sinButton) {
            number1 = Double.parseDouble(display.getText());
            result = Math.sin(Math.toRadians(number1));
            display.setText(String.valueOf(result));
        } else if (e.getSource() == cosButton) {
            number1 = Double.parseDouble(display.getText());
            result = Math.cos(Math.toRadians(number1));
            display.setText(String.valueOf(result));
        } else if (e.getSource() == tanButton) {
            number1 = Double.parseDouble(display.getText());
            result = Math.tan(Math.toRadians(number1));
            display.setText(String.valueOf(result));
        }

        // Handle exponential function button clicks
        if (e.getSource() == expButton) {
            number1 = Double.parseDouble(display.getText());
            result = Math.exp(number1);
            display.setText(String.valueOf(result));
        } else if (e.getSource() == logButton) {
            number1 = Double.parseDouble(display.getText());
            result = Math.log(number1);
            display.setText(String.valueOf(result));
        } else if (e.getSource() == sqrtButton) {
            number1 = Double.parseDouble(display.getText());
            result = Math.sqrt(number1);
            display.setText(String.valueOf(result));
        }

        // Handle equals button click
        if (e.getSource() == operatorButtons[9]) {
            number2 = Double.parseDouble(display.getText());
            switch (operation) {
                case '+':
                    result = number1 + number2;
                    break;
                case '-':
                    result = number1 - number2;
                    break;
                case '*':