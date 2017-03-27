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
	ImageIcon icon;//�Ϲ�Ŭ����
	JTextArea area;
	JScrollPane scroll;
	
	String ori="C:/java_workspace/project0327/res/memo.txt";//����
	String dest="C:/java_workspace/project0327/res/memo_copy.txt";//�ٸ� ������ ������
	FileInputStream fis; //reader, writer�� ���� Ŭ�����ϱ� byte ����̰� �ѱ��� ������
	FileOutputStream fos; //reader, writer�� ���� Ŭ�����ϱ� byte ����̰� �ѱ��� ������
	
	InputStreamReader reader;//���ڱ�� �Է½�Ʈ
	BufferedReader buffr; //����ó���� ���ڿ� ��� �Է½�Ʈ��
						
	//���ڱ���� ��½�Ʈ��
	 OutputStreamWriter writer; //�ܵ������� �������� ���ϰ� fos�� ��ƸԴ´�. 
	 PrintWriter writer2;// ���ڱ���� ��½�Ʈ��	
	 
	public MemoEditor() {
		//����
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
		
		//����
		p_north.add(bt_open);
		p_north.add(bt_save);
		add(p_north, BorderLayout.NORTH);
		add(scroll);
		
		//��ư 2�� ���ο������� ���� & ������ ����
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
		
		//â����
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(700, 600);
		setVisible(true);
	}
	
	//����
	public void open(){
		try{
			fis=new FileInputStream(ori);
			// ���ڱ�� ��Ʈ�������� �������ڵ� �Ӽ��� ������ �� �ִ�. InputStreamReader �����ڿ��� �Ű������� "utf-8"�� �Է��ϸ� �ȴ�. 
			reader =new InputStreamReader(fis, "utf-8");
			buffr=new BufferedReader(reader);
			
			String data;
			//int data;
			//data=fis.read();//1byte �о���δ�. �ѱ��� ��������
			
			int count=0; //read Ƚ���� �˱� ����
			
			while(true){
				//data=reader.read(); //2byte �о���δ�.
				data=buffr.readLine(); //���پ� �о�帰��. 
				count++;			
				//if(data==-1)break;
				//area.append(Character.toString((char)data)); //�ϴ� �����ڵ带 �о�帮���� �����Ҷ� ����. data�� �ڷ����� int �������̶� int������ �ٲ���� 12345 ���ڸ� ���´�. ĳ���������� �ٲ���.
				if(data==null)break;
				area.append(data+"\n"); 
			}
			System.out.println("count="+count);		
		}catch (FileNotFoundException e){ //e�� FileNotFoundException�� ���۷��� ����
			JOptionPane.showMessageDialog(this, "������ �������� �ʽ��ϴ�."); //����ڸ� ���� ���� �α� ����
			e.printStackTrace(); //e���� ������ �������� ���̴� ������ ������ ��µ�. �ܼ�â�� ������ ���ñ����� ����. �����ڸ� ���� ���� �α� ����
		}catch (IOException e){
			e.printStackTrace();
		}
	}
	
	//�����ϱ�	
	public void save(){
		try {
			//FileOutputStream�� ������ ����� ������ ������ ������.(ũ��� 0byte�� empty �� ����)
			fos=new FileOutputStream(dest);
			writer2=new PrintWriter(fos);
			writer2.write(area.getText());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			//������� ��Ʈ���� ���� �ݴ�ó��
			if(writer2!=null){//���� �Ѵٸ�
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
			//FileOutputStream�� ������ ����� ������ ������ ������.(ũ��� 0byte�� empty �� ����)
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
			//������� ��Ʈ���� ���� �ݴ�ó��
			if(writer!=null){//���� �Ѵٸ�
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
