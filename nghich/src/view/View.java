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
import model.Collider;
public class View extends JPanel implements ActionListener  {
	Collider colli = new Collider();
	playermodel pm = new playermodel();
	vat vat = new vat();
	public int Width = 768;
	public int Height = 512;
	int map;
	int pixel=16;
	boolean ingame;
	Timer timer;  
	Image Map;
	map1 loadmap = new map1();
	TAdapter move = new TAdapter();
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
		loadmap();
	}
	public void loadmap() {
		if(map==1) {
			Map = loadmap.Map;

		}
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
		
		checkcollision(pm.mx,pm.my, pm.vel, loadmap.mapcolli);
		 if(move.right && !move.Idle ) {
			pm.moveright();
			System.out.println(""+(pm.dichx-32)+"  "+(loadmap.mapw - Width));
		}
		if(move.left && !move.Idle) {
				pm.moveleft();
				System.out.println(""+(pm.dichx-32)+"  "+(loadmap.mapw - Width));
		}
		if(move.up && !move.Idle) {
				pm.moveup();
				System.out.println(""+(pm.dichy-32)+"  "+(loadmap.maph - Height));
		}
		if(move.down && !move.Idle) {
				pm.movedown();
				System.out.println(""+(pm.dichy-32)+"  "+(loadmap.maph - Height));
		}
		if(move.Idle) {
			pm.Idle();
		}
		
	}
	public void checkcollision(int x, int y,int vel, int[][] mapcolli) {
		y=y+64;
		x=x+16;
		for (int i=x; i<x+46;i++) {
			for(int j=y;j<y+30;j++) {
				if(move.right == true && mapcolli[i+vel][j] == 2  ) {
					pm.moveright();
					pm.mx -=vel;
					move.right = false;
					move.Idle = true;
				}
				 if(move.left == true && mapcolli[i-vel][j] == 2  ) {
					 pm.moveleft();
						pm.mx +=vel;
					move.left = false;
					move.Idle = true;
				}
				 if(move.down == true && mapcolli[i][j+vel] == 2  ) {
					 pm.movedown();
						pm.my -=vel;
					move.down = false;
					move.Idle =true;
				}
				if(move.up == true && mapcolli[i][j-vel] == 2  ) {
					pm.moveup();
					pm.my +=vel;
					move.up =false;
					move.Idle = true;
				}
				
			}
			if(i == Width/2 && (pm.dichx-32) < (loadmap.mapw - Width) && move.right == true) {
				 pm.dichx+=pm.vel;
				 pm.mx-=pm.vel;
				 System.out.println("dich map");
				 break;
				
				}
			if(i == Width/2 && (Width+pm.dichx-32) > Width && move.left == true) {
				 pm.dichx-=pm.vel;
				 pm.mx+=pm.vel;
				 System.out.println("dich map");
				 break;
				 
			}
		}
		for(int j=y;j<y+32;j++) {
			if(j == Height/2 && (pm.dichy-32) < (loadmap.maph - Height) && move.down == true) {
				 pm.dichy+=pm.vel;
				 pm.my-=pm.vel;
				 System.out.println("dich map");
				 break;
				 
			}
			
			if(j == Height/2 && (Height+pm.dichy-32) > Height && move.up == true ) {
				pm.dichy-=pm.vel;
				pm.my+=pm.vel;
				System.out.println("dich map");
				break;
				
			}
		}
	}
	 @Override
	    public void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        drawmap(g);
	        doDrawing(g);
	    }
	    
	 	private void drawmap(Graphics g) {
					g.drawImage(Map,-pm.dichx,-pm.dichy,this);
	 	}
	    private void doDrawing(Graphics g) {
	        
	        if (ingame) {
	        	veda(g,loadmap.dax[0],loadmap.day[0]);
	        	

	            Toolkit.getDefaultToolkit().sync();

	        } else {

	            gameOver(g);
	        }        
	    }
	    private void vetuong(Graphics g, int tuongy) {
	    	if(!move.Idle) {
	        	if(pm.my+16<tuongy) {
	        		g.drawImage(pm.playerMove , pm.mx,pm.my,this); 
	        	g.drawImage(vat.tuong, 320-pm.dichx+16, 240-pm.dichy+16, this);
	        	}
	        	else {
	        		g.drawImage(vat.tuong, 320-pm.dichx+16, 240-pm.dichy+16, this);
	        		g.drawImage(pm.playerMove , pm.mx,pm.my,this); 
	        	}
	        	}
	        	else if(move.Idle) {
		        	if(pm.my+16<tuongy) {
		        		g.drawImage(pm.playerIdle , pm.mx,pm.my,this); 
		        	g.drawImage(vat.tuong, 320+16-pm.dichx, 240-pm.dichy+16, this);
		        	}
		        	else {
		        		g.drawImage(vat.tuong, 320-pm.dichx+16, 240-pm.dichy+16, this);
		        		g.drawImage(pm.playerIdle , pm.mx,pm.my,this); 
		        	}
		        	}
	    }
	    private void veda(Graphics g,int dax, int day) {
	    	if(!move.Idle) {
	        	if(pm.my<day+20) {
	        		g.drawImage(pm.playerMove , pm.mx,pm.my,this); 
	        	g.drawImage(vat.da, dax-pm.dichx, day-pm.dichy, this);
	        	}
	        	else {
	        		g.drawImage(vat.da, dax-pm.dichx, day-pm.dichy, this);
	        		g.drawImage(pm.playerMove , pm.mx,pm.my,this); 
	        	}
	        	}
	        	else if(move.Idle) {
		        	if(pm.my<day+20) {
		        		g.drawImage(pm.playerIdle , pm.mx,pm.my,this); 
		        	g.drawImage(vat.da, dax-pm.dichx, day-pm.dichy, this);
		        	}
		        	else {
		        		g.drawImage(vat.da, dax-pm.dichx, day-pm.dichy, this);
		        		g.drawImage(pm.playerIdle , pm.mx,pm.my,this); 
		        	}
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
