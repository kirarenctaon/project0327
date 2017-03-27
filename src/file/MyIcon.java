//������ ������ �� ũ�⸦ �����Ϸ��� �ڵ尡 �����ϹǷ�, 
//������ ���� ���ɼ��� �����صΰ� ������ ������ �̹��� �������� ���� �����غ���. 

package file;

import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;

public class MyIcon extends ImageIcon {

	public MyIcon(URL url, int width, int height) {
		//folder_on=new ImageIcon(this.getClass().getResource("/folder_on.png"));
		//super(this.getClass().getResource("/folder_on.png"));// ()���� ���� ����ǹǷ� ������
		super(url);
			
		Image scaledImg= this.getImage();
		Image result=scaledImg.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		this.setImage(result);
	}
}
