package control;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import character.Character;
import character.Ememy;
import character.Player1;
import character.Player2;
import functions.Bomb;
import functions.EmemyBomb;
import functions.Gold;
import functions.PlayerBomb;
import functions.Props;
import functions.Scoring;
import functions.SpeedUp;
import scene.BackDrop;
import scene.Barrier;
import scene.Box;
import scene.Stone;
import sound.Music;

public class GameEngine {
	private int action = 100;
	private int time = 0;
	private Graphics g;
	private boolean result;
	private boolean stop;
	private boolean musicOff;
	private int score;
	private List<Bomb> bombs = new ArrayList<>();
	private List<Character> characters = new ArrayList<>();
	private List<Barrier> barriers = new ArrayList<>();
	private List<Props> props = new ArrayList<>();
	private Scoring scoring = new Scoring();
	private Music music = new Music();
	private int ememyLoc=0;
	private boolean haveSpeedUp;
	private int gold=0;
	private BackDrop backDrop = new BackDrop();
	private Image actionImage = Toolkit.getDefaultToolkit().getImage(
			"image/action1.jpg");
	private Image tooltipImage = Toolkit.getDefaultToolkit().getImage(
			"image/tooltip.png");
	private Image speedUpImage= Toolkit.getDefaultToolkit().createImage(
			"image/speedUp.png");
	private int playerNumber;
	public GameEngine() {
		this.setPlayerNumber(playerNumber);
	}

	public boolean isStop() {
		return stop;
	}

	public void setStop(boolean stop) {
		this.stop = stop;
	}

	public void keyPressed(KeyEvent e) {

		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			 
				characters.get(0).setMoveType(1);
			break;
		case KeyEvent.VK_DOWN:
			
				characters.get(0).setMoveType(2);
			break;
		case KeyEvent.VK_LEFT:
			
				characters.get(0).setMoveType(3);
			break;
		case KeyEvent.VK_RIGHT:

				characters.get(0).setMoveType(4);
			break;
		}
		if (e.isControlDown()) {
			if (bombs.size() == 0)
				bombs.add(new PlayerBomb(g, characters.get(0).getX(), characters.get(0).getY()));
			else {
				boolean canFire = true;
				for (int i = 0; i < bombs.size(); i++) {
					if (this.meetBomb(bombs.get(i), characters.get(0).getX(),
							characters.get(0).getY(), 40, 40)) {
						canFire = false;
					}
				}
				if (canFire)
					bombs.add(new PlayerBomb(g, characters.get(0).getX(), characters.get(0).getY()));
			}
		}
	}
	
	//make the player stop moving when the button is no longer pressed
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_RIGHT) {

			characters.get(0).setMoveType(0);

		}
	}

	public boolean canRight(int x, int y, int size) {
		if (x < 1560) {
			result = true;
			if (Barrier.getMap()[(y - 102) / 50][x / 50 + 1] == 1)
				result = false;
			for (int i = 0; i < barriers.size(); i++) {
				if (this.meetBarrier(barriers.get(i), x + size + 5, y + 5, 1,
						size - 10))
					result = false;
			}
			for (int i = 0; i < bombs.size(); i++) {
				if (this.meetBomb(bombs.get(i), x + size + 3, y + 5, 1,
						size - 10)
						&& this.meetBomb(bombs.get(i), x, y, size, size) == false
						) {
					result = false;
					break;
				}
			}
			return result;
		}
		return false;
	}
	//check if there is a barrier or a bomb beside the character
	public boolean canLeft(int x, int y, int size) {
		if (x > 0) {
			result = true;
			for (int i = 0; i < barriers.size(); i++) {
				if (this.meetBarrier(barriers.get(i), x - 5, y + 5, 1,
						size - 10))
					result = false;
			}
			for (int i = 0; i < bombs.size(); i++) {
				if (this.meetBomb(bombs.get(i), x - 3, y + 5, 1, size - 10)
						&& this.meetBomb(bombs.get(i), x, y, size, size) == false
						) {
					result = false;
					break;
				}
			}
			return result;
		}
		return false;
	}

	public boolean canDown(int x, int y, int size) {
		if (y < 832 - 40) {
			result = true;
			for (int i = 0; i < barriers.size(); i++) {
				if (this.meetBarrier(barriers.get(i), x + 5, y + size + 5,
						size - 10, 1))
					result = false;
			}
			for (int i = 0; i < bombs.size(); i++) {
				if (this.meetBomb(bombs.get(i), x + 10, y + size + 3,
						size - 20, 1)
						&& this.meetBomb(bombs.get(i), x, y, size, size) == false
						) {
					result = false;
					break;
				}
			}
			return result;
		}
		return false;
	}

	public boolean canUp(int x, int y, int size) {
		if (y > 102) {
			result = true;
			for (int i = 0; i < barriers.size(); i++) {
				if (this.meetBarrier(barriers.get(i), x + 5, y - 5, size - 10,
						1))
					result = false;
			}
			for (int i = 0; i < bombs.size(); i++) {
				if (this.meetBomb(bombs.get(i), x + 10, y - 5, size - 20, 1)
						&& this.meetBomb(bombs.get(i), x, y, size, size) == false
						) {
					result = false;
					break;
				}
			}
			return result;
		}
		return false;
	}

	public Rectangle getRectPlayer(int x2, int y2, int sizeX, int sizeY) {
		return new Rectangle(x2, y2, sizeX, sizeY);
	}

	public boolean meetBomb(Bomb bomb, int x2, int y2, int sizeX, int sizeY) {
		if (this.getRectPlayer(x2, y2, sizeX, sizeY).intersects(
				bomb.getRectBomb())) {
			return true;
		}
		return false;
	}

	public boolean meetBarrier(Barrier barrier, int x2, int y2, int sizeX,
			int sizeY) {
		if (this.getRectPlayer(x2, y2, sizeX, sizeY).intersects(
				barrier.getRectBarrier())) {
			return true;
		}
		return false;
	}

	public void draw(Graphics g) {

		if (action <= 150) {
			action++;
			g.drawImage(actionImage, 0, 32, 1600, 1002, null);
			if (action == 150&&!musicOff) {
				music.start();
			}

		} else {
			scoring.draw(g);
			if(scoring.isTimeOver()&&stop==false){
				gameStop();
				
				JOptionPane.showMessageDialog(null, "Times up!", "You win!",
						JOptionPane.INFORMATION_MESSAGE);
			}
			backDrop.draw(g);
			drawTooltip(g);
			for (int i = 0; i < props.size(); i++) {
				props.get(i).draw(g);
			}
			if((characters.size()==0)){
				if(playerNumber==2)
				  characters.add(new Player2());
				else{
					characters.add(new Player1());
				}
			}
			if (!stop) {
				if (characters.size() < 3 && time == 70) {
					addEmemy();
				}
			}
			for (int i = 0; i < bombs.size(); i++) {
				bombs.get(i).draw(g);
				if(bombs.get(i).isExplode()){
//					System.out.println("bomb");
				   if(hitCharacter(characters.get(0),bombs.get(i))) 
//					   System.err.println("player hurt");
					   characters.get(0).setLive(false); 
				   for(int k = 1; k < characters.size(); k++){
					   if(hitCharacter(characters.get(k),bombs.get(i))){
						   characters.remove(k); 
						   scoring.setScore(scoring.getScore() + 1);
						   scoring.updataScore();
					   }
				   }
				   for(int k = 0; k < barriers.size(); k++){
				   if(hitBox(barriers.get(k), bombs.get(i))) barriers.remove(k);
				   }
				}
				if(bombs.get(i).isExplodeOver())
					bombs.remove(i);
			}
			for (int i = 0; i < barriers.size(); i++) {
				barriers.get(i).draw(g);
			}
			for (int i = 0; i < characters.size(); i++) {
				characters.get(i).draw(g);
				if (!stop) {
					if (canMove(characters.get(i))) {
						characters.get(i).move();
					} else {

						characters.get(i).changeDirection();
					}
					while (characters.get(i).getStep() == 100) {
						characters.get(i).changeDirection();
						bombs.add(new EmemyBomb(g, characters.get(i).getX(),
								characters.get(i).getY()));
						characters.get(i).setStep(0);
					}
				}

			}
//            ghost.draw(g);
			characters.get(0).draw(g);
			if(canMove(characters.get(0))){
				characters.get(0).move();
				eatProps();
			}
			time++;
			if(time==71) time=0;

		}
	}

	public void gameStop() {
		stop=true;
		for (int i = 0; i <characters.size(); i++) {
			characters.get(i).stop=true;
		}
		for (int i = 0; i <bombs.size(); i++) {
			bombs.get(i).setStop(true);
		}
		scoring.setStop(true);
		music.setPlayStop(true);
	}
	public void gameContinue() {
		stop=false;
		for (int i = 0; i <characters.size(); i++) {
			characters.get(i).stop=false;
		}
		for (int i = 0; i <bombs.size(); i++) {
			bombs.get(i).setStop(false);
		}
		scoring.setStop(false);
		music.setPlayStop(false);
	}

	private void drawTooltip(Graphics g) {
		g.drawImage(tooltipImage, 200, 902, 1400, 100, null);
		if(haveSpeedUp){
	 		   g.drawImage(speedUpImage,510, 913, 80, 80,null);		  
	 	   }
	}

	private void eatProps() {
		for(int i=0;i<props.size();i++){
			if(props.get(i).getX()+20>characters.get(0).getX()&&props.get(i).getX()+20<characters.get(0).getX()+50
   				&&props.get(i).getY()+20>characters.get(0).getY()&&props.get(i).getY()+20<characters.get(0).getY()+50){
   			     if(props.get(i).getType()==1){
   			    	 scoring.setGold(scoring.getGold() + 1);
   			    	 scoring.updataGold();
   			     }
   			     if(props.get(i).getType()==2){
   			    	 this.haveSpeedUp=true;
   			    	 System.out.println("Speed up");
   			    	 characters.get(0).setSpeed(characters.get(0).getSpeed()+3);
   			     }
   			 props.remove(i);
   		}
	  }
		
	}

	private boolean canMove(Character character2) {
		switch (character2.getMoveType()) {
		case 1:
			if (canUp(character2.getX(), character2.getY(), character2.getPlaySize())) {
				return true;
			}
			
			break;
		case 2:
			if (canDown(character2.getX(), character2.getY(),character2.getPlaySize())) {
				return true;
			}
			break;
		case 3:
			if (canLeft(character2.getX(), character2.getY(),character2.getPlaySize())){
				return true;
			}
			break;
		case 4:
			if (canRight(character2.getX(), character2.getY(),character2.getPlaySize())){
				return true;
			}
			break;
		}
		return false;
	}

//	private void HitCharacter(Bomb bomb) {
//		
//		
//	}

	public void addEmemy() {
		int ememyX = 540;
		int ememyY = 500;
		switch (ememyLoc) {
		case 0:
			ememyX = 700;
			ememyY = 300;
			ememyLoc++;
			break;
		case 1:
			ememyX = 1000;
			ememyY = 300;
			ememyLoc--;
			break;
		}
		characters.add(new Ememy(ememyX, ememyY));
	}

	private void addProps(int i, int j) {
		if((i+j)%2==0){
		props.add(new SpeedUp(j,i));
		}else{
			props.add(new Gold(j,i));
		}
	}
	public void addBarrier() {
		for(int i=0;i<16;i++){
			for(int j=0;j<32;j++){
				if(Barrier.map[i][j]==1){
					barriers.add(new Stone(j,i));
				}else if(Barrier.map[i][j]==3){
					barriers.add(new Box(j,i));
					addProps(i, j);
				}
			}
		}
	}
	protected boolean hitCharacter(Character character2,Bomb bomb2) {
		if(bomb2.getRect1().intersects(character2.getRect())|| bomb2.getRect2().intersects(character2.getRect())) {
//			System.out.println("Player is killed by bomb");
	
//			player.setLive(false);
			return true;
		}
		return false;
	}
	protected boolean hitBox(Barrier barrier,Bomb bomb) {
		if(bomb.getRect1().intersects(barrier.getRectBarrier())|| bomb.getRect2().intersects(barrier.getRectBarrier())) {
            if(barrier.getType()==2)  return true;
		}
		return false;
	}

	public boolean isMusicOff() {
		return musicOff;
	}

	public void setMusicOff(boolean musicOff) {
		this.musicOff = musicOff;
	}

	public int getPlayerNumber() {
		return playerNumber;
	}

	public void setPlayerNumber(int playerNumber) {
		this.playerNumber = playerNumber;
	}


}
