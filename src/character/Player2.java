package character;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class Player2 extends Character{
	
	private boolean live=true;
	public Player2(){
		this.setX(0);
		this.setY(102);
		this.speed=3;
	}
	private Image moveDown = Toolkit.getDefaultToolkit().createImage("image/moveDown.png");
	private Image moveLeft = Toolkit.getDefaultToolkit().createImage("image/moveLeft.png");
	private Image moveRight= Toolkit.getDefaultToolkit().createImage("image/moveRight.png");
	private Image moveUp=Toolkit.getDefaultToolkit().getImage("image/moveUp.png");;
	private Image deadImage= Toolkit.getDefaultToolkit().createImage("image/dead1.png");
	public void draw(Graphics g) {
		if (isLive()) {
			if (getMoveType() != 0)
				face = getMoveType();
			switch (face) {
			case 1:
				g.drawImage(moveUp, getX(), getY(), playSize, playSize, null);
				break;
			case 2:
				g.drawImage(moveDown, getX(), getY(), playSize, playSize, null);
				break;
			case 3:
				g.drawImage(moveLeft, getX(), getY(), playSize, playSize, null);
				break;
			case 4:
				g.drawImage(moveRight, getX(), getY(), playSize, playSize, null);
				break;
			}
		}
		
		else{
			g.drawImage(deadImage,100,0,1200,600,null);
		}
	}
	public void setMoveType(int moveType) {
		this.moveType = moveType;
	}
	public boolean isLive() {
		return live;
	}
	public void setLive(boolean live) {
		this.live = live;
	}
}
