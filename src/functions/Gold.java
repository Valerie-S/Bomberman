package functions;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class Gold extends Props{

	public Gold(int j, int i) {
		this.setX(j*50);
		this.y=i*50+102;
		setType(1);
	}
 
	static Image goldImage= Toolkit.getDefaultToolkit().getImage("image/gold.png");
	public void draw(Graphics g){

 	   g.drawImage(goldImage,getX(), y, size, size,null);
// 	   if(meetPlayer()){
// 		   GameFrame.props.remove(this);
// 		   Scoring.gold++;
// 		   Scoring.setGold();
// 	   }
    }

	
}
