package myproject.calculator;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator implements ActionListener{
    JFrame frame;
    JTextField textfield;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[9];
    JButton addButton, subButton, multiButton, divButton;
    JButton decButton, equalButton, delButton, clrButton, negButton;
    JPanel panel;
        
    Font myFont = new Font("serif", Font.BOLD, 30);
    double num1 = 0, num2 =0, result = 0;
    char operator;
    
    Calculator(){
        frame = new JFrame("Claculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 530);
        frame.setLayout(null);
        frame.setResizable(false);
        
        textfield = new JTextField();
        textfield.setBounds(50,25,300,50);
        textfield.setFont(myFont);
        textfield.setEditable(false);
        
        addButton = new JButton("+");
        subButton =  new JButton("-");
        multiButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equalButton = new JButton("=");
        negButton = new JButton("(-)");
        clrButton = new JButton("clr");
        delButton = new JButton("del");
        
        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = multiButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equalButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = negButton;
        
        for(int i=0; i<9; i++){
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);
        }
        
        for(int i=0; i<10; i++){
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
        }
        
        negButton.setBounds(50,430,100,50);
        delButton.setBounds(150,430,100,50);
        clrButton.setBounds(250,430,100,50);
        
        panel = new JPanel();
        panel.setBounds(50,100,300,300);
        panel.setLayout(new GridLayout(4,4,10,10));
        
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(functionButtons[0]);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(functionButtons[1]);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(functionButtons[2]);
        panel.add(functionButtons[4]);
        panel.add(numberButtons[0]);
        panel.add(functionButtons[5]);
        panel.add(functionButtons[3]);
        
        frame.add(panel);
        frame.add(functionButtons[8]);
        frame.add(functionButtons[6]);
        frame.add(functionButtons[7]);
        frame.add(textfield);
        frame.setVisible(true);
        
    }

    public static void main(String[] args) {
        
        Calculator calci = new Calculator();
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        
        for(int i=0; i<10; i++)
            if(e.getSource() == numberButtons[i])
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
        
        if(e.getSource() == decButton)
            textfield.setText(textfield.getText().concat("."));

        if(e.getSource() == addButton){
            num1 = Double.parseDouble(textfield.getText());
            operator = '+';
            textfield.setText("");
        }
        
        if(e.getSource() == subButton){
            num1 = Double.parseDouble(textfield.getText());
            operator = '-';
            textfield.setText("");
        }
        
        if(e.getSource() == multiButton){
            num1 = Double.parseDouble(textfield.getText());
            operator = '*';
            textfield.setText("");
        }
        
        if(e.getSource() == divButton){
            num1 = Double.parseDouble(textfield.getText());
            operator = '/';
            textfield.setText("");
        }
        
        if(e.getSource() == equalButton){
            num2 = Double.parseDouble(textfield.getText());
            
            switch(operator){
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
            }
            textfield.setText(String.valueOf(result));
            num1 = result;
        }
        
        if(e.getSource() == clrButton){
            num1 = 0;
            operator = '0';
            textfield.setText("");
        }
        
        if(e.getSource() == delButton){
            String temp = textfield.getText();
            String temp1 = "";
            textfield.setText("");
            for(int i=0; i<temp.length()-1; i++)
                temp1 += temp.charAt(i);
            textfield.setText(temp1);
        }
        
        if(e.getSource() == negButton){
            double temp = Double.parseDouble(textfield.getText());
            temp *= -1;
            textfield.setText(String.valueOf(temp));
        }
    }
}