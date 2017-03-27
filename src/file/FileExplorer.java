package file;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FileExplorer extends JFrame implements ActionListener{
	
	JPanel panel;
	JLabel label;
	JButton bt;
	JButton[] btArray;
	ImageIcon icon;
	String[] images={"C:/java_workspace/project0327/res/folder_on.png", "C:/java_workspace/project0327/res/folder_off.png"};	
	Boolean imagesFlag =true;
	
	File file=new File("c:/");	
	File[] dir=file.listFiles();
	
	Image img;
	Toolkit kit;
		

	public FileExplorer(){
		for(int i=0;i<dir.length;i++){
			if(dir[i].isDirectory()){
				//생성	
				panel=new JPanel();
				label=new JLabel(dir[i].getName());
				icon=new ImageIcon(images[1]);
				bt=new JButton(icon);
				
				bt.setBorderPainted(false);
				bt.setContentAreaFilled(false);
				bt.setFocusPainted(false);
				bt.setOpaque(false);
	
				//부착
				panel.add(label, BorderLayout.NORTH);
				panel.add(bt, BorderLayout.CENTER);	
				setLayout(new FlowLayout());
				add(panel);
				
				
				//리스너 연결
				bt.addActionListener(this);
			}
		}
		kit=Toolkit.getDefaultToolkit();//인스턴스 얻기; 추상메서드의 클래스메서드로 new할수 없다.
		img=kit.getImage("C:/java_workspace/project0327/res/folder_on.png");
		
		
		//화면
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1000, 800);
	}
	
	public static void main(String[] args) {
		new FileExplorer();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		//icon.setIconImage(img.getImage());
	}
}
