package view;

import java.awt.Graphics;

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
 				if(y+60+map.vat[i].height-board.pm.dichy>0 && x+map.vat[i].width-board.pm.dichx>0 && y+60-board.pm.dichy<560 && x-board.pm.dichx<768) {
 					
 					
 					if(board.pm.my > y-board.pm.dichy &&board.pm.my < y-board.pm.dichy+map.vat[i].height+70&&board.pm.mx+26>x-board.pm.dichx&&board.pm.mx<x-board.pm.dichx+map.vat[i].width) {
 						if(board.pm.my < y-board.pm.dichy+map.vat[i].height+32) {
 						board.pm.Thanhmau(g);
 	 					g.drawImage(board.pm.player, board.pm.mx,board.pm.my,board); 
 	 					g.drawImage(map.vat[i].anhvat, x-board.pm.dichx, y+60-board.pm.dichy,board);
 						}
 						else {
 							
 	 	 					g.drawImage(map.vat[i].anhvat, x-board.pm.dichx, y+60-board.pm.dichy,board);
 	 	 					board.pm.Thanhmau(g);
 	 	 					g.drawImage(board.pm.player, board.pm.mx,board.pm.my,board); 
 						}
 	 					
 					}
 						else {
 								g.drawImage(map.vat[i].anhvat, x-board.pm.dichx, y+60-board.pm.dichy,board);
 		 						board.pm.Thanhmau(g);
 						}
 				}
 				if(y+60-board.pm.dichy>0 && x-board.pm.dichx>0 && y+60-board.pm.dichy<560-map.vat[i].height && x-board.pm.dichx<768-map.vat[i].width) {
 					colli.setCollisionvat(mapcolli, x-board.pm.dichx, y+60-board.pm.dichy+map.vat[i].height-map.vat[i].colliheight, map.vat[i].width,map.vat[i].colliheight, i);
 				}
 				
 			
	    }
	 	public void vequai(Graphics g,int number,monster[] monster) {
	 					monster[number].paintmonster(g);
	 					if(monster[number].hp>monster[number].newhp||monster[number].counterhp>0) {
	 		 				monster[number].monsterhp(g);
	 		 			}
		}
}
