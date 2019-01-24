package ui;

import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class StartFrame extends JFrame {
	private int page=1;
	private int tip=1;
	private JPanel pane = null;
	private CardLayout card = null;
	private JPanel p1 = null, p2 = null, p3 = null, p4 = null;
	private Image tubiaoImage= Toolkit.getDefaultToolkit().getImage("image/tubiao.png");
	private Image selectImage = Toolkit.getDefaultToolkit().getImage("image/select.png");
	private Image player1Image = Toolkit.getDefaultToolkit().getImage("image/player1.png");
	private Image player2Image = Toolkit.getDefaultToolkit().getImage("image/player2.png");
	
	private Image caidanImage=Toolkit.getDefaultToolkit().getImage("image/menu.jpg");
	private Image settingImage=Toolkit.getDefaultToolkit().getImage("image/setting.jpg");
	private GameFrame gameFrame = new GameFrame();
	private Button startButton = new Button("Start Game");
	private Button exitButton = new Button("Quit");
	private Button settingButton=new Button("Setting");
	private Button selectPlayerButton = new Button("Character");
	private Button player2Button = new Button("Cheracter 2");
	private Button player1Button = new Button("Character 1");
	private Button musicOnButton = new Button("Music on");
	private Button musicOffButton = new Button("Music off");
	private Button difficultyButton = new Button("Difficulty");
	private Button backButton = new Button("Back");
	private Button nextButton = new Button("Next");

	public StartFrame() {
		super("Bubble War");
		try {
			
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		card = new CardLayout(5, 5);
		pane = new JPanel(card); 
		p1 = new JPanel();
		p2 = new JPanel();
		p2.setLayout(null);
		p3 = new JPanel();
		p3 = new JPanel();
		p4 = new JPanel();
		p4.setLayout(null);
		p2.setBackground(Color.BLUE);
		p3.setBackground(Color.GREEN);
		p1.add(new JLabel("JPanel_1"));
		p2.add(new JLabel("JPanel_2"));
		p3.add(new JLabel("JPanel_3"));
		pane.add(p1, "p1");
		pane.add(p2, "p2");
		pane.add(p3, "p3");
		
		this.getContentPane().add(pane);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(520, 420);
        this.setLocation(710, 300);
		this.setBackground(Color.LIGHT_GRAY);
		this.setIconImage(tubiaoImage);
		p1.setLayout(null);
		
		startButton.setLocation(140, 100);
		startButton.setSize(90, 30);
		startButton.setBackground(Color.white);
		startButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					 gameFrame.gameStart();
					 dispose();
				}
			});
		p1.add(startButton);

		selectPlayerButton.setLocation(140, 150);
		selectPlayerButton.setBackground(Color.green);
		selectPlayerButton.setSize(90, 30);
		p1.add(selectPlayerButton);

		settingButton.setLocation(140, 200);
		settingButton.setBackground(Color.green);
		settingButton.setSize(90, 30);
		
		settingButton.addMouseListener(new MouseAdapter() {
	         @Override
	        public void mouseClicked(MouseEvent e) {
	        	 settingButtonClick();
	        }
		});
		p1.add(settingButton);
		
		exitButton.setLocation(140, 300);
		exitButton.setBackground(Color.green);
		exitButton.setSize(90, 30);
		exitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
				
			}
		});
		p1.add(exitButton);
		
		player2Button.setLocation(165, 110);
		player2Button.setSize(100, 100);
		player2Button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				player2ButtonClick(e);
				
			}
		});
		p2.add(player2Button);
		player1Button.setLocation(40, 110);
		player1Button.setSize(100, 100);
		player1Button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				gameFrame.setPlayerNumber(1);
				player1ButtonClick(e);
			}
		});
		p2.add(player1Button);
		
		selectPlayerButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				selectPlayerButtonClick(e);
			}
		});
		p3.setLayout(null);
		musicOnButton.setLocation(140, 100);
		musicOnButton.setBackground(Color.green);
		musicOnButton.setSize(90, 30);
		musicOnButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				gameFrame.setMusicOff(false);
				JOptionPane.showMessageDialog(null, "Music is on", "Setting",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		p3.add(musicOnButton);
		
		musicOffButton.setLocation(140, 150);
		musicOffButton.setBackground(Color.green);
		musicOffButton.setSize(90, 30);
		musicOffButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				gameFrame.setMusicOff(true);
				JOptionPane.showMessageDialog(null, "Music is off", "Setting",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		p3.add(musicOffButton);
		
		difficultyButton.setLocation(140, 200);
		difficultyButton.setBackground(Color.green);
		difficultyButton.setSize(90, 30);
		difficultyButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "Not done yet", "Sorry",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		p3.add(difficultyButton);
		
		backButton.setLocation(10, 310);
		backButton.setBackground(Color.green);
		backButton.setSize(90, 30);
		backButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				backButtonClick(e);
			}
		});
		nextButton.setLocation(120, 310);
		nextButton.setBackground(Color.green);
		nextButton.setSize(90, 30);
		nextButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(tip<3) tip++;
				else tip=1;
			}
		});
		p4.add(nextButton);
		
		this.setVisible(true);
	}

	protected void readButtonClick() throws Exception  {
		gameFrame.gameStart();
		//gameFrame.readArchive(); 
		dispose();
		
	}

	protected void backButtonClick(MouseEvent e) {
		
		card.show(pane, "p1");
		page=1;
		
	}

	protected void settingButtonClick() {
		System.out.println("Page Setting");
		card.show(pane, "p3");
		page=3;
		p3.add(backButton);
	}

	protected void player1ButtonClick(MouseEvent e) {
		int result=JOptionPane.showConfirmDialog(null, "Choose A?","Confirmed",JOptionPane.YES_NO_OPTION);
		if (result == 0) {
			gameFrame.setPlayerNumber(1);
		}
		
	}

	protected void player2ButtonClick(MouseEvent e) {
		int result=JOptionPane.showConfirmDialog(null, "Choose B?","Confirmed",JOptionPane.YES_NO_OPTION);
		if (result == 0) {
			gameFrame.setPlayerNumber(2);
		}
	}

	protected void selectPlayerButtonClick(MouseEvent e) {
		card.show(pane, "p2");
		page=2;
		p2.add(backButton);
		
		
	}
    
	protected void helpButtonClicked(MouseEvent event) {
		card.show(pane, "p4");
		page=4;
		p4.add(backButton);
	}
	Graphics g2;

	@Override
	public void paint(Graphics g) {
		if(page==1){
		g2 = this.p1.getGraphics();
		g2.drawImage(caidanImage, 0, 0,480,350,null);
		
		}
		if(page==2){
			g2 = this.p2.getGraphics();
			g2.drawImage(selectImage, 0, 0,480,350, null);
			g2=this.player2Button.getGraphics();
			g2.drawImage(player2Image, 1, 1,98,98, null);
			g2=this.player1Button.getGraphics();
			g2.drawImage(player1Image, 1, 1,98,98, null);
		}
		if(page==3){
			g2 = this.p3.getGraphics();
			g2.drawImage(settingImage, 0, 0,480,350, null);
		}
		
		this.repaint();
	}

}
