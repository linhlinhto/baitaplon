package view;

import java.awt.Graphics;

import model.Collider;
import model.vat;

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
 					
 				if(board.pm.my+40 >= y+60+(map.vat[i].height-map.vat[i].colliheight)-board.pm.dichy ) {
 					
 					g.drawImage(map.vat[i].anhvat, x-board.pm.dichx, y+60-board.pm.dichy,board);
 					board.pm.Thanhmau(g);
 					g.drawImage(board.pm.player , board.pm.mx,board.pm.my,board); 
 					
 				}
 				else if(board.pm.my < y+60+(map.vat[i].height-map.vat[i].colliheight)-board.pm.dichy && board.pm.my>= y+60-board.pm.dichy ) {
 	 				board.pm.Thanhmau(g);
 	 				g.drawImage(board.pm.player, board.pm.mx,board.pm.my,board); 
 	 				g.drawImage(map.vat[i].anhvat, x-board.pm.dichx, y+60-board.pm.dichy,board);
 	 				
 	 			}
 	 			 
 	 			else  {
 	 				g.drawImage(map.vat[i].anhvat, x-board.pm.dichx, y+60-board.pm.dichy,board);
 	 			}
 				}
 				if(y+60-board.pm.dichy>0 && x-board.pm.dichx>0 && y+60-board.pm.dichy<560-map.vat[i].height && x-board.pm.dichx<768-map.vat[i].width) {
 					colli.setCollisionvat(mapcolli, x-board.pm.dichx, y+60-board.pm.dichy+map.vat[i].height-map.vat[i].colliheight, map.vat[i].width,map.vat[i].colliheight, i);
 				}
 				
 			
	    }
}
