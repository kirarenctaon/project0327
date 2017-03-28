package homework;

import java.awt.Color;
import java.awt.Graphics;

public class RectThread extends ShapeThread {

	public RectThread(int x, int y, int width, int height, int interval, Graphics g) {
		super(x, y, width, height, interval, g);

	}

	public void render(){
		g.setColor(Color.ORANGE);
		g.fillRect(0,0,700,600);
		
		//원하는 도형 그리기
		g.setColor(Color.RED);
		x+=2;
		g.drawRect(x, y, width, height);
	}

}
