package model;

import control.TAdapter;
import map.map;
import monster.monster;
import view.View;
public class Collider {
	public boolean collision = false;
	
	public void setCollisionmap(int[][] map ,int rx , int ry, int w, int h) {	//dat va cham o cuoi map
		for(int i = rx;i<(rx+w);i++) {
			for(int j = ry;j<(ry+h);j++) {
				map[i][j] = 100;
			}
		}
		
	}
	public void setCollisionvat(int[][] map ,int rx , int ry, int w, int h,int so) {		// dat va cham cho vat
		for(int i = rx;i<(rx+w);i++) {
			for(int j = ry;j<(ry+h);j++) {
				map[i][j] = so;
			}
		}
	}
	public void checkcollision(int x, int y,int width,int height ,int vel, int[][] mapcolli,loadmap loadmap, playermodel pm) {   // kiem tra va cham 
		y=y+16;
		for (int i=x;i<x+width;i++) {
			for(int j=y;j<y+height;j++) {
				if( mapcolli[i][j] >= 4 && mapcolli[i][j] !=50 ) {
					collision = true;
					break;
				}
				else if(mapcolli[i][j] == 2 && mapcolli[i][j]<4 && mapcolli[i][j] !=50) {
					if(loadmap.map == 1) {
						
						pm.dichx = 0 ;
						pm.mx = 16;
						pm.dichy = 810;
					}
					else if(loadmap.map == 3) {
						pm.dichx = 512 ;
						pm.mx=588;
						
						pm.my = 76;
						pm.dichy = 0;
					}
					loadmap.map = 2;
					
					break;
				}
				else if(mapcolli[i][j] == 1 && mapcolli[i][j]<4 && mapcolli[i][j] !=50) {
					pm.dichx = 1696 ;
					pm.mx = 704;
					pm.dichy = 320;
					loadmap.map=1;
					break;
				}
				else if(mapcolli[i][j] == 3 && mapcolli[i][j]<4 && mapcolli[i][j] !=50) {
					pm.dichx = 584;
					pm.mx = 384;
					pm.my = 464;
					pm.dichy = 596;
					loadmap.map=3;
					break;
				}
				
				
			}
			
		}
	}
	public void checkcollisionm(int x, int y,int width,int height ,int vel, int[][] mapcolli) {   // kiem tra va cham 
		y=y+16;
		for (int i=x;i<x+width;i++) {
			for(int j=y;j<y+height;j++) {
				if( mapcolli[i][j] >= 4 && mapcolli[i][j] !=50 ) {
					collision = true;
					break;
				}
			}
			
		}
	}
	public void checkslash(playermodel pm ,monster monster, int[][] mapcolli ) {
		for(int i=pm.mx-32;i<pm.mx+pm.pwidth+32;i++) {
			for(int j=pm.my+44;j<pm.my+pm.pheight+76;j++) {
				if(mapcolli[i][j]==50) {
					monster.dameget = 4+pm.level/3;
					monster.atacked =true;
				}
			}
		}
	}
	public void checkObject(map map,int x, int y,int width,int height ,int vel, int[][] mapcolli,int so) {   // kiem tra va cham 
		y=y+16;
		for (int i=x;i<x+width;i++) {
			for(int j=y;j<y+height+16;j++) {
				if( mapcolli[i+vel][j] == so|| mapcolli[i-vel][j]== so || mapcolli[i][j+vel]== so|| mapcolli[i][j-vel] == so) {
					map.inevent=true;
					break;
				}
				
				else {
					
					map.inevent=false;
					
				}
				
				
			}
			
		}
	
	}
}
