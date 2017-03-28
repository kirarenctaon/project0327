package progressbar;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JProgressBar;

public class ProgressBarTest extends JFrame{
	JProgressBar[] bar=new JProgressBar[3];
	ProgressThread[] mb=new ProgressThread[3];
	int[] interval={100,500,1000};
	int count;
	
	public ProgressBarTest() {
		setLayout(new FlowLayout());
		
		for(int i=0;i<bar.length;i++){
			bar[i]=new JProgressBar();
			mb[i]=new ProgressThread(bar[i], interval[i]);
			bar[i].setPreferredSize(new Dimension(450, 40));
			add(bar[i]);
		}
		
		
		
		setSize(500, 200);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new ProgressBarTest();
	}
	
}
