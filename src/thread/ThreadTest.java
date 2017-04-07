/*
OS�� ���� ���μ������� ���ÿ� �����ϸ鼭 ������ �� �ֵ�(multi-tasking),
�ϳ��� �ڹ����α׷� ������ ������ ��������� ����� ���ÿ� �����ų �� �ִ�.
�̷��� ������ ��������� ������� �Ѵ�. 
 
 �ڹٴ� �����ڰ� �������� �����Ƶ� �̹� �⺻������ �����Ǵ� ����� ������ ������
 �̷��� �����带 ������ ���ξ������ �Ѵ�. �ᱹ �ڹٴ� ������ ����̴�. 
 
*/

package thread;

public class ThreadTest {
	Thread thread; // java.lang�� �־ import ���ص� ��
	Cat cat;
	
	public ThreadTest() {
		//���ξ������ʹ� ���������� ����ɼ� �ִ� ���� ��������� ������
		//�����尡 � ���� ������ �����ڰ� �����ؾ��ϱ� ������, ��� �ڵ������� �־����-> ������-> ��ӹ޾ƾ���
		thread=new MyThread();
		thread.start(); //run�� ���������ϸ� �ȵ�
		
		//thread.run(); // �������� ȣ���Ѱ� �ƴ϶� run�޼��带 ȣ���ϴ� ����
		//run()�� ���ξ����尡 ������. �ý��ۿ��� �ñ�°� �ƴϱ� ������ ������ ����δ� ���ξ����尡 ������
		//start()�� JVM���� �ñ�� ��. ������ �����, 	�����尡  ���� �����	

		while(true){
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("��");
			//���ξ����嵵 ������ ������� Thread�� ���� ������ �� ����
		}
		
		
	}
	
	//���ξ����� ����, �����ڰ� ���ϴ� ����� ���� ������ �ϳ� ���� ���ϴ� ���� �۾��� ��������.
	public static void main(String[] args) {
		new ThreadTest();
		/*
		int[] arr=new int[3];
		
		System.out.println(arr[3]); 
		 RunTimeException ���� �迭�� ũ�⸦ ���
		Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 3
		at thread.ThreadTest.main(ThreadTest.java:16)
		*/
	}
	
}
