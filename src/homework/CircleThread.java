//원을 표현한 객체 및 그 움직임
package homework;

import java.awt.Color;
import java.awt.Graphics;

public class CircleThread extends ShapeThread{
	
	public CircleThread(int x, int y, int width, int height, int interval, Graphics g) { 
		super(x,y,width,height,interval,g);//인수 있는 생성자라서 부모 생성자를 따로불러야함
	}
	
	//오버라이드이자 결국 업그레이드인것
	public void render(){
		System.out.println("g는 "+g);
		//지우고
		g.setColor(Color.ORANGE);//페인트로 윈도우에 적용하고
		g.fillRect(0, 0, 700, 600);
	
		//그리자
		x+=5;
		g.setColor(Color.BLACK);
		g.drawOval(x, y, width, height);
	}
	
}
