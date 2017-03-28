//움직임 로직을 담게 될 쓰레드!
package practice;

public class MoveTread extends Thread{
	AniMain aniMain; //new를 하면 새로운 aniMain을 만드므로 받아오자!!
	//개발자는 독립실행할 코드를 run에 기재
	//JVM이 이 run을 알아서 호출해준다. 
	
	 public MoveTread(AniMain aniMain) {
		// TODO Auto-generated constructor stub
		 this.aniMain=aniMain;
	 }
	
	@Override
	public void run() {
		while(true){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			aniMain.move();
		}
	}
	
}
