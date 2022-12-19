package monster;

import java.awt.Graphics;

import javax.swing.ImageIcon;

import view.View;

public class Frog extends monster {
	int checkimage;
	public Frog(View board) {
		super(board);
		// TODO Auto-generated constructor stub
		Initmonster();
	}
	public void Initmonster() {
		expgived= 10;
		checkimage=0;
		rangex=32;
		rangey=0;
		this.monsterdame = 2;
		this.atackspeed = 80;
		this.vel = 2;
		rangedetectx = 125;
		rangedetecty = 125;
		this.scalex = -1;
		this.height = 60;
		this.width = 60;
		this.maxhp = 20;
		monsternumim = 4;
		this.monsterim = new ImageIcon[19];
		this.monsterim[0] = new ImageIcon("src/Image/monster/Frog/moveleft1.png");
		this.monsterim[1] = new ImageIcon("src/Image/monster/Frog/moveleft2.png");
		this.monsterim[2] = new ImageIcon("src/Image/monster/Frog/moveleft3.png");
		this.monsterim[3] = new ImageIcon("src/Image/monster/Frog/moveleft4.png");
		this.monsterim[4] = new ImageIcon("src/Image/monster/Frog/moveright1.png");
		this.monsterim[5] = new ImageIcon("src/Image/monster/Frog/moveright2.png");
		this.monsterim[6] = new ImageIcon("src/Image/monster/Frog/moveright3.png");
		this.monsterim[7] = new ImageIcon("src/Image/monster/Frog/moveright4.png");
		this.monsteratk = new ImageIcon[10];
		this.monsteratk[0] = new ImageIcon("src/Image/monster/Frog/atkleft1.png");
		this.monsteratk[1] = new ImageIcon("src/Image/monster/Frog/atkleft2.png");
		this.monsteratk[2] = new ImageIcon("src/Image/monster/Frog/atkleft3.png");
		this.monsteratk[3] = new ImageIcon("src/Image/monster/Frog/atkleft4.png");
		this.monsteratk[4] = new ImageIcon("src/Image/monster/Frog/atkleft5.png");
		this.monsteratk[5] = new ImageIcon("src/Image/monster/Frog/atkright1.png");
		this.monsteratk[6] = new ImageIcon("src/Image/monster/Frog/atkright2.png");
		this.monsteratk[7] = new ImageIcon("src/Image/monster/Frog/atkright3.png");
		this.monsteratk[8] = new ImageIcon("src/Image/monster/Frog/atkright4.png");
		this.monsteratk[9] = new ImageIcon("src/Image/monster/Frog/atkright5.png");
		this.monsteratked = new ImageIcon[2];
		this.monsteratked[0] = new ImageIcon("src/Image/monster/Frog/atked1.png");
		this.monsteratked[1] = new ImageIcon("src/Image/monster/Frog/atked2.png");
		this.monsterdie = new ImageIcon("src/Image/monster/Frog/dying.png");
	}
	@Override
	public void atack(Graphics g) {
		
		if(atk<atackspeed) {
					if(scalex ==-1){
						if(atk/5<5) {
							if(atk/5==3) {
								if(checkimage==0) {
								mx = mx -32;
								checkimage++;
								}
								else if(checkimage<4) {
									checkimage++;
									
								}
								else {
									checkimage=0;
								}
								
							}
							else if(atk/5==4) {
								if(checkimage==0) {
									mx = mx +32;
									
									checkimage++;
									}
									else if(checkimage<4) {
										checkimage++;
									}
									else {
										checkimage=0;
									}
																}
								monster = monsteratk[atk/5].getImage();
						}
						else {
							monster = monsteratk[4].getImage();
							
							}
						}
						else {
							if(atk/5<5) {
								monster = monsteratk[atk/5+5].getImage();
								}
								else {
									monster = monsteratk[9].getImage();
									
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
