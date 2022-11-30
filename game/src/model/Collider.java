package model;

import control.TAdapter;
import view.View;
public class Collider {
	public boolean collision = false;
	public void setCollisionmap(int[][] map ,int rx , int ry, int w, int h) {
		for(int i = rx;i<(rx+w);i++) {
			for(int j = ry;j<(ry+h);j++) {
				map[i][j] = 100;
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
	public void checkcollision(View board,int x, int y,int width,int height ,int vel, int[][] mapcolli) {
		y=y+16;
		for (int i=x;i<x+width;i++) {
			for(int j=y;j<y+height;j++) {
				if( mapcolli[i][j] > 2  ) {
					collision = true;
					break;
				}
				
				
			}
			
		}
	}
}
