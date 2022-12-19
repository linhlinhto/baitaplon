package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class StartMenu {
	View board;
	Image img,Playgame,Option,Exit,inOption,inOption1,inOption2,Continue,Help,helpboard, Playagain, Menu;
	public int option,optioni,dokho;
	public boolean inoption,paused,inHelp;
	public StartMenu(View board) {
		this.board = board;
		loadImage();
		option=1;
		optioni=1;
		inoption=false;
		inHelp = false;
		dokho=1;
		paused = false;
	}
	public void loadImage() {
		ImageIcon img = new ImageIcon("src/Image/Start/startmap.png");
		this.img = img.getImage();
		ImageIcon Playgame = new ImageIcon("src/Image/Start/Playgame.png");
		this.Playgame = Playgame.getImage();
		ImageIcon Option = new ImageIcon("src/Image/Start/option.png");
		this.Option = Option.getImage();
		ImageIcon Exit = new ImageIcon("src/Image/Start/Exit.png");
		this.Exit = Exit.getImage();
		ImageIcon inOption = new ImageIcon("src/Image/Start/inOption.png");
		this.inOption = inOption.getImage();
		ImageIcon inOption1 = new ImageIcon("src/Image/Start/inOptionde.png");
		this.inOption1 = inOption1.getImage();
		ImageIcon inOption2 = new ImageIcon("src/Image/Start/inOptionkho.png");
		this.inOption2 = inOption2.getImage();
		ImageIcon Continue = new ImageIcon("src/Image/Start/continue.png");
		this.Continue = Continue.getImage();
		ImageIcon Help = new ImageIcon("src/Image/Start/help.png");
		this.Help = Help.getImage();
		ImageIcon Helpboard = new ImageIcon("src/Image/Start/helpboard.png");
		this.helpboard = Helpboard.getImage();
		ImageIcon Playagain = new ImageIcon("src/Image/Start/playagain.png");
		this.Playagain = Playagain.getImage();
		ImageIcon Menu = new ImageIcon("src/Image/Start/menu.png");
		this.Menu = Menu.getImage();
	}
	public void start(Graphics g) {
		if(inHelp) {
			Help(g);
		}
		else if (inoption) {
			Option(g);
		}
		else {
		g.drawImage(img,-600,-340,board);
		g.drawImage(Playgame,240,60,board);
		g.drawImage(Option,240,160,board);
		g.drawImage(Help,240,260,board);
		g.drawImage(Exit,240,360,board);
		g.setColor(Color.GREEN);
		if(optioni<=10) {
			if(option ==1) {
				g.drawRect(240, 60, 352, 80);
			}
			else if(option==2) {
				g.drawRect(240, 160, 352, 80);
			}
			else if(option==3) {
				g.drawRect(240, 260, 352, 80);
			}
			else if(option==4) {
				g.drawRect(240, 360, 352, 80);
			}
			optioni++;
		}
		else if(optioni<20) {
			optioni++;
		}
		else {
			optioni=1;
		}
		}
		
	}
	public void Option(Graphics g) {
		g.drawImage(img,-600,-340,board);
		g.drawImage(inOption,0,112,board);
		g.drawImage(inOption1,240,288,board);
		g.drawImage(inOption2,240,400,board);
		g.setColor(Color.GREEN);
		if(optioni<=10) {
			if(option ==1) {
				g.drawRect(240, 288, 352, 80);
			}
			else if(option==2) {
				g.drawRect(240, 400, 352, 80);
			}
			optioni++;
		}
		else if(optioni<20) {
			optioni++;
		}
		else {
			optioni=1;
		}
	}
	public void Paused(Graphics g) {
		g.drawImage(img,-600,-340,board);
		g.drawImage(Continue,240,100,board);
		g.drawImage(Menu,240,220,board);
		g.drawImage(Exit,240,340,board);
		g.setColor(Color.GREEN);
		if(optioni<=10) {
			if(option ==1) {
				g.drawRect(240, 100, 352, 80);
			}
			else if(option==2) {
				g.drawRect(240, 220, 352, 80);
			}
			else if(option == 3) {
				g.drawRect(240, 340, 352, 80);
			}
			
			optioni++;
		}
		else if(optioni<20) {
			optioni++;
		}
		else {
			optioni=1;
		}
	}
	public void Help(Graphics g) {
		g.drawImage(img,-600,-340,board);
		g.drawImage(helpboard, 230, 160, board);
	}
	 public void gameOver(Graphics g) {
		 String msg;
	        if(board.win) {
	         msg = "You Win";
	        }
	        else {
	        	 msg = "You Lose";
	        }
	        Font small = new Font("Helvetica", Font.BOLD, 36);
	        g.setColor(Color.red);
	        g.setFont(small);
	        g.drawString(msg, 336, 80);
	        g.drawImage(Playagain,240,140,board);
	        g.drawImage(Menu,240,260,board);
			g.drawImage(Exit,240,380,board);
			g.setColor(Color.GREEN);
			if(optioni<=10) {
				if(option ==1) {
					g.drawRect(240, 140, 352, 80);
				}
				else if(option==2) {
					g.drawRect(240, 260, 352, 80);
				}
				else if(option == 3 ) {
					g.drawRect(240, 380, 352, 80);
				}
				
				
				optioni++;
			}
			else if(optioni<20) {
				optioni++;
			}
			else {
				optioni=1;
			}
	    }
}
