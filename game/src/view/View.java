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
	public loadmap loadmap = new loadmap(this);
	Collider colli = new Collider();
	public playermodel pm = new playermodel();
	public vat vat = new vat();
	public int Width = 768;
	public int Height = 512+48;
	public int drawHeight =512;
	int pixel=16;
	public boolean ingame;
	public boolean gameover;
	Timer timer;  
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
		timer = new Timer(1000/60, this);
		timer.start();
	}
	public void mmove() {
		colli.checkcollision(this,pm.mx,pm.my, pm.vel, loadmap.mapcolli);
		pm.dichmap(this);
		 if(move.right && !move.Idle ) {
			pm.moveright();

		}
		if(move.left && !move.Idle) {
				pm.moveleft();
		}
		if(move.up && !move.Idle) {
				pm.moveup();
		}
		if(move.down && !move.Idle) {
				pm.movedown();
		}
		if(move.Idle) {
			pm.Idle();
		}
		
	}
	
	
	 @Override
	    public void paintComponent(Graphics g) {
	        super.paintComponent(g);
	         doDrawing(g);
		
	    }
	    
	 	
					
					
	    private void doDrawing(Graphics g) {
	        
	        if (ingame && !gameover) {
	        	
	            loadmap.loadthismap(g);
	            if(start.paused ) {
	        		start.Paused(g);
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
	        Toolkit.getDefaultToolkit().sync();
	        	
	    }
	   
	    

	    private void gameOver(Graphics g) {
	        
	        String msg = "Game Over";
	        Font small = new Font("Helvetica", Font.BOLD, 36);
	        FontMetrics metr = getFontMetrics(small);

	        g.setColor(Color.red);
	        g.setFont(small);
	        g.drawString(msg, (1000 - metr.stringWidth(msg)) / 2, 1000 / 2);
	    }
	    
	    @Override
	    public void actionPerformed(ActionEvent e) {

	        if (ingame) {
	        	
	            mmove();
	        }

	        repaint();
	    }

	    
}
