package model;

import control.TAdapter;
import view.View;
public class Collider {
	boolean collision = false;
	public void setCollisionmap(int[][] map ,int rx , int ry, int w, int h) {
		for(int i = rx;i<(rx+w);i++) {
			for(int j = ry;j<(ry+h);j++) {
				map[i][j] = 10;
			}
		}
		
	}
	public void setCollisionvat(int[][] map ,int rx , int ry, int w, int h,int so) {
		for(int i = rx;i<(rx+w);i++) {
			for(int j = ry;j<(ry+h);j++) {
				map[i][j] = so;
			}
		}
	}
	public void checkcollision(View board,int x, int y,int vel, int[][] mapcolli) {
		y=y+16;
		
		for (int i=x; i<x+34;i++) {
			for(int j=y;j<y+32;j++) {
				for(int k=1;k<=vel;k++) {
				if(board.move.right == true && mapcolli[i+k][j] > mapcolli[i][j]+1  ) {
					if(board.pm.right==0) {
					board.pm.moveright();
					
					board.pm.mx -=vel;
					}
					board.move.right = false;
					board.move.Idle = true;
					break;
				}
				 if(board.move.left == true && mapcolli[i-k][j] > mapcolli[i][j]+1  ) {
					 
					 if(board.pm.left==0) {
					 board.pm.moveleft();
						board.pm.mx +=vel;
					 }
					 board.move.left = false;
					 board.move.Idle = true;
					break;
				}
				 if(board.move.down == true && mapcolli[i][j+k] > mapcolli[i][j]+1  ) {
					 if(board.pm.down==0) {
					 board.pm.movedown();
						board.pm.my -=vel;
					 }
					 board.move.down = false;
					 board.move.Idle =true;
					break;
					
				}
				if(board.move.up == true && mapcolli[i][j-k] >mapcolli[i][j]+1  ) {
					if(board.pm.up==0) {
						board.pm.moveup();
						board.pm.my +=vel;
					}
					board.move.up =false;
					board.move.Idle = true;
					break;
				}
				}
				
				
			}
			
		}
	}
}
