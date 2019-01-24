package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import control.GameEngine;


public class GameFrame extends Frame{
	private JButton stopButton=new JButton();
	//private JButton archiveButton=new JButton();
	private Image offScreenImage = null;
	private GameEngine gameEngine=new GameEngine();
	private int playerNumber=1;
	private boolean musicOff;
	private Image tubiaoImage= Toolkit.getDefaultToolkit().getImage("image/tubiao.png");
	
	@Override
	public void paint(Graphics g) {
		gameEngine.draw(g);
			super.paint(g);
	}

	public void lauchFrame() {
		this.setLayout(null);
		this.setSize(1600, 1002);
		this.setTitle("Bubble war");
		this.setIconImage(tubiaoImage);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		this.setResizable(false);
		this.setBackground(Color.black);
		this.setLocation(180, 0);
		this.addKeyListener(new KeyMonitor());
		this.add(stopButton);
		stopButton.setBounds(0, 902, 200, 100);
		Font f=new Font("Arial",Font.BOLD,40);
		stopButton.setFont(f);
		stopButton.setText("Pause");
		stopButton.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent event) {
				stopButtonMouseMouseClicked(event);		
			}		
			
		});
		
		setVisible(true);
		new Thread(new PaintThread()).start();
	}
	


	public void update(Graphics g) {
		if(offScreenImage == null) {
			offScreenImage = this.createImage(1600,1002);
		}
		Graphics gOffScreen = offScreenImage.getGraphics();
		Color c = gOffScreen.getColor();
		gOffScreen.setColor(Color.lightGray);
		gOffScreen.fillRect(0, 0, 1600, 1002);
		gOffScreen.setColor(c);
		paint(gOffScreen);
		g.drawImage(offScreenImage, 0, 0, null);
	}

	public void gameStart() {
//		gameEngine = new GameEngine();
		gameEngine.setPlayerNumber(this.getPlayerNumber());
		gameEngine.setMusicOff(this.musicOff);
		lauchFrame();
		gameEngine.addBarrier();
		requestFocus();
	
	}
	
	
	private class PaintThread implements Runnable {

		public void run() {
			while(true) {
				repaint();
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	private class KeyMonitor extends KeyAdapter {
		public void keyReleased(KeyEvent e) {
			if(!gameEngine.isStop())
			gameEngine.keyReleased(e);
		}

		public void keyPressed(KeyEvent e) {
//			if(!GameEngine.isStop()) 
			gameEngine.keyPressed(e);
		}
		
	}
	protected void stopButtonMouseMouseClicked(MouseEvent event) {
		gameEngine.setStop(!gameEngine.isStop());
		if(gameEngine.isStop()){
		  this.stopButton.setText("Continue");
		  gameEngine.gameStop();
//		  this.music.suspend();
		  
		}else{
			this.stopButton.setText("Pause");
			gameEngine.gameContinue();
		}
		this.requestFocus();
		
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
