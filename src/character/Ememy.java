package character;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Random;

public class Ememy extends Character{
		private int step=0;
		public int getStep() {
			return step;
		}
		public void setStep(int step) {
			this.step = step;
		}
		Random random=new Random();
		public Ememy(int ememyX,int ememyY){
			this.setX(ememyX);
			this.setY(ememyY);
//			changeDirection();
		}
		private Image ememyUp = Toolkit.getDefaultToolkit().createImage("image/ememyUp.png");
		private Image ememyDown = Toolkit.getDefaultToolkit().createImage("image/ememyDown.png");
		private Image ememyLeft = Toolkit.getDefaultToolkit().createImage("image/ememyLeft.png");
		private Image ememyRight= Toolkit.getDefaultToolkit().createImage("image/ememyRight.png");
		public void draw(Graphics g) {
			
			g.setColor(Color.lightGray);
			if(moveType!=0) {
				face = moveType;
			}
			switch(face){
			case 1:
				g.drawImage(ememyUp, getX(), getY(), playSize, playSize, null);
				break;
			case 2:
				g.drawImage(ememyDown, getX(), getY(), playSize, playSize, null);
				break;
			case 3:
				g.drawImage(ememyLeft, getX(), getY(), playSize, playSize, null);
				break;
			case 4:
				g.drawImage(ememyRight, getX(), getY(), playSize, playSize, null);
				break;
			}
				step++;
				
		}
		public void initStep() {
			step=random.nextInt(4)+1;
		}
		public void changeDirection() {
			moveType=random.nextInt(4)+1;
		}
//		public void move(){
//			
//			switch(moveType) {
//			case 1:
//				if (gameEmgine.canUp(getX(), getY(), playSize))
//				setY(getY() - getSpeed());
//				else
//					changeDirection();
//				break;
//			case 2:
//				if (gameEmgine.canDown(getX(), getY(), playSize))
//				setY(getY() + getSpeed());
//				else
//					changeDirection();
//				break;
//			case 3:
//				if (gameEmgine.canLeft(getX(), getY(), playSize))
//				setX(getX() - getSpeed());
//				else
//					changeDirection();
//				break;
//			case 4:
//				if (gameEmgine.canRight(getX(), getY(), playSize))
//				setX(getX() + getSpeed());
//				else
//					changeDirection();
//				break;
//
//			}
//		}
		
}
