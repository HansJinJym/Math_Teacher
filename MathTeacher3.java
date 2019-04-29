package Coursework;

//import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * Title      : MathTeacher3.java
 * Description: This class contains the MathTeacher with all the extension.
 * Copyright  : Copyright (c) 2018
 * @author  Jin Yuanming
 * @version 1.0
 */

public class MathTeacher3 extends JFrame {
	private JPanel inputPanel,QuestionPanel,BtnPanel,AnsPanel,NumPanel,ScorePanel;
	private JButton Press;
	private JTextField inputField;
	private JLabel Question,Answer,Score;
	private int x,y,ans;					//Generate the number of the question
	private char o;						//Generate the operator
	private int correct = 0,total = 0;
	private JButton btn7,btn8,btn9;
	private JButton btn4,btn5,btn6;
	private JButton btn1,btn2,btn3;
	private JButton btn0,clear,minus;
	
	public void GenerateQuestion() {
	//Question generator
			switch((int)(Math.random()*4)) {      //Make four kinds of algorithm happen 
			case 0:x = (int)(Math.random()*10)+1; //with equal probability
				   y = (int)(Math.random()*10)+1;
				   o='+';
				   ans=x+y;
				   break;
			case 1:x = (int)(Math.random()*10)+1;
				   y = (int)(Math.random()*10)+1;
				   o='-';
				   ans=x-y;
				   break;
			case 2:x = (int)(Math.random()*10)+1;
				   y = (int)(Math.random()*10)+1;
				   o='*';
				   ans=x*y;
				   break;
			case 3:while(true) {
				   x = (int)(Math.random()*10)+1;
				   y = (int)(Math.random()*10)+1;
				   o='/';
				   ans=x/y;
				   if(x%y==0)
					   break;
			}
			break;
			}
	}
	
	public MathTeacher3() {
		inputPanel = new JPanel();
		QuestionPanel = new JPanel();
		inputField = new JTextField(3);
		GenerateQuestion();
		Question = new JLabel("Question " + x + o + y);
		inputPanel.add(inputField);
		QuestionPanel.add(Question);
		this.add(inputPanel);
		this.add(QuestionPanel);
		
		BtnPanel = new JPanel();
		AnsPanel = new JPanel();
		Answer = new JLabel();
		Press = new JButton("Press for answer");
		BtnPanel.add(Press);
		AnsPanel.add(Answer);
		
		ScorePanel = new JPanel();
		Score = new JLabel();
		Press.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!inputField.getText().equals("")) {     //Test empty
					
					//Here is the changing part of task 1
					String testStr = inputField.getText();    //replace all integer numbers
					testStr = testStr.replaceAll("[0-9]",""); //with space 
					if(testStr.length() != 0 && !testStr.equals("-") ) {   //Test numbers
						Answer.setText("Please enter integer numbers!");
					}
					else if((testStr.equals("-") && !inputField.getText().subSequence(0,1).equals("-"))||inputField.getText().equals("-")){
						Answer.setText("Please enter integer numbers!");    //Test minus numbers since it may regard "-" as a non-numeric
					}
					else {
						if(Integer.parseInt(inputField.getText()) < -10 || Integer.parseInt(inputField.getText()) > 100) {
							Answer.setText("Please enter an integer between -10 to 100 (inclusive)");   //Test boundary
						}
						else {
							
							total += 1;
							if(Integer.parseInt(inputField.getText()) == ans) {
								correct += 1;
								Answer.setText("Correct! Answer for "+ x + o + y + " is "+ans);
								Score.setText("You got "+correct+" correct out of "+total);
								ScorePanel.add(Score);
							}
							else {
								Answer.setText("Wrong! Answer for "+ x + o + y + " is "+ans);
								Score.setText("You got "+correct+" correct out of "+total);
								ScorePanel.add(Score);
							}
							GenerateQuestion();
							Question.setText("Question " + x + o + y);
							inputField.setText("");
						}
					}
				}
			}
		});
		this.add(BtnPanel);
		this.add(AnsPanel);
		
		//Extension3
		NumPanel = new JPanel();
		btn7 = new JButton("7");
		btn8 = new JButton("8");
		btn9 = new JButton("9");
		btn4 = new JButton("4");
		btn5 = new JButton("5");
		btn6 = new JButton("6");
		btn1 = new JButton("1");
		btn2 = new JButton("2");
		btn3 = new JButton("3");
		btn0 = new JButton("0");
		minus = new JButton("-");
		clear = new JButton("Clear");
		btn7.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e){
			    inputField.setText(inputField.getText()+"7");
			}
			});
		btn8.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e){
			    inputField.setText(inputField.getText()+"8");
			}
			});
		btn9.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e){
			    inputField.setText(inputField.getText()+"9");
			}
			});
		btn4.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e){
			    inputField.setText(inputField.getText()+"4");
			}
			});
		btn5.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e){
			    inputField.setText(inputField.getText()+"5");
			}
			});
		btn6.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e){
			    inputField.setText(inputField.getText()+"6");
			}
			});
		btn1.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e){
			    inputField.setText(inputField.getText()+"1");
			}
			});
		btn2.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e){
			    inputField.setText(inputField.getText()+"2");
			}
			});
		btn3.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e){
			    inputField.setText(inputField.getText()+"3");
			}
			});
		btn0.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e){
			    inputField.setText(inputField.getText()+"0");
			}
			});
		clear.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e){
			    inputField.setText("");
			}
			});
		minus.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e){
			    inputField.setText("-");
			}
			});
		NumPanel.add(btn7);
		NumPanel.add(btn8);
		NumPanel.add(btn9);
		NumPanel.add(btn4);
		NumPanel.add(btn5);
		NumPanel.add(btn6);
		NumPanel.add(btn1);
		NumPanel.add(btn2);
		NumPanel.add(btn3);
		NumPanel.add(btn0);
		NumPanel.add(minus);
		NumPanel.add(clear);
		NumPanel.setLayout(new GridLayout(4,3));
		this.add(NumPanel);
		
		this.add(ScorePanel);
		
		this.setTitle("Math Teacher");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new GridLayout(3,2));
		this.setSize(800,400);
		this.setVisible(true);
	}
	
public static void main(String[] args) {
		new MathTeacher3();
	}
}
