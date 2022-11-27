package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class startwindown {
	View board;
	Image img,Playgame,Option,Exit,inOption,inOption1,inOption2,Continue;
	public int option,optioni,dokho;
	public boolean inoption,paused;
	public startwindown(View board) {
		this.board = board;
		loadImage();
		option=1;
		optioni=1;
		inoption=false;
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
	}
	public void start(Graphics g) {
		g.drawImage(img,-600,-340,board);
		g.drawImage(Playgame,240,112,board);
		g.drawImage(Option,240,224,board);
		g.drawImage(Exit,240,336,board);
		g.setColor(Color.GREEN);
		if(optioni<=10) {
			if(option ==1) {
				g.drawRect(240, 112, 352, 80);
			}
			else if(option==2) {
				g.drawRect(240, 224, 352, 80);
			}
			else if(option==3) {
				g.drawRect(240, 336, 352, 80);
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
		g.drawImage(Continue,240,168,board);
		g.drawImage(Exit,240,336,board);
		g.setColor(Color.GREEN);
		if(optioni<=10) {
			if(option ==1) {
				g.drawRect(240, 168, 352, 80);
			}
			else if(option==2) {
				g.drawRect(240, 336, 352, 80);
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
