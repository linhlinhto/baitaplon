package model;
import java.awt.Image;

import javax.swing.ImageIcon;

	public class playermodel {
		public int mx,my;
		public int vel;
		public int dichx,dichy;
		public int left,right,down,up;
		public Image playerMove,playerIdle;
		ImageIcon pIdle1,pIdle2,pIdle3,pIdle4,pleft1,pleft2,pright1,pright2,pup1,pup2,pdown1,pdown2;
		
		public playermodel() {
			Initplayer();
		}
		public void Initplayer() {
			mx = 16;
			my = 16;
			dichx = 32;
			dichy = 32;
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
				playerMove = pleft1.getImage();
			}
			else if(left<=12) {
				playerMove = pleft2.getImage();
			}
			}
			
			
		}
		public void moveright() {
			if(right>0) {
			if(right<6) {
				playerMove = pright1.getImage();
			}
			else if(right<=12) {
				playerMove = pright2.getImage();
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
				playerMove = pup1.getImage();
			}
			else if(up<=12) {
				playerMove = pup2.getImage();
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
				playerMove = pdown1.getImage();
			}
			else if(down<=12) {
				playerMove = pdown2.getImage();
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
				playerIdle = pIdle2.getImage();
			}
			else if(right>0) {
				playerIdle = pIdle3.getImage();
			}
			else if(up>0) {
				playerIdle = pIdle4.getImage();
			}
			else if(down>0) {
				playerIdle = pIdle1.getImage();
			}
		}
		
		
	}
