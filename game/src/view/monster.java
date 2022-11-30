package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.math.MathContext;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.Timer;

import model.Collider;

public class monster {
	Image monster;
	ImageIcon[] monsterim;
	int monsteri,width,height,monsternumim;
	public int hp,newhp,counterhp;
	public int maxhp;
	public boolean donei,detectplayer,dying,alive;
	int mi ;
	int scalex,scaley,rx,ry;
	public int monsterdame;
	public int mx,my;
	public int startx,starty;
	public int vel;
	public View board;
	Collider colli;
	public int chieu;
	public monster(View board) {
		this.board = board;
		monsteri=1;
		colli = new Collider();
		detectplayer = false;
		dying= false;
		alive = true;
		counterhp=0;
	}
	public void Init() {
		mx = startx;
		my = starty;
		hp = maxhp;
		newhp = hp;
	}
	public void paintmonster(Graphics g) {
		if(mx+width-board.pm.dichx>0&&mx-board.pm.dichx<768&&my+height-board.pm.dichy>0&&my-board.pm.dichy<560) {
		if(monsteri<monsternumim*4) {
			if(scalex == -1) {
				this.monster = monsterim[monsteri/4].getImage();
			
			}
			else {
				this.monster = monsterim[monsteri/4+monsternumim].getImage();
			}
			g.drawImage(this.monster,mx-board.pm.dichx,my-board.pm.dichy,board);
			if(!donei) {
			monsteri++;
			}
			else {
				monsteri--;
				if(monsteri<=1) {
					donei=false;
				}
			}
		}
		else {
			donei=true;
			monsteri-=4;
			g.drawImage(monster,mx-board.pm.dichx,my-board.pm.dichy,board);
		}
		}
			monstermove();
}
		
	public void monstermove() {
		detectplayer();
		Random r = new Random();
		if(!detectplayer && mi==0) {
			try {
				rx = r.nextInt(100)+1;	
				
				ry = r.nextInt(100)+1;	
			
				scalex = r.nextInt(2);	
				scaley = r.nextInt(2);	

				
				if(scalex==0) {
					scalex=-1;
				}
				if(scaley==0) {
					scaley=-1;
				}
				rx = startx +scalex*rx;
				ry = starty+scaley*ry;
				scaley = (ry-my)/Math.abs(ry-my);
				scalex = (rx-mx)/Math.abs(rx-mx);
				mi++;
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		
		}
		else if(detectplayer) {
			rx = board.pm.mx;
			ry = board.pm.my;
			vel = 2;
		}
		if(mi>0) {
					if((scalex*(rx-mx))>vel) {
						mx= mx + scalex*vel;
						colli.checkcollision(board, mx, my, width, height, vel, board.loadmap.lomap[board.loadmap.map].mapcolli);
						
						if(colli.collision==true) {
							rx=mx;
							mx=mx-scalex*vel;
							colli.collision = false;
							
						}
					}
					else {
							if((scaley*(ry-my))>vel) {
							my=my+ scaley*vel;
							colli.checkcollision(board, mx, my, width, height, vel, board.loadmap.lomap[board.loadmap.map].mapcolli);
							if(colli.collision==true) {
								ry=my;
								my=my-scaley*vel;
								colli.collision = false;
							}
						}
						else {
							mi=0;
						}
					}
			}
		}
	public void detectplayer() {
		
	}
	public void monsterhp(Graphics g){
		hp=newhp;
		if(hp<=0) {
			alive=false;
			dying=true;
		}
		 if(counterhp<40) {
		int hpwidth =(int) ((float)newhp/(float)maxhp *(float)width);
		g.setColor(Color.red);
		g.fillRect(mx-board.pm.dichx, my-board.pm.dichy-16, hpwidth, 6);
		g.drawRect(mx-board.pm.dichx,my-board.pm.dichy-16,width,6);
		counterhp++;
		}
		else {
			
			counterhp=0;
		}
	}
	public void paintmonsterdying(Graphics g) {
		
		
		dying=false;
	}
		
}
