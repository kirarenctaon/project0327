package practice;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class AniMain extends JFrame{
	JButton bt;
	Canvas can;
	int x,y,z;
	AniMain aniMain;

	public AniMain() {
		aniMain=this;
		bt=new JButton("물체이동");
		add(bt, BorderLayout.NORTH);
		
		can=new Canvas(){
			public void paint(Graphics g){
				g.drawOval(x, 0, 50, 50);
				g.drawRect(y, 100, 50, 50);
				g.drawOval(z, 200, 20, 50);
			}
		};
				
		can.setBackground(Color.YELLOW);
		add(can);

		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MoveTread mt=new MoveTread(aniMain);
				mt.start();
			}
		});
		
		setSize(700, 500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void move(){
		x+=5;
		y+=15;
		z+=1;
		can.repaint();
	}
	
	public static void main(String[] args) {
		new AniMain();
	}
}
