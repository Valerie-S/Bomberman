package functions;

import java.awt.Graphics;

public class Props {
       private int x;
       protected int y;
       protected int size=50;
       protected int type=0;
       
       public void draw(Graphics g){
    	
       }
//       protected boolean meetPlayer() {
//   		if(x+20>GameFrame.player.getX()&&x+20<GameFrame.player.getX()+50
//   				&&y+20>GameFrame.player.getY()&&y+20<GameFrame.player.getY()+50){
//   			return true;
//   			
//   		}
//   		return false;
//   	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
       
	
}
