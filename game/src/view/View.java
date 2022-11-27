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
	public loadmap loadmap = new loadmap(this);
	Collider colli = new Collider();
	public playermodel pm = new playermodel();
	public vat vat = new vat();
	public int Width = 768;
	public int Height = 512+48;
	public int drawHeight =512;
	int map;
	int pixel=16;
	boolean ingame;
	Timer timer;  
	public TAdapter move = new TAdapter();
	public View(){
		InitBoard();
	}
	public void InitBoard() {
		this.addKeyListener(move);
		this.setBackground(Color.black);
		this.setFocusable(true);
		setPreferredSize(new Dimension(Width,Height));
		map = 1;
		Initgame();
	}

	public void Initgame(){
		move.right = false;
		move.left = false;
		move.up = false;
		move.down = false;
		move.Idle = true;
		ingame = true;
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
	        loadmap.loadthismap(g);
		
	    }
	    
	 	
					
					
	    private void doDrawing(Graphics g) {
	        
	        if (ingame) {

	            Toolkit.getDefaultToolkit().sync();

	        } else {

	            gameOver(g);
	        }        
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
