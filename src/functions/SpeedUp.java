package functions;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class SpeedUp extends Props{
	
	public SpeedUp(int j, int i) {
		this.setX(j*50);
		this.y=i*50+102;
		setType(2);
	}

	Image speedUpImage= Toolkit.getDefaultToolkit().createImage("image/speedUp.png");
	public void draw(Graphics g){
//		System.out.println("speedUp");
 	   g.drawImage(speedUpImage,getX(), y, size, size,null);

// 	   if(meetPlayer()){
// 		   GameFrame.props.remove(this);
// 		   GameFrame.player.setSpeed(GameFrame.player.getSpeed() + 3);
// 		  haveSpeedUp=true;
// 	   }
// 	   
    }
}
