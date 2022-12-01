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
	ImageIcon[] monsterim,monsteratk,monsteratked;
	ImageIcon monsterdie;
	public int monsteri,width,height,monsternumim;
	public int hp,newhp,counterhp,counterdying,atackedcounter;
	public int maxhp,dame,atackspeed,dameget,atk;
	public boolean donei,detectplayer,dying,alive,atack,atacked;
	int mi,rangex,rangey ;
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
		atack = false;
		atacked= false;
		counterhp=0;
		counterdying=0;
		dameget=0;
		atackedcounter=0;
		atk =0;
	}
	public void Init() {
		mx = startx;
		my = starty;
		dame = dame*board.start.dokho;
		atackspeed = atackspeed/board.start.dokho;
		maxhp = maxhp*board.start.dokho;
		hp = maxhp;
		newhp = hp;
	}
	public void paintmonster(Graphics g) {
		if(alive == true&&!dying) {
			if(!atacked) {
				if(!atack) {
					if(mx+width-board.pm.dichx>0&&mx-board.pm.dichx<768&&my+height-board.pm.dichy>0&&my-board.pm.dichy<560) {
						if(monsteri<monsternumim*5) {
							if(scalex == -1) {
								this.monster = monsterim[monsteri/5].getImage();
									
							}
							else {
								this.monster = monsterim[monsteri/5+monsternumim].getImage();
							}
			
							monsteri++;
						}
						else {
							monsteri=1;
						}
					}
			
				monstermove();
				}
				else if(atack) {
					atack();
				}
			}
			else if(atacked) {
				atacked();
			}
			
		}
		else if(!alive &&dying) {
			
			paintmonsterdying();
		}
		g.drawImage(this.monster,mx-board.pm.dichx,my-board.pm.dichy,board);
}
		
	public void monstermove() {
		detectplayer();
		Random r = new Random();
		if(detectplayer) {
			rx = board.pm.mx-32+board.pm.dichx;
			ry = board.pm.my+board.pm.dichy;
			//vel++;
			try {
				scaley = (ry-my)/Math.abs(ry-my);
				scalex = (rx-mx)/Math.abs(rx-mx);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			mi=1;
		}
		else if(!detectplayer && mi==0) {
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
		
		if(mi>0) {
			if((scaley*(ry-my))>vel) {
				my=my+ scaley*vel;
				if(my-board.pm.dichy>0 && mx-board.pm.dichx>0 && my+60-board.pm.dichy<560-height && mx-board.pm.dichx<768-width) {
					colli.checkcollision(board, mx-board.pm.dichx, my+60-board.pm.dichy, width, height, vel, board.loadmap.lomap[board.loadmap.map].mapcolli);
					}
						if(colli.collision==true) {
							ry=my;
							my=my-scaley*vel;
							colli.collision = false;
							
						}
					}
					else {
							if((scalex*(rx-mx))>vel) {
							mx= mx + scalex*vel;
							if(my+60-board.pm.dichy>0 && mx-board.pm.dichx>0 && my+60-board.pm.dichy<560-height && mx-board.pm.dichx<768-width) {
							colli.checkcollision(board, mx-board.pm.dichx, my+32-board.pm.dichy, width, height, vel, board.loadmap.lomap[board.loadmap.map].mapcolli);
							}
							if(colli.collision==true) {
								System.out.println("colli");
								rx=mx;
								mx=mx-scalex*vel;
								colli.collision = false;
							}
						}
						else {
							mi=0;
							detectplayer = false;
						}
					}
			}
		if(my+60-board.pm.dichy>0 && mx-board.pm.dichx>0 && my+60-board.pm.dichy<560-height && mx-board.pm.dichx<768-width) {
		 colli.setCollisionvat(board.loadmap.lomap[board.loadmap.map].mapcolli, mx-board.pm.dichx, my+60-board.pm.dichy+60, width, height, 50);
		}
		}
	public void detectplayer() {
		
		
		if(Math.abs(board.pm.mx-mx-board.pm.dichx)<100&&Math.abs(board.pm.my-my-board.pm.dichy)<100) {
			detectplayer = true;
		}
		else {
			detectplayer=false;
		}
		checkplayer();
	}
	public void monsterhp(Graphics g){
		hp=newhp;
		if(hp<=0) {
			alive=false;
			dying=true;
		}
		 if(counterhp<40&&alive) {
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
	public void paintmonsterdying( ) {
		if(counterdying<15) {
			monster = monsterdie.getImage();
			counterdying++;
		}
		else {
			this.dying=false;	
		}
		
	}
	public void atack() {
		
		if(atk<atackspeed) {
					if(scalex ==-1){
						if(atk==0) {
							
						}
						if(atk/5<5) {
						monster = monsteratk[atk/5].getImage();
						}
						else {
							monster = monsteratk[4].getImage();
							}
						}
						else {
							if(atk/5<5) {
								monster = monsteratk[atk/5+5].getImage();
								}
								else {
									monster = monsteratk[9].getImage();
								}
						}
					atk++;
		}
		else {
			atack = false;
			board.pm.mau -= dame;
			atk = 0;
		}
		
	}
	public void atacked() {
		if(atackedcounter<4) {
			if(scalex ==-1) {
			monster = monsteratked[0].getImage();
			}
			else {
				monster = monsteratked[1].getImage();
			}
			atackedcounter++;
		}
		else {
			newhp = hp-dameget;
			atacked = false;
			atackedcounter=0;
		}
	}
	public void checkplayer() {
		
		for(int i = my-board.pm.dichy;i<my-board.pm.dichy+height;i++) {
			for(int j = mx-board.pm.dichx;j<mx-board.pm.dichx+width;j++) {
				try {
				if(i==(board.pm.my+(-scaley)*rangey) && j == (board.pm.mx+(-scalex)*rangex)) {
					detectplayer = false;
					atack = true;
					break;
				}
				} catch (Exception e) {
					// TODO: handle exception
			
			}
			}
		}
	}
		
}
