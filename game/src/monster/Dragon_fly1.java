package monster;

import java.awt.Graphics;

import javax.swing.ImageIcon;

import view.View;
import java.awt.Image;

public class Dragon_fly1 extends monster {

	Image cau;
	ImageIcon cau2;
	int speedcau=6;
	int caux,cauy,c=0;

	public Dragon_fly1(View board) {
		super(board);
		// TODO Auto-generated constructor stub
		Initmonster();
	}
	public void Initmonster() {
		expgived= 45; // diem giet quai
		
		rangex=100; //pham vi ra don
		rangey=100; //pham vi ra don
		this.monsterdame = 4; //diem tan cong
		this.atackspeed = 60; //toc do ra don
		this.vel = 2;// toc do di chuyen
		this.scalex = -1; // chieu di chuyen: -1 di trai, 1 di phai
		this.height = 80; // chieu cao quai
		this.width = 80; //chieu rong quai
		this.maxhp = 10; //mau quai
		monsternumim = 4; //so luong hinh anh quai di chuyen
		this.rangedetectx=175;
		this.rangedetecty=175;
		this.monsterim = new ImageIcon[19];
		this.monsterim[0] = new ImageIcon("src/Image/monster/Dragon_fly1/Left_1.png");
		this.monsterim[1] = new ImageIcon("src/Image/monster/Dragon_fly1/Left_2.png");
		this.monsterim[2] = new ImageIcon("src/Image/monster/Dragon_fly1/Left_3.png");
		this.monsterim[3] = new ImageIcon("src/Image/monster/Dragon_fly1/Left_4.png");
		this.monsterim[4] = new ImageIcon("src/Image/monster/Dragon_fly1/Right_1.png");
		this.monsterim[5] = new ImageIcon("src/Image/monster/Dragon_fly1/Right_2.png");
		this.monsterim[6] = new ImageIcon("src/Image/monster/Dragon_fly1/Right_3.png");
		this.monsterim[7] = new ImageIcon("src/Image/monster/Dragon_fly1/Right_4.png");
		this.monsteratk = new ImageIcon[10];
		this.monsteratk[0] = new ImageIcon("src/Image/monster/Dragon_fly1/Attack_left_1.png");
		this.monsteratk[1] = new ImageIcon("src/Image/monster/Dragon_fly1/Attack_left_2.png");
		this.monsteratk[2] = new ImageIcon("src/Image/monster/Dragon_fly1/Attack_left_3.png");
		
		this.monsteratk[3] = new ImageIcon("src/Image/monster/Dragon_fly1/Attack_right_1.png");
		this.monsteratk[4] = new ImageIcon("src/Image/monster/Dragon_fly1/Attack_right_2.png");
		this.monsteratk[5] = new ImageIcon("src/Image/monster/Dragon_fly1/Attack_right_3.png");
		cau2=new ImageIcon("src/Image/monster/Dragon_fly1/Toxic.png");
		cau=cau2.getImage();

		
		this.monsteratked = new ImageIcon[2];
		this.monsteratked[0] = new ImageIcon("src/Image/monster/Dragon_fly1/Attacked_left.png");
		this.monsteratked[1] = new ImageIcon("src/Image/monster/Dragon_fly1/Attacked_right.png");
		this.monsterdie = new ImageIcon("src/Image/monster/Dragon_fly1/Died.png");
	}
	@Override
	public void atack(Graphics g) {
		
		if(atk<atackspeed) {
					if(scalex ==-1){
						if(atk/6<3) {
							
																
								monster = monsteratk[atk/6].getImage();
						}
						else {
							monster = monsteratk[0].getImage();
							
							}
						}
						else {
							if(atk/6<3) {
								monster = monsteratk[atk/6+3].getImage();
								}
								else {
									monster = monsteratk[3].getImage();
									
								}
						}
					atk++;

					
		}
		if(atk==atackspeed) {
			bandoc(g);

		}
		
		

		
	}
	public void bandoc(Graphics g) {
		if (c==0) {
			caux=mx-board.pm.dichx;
		cauy=my-board.pm.dichy;
		c++;
		}
		else  {
			if(((board.pm.mx-caux)*scalex)>=0 ) {
				caux+=(speedcau*scalex);
			}
			 if(((board.pm.my-cauy)*scaley)>=0 ) {
				cauy+=(speedcau*scaley);
			}
			if(((board.pm.mx-caux)*scalex)<=0 && ((board.pm.my-cauy)*scaley)<=0) {
				board.pm.mau-=monsterdame;
				atk=0;
				board.pm.Thanhmau(g);
				atack=false;
				c=0;
			}

			
		}
		g.drawImage(cau, caux, cauy, board);
		
		



	}
}

