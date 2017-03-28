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
		//�̹����� �����ΰ� �ƴ� ������Ʈ ���� �������� �����ü� ����. 
		//Ŭ�����н��� ����ϸ� ��. ����-built path-Use as Source Folder
		//�̹��� �������� �����ϵ� ���ҽ� �����κ��� ������
		//Uniformed Resource Locator;
		//URL url=this.getClass().getResource("/folder_on.png");
		
		folder_on=new MyIcon(this.getClass().getResource("/folder_on.png"), 50, 50);
		folder_off=new MyIcon(this.getClass().getResource("/folder_off.png"), 50, 50);
		
		//����� ������ �׽�Ʈ
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
	
	//���ϴ� ����� ���� ���丮/���� ���ϱ�
	public ArrayList<String> getDirList(){
		File file=new File("c:/");
		File[] fileList=file.listFiles();
		ArrayList<String> dirList=new ArrayList<String>();
			
		//���丮�� �����
		for(int i=0;i<fileList.length;i++){
			if(fileList[i].isDirectory()){
				//���丮�� �߰ߵɶ����� list�߰�
				dirList.add(fileList[i].getName());
			}
		}
		return dirList;
	}
	
	public static void main(String[] args) {
		new FileWindow();
	}
}
