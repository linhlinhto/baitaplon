package model;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import view.View;

	public class playermodel {
		public int mau;
		public int mx,my;
		public int vel;
		public int dichx,dichy;
		public int left,right,down,up;
		public Image player;
		ImageIcon pIdle1,pIdle2,pIdle3,pIdle4,pleft1,pleft2,pright1,pright2,pup1,pup2,pdown1,pdown2;
		
		public playermodel() {
			Initplayer();
		}
		public void Initplayer() {
			mau = 240;
			mx = 384;
			my = 256;
			dichx = 0;
			dichy = 0;
			vel = 6;
			left =0;
			down =1;
			up=0;
			right=0;
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
		}
		public void moveleft() {
			right=0;
			up=0;
			down=0;
			if(left ==12) {
				left =1;
			}
			else {
				left++;
			}
		mx -= vel;
			if(left>0) {
			if(left<=6) {
				player = pleft1.getImage();
			}
			else if(left<=12) {
				player = pleft2.getImage();
			}
			}
			
			
		}
		public void moveright() {
			if(right>0) {
			if(right<6) {
				player = pright1.getImage();
			}
			else if(right<=12) {
				player = pright2.getImage();
			}
			}
			left=0;
			up=0;
			down=0;
			if(right ==12) {
				right =1;
			}
			else {
				right++;
			}
		mx += vel;
		}
		public void moveup() {
			if(up>0) {
			if(up<=6) {
				player = pup1.getImage();
			}
			else if(up<=12) {
				player= pup2.getImage();
			}
			}
			right=0;
			left=0;
			down=0;
			if(up ==12) {
				up =1;
			}
			else {
				up++;
			}
		my -= vel;
		}
		public void movedown() {
			if(down>0) {
			if(down<=6) {
				player = pdown1.getImage();
			}
			else if(down<=12) {
				player= pdown2.getImage();
			}
			}
			right=0;
			up=0;
			left=0;
			if(down ==12) {
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
		
		
	}
