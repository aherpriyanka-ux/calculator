import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleCalculator extends JFrame implements ActionListener {

    JTextField display;
    double num1 = 0, num2 = 0, result = 0;
    String operator = "";

  SimpleCalculator() {

        setTitle("Mobile Calculator");
        setSize(700, 900);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);

        display = new JTextField();
        display.setBounds(20, 30, 320, 80);
        display.setFont(new Font("Segoe UI", Font.BOLD, 32));
        display.setHorizontalAlignment(SwingConstants.RIGHT);
        display.setEditable(false);
        display.setBackground(new Color(25, 25, 25));
        display.setForeground(Color.WHITE);
        display.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(display);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 4, 10, 10));
        panel.setBounds(20, 130, 320, 420);
        panel.setBackground(new Color(25, 25, 25));

        String btns[] = {
            "C", "<-", "%", "/",
            "7", "8", "9", "*",
            "4", "5", "6", "-",
            "1", "2", "3", "+",
            "0", ".", "=", ""
        };

        for (String text : btns) {
            if (text.equals("")) {
                panel.add(new JLabel());
                continue;
            }
            JButton btn = createMobileButton(text);
            panel.add(btn);
        }

        add(panel);
        setVisible(true);
    }

    JButton createMobileButton(String text) {
        JButton btn = new JButton(text);
        btn.setFont(new Font("Segoe UI", Font.BOLD, 22));
        btn.setBackground(new Color(50, 50, 50));
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.setBorder(BorderFactory.createLineBorder(new Color(70, 70, 70)));
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn.addActionListener(this);

        if (text.equals("/") || text.equals("*") || text.equals("-") || text.equals("+") || text.equals("=")) {
            btn.setBackground(new Color(255, 149, 0));
        }
        if (text.equals("C") || text.equals("<-") || text.equals("%")) {
            btn.setBackground(new Color(100, 100, 100));
        }

        return btn;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String btn = e.getActionCommand();

        if (btn.matches("[0-9]") || btn.equals(".")) {
            display.setText(display.getText() + btn);
        }

        else if (btn.equals("C")) {
            display.setText("");
            num1 = num2 = result = 0;
        }

        else if (btn.equals("<-")) {
            String text = display.getText();
            if (!text.isEmpty())
                display.setText(text.substring(0, text.length() - 1));
        }

        else if (btn.equals("%")) {
            try {
                double value = Double.parseDouble(display.getText());
                display.setText(String.valueOf(value / 100));
            } catch (Exception ex) {
                display.setText("Error");
            }
        }

        else if (btn.equals("=")) {
            try {
                num2 = Double.parseDouble(display.getText());
                switch (operator) {
                    case "+": result = num1 + num2; break;
                    case "-": result = num1 - num2; break;
                    case "*": result = num1 * num2; break;
                    case "/": 
                        if (num2 == 0) {
                            JOptionPane.showMessageDialog(this, "Cannot divide by zero!");
                            return;
                        }
                        result = num1 / num2;
                        break;
                }
                display.setText("" + result);
            } catch (Exception ex) {
                display.setText("Error");
            }
        }

        else {
            try {
                num1 = Double.parseDouble(display.getText());
                operator = btn;
                display.setText("");
            } catch (Exception ex) {
                display.setText("");
            }
        }
    }

    public static void main(String[] args) {
        new SimpleCalculator();
    }
}
