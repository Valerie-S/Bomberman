package scene;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Stone extends Barrier{
	public Stone(int x, int y) {
		super(x, y);
		this.setType(1);
	}
	
	public void draw(Graphics g){
		g.drawImage(barrierImage, getBarrierX()*50, getBarrierY()*50+102, 50,50,null);
     
	}
	public Rectangle getRectBarrier() {
		return new Rectangle( getBarrierX()*50,getBarrierY()*50+102, 50, 50);
	}
}
