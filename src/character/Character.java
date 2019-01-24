package character;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Character {
	protected int x;
	protected int y;
	protected int face = 2;
	protected int speed = 5;
	protected int playSize = 45;
	protected int moveType=2;
	public boolean stop;
	public int getPlaySize() {
		return playSize;
	}

	public void setPlaySize(int playSize) {
		this.playSize = playSize;
	}

	public void move() {
      if(!stop){
		switch (moveType) {
		case 1:
			y = y - speed;
			break;
		case 2:
			y = y + speed;
			break;
		case 3:
			x -= speed;
			break;
		case 4:
			x += speed;
			break;
		}
      }
	}
	
	//use rectangle to check for collision
	public Rectangle getRect() {
		return new Rectangle(getX(), getY(), playSize, playSize);
	}

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

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getMoveType() {
		return moveType;
	}

	public void draw(Graphics g) {
		
	}

	public void changeDirection() {
	}

	public int getStep() {
		return 0;
	}

	public void setMoveType(int moveType) {
		this.moveType = moveType;
	}

	public void setStep(int i) {
	
	}

	public void setLive(boolean b) {
		
	}

}
