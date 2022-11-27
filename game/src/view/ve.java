package view;

import java.awt.Graphics;

import model.Collider;

public class ve {
	Collider colli = new Collider();
	anhvat anh;
	View board;
	public ve(View board) {
		 anh = new anhvat();
		this.board = board;
	}
	 public void vevat(Graphics g,int i,int x, int y,int[][] mapcolli) {
 				
 				x = x*16;
 				y = y*16;
 				if(y+60+anh.vat[i].height-board.pm.dichy>0 && x+anh.vat[i].width-board.pm.dichx>0 && y+60-board.pm.dichy<560 && x-board.pm.dichx<768) {
 					
 				if(board.pm.my >= y+60+(anh.vat[i].height-anh.vat[i].colliheight)-board.pm.dichy ) {
 					
 					g.drawImage(anh.vat[i].anhvat, x-board.pm.dichx, y+60-board.pm.dichy,board);
 					board.pm.Thanhmau(g);
 					g.drawImage(board.pm.player , board.pm.mx,board.pm.my,board); 
 					
 				}
 				else if(board.pm.my < y+60+(anh.vat[i].height-anh.vat[i].colliheight)-board.pm.dichy && board.pm.my>= y+60-board.pm.dichy ) {
 	 				board.pm.Thanhmau(g);
 	 				g.drawImage(board.pm.player, board.pm.mx,board.pm.my,board); 
 	 				g.drawImage(anh.vat[i].anhvat, x-board.pm.dichx, y+60-board.pm.dichy,board);
 	 				
 	 			}
 	 			 
 	 			else  {
 	 				g.drawImage(anh.vat[i].anhvat, x-board.pm.dichx, y+60-board.pm.dichy,board);
 	 			}
 				}
 				if(y+60-board.pm.dichy>0 && x-board.pm.dichx>0 && y+60-board.pm.dichy<560-anh.vat[i].height && x-board.pm.dichx<768-anh.vat[i].width) {
 					colli.setCollisionvat(mapcolli, x-board.pm.dichx, y+60-board.pm.dichy+anh.vat[i].height-anh.vat[i].colliheight, anh.vat[i].width,anh.vat[i].colliheight, i);
 				}
 				
 			
	    }
}
