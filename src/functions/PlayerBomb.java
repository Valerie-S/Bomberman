package functions;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class PlayerBomb extends Bomb{

	public PlayerBomb(Graphics g, int x, int y) {
		super(g, x, y);
		
	}
	private Image playerBombImage= Toolkit.getDefaultToolkit().getImage("image/playerBomb.png");
	private Image bomb1Image= Toolkit.getDefaultToolkit().getImage("image/bomb1.png");
	private Image bomb2Image= Toolkit.getDefaultToolkit().getImage("image/bomb2.png");
	public void draw(Graphics g) {

		if(!stop) time=time+1;
		if(time<100){
        g.drawImage(playerBombImage,bombX,bombY, 40,40,null);
		}
		
		
		if(time>=70&&time<85){
			g.setColor(Color.blue);
			g.drawImage(bomb2Image,bombX-bombSize, bombY, bombSize*3, bombSize,null);
			g.drawImage(bomb1Image,bombX, bombY-bombSize, bombSize, bombSize*3,null);
			setExplode(true);
		}
		if(time>80) explodeOver=true;
		
	}
	
         
}
