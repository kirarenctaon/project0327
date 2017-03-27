package io;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MemoEditor extends JFrame{
	JPanel p_north;
	JButton bt_open, bt_save;
	ImageIcon icon;//일반클레스
	JTextArea area;
	JScrollPane scroll;
	
	String ori="C:/java_workspace/project0327/res/memo.txt";//원본
	String dest="C:/java_workspace/project0327/res/memo_copy.txt";//다른 파일의 저장경로
	FileInputStream fis; //reader, writer가 없는 클래스니까 byte 기반이고 한글을 깨질듯
	FileOutputStream fos; //reader, writer가 없는 클래스니까 byte 기반이고 한글을 깨질듯
	
	InputStreamReader reader;//문자기반 입력스트
	BufferedReader buffr; //버퍼처리된 문자열 기반 입력스트림
						
	//문자기반의 출력스트림
	 OutputStreamWriter writer; //단독적으로 존재하지 못하고 fos를 잡아먹는다. 
	 PrintWriter writer2;// 문자기반의 출력스트림	
	 
	public MemoEditor() {
		//생성
		p_north=new JPanel();
		icon=new ImageIcon("C:/java_workspace/project0327/res/folder_on.png");
		bt_open=new JButton(icon);
		bt_save=new JButton("save");
		area = new JTextArea();
		scroll=new JScrollPane(area);	
		
		bt_open.setBorderPainted(false);
		bt_open.setContentAreaFilled(false);
		bt_open.setFocusPainted(false);
		bt_open.setOpaque(false);
		
		//부착
		p_north.add(bt_open);
		p_north.add(bt_save);
		add(p_north, BorderLayout.NORTH);
		add(scroll);
		
		//버튼 2개 내부역명으로 가자 & 리스너 연결
		bt_open.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				open();
			}
		});
		
		bt_save.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				save();
			}
		});
		
		//창설정
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(700, 600);
		setVisible(true);
	}
	
	//열기
	public void open(){
		try{
			fis=new FileInputStream(ori);
			// 문자기반 스트림에서는 문자인코딩 속성을 지정할 수 있다. InputStreamReader 생성자에서 매개변수로 "utf-8"을 입력하면 된다. 
			reader =new InputStreamReader(fis, "utf-8");
			buffr=new BufferedReader(reader);
			
			String data;
			//int data;
			//data=fis.read();//1byte 읽어들인다. 한글을 깨질예정
			
			int count=0; //read 횟수를 알기 위해
			
			while(true){
				//data=reader.read(); //2byte 읽어들인다.
				data=buffr.readLine(); //한줄씩 읽어드린다. 
				count++;			
				//if(data==-1)break;
				//area.append(Character.toString((char)data)); //일단 유니코드를 읽어드리지만 실행할때 깨짐. data의 자료형은 int 숫자형이라 int형으로 바꿔봤자 12345 숫자만 나온다. 캐릭터형으로 바꾸자.
				if(data==null)break;
				area.append(data+"\n"); 
			}
			System.out.println("count="+count);		
		}catch (FileNotFoundException e){ //e는 FileNotFoundException의 레퍼런스 변수
			JOptionPane.showMessageDialog(this, "파일이 존재하지 않습니다."); //사용자를 위한 에러 로그 정보
			e.printStackTrace(); //e에는 에러가 점점위로 쌓이는 구조로 에러가 출력됨. 콘솔창에 에러가 스택구조로 쌓임. 개발자를 위한 에러 로그 정보
		}catch (IOException e){
			e.printStackTrace();
		}
	}
	
	//저장하기	
	public void save(){
		try {
			//FileOutputStream은 지정한 경로의 파일을 생성해 버린다.(크기는 0byte인 empty 빈 파일)
			fos=new FileOutputStream(dest);
			writer2=new PrintWriter(fos);
			writer2.write(area.getText());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			//열어놓은 스트림은 전부 닫는처리
			if(writer2!=null){//존재 한다면
				writer2.close();
			}
			if(fos!=null){
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}	
	}
	
	/*
	public void save(){
		try {
			//FileOutputStream은 지정한 경로의 파일을 생성해 버린다.(크기는 0byte인 empty 빈 파일)
			fos=new FileOutputStream(dest);
			
			writer=new OutputStreamWriter(fos, "utf-8");
			writer.write(area.getText());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			//열어놓은 스트림은 전부 닫는처리
			if(writer!=null){//존재 한다면
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(fos!=null){
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}	

	}
	*/
	
	public static void main(String[] args) {
		new MemoEditor();
	}

}
