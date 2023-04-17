package controllers;

import operations.Function;
import polynomial.Polynom;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class PolynomialCalculator extends JFrame  {
    private JTextField polynomial1Field, polynomial2Field, resultField;
    private JButton addButton, subtractButton, multiplyButton, divideButton, derivativeButton, integralButton;

    public PolynomialCalculator() {
        // Set up the frame
        setTitle("Polynomial Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setSize(550, 400);
        //setBackground(Color.decode("#61b0f3"));
        setBackground(Color.red);

        // Set up the text fields
        polynomial1Field = new JTextField(20);
        polynomial2Field = new JTextField(20);
        resultField = new JTextField(20);
        resultField.setEditable(false);
        polynomial2Field.setBackground(Color.decode("#ace5af"));
        polynomial1Field.setBackground(Color.decode("#ace5af"));
        resultField.setBackground(Color.decode("#aceae8"));

        // Set up the buttons
        addButton = new JButton("Add");
        subtractButton = new JButton("Subtract");
        multiplyButton = new JButton("Multiply");
        divideButton = new JButton("Divide");
        derivativeButton = new JButton("Derivative");
        integralButton = new JButton("Integral");

        addButton.setBackground(Color.decode("#fec2e8"));
        subtractButton.setBackground(Color.decode("#fec2e8"));
        multiplyButton.setBackground(Color.decode("#fec2e8"));
        divideButton.setBackground(Color.decode("#fec2e8"));
        derivativeButton.setBackground(Color.decode("#fec2e8"));
        integralButton.setBackground(Color.decode("#fec2e8"));

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String polynomial1 = polynomial1Field.getText();
                String polynomial2 = polynomial2Field.getText();

                Polynom p1=new Polynom(polynomial1);
                Polynom p2=new Polynom(polynomial2);

                Function.add(p1,p2);
                String p=p1.convertPolynom(p1);
                resultField.setText(p);
            }
        });

        subtractButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String polynomial1 = polynomial1Field.getText();
                String polynomial2 = polynomial2Field.getText();

                Polynom p1=new Polynom(polynomial1);
                Polynom p2=new Polynom(polynomial2);

                Function.subtract(p1,p2);
                String p=p1.convertPolynom(p1);
                resultField.setText(p);
            }
        });

        divideButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });

        multiplyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String polynomial1=polynomial1Field.getText();
                String polynomial2=polynomial2Field.getText();

                Polynom p1=new Polynom(polynomial1);
                Polynom p2=new Polynom(polynomial2);

                String result=p1.convertPolynom(Function.multiplication(p1,p2));
                resultField.setText(result);
            }
        });

        derivativeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String polynomial=polynomial1Field.getText();

                Polynom p=new Polynom(polynomial);

                String result=p.convertPolynom(Function.derivation(p));
                resultField.setText(result);
            }
        });

        integralButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });



        // Set up the panels
        JPanel inputPanel = new JPanel(new GridLayout(3, 2));
        inputPanel.add(new JLabel("Polynomial 1:"));
        inputPanel.add(polynomial1Field);
        inputPanel.add(new JLabel("Polynomial 2:"));
        inputPanel.add(polynomial2Field);
        inputPanel.add(new JLabel("Result:"));
        inputPanel.add(resultField);
        inputPanel.setBackground(Color.decode("#acb0f3"));


        JPanel buttonPanel = new JPanel(new GridLayout(2, 3));
        buttonPanel.add(addButton);
        buttonPanel.add(subtractButton);
        buttonPanel.add(multiplyButton);
        buttonPanel.add(divideButton);
        buttonPanel.add(derivativeButton);
        buttonPanel.add(integralButton);
        buttonPanel.setBackground(Color.decode("#acb0d0"));
        // Add the panels to the frame
        add(inputPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // Display the frame
        setVisible(true);
    }



}
