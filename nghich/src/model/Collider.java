package model;

import control.TAdapter;
public class Collider {
	TAdapter move = new TAdapter();
	boolean collision = false;
	public void setCollision2(int[][] map ,int rx , int ry, int w, int h) {
		for(int i = rx;i<(rx+w);i++) {
			for(int j = ry;j<(ry+h);j++) {
				map[i][j] = 2;
			}
		}
		
	}
	public void setCollision0 (int[][] map ,int rx , int ry, int w, int h) {
		for(int i = rx;i<(rx+w);i++) {
			for(int j = ry;j<(ry+h);j++) {
				map[i][j]=0;
			}
		}
		
	}
	public void checkcollision(int x, int y,int vel, int[][] mapcolli) {
		for (int i=x; i<x+48;i++) {
			for(int j=y;j<y+32;j++) {
				if(move.right == true && mapcolli[i+vel][j] == 2  ) {
					move.right = false;
					move.Idle = true;
				}
				else if(move.left == true && mapcolli[i-vel][j] == 2  ) {
					move.left = false;
					move.Idle = true;
				}
				else if(move.down == true && mapcolli[i][j+vel] == 2  ) {
					move.down = false;
				}
				else if(move.up == true && mapcolli[i][j-vel] == 2  ) {
					move.up =false;
					move.Idle = true;
				}
			}
		}
	}
}
