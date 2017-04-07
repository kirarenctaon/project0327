package homework3;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

public class SaveWindow extends JFrame implements ActionListener{
	JProgressBar bar;
	JButton bt_open, bt_setpath, bt_copy;
	JTextField t_open, t_setpath;
	JLabel percentNum;
	
	FileInputStream fis;
	FileOutputStream fos;
	JFileChooser chooser;
	
	Thread copyThread;
	SaveWindow saveWindow;
	int count;
	long fileLength;
	int percent;

	public SaveWindow() {
		bar=new JProgressBar();
		bt_open=new JButton("파일선택");
		bt_setpath=new JButton("저장경로");
		bt_copy=new JButton("복사실행");
		t_open=new JTextField(30);
		t_setpath=new JTextField(30);
		percentNum=new JLabel("0 %");
		chooser=new JFileChooser("c:/java_workspace/project0327/");
		
		setLayout(new FlowLayout());
		bar.setPreferredSize(new Dimension(400, 40));
		
		add(bar);
		add(percentNum);
		add(bt_open); 
		add(t_open);
		add(bt_setpath); 
		add(t_setpath);
		add(bt_copy);
		
		bt_open.addActionListener(this);
		bt_setpath.addActionListener(this);
		bt_copy.addActionListener(this);
		
		setSize(500, 200);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		copy();
	}
	
	public void actionPerformed(ActionEvent e) {
		Object obj=e.getSource();
		
		if(obj==bt_open){
			int state=chooser.showSaveDialog(this);
			
			if(state==JFileChooser.APPROVE_OPTION){
				File file=chooser.getSelectedFile();
				fileLength= file.length();
				String path=file.getAbsolutePath();
				t_open.setText(path);
			}else if(state==JFileChooser.CANCEL_OPTION){
				t_open.setText("");
			}			
		}else if(obj==bt_setpath){
			int state=chooser.showOpenDialog(this);
			
			if(state==JFileChooser.APPROVE_OPTION){
				File file=chooser.getSelectedFile();
				String path=file.getAbsolutePath();
				t_setpath.setText(path);
			}else if(state==JFileChooser.CANCEL_OPTION){
				t_setpath.setText("");
			}
		}else if(obj==bt_copy){	
			copyThread.start();
		}
	}
	
	public void copy(){
		copyThread = new Thread(){
			public void run(){
				String oriPath=t_open.getText();
				String destPath=t_setpath.getText();
				
				try{
					fis=new FileInputStream(oriPath); 
					fos=new FileOutputStream(destPath); 

					int data=-1;
					while(true){
						data=fis.read();
						if(data==-1) break;
						fos.write(data);
						count++;
						//System.out.println(count);
						percent=(int)(((double)count*100/(double)fileLength));
						percentNum.setText(percent+"%");
						bar.setValue(percent);
					}
					JOptionPane.showMessageDialog(saveWindow, "복사완료");
				}catch(FileNotFoundException e){
					JOptionPane.showMessageDialog(saveWindow, "파일을 찾을 수 없습니다!"); 
				}catch(IOException e){ 
					JOptionPane.showMessageDialog(saveWindow, "IO작업중 에러 발생했네요.");
				}finally{
					try{
						if(fis!=null){
							fis.close();
						}
						if(fos!=null){
							fos.close();
						}
					}catch(IOException e){}
				}//finallay 끝
			}//run끝
		}; //쓰레드 끝	
	}

	public static void main(String[] args) {
		new SaveWindow();
	}
}
