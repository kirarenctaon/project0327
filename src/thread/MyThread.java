/*
  ���ü����ϰ� ���� �ڵ�� �����ڰ� �����ؾ��ϱ� ������ �����带 ������ �ؾ��Ѵ�.  
 */
package thread;

public class MyThread extends Thread{
	//  �����ڴ� ���������� �����ϰ� ���� �ڵ带 �������� run�޼��� �ȿ� �ۼ��ϸ� �ȴ�.

	public void run() {
		//�����尡 �ݴ� �극�̽��� ������ �ȵ��� ���ѹݺ� ����
		while(true){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}//1�� ���ٿ�
			
			System.out.println("��");
		}
	}

}
