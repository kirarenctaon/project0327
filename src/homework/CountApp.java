package homework;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.BinaryOperator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import homework2.CountThread;

public class CountApp extends JFrame{

	JLabel p_left, p_right;
	JButton bt;
	
	public CountApp(){
		p_left=new JLabel("1");
		p_right=new JLabel("2");

		setLayout(new FlowLayout());
		
		add(p_left);
		add(p_right);

		setSize(200, 200);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		 CountThread ch1=new CountThread(p_left, 10);
		 CountThread ch2=new CountThread(p_right, 50);
	}
	
	
	public static void main(String[] args) {
		new CountApp();
	}
}
