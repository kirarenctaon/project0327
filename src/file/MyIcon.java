//아이콘 생성시 그 크기를 조정하려면 코드가 복잡하므로, 
//앞으로 재사용 가능성을 염두해두고 나만의 재조정 이미지 아이콘을 새로 정의해본다. 

package file;

import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;

public class MyIcon extends ImageIcon {

	public MyIcon(URL url, int width, int height) {
		//folder_on=new ImageIcon(this.getClass().getResource("/folder_on.png"));
		//super(this.getClass().getResource("/folder_on.png"));// ()안이 먼저 실행되므로 에러뜸
		super(url);
			
		Image scaledImg= this.getImage();
		Image result=scaledImg.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		this.setImage(result);
	}
}
