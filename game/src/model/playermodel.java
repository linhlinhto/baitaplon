package model;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import view.View;

	public class playermodel {
		public int mau;
		public int mx,my,pwidth,pheight;
		public int vel;
		public int dichx,dichy;
		public int left,right,down,up;
		public Image player;
		public boolean slashbool;
		Image slash;
		ImageIcon[] slashi;
		int sli,slashdame,slasrangex,slashrangey;
		ImageIcon pIdle1,pIdle2,pIdle3,pIdle4,pleft1,pleft2,pright1,pright2,pup1,pup2,pdown1,pdown2;
		View board;
		public playermodel(View board) {
			this.board = board;
			Initplayer();
		}
		public void Initplayer() {
			mau = 240;
			mx = 384;
			my = 256;
			pwidth = 24;
			pheight = 30;
			dichx = 0;
			dichy = 0;
			vel = 4;
			left =0;
			down =1;
			up=0;
			right=0;
			slashdame = 5;
			slashbool = false;
			slasrangex = 32;
			slashrangey = 32;
			loadimageplayer();
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
			if(left ==8) {
				left =1;
			}
			else {
				left++;
			}
		mx -= vel;
			if(left>0) {
			if(left<=4) {
				player = pleft1.getImage();
			}
			else if(left<=8) {
				player = pleft2.getImage();
			}
			}
			
			
		}
		public void moveright() {
			if(right>0) {
			if(right<4) {
				player = pright1.getImage();
			}
			else if(right<=8) {
				player = pright2.getImage();
			}
			}
			left=0;
			up=0;
			down=0;
			if(right ==8) {
				right =1;
			}
			else {
				right++;
			}
		mx += vel;
		}
		public void moveup() {
			if(up>0) {
			if(up<=4) {
				player = pup1.getImage();
			}
			else if(up<=8) {
				player= pup2.getImage();
			}
			}
			right=0;
			left=0;
			down=0;
			if(up ==8) {
				up =1;
			}
			else {
				up++;
			}
		my -= vel;
		}
		public void movedown() {
			if(down>0) {
			if(down<=4) {
				player = pdown1.getImage();
			}
			else if(down<=8) {
				player= pdown2.getImage();
			}
			}
			right=0;
			up=0;
			left=0;
			if(down ==8) {
				down =1;
			}
			else {
				down++;
			}
	
			my += vel;
			
		}
		public void Idle() {
			if(left>0) {
				player = pIdle2.getImage();
			}
			else if(right>0) {
				player = pIdle3.getImage();
			}
			else if(up>0) {
				player = pIdle4.getImage();
			}
			else if(down>0) {
				player = pIdle1.getImage();
			}
		}
		public void Thanhmau(Graphics g) {
			g.setColor(Color.RED);
			g.drawString("HP", 0, 0);
			g.fillRect(16, 16, mau, 16);
			
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
		public void slash(Graphics g) {
				if(left>0) {
					slasrangex = slasrangex- mx;
					slashrangey = my;
					if(sli!=2) {
					sli=2;
					}
					else {
						sli++;
						slashbool = false;
					}
					slash = slashi[sli].getImage();
					g.drawImage(slash,mx-32,my,board);
				}
				if(right>0) {
					slasrangex += mx;
					slashrangey = my;
					if(sli!=0) {
					sli=0;
					}
					else {
						sli++;
						slashbool = false;
					}
					slash = slashi[sli].getImage();
					g.drawImage(slash,mx,my,board);
					
				}
				if(up>0) {
					slashrangey -= my;
					slasrangex = mx;
					if(sli!=4) {
					sli=4;
					}
					else {
						sli++;
						slashbool=false;
					}
					slash = slashi[sli].getImage();
					g.drawImage(slash,mx-8,my-32,board);
					
				}
				if(down>0) {
					slashrangey += my;
					slasrangex = mx;
					if(sli!=6) {
					sli=6;
					}
					else {
						sli++;
						slashbool = false;
						
					}
					slash = slashi[sli].getImage();
					g.drawImage(slash,mx-8,my,board);
				}
				if(slashbool) {
					
					
				}
				else {
					slasrangex =32;
					slashrangey = 32;
				}

			
		}
		
		
	}
