package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

import map.map;
import model.Collider;
import model.vat;
import monster.monster;

public class ve {
	Collider colli = new Collider();
	View board;
	public ve(View board) {
		this.board = board;
	}
	 public void vevat(Graphics g,int i,int x, int y,int[][] mapcolli, map map) {
 				x = x*16;
 				y = y*16;
 				
 					
 						if(board.pm.my+board.pm.dichy < y+map.vat[i].height+32) {
 	 					g.drawImage(map.vat[i].anhvat, x-board.pm.dichx, y+60-board.pm.dichy,board);
 						}
 						else {
 							
 	 	 					g.drawImage(map.vat[i].anhvat, x-board.pm.dichx, y+60-board.pm.dichy,board);
 	 	 					if(board.pm.mx+board.pm.dichx+board.pm.pwidth >= x && board.pm.mx+board.pm.dichx < x+map.vat[i].width) {
 	 	 					g.drawImage(board.pm.player, board.pm.mx,board.pm.my,board); 
 	 	 					}
 						}
 				
 						colli.setCollisionvat(mapcolli, x, y+60+map.vat[i].height-map.vat[i].colliheight, map.vat[i].width,map.vat[i].colliheight,i);

 						
 					x= x/16;
 					y = y/16;
 				
 			
	    }
	 	public void vequai(Graphics g,int number,monster[] monster,map map) {
	 			
	 					monster[number].paintmonster(g,map);
	 					
	 					if (map.boss){
	 						String Boss = "Boss";
	 						monster[number].hp=monster[number].newhp;
	 						if(monster[number].hp<=0) {
	 							monster[number].alive=false;
	 							monster[number].dying=true;
	 						}
	 						 if(monster[number].hp>=0) {
	 						int hpwidth =(int) ((float)monster[number].newhp/(float)monster[number].maxhp *560f);
	 						
	 						g.setColor(Color.red);
	 						g.fillRect(96, 64, hpwidth, 16);
	 						g.drawRect(96,64,560,16);
	 						g.setFont(new Font(Boss, Font.BOLD, 48));
	 						}
	 					}
	 					else if(monster[number].hp>monster[number].newhp||monster[number].counterhp>0) {
	 		 				monster[number].monsterhp(g);
	 		 			}
		}
}
