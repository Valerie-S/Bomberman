package scene;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class BackDrop {
	public BackDrop(){
		
	}
	private Image backDrop0Image= Toolkit.getDefaultToolkit().getImage("image/backDrop0.png");
	public void draw(Graphics g){
     for(int i=0;i<20;i++){
    	 for(int j=0;j<10;j++){
    		g.drawImage(backDrop0Image, i*150, j*150+102, 150,150,null);
    	 }
     }
	}
	
}
