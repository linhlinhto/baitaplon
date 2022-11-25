package control;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
	public class TAdapter extends KeyAdapter {
	
	public boolean right;
	public boolean Idle;
	public boolean left;
	public boolean up;
	public boolean down;
    @Override
    public void keyPressed(KeyEvent e) {
    	 
        int key = e.getKeyCode();

         if ((key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A) && (!right)) {
            left = true;
            up= false;
            down = false;
            right = false;;
            Idle = false;
        }

        else if ((key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) && (!left)) {
            right = true;
            left = false;
            up = false;
            down = false;
            Idle = false;
           
        }

        else if ((key == KeyEvent.VK_UP || key == KeyEvent.VK_W) && (!down)) {
            up = true;
            down = false;
            right = false;
            left = false;
            Idle = false;
        }

        else if ((key == KeyEvent.VK_DOWN || key == KeyEvent.VK_S) && (!up)) {
            down = true;
            up = false;
            right = false;
            left = false;
            Idle = false;
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
