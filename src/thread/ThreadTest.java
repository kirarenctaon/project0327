/*
OS가 여러 프로세스들을 동시에 수행하면서 관리할 수 있듯(multi-tasking),
하나의 자바프로그램 내에서 세부적 실행단위를 만들어 동시에 수행시킬 수 있다.
이러한 세부적 실행단위를 쓰레드라 한다. 
 
 자바는 개발자가 정의하지 ㅇ낳아도 이미 기본적으로 제공되는 실행용 쓰레가 있으며
 이러한 쓰레드를 가리켜 메인쓰레드라 한다. 결국 자바는 쓰레드 기반이다. 
 
*/

package thread;

public class ThreadTest {
	Thread thread; // java.lang에 있어서 import 안해도 됨
	Cat cat;
	
	public ThreadTest() {
		//메인쓰레도와는 독립적으로 실행될수 있는 세부 실행단위를 생성함
		//쓰레드가 어떤 일을 할지는 개발자가 결정해야하기 때문에, 적어도 코딩영역이 있어야함-> 재정의-> 상속받아야함
		thread=new MyThread();
		thread.start(); //run을 직접수행하면 안됨
		
		//thread.run(); // 쓰레도를 호출한게 아니라 run메서드를 호출하는 것임
		//run()을 메인쓰레드가 수행함. 시스템에게 맡기는게 아니기 때문에 별도의 실행부는 메인쓰레드가 수행함
		//start()은 JVM에게 맡기는 것. 메인은 ☆찍고, 	쓰레드가  ★을 찍게함	

		while(true){
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("☆");
			//메인쓰레드도 일종의 쓰레드로 Thread에 의해 통재할 수 있음
		}
		
		
	}
	
	//메인쓰레드 말고, 개발자가 원하는 사용자 정의 쓰레드 하나 만들어서 원하는 동시 작업을 수행하자.
	public static void main(String[] args) {
		new ThreadTest();
		/*
		int[] arr=new int[3];
		
		System.out.println(arr[3]); 
		 RunTimeException 오류 배열의 크기를 벗어남
		Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 3
		at thread.ThreadTest.main(ThreadTest.java:16)
		*/
	}
	
}
