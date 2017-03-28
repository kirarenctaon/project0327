package file;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;

public class FileWindow extends JFrame{
	
	MyIcon folder_on, folder_off;
	ArrayList<MyPanel> panels=new ArrayList<MyPanel>();

	public FileWindow(){
		setLayout(new FlowLayout());
		//이미지를 절대경로가 아닌 프로젝트 폴더 기준으로 가져올수 있음. 
		//클래스패스에 등록하면 됨. 폴더-built path-Use as Source Folder
		//이미지 아이콘을 생성하되 리소스 폴더로부터 가져옴
		//Uniformed Resource Locator;
		//URL url=this.getClass().getResource("/folder_on.png");
		
		folder_on=new MyIcon(this.getClass().getResource("/folder_on.png"), 50, 50);
		folder_off=new MyIcon(this.getClass().getResource("/folder_off.png"), 50, 50);
		
		//제대로 붙을지 테스트
		ArrayList<String> list=getDirList();
		
		for(int i=0;i<list.size();i++){
			String dirName=list.get(i);
			
			MyPanel mp=new MyPanel(dirName, folder_off);
			add(mp);
			panels.add(mp);
			
			mp.bt.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					for(int j=0;j<panels.size();j++){
						if(mp==panels.get(j)){
							panels.get(j).bt.setIcon(folder_on);
						}else{
							panels.get(j).bt.setIcon(folder_off);
						}
					}
				
				}
			});

		}
		setSize(600, 650);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	//원하는 경로의 하위 디렉토리/파일 구하기
	public ArrayList<String> getDirList(){
		File file=new File("c:/");
		File[] fileList=file.listFiles();
		ArrayList<String> dirList=new ArrayList<String>();
			
		//디렉토리만 골라내자
		for(int i=0;i<fileList.length;i++){
			if(fileList[i].isDirectory()){
				//디렉토리가 발견될때마다 list추가
				dirList.add(fileList[i].getName());
			}
		}
		return dirList;
	}
	
	public static void main(String[] args) {
		new FileWindow();
	}
}
