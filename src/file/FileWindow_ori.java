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
		//이미지를 절대경로가 아닌 프로젝트 폴더 기준으로 가져올수 있음. 
		//클래스패스에 등록하면 됨. 폴더-built path-Use as Source Folder
		//이미지 아이콘을 생성하되 리소스 폴더로부터 가져옴
		//Uniformed Resource Locator;
		
		//URL url=this.getClass().getResource("/folder_on.png");
		
		folder_on=new ImageIcon(this.getClass().getResource("/folder_on.png"));
		folder_off=new ImageIcon(this.getClass().getResource("/folder_off.png"));
		
		Image scaledImg= folder_on.getImage();//아이콘은 수정이 안되서 이미지를 얻어와 수정함
		//크기를 재조정한 후 결과적으로 이미지 객체를 다시 반환
		Image result=scaledImg.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		folder_on.setImage(result);
		
		//제대로 붙을지 테스트
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
