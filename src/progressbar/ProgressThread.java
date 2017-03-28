package progressbar;

import javax.swing.JProgressBar;

public class ProgressThread extends Thread {
	JProgressBar bar;
	int count;
	int interval;
	
	public ProgressThread(	JProgressBar bar, int interval) {
		this.bar=bar;
		this.interval=interval;
		
		this.start();
	}
	
	public void run(){
		while(true){
			try {
				Thread.sleep(interval);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			count++;
			bar.setValue(count);
		}
	}
}
