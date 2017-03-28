//���̴� ������̴� � ������ ǥ���� ��ü�̴� ��� �� Ŭ������ �ڽ����� ����
//��? ������ Ư¡�� �����Ƿ�.

package homework;

import java.awt.Color;
import java.awt.Graphics;

public abstract class ShapeThread extends Thread{
	int x;
	int y;
	int width;
	int height;
	int interval;
	Graphics g; //�߻������� new�Ҽ� ���ٴ� ���� �� ��������� �����ϴ� ���� ��������. 
	 //�� ���� ĵ������ �÷����ϱ� ������ �������� �ø��� �Ѱܹ޾ƾ��Ѵ�. 	
	
	public ShapeThread(int x, int y, int width, int height, int interval, Graphics g) {
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		this.interval=interval;
		this.g=g;
		start();
	}
	
	abstract public void render(); //�ڽĵ��� ������ �����ϵ��� �߻�޼���� ����
	/*	
		System.out.println("g�� "+g);
		//�����
		g.setColor(Color.ORANGE);//����Ʈ�� �����쿡 �����ϰ�
		g.fillRect(0, 0, 700, 600);
		
		//�׸���
		x+=5;
		g.setColor(Color.BLACK);
		g.drawOval(x, y, width, height);
	*/
	
	public void run() {
		while(true){
			try {
				Thread.sleep(interval);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		
			render();
		}
	}
}
