package model;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import view.View;
import view.monster;

	public class playermodel {
		public Collider colli;
		public int mau,maxhp;
		public int mx,my,pwidth,pheight;
		public int vel;
		public int dichx,dichy;
		public int left,right,down,up;
		public Image player;
		public boolean slashbool;
		Image slash;
		ImageIcon[] slashi;
		int atackspeed,slashdame,slasrangex,slashrangey;
		ImageIcon pIdle1,pIdle2,pIdle3,pIdle4,pleft1,pleft2,pright1,pright2,pup1,pup2,pdown1,pdown2;
		View board;
		public playermodel(View board) {
			this.board = board;
			Initplayer();
		}
		public void Initplayer() {
			maxhp=40;
			mau = maxhp;
			mx = 384;
			my = 256;
			pwidth = 24;
			pheight = 30;
			dichx = 0;
			dichy = 0;
			vel = 4;
			left =0;
			down =1;
			atackspeed=0;
			up=0;
			right=0;
			slashdame = 5;
			slashbool = false;
			slasrangex = 32;
			slashrangey = 32;
			loadimageplayer();
			colli = new Collider();
	}
		public void loadimageplayer() {
			
			pIdle1 = new ImageIcon("src/Image/player/Idle.png");
			pIdle2 = new ImageIcon("src/Image/player/Idle2.png");
			pIdle3 = new ImageIcon("src/Image/player/Idle3.png");
			pIdle4 = new ImageIcon("src/Image/player/Idl4.png");
			pleft1 = new ImageIcon("src/Image/player/left1.png");
			pleft2 = new ImageIcon("src/Image/player/left2.png");
			pright1 = new ImageIcon("src/Image/player/right1.png");
			pright2 = new ImageIcon("src/Image/player/right2.png");
			pup1 = new ImageIcon("src/Image/player/up1.png");
			pup2 = new ImageIcon("src/Image/player/up2.png");
			pdown1 = new ImageIcon("src/Image/player/down1.png");
			pdown2 = new ImageIcon("src/Image/player/down2.png");
			slashi = new ImageIcon[8];
			 slashi[0] = new ImageIcon("src/Image/player/rightslas1.png");
			 slashi[1] = new ImageIcon("src/Image/player/rightslash2.png");
			 slashi[2] = new ImageIcon("src/Image/player/leftslas1.png");
			 slashi[3] = new ImageIcon("src/Image/player/leftslash2.png");
			 slashi[4] = new ImageIcon("src/Image/player/upslas.png");
			 slashi[5] = new ImageIcon("src/Image/player/upslash2.png");
			 slashi[6] = new ImageIcon("src/Image/player/downslas1.png");
			 slashi[7] = new ImageIcon("src/Image/player/downslash2.png");
		}
		public void moveleft() {
			right=0;
			up=0;
			down=0;
			if(!slashbool) {
				
				if(left ==8) {
						left =1;
					}
					else {
						left++;
					}
	
					if(left>0) {
						if(left<=4) {
							player = pleft1.getImage();
						}
					else if(left<=8) {
				
						player = pleft2.getImage();
					}
					}
			}
			else {
				slash(0);
			}
			mx -= vel;
			
			
		}
		public void moveright() {
			left=0;
			up=0;
			down=0;
			if(!slashbool) {
				if(right>0) {
					if(right<4) {
					player = pright1.getImage();
				}
				else if(right<=8) {
				
				player = pright2.getImage();
				
					}
				}
				
				if(right ==8) {
					right =1;
				}
				else {
					right++;
				}
			}
			else {
				slash(1);
			}
		mx += vel;
		}
		public void moveup() {
			right=0;
			left=0;
			down=0;
			if(!slashbool) {
				if(up>0) {
					if(up<=4) {
						player = pup1.getImage();
						}
						else if(up<=8) {
							player= pup2.getImage();
						}
				}
						
						if(up ==8) {
							up =1;
						}
						else {
							up++;
						}
				}
			else {
				slash(2);
			}
		my -= vel;
		}
		public void movedown() {
			right=0;
			up=0;
			left=0;
			if(!slashbool) {
			if(down>0) {
				if(down<=4) {
					player = pdown1.getImage();
				}
				else if(down<=8) {
					player= pdown2.getImage();
				}
			}
			
				if(down ==8) {
					down =1;
				}
				else {
					down++;
				}
			}
			else {
				slash(3);
			}
	
			my += vel;
			
		}
		public void Idle() {
			if(left>0) {
				if(!slashbool) {
				player = pIdle2.getImage();
				}
				else {
					slash(0);
				}
			}
			else if(right>0) {
				if(!slashbool) {
				player = pIdle3.getImage();
				}
				else {
					slash(1);
				}
			}
			else if(up>0) {
				if(!slashbool) {
				player = pIdle4.getImage();
				}
				else {
					slash(2);
				}
			}
			else if(down>0) {
				if(!slashbool) {
				player = pIdle1.getImage();
				}
				else {
					slash(3);
				}
			}
		}
		public void Thanhmau(Graphics g) {
			int drawhp = (int)((float)mau/(float)maxhp  *200);
			g.setColor(Color.RED);
			g.drawRect(16, 16, 200, 16);
			g.fillRect(16, 16, drawhp, 16);
			if(mau <= 0) {
				board.ingame =false;
				board.gameover =true;
			}
			
		}
		public void dichmap(View board) {
		for(int i=board.pm.mx;i<board.pm.mx+32;i++) {
			if(i >= board.Width/2 && (board.pm.dichx) < (board.loadmap.mapw -board.Width) && board.move.right == true) {
				board.pm.dichx+=board.pm.vel;
				board. pm.mx-=board.pm.vel;
				 break;
				
				}
			if(i <= board.Width/2 && (board.Width+board.pm.dichx) > board.Width && board.move.left == true) {
				board.pm.dichx-=board.pm.vel;
				board.pm.mx+=board.pm.vel;
				 break;
				 
			}
		}
		for(int j=board.pm.my;j<board.pm.my+30;j++) {
			if(j >= board.Height/2 && (board.pm.dichy) < (board.loadmap.maph - 512) && board.move.down == true) {
				board.pm.dichy += board.pm.vel;
				board.pm.my-=board.pm.vel;
				break;
				 
			}
			
			if(j <= board.Height/2 && (512+board.pm.dichy) > 512 && board.move.up == true ) {
				board.pm.dichy -= board.pm.vel;
				board.pm.my+=board.pm.vel;
				break;
				
			}
		}
	}
		public void slash(int scale) {
			if(scale==0) {
				if(atackspeed==0) {
					mx= mx-32;
					pwidth = 64;
					pheight = 43;
					player = slashi[2].getImage();
					atackspeed++;
				}
				else if(atackspeed<3) {
					player = slashi[2].getImage();
					atackspeed++;
				}
				else if(atackspeed<6) {
					player = slashi[3].getImage();
					atackspeed++;
				}
				
				else {
					player = pleft1.getImage();
					slashbool=false;
					mx= mx+32;
					pwidth = 24;
					pheight = 30;
					atackspeed=0;
				}
			}
			if(scale==1) {
				if(atackspeed==0) {
					pwidth=64;
					pheight = 43;
					player = slashi[0].getImage();
					atackspeed++;
				}
				else if(atackspeed<3) {
					player = slashi[0].getImage();
					atackspeed++;
				}
				else if(atackspeed<6) {
					player = slashi[1].getImage();
					atackspeed++;
				}
				
				else {
					player = pright1.getImage();
					slashbool=false;
					pwidth = 24;
					pheight = 30;
					atackspeed=0;
				}
			}
			if(scale==2) {
				if(atackspeed==0) {
					mx=mx-8;
					my=my-32;
					pheight = 75;
					pwidth = 48;
					player = slashi[4].getImage();
					atackspeed++;
				}
				else if(atackspeed<3) {
					atackspeed++;
					player = slashi[4].getImage();
				}
				else if(atackspeed<6) {
					atackspeed++;
					player = slashi[5].getImage();
				}
				
				else {
					slashbool=false;
					mx=mx+8;
					my=my+32;
					pwidth = 24;
					pheight = 30;
					atackspeed=0;
					player = pup1.getImage();
				}
				
			}
			if(scale==3) {
				if(atackspeed==0) {
					pheight = 75;
					pwidth = 48;
					player = slashi[6].getImage();
					mx=mx-8;
					atackspeed++;
				}
				else if(atackspeed<3) {
					player = slashi[6].getImage();
					atackspeed++;
				}
				else if(atackspeed<6) {
					player = slashi[7].getImage();
					atackspeed++;
				}
				
				else {
					player = pdown1.getImage();
					slashbool=false;
					pwidth = 24;
					pheight = 30;
					mx=mx+8;
					atackspeed=0;
				}
			}
			if(!slashbool) {
				for(int i = 0;i<board.loadmap.lomap[board.loadmap.map].monsternum;i++) {
					if(board.loadmap.lomap[board.loadmap.map].monster[i] != null) {
					colli.checkslash(this,board.loadmap.lomap[board.loadmap.map].monster[i] ,board.loadmap.lomap[board.loadmap.map].mapcolli );
					}
					}
			}
			
			
			
				
			
		}
		
		
	}
