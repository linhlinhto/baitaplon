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
 			if(i>6) {
 				x = (x+1)*16;
 				y = (y+1)*16;
 				System.out.println(""+board.pm.my+""+y);
 				
	    			if(board.pm.my < y+48) {
	    				board.pm.Thanhmau(g);
	    				g.drawImage(board.pm.player, board.pm.mx,board.pm.my,board); 
	    				g.drawImage(anh.vat[i].anhvat, x-board.pm.dichx, y+32-board.pm.dichy,board);
	    				
	    			}
	    			else {
	    				
	    				g.drawImage(anh.vat[i].anhvat, x-board.pm.dichx, y+32-board.pm.dichy, board);
	    				board.pm.Thanhmau(g);
	    				g.drawImage(board.pm.player , board.pm.mx,board.pm.my,board); 
	    			}
	    			colli.setCollisionvat(mapcolli, x, y+anh.vat[i].colliheight, anh.vat[i].width,anh.vat[i].height-anh.vat[i].colliheight, i);
	    			
	    			x= x/16-1;
	    			y = y/16 -1;
	    			//x+=anh.vat[i].width/16;
	    			
 			}
 			else {
 				
 				
 			}
 			
	    }
}
