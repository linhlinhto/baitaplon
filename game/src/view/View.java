package view;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import control.TAdapter;
import model.playermodel;
import model.vat;
import model.Collider;
import model.loadmap;
public class View extends JPanel implements ActionListener  {
	public Jframe scr;
	public startwindown start;
	public loadmap loadmap ;
	public Collider colli = new Collider();
	public playermodel pm = new playermodel(this);
	public vat vat = new vat();
	public int Width = 768;
	public int Height = 512+48;
	public int drawHeight =512;
	int pixel=16;
	public boolean ingame;
	public boolean gameover;
	public Timer timer;  
	public TAdapter move = new TAdapter(this);
	public View(){
		InitBoard();
		start = new startwindown(this);
	}
	public void InitBoard() {
		this.addKeyListener(move);
		this.setBackground(Color.black);
		this.setFocusable(true);
		setPreferredSize(new Dimension(Width,Height));
		Initgame();
		scr = new Jframe(this);
		scr.setVisible(true);
	}

	public void Initgame(){
		move.right = false;
		move.left = false;
		move.up = false;
		move.down = false;
		move.Idle = true;
		ingame = false;
		gameover = false;
		timer = new Timer(1000/75, this);
		timer.start();
	}
	public void mmove() {  		// Di chuyen nhan vat
		if(pm.healing) {
			pm.heal();
		}
		
		
		 if(move.right && !move.Idle ) {
			 pm.moveright();
			 colli.checkcollision(pm.mx,pm.my,pm.pwidth,pm.pheight,pm.vel, loadmap.lomap[loadmap.map].mapcolli);
				if(colli.collision == true) {
				pm.mx -=pm.vel;
				move.right = false;
				move.Idle = true;
				colli.collision =false;
				}
		 }
		if(move.left && !move.Idle) {
				pm.moveleft();
				colli.checkcollision(pm.mx,pm.my,pm.pwidth,pm.pheight,pm.vel, loadmap.lomap[loadmap.map].mapcolli);
					if(colli.collision == true) {
					pm.mx +=pm.vel;
					move.left = false;
					move.Idle = true;
					colli.collision =false;
					}
		}
		if(move.up && !move.Idle) {
				pm.moveup();
				 colli.checkcollision(pm.mx,pm.my,pm.pwidth,pm.pheight,pm.vel, loadmap.lomap[loadmap.map].mapcolli);
					if(colli.collision == true) {
					pm.my +=pm.vel;
					move.up = false;
					move.Idle = true;
					colli.collision = false;
					}
		}
		if(move.down && !move.Idle) {
				pm.movedown();
				 colli.checkcollision(pm.mx,pm.my,pm.pwidth,pm.pheight,pm.vel, loadmap.lomap[loadmap.map].mapcolli);
					if(colli.collision == true) {
					pm.my -=pm.vel;
					move.down = false;
					move.Idle = true;
					colli.collision = false;
					}
		}
		if(move.Idle) {
			pm.Idle();
		}
		pm.dichmap(this);
		
		
	}
	
	
	 @Override
	    public void paintComponent(Graphics g) {
	        super.paintComponent(g);
	         doDrawing(g);
		
	    }
	    
	 	
					
					
	    private void doDrawing(Graphics g) {
	        
	        if (ingame && !gameover) {
	        	
	            loadmap.drawmap(g);
	            if(start.paused ) {
	        		start.Paused(g);
	        		timer.stop();
	        	}

	        } else if(!ingame && !gameover) {
	        	try {
	        		if(start.inoption == false) {
	    	            start.start(g);
	    	        	}
	    	        	else {
	    	        		start.Option(g);
	    	        	}        
				} catch (Exception e) {
					// TODO: handle exception
				}
	        }
	        else if(!ingame && gameover) {
	        	gameOver(g);
	        }
	        Toolkit.getDefaultToolkit().sync();
	        	
	    }
	   
	    

	    private void gameOver(Graphics g) {
	        
	        String msg = "Game Over";
	        Font small = new Font("Helvetica", Font.BOLD, 36);
	        FontMetrics metr = getFontMetrics(small);

	        g.setColor(Color.red);
	        g.setFont(small);
	        g.drawString(msg, 286, 160);
	    }
	    
	    @Override
	    public void actionPerformed(ActionEvent e) {

	        if (ingame) {
	        	
	            mmove();
	        }

	        repaint();
	    }

	    
}
