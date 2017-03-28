package thread2;

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
	int x,y;
	Thread thread;//내부익명 스타일로 개발
	
	public AniMain() {
		thread = new Thread(){
			public void run() {
				while(true){
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					move();
				}
			}
		};
		
		bt=new JButton("물체이동");
		add(bt, BorderLayout.NORTH);
		can=new Canvas(){
			public void paint(Graphics g){
				g.drawOval(x, y, 50, 50);
			}
		};
				
		can.setBackground(Color.YELLOW);
		add(can);
		
		//버튼과 리스너 연결
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//이동하는 메서드 호출!
				//동생 쓰레드를 만들어 일을 시키자!
				thread.start();
			}
		});
		
		setSize(700, 500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void move(){
		x+=5;
		can.repaint();
	}
	
	public static void main(String[] args) {
		new AniMain();
	}
}
