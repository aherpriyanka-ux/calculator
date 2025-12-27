import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Calculator extends JFrame implements ActionListener {

    JLabel label;
    JTextField textField;
    JRadioButton on, off;
    JButton btnzero, btnone, btntwo, btnthree, btnfour, btnfive, btnsix, btnseven, btneight, btnnine,
            btnDot, btnClear, btnDelete, btnEqual, btnMul, btnDiv, btnPlus, btnMinus, btnSquare,
            btnRecipocal, btnSqrt;

    double num1 = 0, num2 = 0, result = 0;
    int calculation;

    Calculator() {

        setLayout(null);
        setTitle("Calculator");

        label = new JLabel("Calculator");
        label.setBounds(250, 0, 50, 50);
        label.setForeground(Color.white);
        add(label);

        textField = new JTextField();
        textField.setBounds(10, 40, 270, 40);
        textField.setFont(new Font("Arial", Font.BOLD, 20));
        textField.setEditable(false);
        textField.setHorizontalAlignment(SwingConstants.RIGHT);
        add(textField);

        // RadioButton
        on = new JRadioButton("ON");
        on.setBounds(10, 95, 60, 40);
        on.setFont(new Font("Arial", Font.BOLD, 14));
        on.setForeground(Color.white);
        on.setBackground(Color.black);
        on.setSelected(true);
        on.setFocusable(false);
        add(on);

        off = new JRadioButton("OFF");
        off.setBounds(10, 120, 60, 40);
        off.setFont(new Font("Arial", Font.BOLD, 14));
        off.setForeground(Color.white);
        off.setBackground(Color.black);
        off.setSelected(false);
        off.setFocusable(false);
        add(off);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(on);
        buttonGroup.add(off);

        // buttons
        btnseven = new JButton("7");
        btnseven.setBounds(10, 230, 60, 40);
        btnseven.setFont(new Font("Arial", Font.BOLD, 20));
        btnseven.setFocusable(false);
        add(btnseven);

        btneight = new JButton("8");
        btneight.setBounds(80, 230, 60, 40);
        btneight.setFont(new Font("Arial", Font.BOLD, 20));
        btneight.setFocusable(false);
        add(btneight);

        btnnine = new JButton("9");
        btnnine.setBounds(150, 230, 60, 40);
        btnnine.setFont(new Font("Arial", Font.BOLD, 20));
        btnnine.setFocusable(false);
        add(btnnine);

        btnfour = new JButton("4");
        btnfour.setBounds(10, 290, 60, 40);
        btnfour.setFont(new Font("Arial", Font.BOLD, 20));
        btnfour.setFocusable(false);
        add(btnfour);

        btnfive = new JButton("5");
        btnfive.setBounds(80, 290, 60, 40);
        btnfive.setFont(new Font("Arial", Font.BOLD, 20));
        btnfive.setFocusable(false);
        add(btnfive);

        btnsix = new JButton("6");
        btnsix.setBounds(150, 290, 60, 40);
        btnsix.setFont(new Font("Arial", Font.BOLD, 20));
        btnsix.setFocusable(false);
        add(btnsix);

        btnone = new JButton("1");
        btnone.setBounds(10, 350, 60, 40);
        btnone.setFont(new Font("Arial", Font.BOLD, 20));
        btnone.setFocusable(false);
        add(btnone);

        btntwo = new JButton("2");
        btntwo.setBounds(80, 350, 60, 40);
        btntwo.setFont(new Font("Arial", Font.BOLD, 20));
        btntwo.setFocusable(false);
        add(btntwo);

        btnthree = new JButton("3");
        btnthree.setBounds(150, 350, 60, 40);
        btnthree.setFont(new Font("Arial", Font.BOLD, 20));
        btnthree.setFocusable(false);
        add(btnthree);

        btnDot = new JButton(".");
        btnDot.setBounds(150, 410, 60, 40);
        btnDot.setFont(new Font("Arial", Font.BOLD, 20));
        btnDot.setFocusable(false);
        add(btnDot);

        btnDiv = new JButton("/");
        btnDiv.setBounds(220, 110, 60, 40);
        btnDiv.setFont(new Font("Arial", Font.BOLD, 20));
        btnDiv.setBackground(new Color(239, 188, 2));
        btnDiv.setFocusable(false);
        add(btnDiv);

        btnzero = new JButton("0");
        btnzero.setBounds(10, 410, 130, 40);
        btnzero.setFont(new Font("Arial", Font.BOLD, 20));
        btnzero.setFocusable(false);
        add(btnzero);

        btnDelete = new JButton("DEL");
        btnDelete.setBounds(150, 110, 60, 40);
        btnDelete.setFont(new Font("Arial", Font.BOLD, 12));
        btnDelete.setFocusable(false);
        btnDelete.setBackground(Color.red);
        btnDelete.setForeground(Color.white);
        add(btnDelete);

        btnEqual = new JButton("=");
        btnEqual.setBounds(220, 350, 60, 100);
        btnEqual.setFont(new Font("Arial", Font.BOLD, 20));
        btnEqual.setFocusable(false);
        btnEqual.setBackground(new Color(239, 188, 2));
        add(btnEqual);

        btnSqrt = new JButton("\u221A");
        btnSqrt.setBounds(10, 170, 60, 40);
        btnSqrt.setFont(new Font("Arial", Font.BOLD, 20));
        btnSqrt.setFocusable(false);
        add(btnSqrt);

        btnMul = new JButton("X");
        btnMul.setBounds(220, 230, 60, 40);
        btnMul.setFont(new Font("Arial", Font.BOLD, 20));
        btnMul.setBackground(new Color(239, 188, 2));
        btnMul.setFocusable(false);
        add(btnMul);

        btnMinus = new JButton("-");
        btnMinus.setBounds(220, 170, 60, 40);
        btnMinus.setFont(new Font("Arial", Font.BOLD, 20));
        btnMinus.setBackground(new Color(239, 188, 2));
        btnMinus.setFocusable(false);
        add(btnMinus);

        btnPlus = new JButton("+");
        btnPlus.setBounds(220, 290, 60, 40);
        btnPlus.setFont(new Font("Arial", Font.BOLD, 20));
        btnPlus.setBackground(new Color(239, 188, 2));
        btnPlus.setFocusable(false);
        add(btnPlus);

        btnSquare = new JButton("x\u00B2");
        btnSquare.setBounds(80, 170, 60, 40);
        btnSquare.setFont(new Font("Arial", Font.BOLD, 20));
        btnSquare.setFocusable(false);
        add(btnSquare);

        btnRecipocal = new JButton("1/x");
        btnRecipocal.setBounds(150, 170, 60, 40);
        btnRecipocal.setFont(new Font("Arial", Font.BOLD, 15));
        btnRecipocal.setFocusable(false);
        add(btnRecipocal);

        btnClear = new JButton("C");
        btnClear.setBounds(80, 110, 60, 40);
        btnClear.setFont(new Font("Arial", Font.BOLD, 15));
        btnClear.setBackground(Color.red);
        btnClear.setForeground(Color.white);
        btnClear.setFocusable(false);
        add(btnClear);

        addActionEvent(); // events

        setSize(305, 510);
        getContentPane().setBackground(Color.black);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void addActionEvent() {
        on.addActionListener(this);
        off.addActionListener(this);
        btnzero.addActionListener(this);
        btnone.addActionListener(this);
        btntwo.addActionListener(this);
        btnthree.addActionListener(this);
        btnfour.addActionListener(this);
        btnfive.addActionListener(this);
        btnsix.addActionListener(this);
        btnseven.addActionListener(this);
        btneight.addActionListener(this);
        btnnine.addActionListener(this);
        btnDot.addActionListener(this);
        btnClear.addActionListener(this);
        btnDelete.addActionListener(this);
        btnEqual.addActionListener(this);
        btnMul.addActionListener(this);
        btnDiv.addActionListener(this);
        btnPlus.addActionListener(this);
        btnMinus.addActionListener(this);
        btnSquare.addActionListener(this);
        btnRecipocal.addActionListener(this);
        btnSqrt.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object source = e.getSource();

        if (source == on) {
            enable();
        } else if (source == off) {
            disable();
        } else if (source == btnClear) {
            label.setText("");
            textField.setText("");
        } else if (source == btnDelete) {
            int length = textField.getText().length();
            int number = length - 1;
            if (length > 0) {
                StringBuilder back = new StringBuilder(textField.getText());
                back.deleteCharAt(number);
                textField.setText(back.toString());
            }
            if (textField.getText().equals("")) {
                label.setText("");
            }
        } else if (source == btnzero) {
            if (textField.getText().equals("0")) {
                return;
            } else {
                textField.setText(textField.getText() + "0");
            }
        } else if (source == btnone) {
            textField.setText(textField.getText() + "1");
        } else if (source == btntwo) {
            textField.setText(textField.getText() + "2");
        } else if (source == btnthree) {
            textField.setText(textField.getText() + "3");
        } else if (source == btnfour) {
            textField.setText(textField.getText() + "4");
        } else if (source == btnfive) {
            textField.setText(textField.getText() + "5");
        } else if (source == btnsix) {
            textField.setText(textField.getText() + "6");
        } else if (source == btnseven) {
            textField.setText(textField.getText() + "7");
        } else if (source == btneight) {
            textField.setText(textField.getText() + "8");
        } else if (source == btnnine) {
            textField.setText(textField.getText() + "9");
        } else if (source == btnDot) {
            if (textField.getText().contains(".")) {
                return;
            } else {
                textField.setText(textField.getText() + ".");
            }
        } else if (source == btnPlus) {
            String str = textField.getText();
            num1 = Double.parseDouble(textField.getText());
            calculation = 1;
            textField.setText("");
            label.setText(str + "+");
        } else if (source == btnMinus) {
            String str = textField.getText();
            num1 = Double.parseDouble(textField.getText());
            calculation = 2;
            textField.setText("");
            label.setText(str + "-");
        } else if (source == btnMul) {
            String str = textField.getText();
            num1 = Double.parseDouble(textField.getText());
            calculation = 3;
            textField.setText("");
            label.setText(str + "X");
        } else if (source == btnDiv) {
            String str = textField.getText();
            num1 = Double.parseDouble(textField.getText());
            calculation = 4;
            textField.setText("");
            label.setText(str + "/");
        } else if (source == btnSquare) {
            num1 = Double.parseDouble(textField.getText());
            double square = Math.pow(num1, 2);
            String string = Double.toString(square);
            if (string.endsWith(".0")) {
                textField.setText(string.replace(".0", ""));
            } else {
                textField.setText(string);
            }
        } else if (source == btnSqrt) {
            num1 = Double.parseDouble(textField.getText());
            double sqrt = Math.sqrt(num1);
            String string = Double.toString(sqrt);
            if (string.endsWith(".0")) {
                textField.setText(string.replace(".0", ""));
            } else {
                textField.setText(string);
            }
        } else if (source == btnRecipocal) {
            num1 = Double.parseDouble(textField.getText());
            double recipocal = 1 / num1;
            String string = Double.toString(recipocal);
            if (string.endsWith(".0")) {
                textField.setText(string.replace(".0", ""));
            } else {
                textField.setText(string);
            }
        } else if (source == btnEqual) {
            num2 = Double.parseDouble(textField.getText());
            switch (calculation) {
                case 1:
                    result = num1 + num2;
                    break;
                case 2:
                    result = num1 - num2;
                    break;
                case 3:
                    result = num1 * num2;
                    break;
                case 4:
                    result = num1 / num2;
                    break;
            }
            String string = Double.toString(result);
            if (string.endsWith(".0")) {
                textField.setText(string.replace(".0", ""));
            } else {
                textField.setText(string);
            }
            label.setText("");
            num1 = result;
        }
    }

    public void enable() {
        on.setEnabled(false);
        off.setEnabled(true);
        textField.setEnabled(true);
        label.setEnabled(true);
        btnClear.setEnabled(true);
        btnzero.setEnabled(true);
        btnone.setEnabled(true);
        btntwo.setEnabled(true);
        btnthree.setEnabled(true);
        btnfour.setEnabled(true);
        btnfive.setEnabled(true);
        btnsix.setEnabled(true);
        btnseven.setEnabled(true);
        btneight.setEnabled(true);
        btnnine.setEnabled(true);
        btnDot.setEnabled(true);
        btnDelete.setEnabled(true);
        btnEqual.setEnabled(true);
        btnMul.setEnabled(true);
        btnDiv.setEnabled(true);
        btnPlus.setEnabled(true);
        btnMinus.setEnabled(true);
        btnSquare.setEnabled(true);
        btnRecipocal.setEnabled(true);
        btnSqrt.setEnabled(true);
    }

    public void disable() {
        on.setEnabled(true);
        off.setEnabled(false);
        textField.setEnabled(false);
        label.setEnabled(false);
        btnClear.setEnabled(false);
        btnzero.setEnabled(false);
        btnone.setEnabled(false);
        btntwo.setEnabled(false);
        btnthree.setEnabled(false);
        btnfour.setEnabled(false);
        btnfive.setEnabled(false);
        btnsix.setEnabled(false);
        btnseven.setEnabled(false);
        btneight.setEnabled(false);
        btnnine.setEnabled(false);
        btnDot.setEnabled(false);
        btnDelete.setEnabled(false);
        btnEqual.setEnabled(false);
        btnMul.setEnabled(false);
        btnDiv.setEnabled(false);
        btnPlus.setEnabled(false);
        btnMinus.setEnabled(false);
        btnSquare.setEnabled(false);
        btnRecipocal.setEnabled(false);
        btnSqrt.setEnabled(false);
    }

    public static void main(String args[]) {
        new Calculator();
    }
}
