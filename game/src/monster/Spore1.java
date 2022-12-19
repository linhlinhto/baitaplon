package monster;

import java.awt.Graphics;

import javax.swing.ImageIcon;

import view.View;

public class Spore1 extends monster {
	int checkimage;
	public Spore1(View board) {
		super(board);
		// TODO Auto-generated constructor stub
		Initmonster();
	}
	public void Initmonster() {
		expgived= 10;
		checkimage=0;
		rangex=16;
		rangey=0;
		this.monsterdame = 2;
		this.atackspeed = 80;
		this.vel = 2;
		this.scalex = -1;
		this.height = 48;
		this.width = 48;
		rangedetectx = 150;
		rangedetecty = 150;
		this.maxhp = 30;
		monsternumim = 2;
		this.monsterim = new ImageIcon[19];
		this.monsterim[0] = new ImageIcon("src/Image/monster/Spore/L1.png");
		this.monsterim[1] = new ImageIcon("src/Image/monster/Spore/L2.png");
		this.monsterim[2] = new ImageIcon("src/Image/monster/Spore/R1.png");
		this.monsterim[3] = new ImageIcon("src/Image/monster/Spore/R2.png");
		this.monsteratk = new ImageIcon[10];
		this.monsteratk[0] = new ImageIcon("src/Image/monster/Spore/Atkl1.png");
		this.monsteratk[1] = new ImageIcon("src/Image/monster/Spore/Atkl2.png");
		this.monsteratk[2] = new ImageIcon("src/Image/monster/Spore/Atkl3.png");
		this.monsteratk[3] = new ImageIcon("src/Image/monster/Spore/Atkr1.png");
		this.monsteratk[4] = new ImageIcon("src/Image/monster/Spore/Atkr2.png");
		this.monsteratk[5] = new ImageIcon("src/Image/monster/Spore/Atkr3.png");
		this.monsteratked = new ImageIcon[2];
		this.monsteratked[0] = new ImageIcon("src/Image/monster/Spore/Atkdl.png");
		this.monsteratked[1] = new ImageIcon("src/Image/monster/Spore/Atkdr.png");
		this.monsterdie = new ImageIcon("src/Image/monster/Spore/Die.png");
	}
	@Override
	public void atack(Graphics g) {
		
		if(atk<atackspeed) {
					if(scalex ==-1){
						if(atk/5<3) {
								monster = monsteratk[atk/5].getImage();
						}
						else {
							monster = monsteratk[0].getImage();
							
							}
						}
						else {
							if(atk/5<3) {
								monster = monsteratk[atk/5+3].getImage();
								}
								else {
									monster = monsteratk[3].getImage();
									
								}
						}
					atk++;
					if(atk==atackspeed/4) {
						board.pm.mau -= monsterdame;
						board.pm.Thanhmau(g);
					}
		}
		else {
			atack = false;
			
			atk = 0;
		}
		

		
	}
}