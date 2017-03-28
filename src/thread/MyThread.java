/*
  동시수행하고 싶은 코드는 개발자가 정의해야하기 때문에 쓰레드를 재정의 해야한다.  
 */
package thread;

public class MyThread extends Thread{
	//  개발자는 독립적으로 수행하고 싶은 코드를 쓰레드의 run메서드 안에 작성하면 된다.

	public void run() {
		//쓰레드가 닫는 브레이스를 만나지 안도록 무한반복 돌림
		while(true){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}//1초 쉬다와
			
			System.out.println("★");
		}
	}

}
