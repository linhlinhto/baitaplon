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
        	if(board.loadmap.lomap[board.loadmap.map].inbang==true) {
        		if(key == KeyEvent.VK_ENTER) {
        			board.loadmap.lomap[board.loadmap.map].inbang = false;
        			board.timer.start();
        			
        		}
        	}
        	else {
        	if(key == KeyEvent.VK_ESCAPE) {
        		this.board.ingame = false;
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
        else if(key == KeyEvent.VK_E) {
        	board.pm.healing = true;
        }
        else if(key == KeyEvent.VK_ENTER && board.loadmap.lomap[board.loadmap.map].inevent) {
        	board.loadmap.lomap[board.loadmap.map].event = true;
        }
        	}
    	 }
        else if(!board.ingame&& !board.gameover &&board.start.paused) {
        	if (key == KeyEvent.VK_DOWN && board.start.option <3) {
   			 board.start.option++;
   		 }
   		 else if(key == KeyEvent.VK_UP && board.start.option >1) {
   			 board.start.option--;
   		 }
   		 else if(key== KeyEvent.VK_ENTER && board.start.option ==1 ) {
   			 board.start.paused =false;
   			 board.ingame = true;
   		 }
   		 else if(key== KeyEvent.VK_ENTER && board.start.option ==2) {
   			 board.start.paused = false;
   			 board.start.option =1;
   		 }
   		 else if(key== KeyEvent.VK_ENTER && board.start.option ==3) {
   			 board.scr.dispose();
   		 }
        }
    	 else if(!board.ingame && !board.gameover &&!board.start.paused) {
    		 if(!board.start.inoption&&!board.start.inHelp) {
    		 if (key == KeyEvent.VK_DOWN && board.start.option <4) {
    			 board.start.option++;
    		 }
    		 else if(key == KeyEvent.VK_UP && board.start.option >1) {
    			 board.start.option--;
    		 }
    		 else if(key== KeyEvent.VK_ENTER && board.start.option ==1 ) {
    			 board.Initgame();
    			 board.ingame = true;
    			 
    		 }
    		 else if(key== KeyEvent.VK_ENTER && board.start.option ==2 ) {
    			 board.start.inoption =true;
    			 board.start.option =1;
    		 }
    		 else if(key== KeyEvent.VK_ENTER && board.start.option ==3 ) {
    			 board.start.inHelp = true;
    		 }
    		 else if(key== KeyEvent.VK_ENTER && board.start.option ==4 ) {
    			 board.scr.dispose();
    		 }
    		 }
    		 else if(board.start.inoption&&!board.start.inHelp) {
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
        			 board.start.inoption = false;
        		 }
        		 else if(key== KeyEvent.VK_ENTER && board.start.option ==2 ) {
        			 board.start.dokho =2;
        			 board.start.inoption = false;
        		 }
    		 }
    		 else {
    			 if(key == KeyEvent.VK_ESCAPE || key == KeyEvent.VK_ENTER) {
    				 board.start.inHelp = false;
    			 }
    		 }
    	 }
    	 else if(!board.ingame && board.gameover &&!board.start.paused) {
    		 if (key == KeyEvent.VK_DOWN && board.start.option <3) {
    			 board.start.option++;
    		 }
    		 else if(key == KeyEvent.VK_UP && board.start.option >1) {
    			 board.start.option--;
    		 }
    		 else if(key== KeyEvent.VK_ENTER && board.start.option ==1 ) {
    			 board.Initgame();
    			 board.ingame = true;
    		 }
    		 else if(key== KeyEvent.VK_ENTER && board.start.option ==2 ) {
    			 board.gameover = false;
    			 board.start.option =1;
    		 }
    		 else if(key== KeyEvent.VK_ENTER && board.start.option ==3 ) {
    			 board.scr.dispose();
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
