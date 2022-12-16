package monster;

import java.awt.Graphics;

import javax.swing.ImageIcon;

import view.View;

public class Asimole1 extends monster {
	int checkimage;
	public Asimole1(View board) {
		super(board);
		// TODO Auto-generated constructor stub
		Initmonster();
	}
	public void Initmonster() {
		expgived= 10;
		checkimage=0;
		rangex=32;
		rangey=0;
		this.monsterdame = 20;
		this.atackspeed = 80;
		this.vel = 2;
		this.scalex = -1;
		this.height = 100;
		this.width = 100;
		this.maxhp = 500;
		monsternumim = 4;
		this.rangedetectx=200;
		this.rangedetecty=200;
		this.monsterim = new ImageIcon[19];
		this.monsterim[0] = new ImageIcon("src/Image/monster/Asimole1/L1.png");
		this.monsterim[1] = new ImageIcon("src/Image/monster/Asimole1/L2.png");
		this.monsterim[2] = new ImageIcon("src/Image/monster/Asimole1/L3.png");
		this.monsterim[3] = new ImageIcon("src/Image/monster/Asimole1/L4.png");
		this.monsterim[4] = new ImageIcon("src/Image/monster/Asimole1/R1.png");
		this.monsterim[5] = new ImageIcon("src/Image/monster/Asimole1/R2.png");
		this.monsterim[6] = new ImageIcon("src/Image/monster/Asimole1/R3.png");
		this.monsterim[7] = new ImageIcon("src/Image/monster/Asimole1/R4.png");
		this.monsteratk = new ImageIcon[10];
		this.monsteratk[0] = new ImageIcon("src/Image/monster/Asimole1/Atkl1.png");
		this.monsteratk[1] = new ImageIcon("src/Image/monster/Asimole1/Atkk2.png");
		this.monsteratk[5] = new ImageIcon("src/Image/monster/Asimole1/Atkr1.png");
		this.monsteratk[6] = new ImageIcon("src/Image/monster/Asimole1/Atkr2.png");
		this.monsteratked = new ImageIcon[2];
		this.monsteratked[0] = new ImageIcon("src/Image/monster/Asimole1/Atkdl.png");
		this.monsteratked[1] = new ImageIcon("src/Image/monster/Asimole1/Atkdr.png");
		this.monsterdie = new ImageIcon("src/Image/monster/Asimole1/Die.png");
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
