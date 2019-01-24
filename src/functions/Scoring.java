package functions;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class Scoring {
	private int gold=0;
	private int score=0;
	private int time=100;
	

	private boolean timeOver;
	private int k=0;
	private boolean stop;
	private static Image scoreImage= Toolkit.getDefaultToolkit().createImage("image/score.png");
	private static Image number0Image=Toolkit.getDefaultToolkit().createImage("image/number0.png");
	private static Image number1Image=Toolkit.getDefaultToolkit().createImage("image/number1.png");
	private static Image number2Image=Toolkit.getDefaultToolkit().createImage("image/number2.png");
	private static Image number3Image=Toolkit.getDefaultToolkit().createImage("image/number3.png");
	private static Image number4Image=Toolkit.getDefaultToolkit().createImage("image/number4.png");
	private static Image number5Image=Toolkit.getDefaultToolkit().createImage("image/number5.png");
	private static Image number6Image=Toolkit.getDefaultToolkit().createImage("image/number6.png");
	private static Image number7Image=Toolkit.getDefaultToolkit().createImage("image/number7.png");
	private static Image number8Image=Toolkit.getDefaultToolkit().createImage("image/number8.png");
	private static Image number9Image=Toolkit.getDefaultToolkit().createImage("image/number9.png");
	private static Image scoreTen=number0Image;
	private static Image scoreSingle=number0Image;
	private static Image goldTen=number0Image;
	private static Image goldSingle=number0Image;
	private static Image timeSingle=number0Image;
	private static Image timeTen=number0Image;
	private static Image timehundred=number1Image;

	public void draw(Graphics g) {
		g.drawImage(scoreImage,0,20,1600,95,null);
		g.drawImage(scoreTen,490,32,50,50,null);
		g.drawImage(scoreSingle,530,32,50,50,null);
		g.drawImage(goldTen,1150,32,50,50,null);
		g.drawImage(goldSingle,1190,32,50,50,null);
		g.drawImage(timehundred,1460,32,50,50,null);
		g.drawImage(timeTen,1500,32,50,50,null);
		g.drawImage(timeSingle,1540,32,50,50,null);
		k++;
		if(k==20&&time>0){
			if(!stop) time--;
			updataTime();
			k=0;
		}
		if(time==0){
			setTimeOver(true);
		}

		
	}

	public void updataScore() {
		switch(score%10){
		case 0:
			scoreSingle=number0Image;
			break;
		case 1:
			scoreSingle=number1Image;
			break;
		case 2:
			scoreSingle=number2Image;
			break;
		case 3:
			scoreSingle=number3Image;
			break;
		case 4:
			scoreSingle=number4Image;
			break;
		case 5:
			scoreSingle=number5Image;
			break;
		case 6:
			scoreSingle=number6Image;
			break;
		case 7:
			scoreSingle=number7Image;
			break;
		case 8:
			scoreSingle=number8Image;
			break;
		case 9:
			scoreSingle=number9Image;
			break;
		}
		switch(score/10){
		case 0:
		    scoreTen=number0Image;
			break;
		case 1:
			scoreTen=number1Image;
			break;
		case 2:
			scoreTen=number2Image;
			break;
		case 3:
			scoreTen=number3Image;
			break;
		case 4:
			scoreTen=number4Image;
			break;
		case 5:
			scoreTen=number5Image;
			break;
		case 6:
			scoreTen=number6Image;
			break;
		case 7:
			scoreTen=number7Image;
			break;
		case 8:
			scoreTen=number8Image;
			break;
		case 9:
			scoreTen=number9Image;
			break;
		}
		
	}
	public void updataGold() {
		switch(gold%10){
		case 0:
			goldSingle=number0Image;
			break;
		case 1:
			goldSingle=number1Image;
			break;
		case 2:
			goldSingle=number2Image;
			break;
		case 3:
			goldSingle=number3Image;
			break;
		case 4:
			goldSingle=number4Image;
			break;
		case 5:
			goldSingle=number5Image;
			break;
		case 6:
			goldSingle=number6Image;
			break;
		case 7:
			goldSingle=number7Image;
			break;
		case 8:
			goldSingle=number8Image;
			break;
		case 9:
			goldSingle=number9Image;
			break;
		}
		switch(gold/10){
		case 0:
		    goldTen=number0Image;
			break;
		case 1:
			goldTen=number1Image;
			break;
		case 2:
			goldTen=number2Image;
			break;
		case 3:
			goldTen=number3Image;
			break;
		case 4:
			goldTen=number4Image;
			break;
		case 5:
			goldTen=number5Image;
			break;
		case 6:
			goldTen=number6Image;
			break;
		case 7:
			goldTen=number7Image;
			break;
		case 8:
			goldTen=number8Image;
			break;
		case 9:
			goldTen=number9Image;
			break;
		}
		
	}
	public void updataTime() {
		switch(time%10){
		case 0:
			timeSingle=number0Image;
			break;
		case 1:
			timeSingle=number1Image;
			break;
		case 2:
			timeSingle=number2Image;
			break;
		case 3:
			timeSingle=number3Image;
			break;
		case 4:
			timeSingle=number4Image;
			break;
		case 5:
			timeSingle=number5Image;
			break;
		case 6:
			timeSingle=number6Image;
			break;
		case 7:
			timeSingle=number7Image;
			break;
		case 8:
			timeSingle=number8Image;
			break;
		case 9:
			timeSingle=number9Image;
			break;
		}
		switch(time/10%10){
		case 0:
		    timeTen=number0Image;
			break;
		case 1:
			timeTen=number1Image;
			break;
		case 2:
			timeTen=number2Image;
			break;
		case 3:
			timeTen=number3Image;
			break;
		case 4:
			timeTen=number4Image;
			break;
		case 5:
			timeTen=number5Image;
			break;
		case 6:
			timeTen=number6Image;
			break;
		case 7:
			timeTen=number7Image;
			break;
		case 8:
			timeTen=number8Image;
			break;
		case 9:
			timeTen=number9Image;
			break;
		}
		switch(time/100){
		case 0:
		    timehundred=number0Image;
			break;
		case 1:
			timehundred=number1Image;
			break;
		case 2:
			timehundred=number2Image;
			break;
		case 3:
			timehundred=number3Image;
			break;
		case 4:
			timehundred=number4Image;
			break;
		case 5:
			timehundred=number5Image;
			break;
		case 6:
			timehundred=number6Image;
			break;
		case 7:
			timehundred=number7Image;
			break;
		case 8:
			timehundred=number8Image;
			break;
		case 9:
			timehundred=number9Image;
			break;
		}
		
	}

	public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public boolean isTimeOver() {
		return timeOver;
	}

	public void setTimeOver(boolean timeOver) {
		this.timeOver = timeOver;
	}

	public boolean isStop() {
		return stop;
	}

	public void setStop(boolean stop) {
		this.stop = stop;
	}
	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	
}
