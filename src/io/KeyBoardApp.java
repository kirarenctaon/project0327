/*
FileInputStream 등은 개발자가 원하는 시점에 스트림을 생성할 수 있지만, 
키보드와 같은 표준 입력 하드웨어의 경우엔 자바가 스트림을 생성하지 못하고
해당 OS가 관리하므로, 자바 갭라자는 OS로부터 표준 입력스트림을 얻어야한다. 

자바의 클래스중 System클래스의 static 멤버변수중 즉 has a 관계로 보유한
InptuStream형 in 객체가 바로 표준입력 스트림을 받아놓은 클래스이다. 
따라서 사용시엔 그냥 System.in;

문자기반 스트림 클래스의 명명규칙
입력 : ~~Reader
출력 : ~~Writer
//이 두개가 붙으면 한글을 입력해도 깨지지 않는다. 

*/
package io;

import java.io.InputStream;
import java.io.IOException;
import java.io.InputStreamReader;

class KeyBoardApp{
	public static void main(String[] args){
		InputStream is=System.in;
	
		//문자기반 스트림은 단독으로 존재하는 것이 아니라 이미 바이트 기반 스트림을 전제로 한다.
		//따라서 생성시 생성자의 인수에 바이트 기반 스트림을 넣는다. 
		InputStreamReader reader=null;
		reader=new InputStreamReader(is); //byte기반의 is를 넣는다. 

		int data;
		try{
			while(true){
				//data=is.read(); //1byte 읽어드림 
				data=reader.read(); //2byte 읽어드림 
				//out은 PrintStream형 static 변수
				//System.out.print(data);  유니코드문자+13(줄바꿈 기능키)+10(맨앞으로 커서를 놓는 기능키)
				System.out.print((char)data); 
			}
		}catch(IOException e){
		
		}
	}
}