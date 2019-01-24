package functions;

import java.awt.Color;
import java.awt.Graphics;

public class EmemyBomb extends Bomb{

	public EmemyBomb(Graphics g, int x, int y) {
		super(g, x, y);
	}
	public void draw(Graphics g) {

		if(!stop) time=time+1;
		if(time<100){
        g.drawImage(getBombImage(),bombX,bombY, 40,40,null);
		}
		
		
		if(time>=70&&time<80){
			explode=true;
			g.setColor(Color.blue);
			g.fillRect(bombX-bombSize, bombY, bombSize*3, bombSize);
			g.fillRect(bombX, bombY-bombSize, bombSize, bombSize*3);
			setExplode(true);
		}
		if(time>80) explodeOver=true;
		
	}

}
