package scene;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class Box extends Barrier{
	public Box(int x, int y) {
		
		super(x, y);
		this.setType(2);
		
	}
	private Image boxImage= Toolkit.getDefaultToolkit().getImage("image/box.png");
	public void draw(Graphics g) {
		g.drawImage(boxImage, getBarrierX()*50, getBarrierY()*50+102, 50, 50, null);
		
	}
}
