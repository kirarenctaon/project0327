/*
FileInputStream ���� �����ڰ� ���ϴ� ������ ��Ʈ���� ������ �� ������, 
Ű����� ���� ǥ�� �Է� �ϵ������ ��쿣 �ڹٰ� ��Ʈ���� �������� ���ϰ�
�ش� OS�� �����ϹǷ�, �ڹ� �����ڴ� OS�κ��� ǥ�� �Է½�Ʈ���� �����Ѵ�. 

�ڹ��� Ŭ������ SystemŬ������ static ��������� �� has a ����� ������
InptuStream�� in ��ü�� �ٷ� ǥ���Է� ��Ʈ���� �޾Ƴ��� Ŭ�����̴�. 
���� ���ÿ� �׳� System.in;

���ڱ�� ��Ʈ�� Ŭ������ ����Ģ
�Է� : ~~Reader
��� : ~~Writer
//�� �ΰ��� ������ �ѱ��� �Է��ص� ������ �ʴ´�. 

*/
package io;

import java.io.InputStream;
import java.io.IOException;
import java.io.InputStreamReader;

class KeyBoardApp{
	public static void main(String[] args){
		InputStream is=System.in;
	
		//���ڱ�� ��Ʈ���� �ܵ����� �����ϴ� ���� �ƴ϶� �̹� ����Ʈ ��� ��Ʈ���� ������ �Ѵ�.
		//���� ������ �������� �μ��� ����Ʈ ��� ��Ʈ���� �ִ´�. 
		InputStreamReader reader=null;
		reader=new InputStreamReader(is); //byte����� is�� �ִ´�. 

		int data;
		try{
			while(true){
				//data=is.read(); //1byte �о�帲 
				data=reader.read(); //2byte �о�帲 
				//out�� PrintStream�� static ����
				//System.out.print(data);  �����ڵ幮��+13(�ٹٲ� ���Ű)+10(�Ǿ����� Ŀ���� ���� ���Ű)
				System.out.print((char)data); 
			}
		}catch(IOException e){
		
		}
	}
}