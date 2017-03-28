/*
 * 서로 다른 그래픽, 속도, 기타값을 갖는 물체를 움직이게 하자
 * */
package homework;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MultiAni extends JFrame{
	JButton bt;
	Canvas can;
	Graphics gp;
	CircleThread ct;
	
	public MultiAni() {
		bt=new JButton("각자 움직이기");
		can=new Canvas(){
			public void paint(Graphics g) {
				//gp=g; //gp가 아직 메모리에 올라오지 않은 시점으로 NullPointerException 발생
			}	
		};
		
		//그래픽스를 먼저 얻어온후 써클을 만들자.
		//ct=new CircleThread(gp, 0, 0, 50, 50);
		//ct.start();
		
		can.setBackground(Color.ORANGE);
		add(bt, BorderLayout.NORTH);
		add(can);
		
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Graphics g= can.getGraphics();
				
				CircleThread ct=new CircleThread(0, 0, 50, 50, 100, g);
				RectThread rt= new RectThread(0, 200, 100, 100, 50, g);
				//ct.start();
				/* 이렇게 해도 물론 가능함
				ShapeThread st=ct;
				st.start();
				 */
			}
		});
		
		setSize(700,600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
		
	public static void main(String[] args) {
		new MultiAni();
	}

}
