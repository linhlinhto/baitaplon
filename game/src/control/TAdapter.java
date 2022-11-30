package control;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import model.loadmap;
import view.Jframe;
import view.View;
	public class TAdapter extends KeyAdapter {
	public boolean right;
	public boolean Idle;
	public boolean left;
	public boolean up;
	public boolean down;
	private View board;
	public TAdapter(View board) {
		this.board = board;
	}
    @Override
    public void keyPressed(KeyEvent e) {
    	 
        int key = e.getKeyCode();
        if(board.ingame && !board.gameover && !board.start.paused) {
        	if(key == KeyEvent.VK_ESCAPE) {
        		this.board.start.paused = true;
        	}
         if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A) {
            left = true;
            up= false;
            down = false;
            right = false;;
            Idle = false;
        }

        else if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) {
            right = true;
            left = false;
            up = false;
            down = false;
            Idle = false;
           
        }

        else if (key == KeyEvent.VK_UP || key == KeyEvent.VK_W) {
            up = true;
            down = false;
            right = false;
            left = false;
            Idle = false;
        }

        else if (key == KeyEvent.VK_DOWN || key == KeyEvent.VK_S){
            down = true;
            up = false;
            right = false;
            left = false;
            Idle = false;
        }
        else if(key == KeyEvent.VK_F) {
        	board.pm.slashbool = true;
        }
    	 }
        else if(board.ingame&& !board.gameover &&board.start.paused) {
        	if (key == KeyEvent.VK_DOWN && board.start.option <2) {
   			 board.start.option++;
   		 }
   		 else if(key == KeyEvent.VK_UP && board.start.option >1) {
   			 board.start.option--;
   		 }
   		 else if(key== KeyEvent.VK_ENTER && board.start.option ==1 ) {
   			 board.start.paused =false;
   		 }
   		 else if(key== KeyEvent.VK_ENTER && board.start.option ==2) {
   			 board.scr.dispose();
   		 }
        }
    	 else if(!board.ingame && !board.gameover) {
    		 if(!board.start.inoption) {
    		 if (key == KeyEvent.VK_DOWN && board.start.option <3) {
    			 board.start.option++;
    		 }
    		 else if(key == KeyEvent.VK_UP && board.start.option >1) {
    			 board.start.option--;
    		 }
    		 else if(key== KeyEvent.VK_ENTER && board.start.option ==1 ) {
    			 board.ingame =true;
    			 board.loadmap =new loadmap(board);
    		 }
    		 else if(key== KeyEvent.VK_ENTER && board.start.option ==2 ) {
    			 board.start.inoption =true;
    		 }
    		 else if(key== KeyEvent.VK_ENTER && board.start.option ==3 ) {
    			 board.scr.dispose();
    		 }
    		 }
    		 else {
    			 if(key == KeyEvent.VK_ESCAPE) {
    				 board.start.inoption = false;
    			 }
    			 if (key == KeyEvent.VK_DOWN && board.start.option <2) {
        			 board.start.option++;
        		 }
        		 else if(key == KeyEvent.VK_UP && board.start.option >1) {
        			 board.start.option--;
        		 }
        		 else if(key== KeyEvent.VK_ENTER && board.start.option ==1 ) {
        			 board.start.dokho =1;
        		 }
        		 else if(key== KeyEvent.VK_ENTER && board.start.option ==2 ) {
        			 board.start.dokho =2;
        		 }
    		 }
    	 }
    	 
    } 
 @Override
public void keyReleased(KeyEvent e){
	 int key = e.getKeyCode();
	 if (key == KeyEvent.VK_LEFT|| key == KeyEvent.VK_A) {
            left = false;
            up= false;
            down = false;
            Idle = true;
        }

        else if (key == KeyEvent.VK_RIGHT|| key == KeyEvent.VK_D){
            right = false;
            up = false;
            down = false;
            Idle = true;
           
        }

        else if (key == KeyEvent.VK_UP|| key == KeyEvent.VK_W) {
            up = false;
            right = false;
            left = false;
            Idle = true;
        }

        else if (key == KeyEvent.VK_DOWN|| key == KeyEvent.VK_S) {
            down = false;
            right = false;
            left = false;
            Idle = true;
        }
 }
}
