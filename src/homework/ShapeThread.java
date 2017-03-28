//원이던 사격형이던 어떤 도형을 표현한 객체이던 모두 이 클래스의 자식으로 두자
//왜? 공통적 특징이 있으므로.

package homework;

import java.awt.Color;
import java.awt.Graphics;

public abstract class ShapeThread extends Thread{
	int x;
	int y;
	int width;
	int height;
	int interval;
	Graphics g; //추상이지만 new할수 없다는 것일 뿐 멤버변수로 보유하는 것은 생관없음. 
	 //단 기존 캔버스에 올려야하기 때문에 누군가가 올릴때 넘겨받아야한다. 	
	
	public ShapeThread(int x, int y, int width, int height, int interval, Graphics g) {
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		this.interval=interval;
		this.g=g;
		start();
	}
	
	abstract public void render(); //자식들이 구현을 강제하도록 추상메서드로 만듬
	/*	
		System.out.println("g는 "+g);
		//지우고
		g.setColor(Color.ORANGE);//페인트로 윈도우에 적용하고
		g.fillRect(0, 0, 700, 600);
		
		//그리자
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
