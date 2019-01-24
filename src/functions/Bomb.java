package functions;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;

import scene.Barrier;


public class Bomb {
 
	private Image bombImage= Toolkit.getDefaultToolkit().createImage("image/bomb.png");
	private Image bomb1Image= Toolkit.getDefaultToolkit().createImage("image/bomb1.png");
	private Image bomb2Image= Toolkit.getDefaultToolkit().createImage("image/bomb2.png");
	protected int bombX;
	protected int bombY;
	protected int time=0;
	protected int bombSize=40;
	private static int face=2 ;
	protected boolean explode;
	protected boolean explodeOver;
	public boolean isExplodeOver() {
		return explodeOver;
	}
	public void setExplodeOver(boolean explodeOver) {
		this.explodeOver = explodeOver;
	}
	protected Graphics g;
	protected boolean stop;
	
	public Bomb(Graphics g, int x, int y){
		this.g=g;
		this.bombX=x;
		this.bombY=y;
	}
	public void throwBomb(){
		g.setColor(Color.blue);
		switch (face) {
		case 1:
			bombX=bombX+bombSize;
			bombY=bombY+60;
			break;
		case 2:
			bombX=bombX+bombSize;
			bombY=bombY-bombSize;
			break;
		case 3:
			bombX=bombX+60;
			bombY=bombY+bombSize;
			break;
		case 4:
			bombX=bombX-bombSize;
			bombY=bombY+bombSize;
			break;
		}
		
	}
//	public void run(){
//		try{
//			System.out.println("开火");
//			    g.setColor(Color.black);
//			    g.fillOval(GameFrame.player.x, GameFrame.player.y, 40, 40);
//				Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//	}
	public void draw(Graphics g) {
	}
//	protected void hitCharacter() {
//		for (int i = 0; i < GameFrame.ememys.size(); i++){
//		if(this.hitEmemy(GameFrame.ememys.get(i))){
//			GameFrame.ememys.remove(i);
//			mf.addEmemy();
//			GameFrame.setScore(GameFrame.getScore() + 1);
//			Scoring.setScore(GameFrame.getScore());
//			
//		}
//		if(this.hitPlayer(GameFrame.player)){
//			GameFrame.ememys.remove(i);
//			mf.addEmemy();
//		}
//			for (int j = 0; j < GameFrame.barriers.size(); j++) {
//				if (this.hitBox(GameFrame.barriers.get(j))) {
//					GameFrame.barriers.remove(j);
//					
//				}
//			}
//		if(time==80) GameFrame.bombs.remove(this);
//		}
//	}
	
	public Rectangle getRect1() {
		return new Rectangle(bombX-bombSize+5, bombY, bombSize*3-10, bombSize);
	}
	public Rectangle getRect2() {
		return new Rectangle(bombX, bombY-bombSize+5, bombSize, bombSize*3-10);
	}
	public Rectangle getRectBomb() {
		return new Rectangle(bombX, bombY, bombSize, bombSize);
	}
//	public boolean hitEmemy(Ememy ememy) {
//		if(this.getRect1().intersects(ememy.getRect())||this.getRect2().intersects(ememy.getRect())) {
//			return true;
//		}
//		return false;
//	}	
//	protected boolean hitPlayer(Player player) {
//		if(this.getRect1().intersects(GameFrame.player.getRect())||this.getRect2().intersects(GameFrame.player.getRect())) {
////			System.out.println("玩家被炸死了");
//			GameFrame.player.setLive(false);
//			return true;
//		}
//		return false;
//	}
	protected boolean hitBox(Barrier barrier) {
		if(this.getRect1().intersects(barrier.getRectBarrier())||this.getRect2().intersects(barrier.getRectBarrier())) {
            if(barrier.getType()==2)  return true;
		}
		return false;
	}
	public Image getBombImage() {
		return bombImage;
	}
	public void setBombImage(Image bombImage) {
		this.bombImage = bombImage;
	}
	public Image getBomb1Image() {
		return bomb1Image;
	}
	public void setBomb1Image(Image bomb1Image) {
		this.bomb1Image = bomb1Image;
	}
	public Image getBomb2Image() {
		return bomb2Image;
	}
	public void setBomb2Image(Image bomb2Image) {
		this.bomb2Image = bomb2Image;
	}
	public boolean isExplode() {
		return explode;
	}
	public void setExplode(boolean explode) {
		this.explode = explode;
	}
	public boolean isStop() {
		return stop;
	}
	public void setStop(boolean stop) {
		this.stop = stop;
	}
}
