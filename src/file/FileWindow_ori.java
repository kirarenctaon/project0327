package file;

import java.awt.FlowLayout;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class FileWindow_ori extends JFrame{
	
	ImageIcon folder_on, folder_off;
	


	
	public FileWindow_ori(){
		setLayout(new FlowLayout());
		//�̹����� �����ΰ� �ƴ� ������Ʈ ���� �������� �����ü� ����. 
		//Ŭ�����н��� ����ϸ� ��. ����-built path-Use as Source Folder
		//�̹��� �������� �����ϵ� ���ҽ� �����κ��� ������
		//Uniformed Resource Locator;
		
		//URL url=this.getClass().getResource("/folder_on.png");
		
		folder_on=new ImageIcon(this.getClass().getResource("/folder_on.png"));
		folder_off=new ImageIcon(this.getClass().getResource("/folder_off.png"));
		
		Image scaledImg= folder_on.getImage();//�������� ������ �ȵǼ� �̹����� ���� ������
		//ũ�⸦ �������� �� ��������� �̹��� ��ü�� �ٽ� ��ȯ
		Image result=scaledImg.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		folder_on.setImage(result);
		
		//����� ������ �׽�Ʈ
		MyPanel mp=new MyPanel("worksapce", folder_on);
		add(mp);
		
		setSize(600, 500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	public static void main(String[] args) {
		new FileWindow_ori();
	}

}
