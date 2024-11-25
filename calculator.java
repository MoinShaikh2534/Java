import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MethodsOfCalculator implements ActionListener {
    JFrame f;
    JTextField tx1;
    JButton[] numButtons = new JButton[10]; 
    JButton bAdd, bSub, bMul, bDiv, bDec, bEqual, bClear;
    String operator;
    double num1, num2, result;

    MethodsOfCalculator() {
        f = new JFrame("System-like Calculator");
        f.setLayout(new BorderLayout());

        tx1 = new JTextField();
        tx1.setHorizontalAlignment(JTextField.RIGHT); 
        tx1.setFont(new Font("Arial", Font.PLAIN, 34));
        f.add(tx1, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4, 6, 6)); 

        for (int i = 0; i < 10; i++) {
            numButtons[i] = new JButton(String.valueOf(i));
            numButtons[i].setFont(new Font("Arial", Font.BOLD, 18));
            numButtons[i].addActionListener(this);
        }

        bAdd = new JButton("+");
        bSub = new JButton("-");
        bMul = new JButton("*");
        bDiv = new JButton("/");
        bDec = new JButton(".");
        bEqual = new JButton("=");
        bClear = new JButton("AC");

        JButton[] opButtons = {bAdd, bSub, bMul, bDiv, bDec, bEqual, bClear};
        for (JButton btn : opButtons) {
            btn.setFont(new Font("Arial", Font.BOLD, 18));
            btn.addActionListener(this);
        }

        panel.add(numButtons[7]);
        panel.add(numButtons[8]);
        panel.add(numButtons[9]);
        panel.add(bAdd);

        panel.add(numButtons[4]);
        panel.add(numButtons[5]);
        panel.add(numButtons[6]);
        panel.add(bSub);

        panel.add(numButtons[1]);
        panel.add(numButtons[2]);
        panel.add(numButtons[3]);
        panel.add(bMul);

        panel.add(bDec);
        panel.add(numButtons[0]);
        panel.add(bEqual);
        panel.add(bDiv);

        f.add(panel, BorderLayout.CENTER); 

        f.add(bClear, BorderLayout.SOUTH);

        f.setSize(350, 400);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numButtons[i]) {
                tx1.setText(tx1.getText() + i);
            }
        }
        if (e.getSource() == bDec) {
            tx1.setText(tx1.getText() + ".");
        }

        if (e.getSource() == bAdd || e.getSource() == bSub || 
            e.getSource() == bMul || e.getSource() == bDiv) {
            try {
                num1 = Double.parseDouble(tx1.getText());
                operator = ((JButton) e.getSource()).getText();
                tx1.setText(""); 
            } catch (NumberFormatException ex) {
                tx1.setText("Error");
            }
        }

        if (e.getSource() == bEqual) {
            try {
                num2 = Double.parseDouble(tx1.getText());
                switch (operator) {
                    case "+":
                        result = num1 + num2;
                        break;
                    case "-":
                        result = num1 - num2;
                        break;
                    case "*":
                        result = num1 * num2;
                        break;
                    case "/":
                        result = num1 / num2;
                        break;
                }
                tx1.setText(String.valueOf(result)); 
            } catch (Exception ex) {
                tx1.setText("Error");
            }
        }

        if (e.getSource() == bClear) {
            tx1.setText(""); 
        }
    } 
}

public class calculator {
    public static void main(String[] args) {
        new MethodsOfCalculator(); 
    }
}