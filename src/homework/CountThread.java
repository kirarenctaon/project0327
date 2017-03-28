package homework;

import javax.swing.JLabel;

public class CountThread extends Thread{
	JLabel la;
	int count;
	int interval;
	
	public CountThread(JLabel la, int interval) {
		this.la=la;
		this.interval=interval;
		
		start();
	}
	
	public void run(){
		
		while(true){
			try {
				Thread.sleep(interval);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			count++;
			la.setText(Integer.toString(count));
		}
	}
}
