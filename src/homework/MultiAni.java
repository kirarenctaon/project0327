/*
 * ���� �ٸ� �׷���, �ӵ�, ��Ÿ���� ���� ��ü�� �����̰� ����
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
		bt=new JButton("���� �����̱�");
		can=new Canvas(){
			public void paint(Graphics g) {
				//gp=g; //gp�� ���� �޸𸮿� �ö���� ���� �������� NullPointerException �߻�
			}	
		};
		
		//�׷��Ƚ��� ���� ������ ��Ŭ�� ������.
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
				/* �̷��� �ص� ���� ������
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
