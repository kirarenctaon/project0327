//������ ������ ��� �� ������!
package practice;

public class MoveTread extends Thread{
	AniMain aniMain; //new�� �ϸ� ���ο� aniMain�� ����Ƿ� �޾ƿ���!!
	//�����ڴ� ���������� �ڵ带 run�� ����
	//JVM�� �� run�� �˾Ƽ� ȣ�����ش�. 
	
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
