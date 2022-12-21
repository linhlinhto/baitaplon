package monster;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.math.MathContext;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.Timer;

import map.map;
import model.Collider;
import view.View;

public class monster {
	Image monster;
	ImageIcon[] monsterim,monsteratk,monsteratked;
	ImageIcon monsterdie;
	public int monsteri,width,height,monsternumim;
	public int hp,newhp,counterhp,counterdying,atackedcounter;
	public int maxhp,dame,atackspeed,dameget,atk,expgived;
	public boolean donei,detectplayer,dying,alive,atack,atacked;
	int mi,rangex,rangey, rangedetectx,rangedetecty,so ;
	public int scalex,scaley,rx,ry;
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
		mi=0;
	}
	public void Init(int map,int so) {
	
		mx = startx;
		my = starty;
		dame = dame*board.start.dokho+map;
		atackspeed = atackspeed/board.start.dokho;
		maxhp = maxhp*board.start.dokho+map*15;
		hp = maxhp;
		newhp = hp;
		this.so = so;
	}
	public void paintmonster(Graphics g,map map) {
		if(alive == true&&!dying) {
			if(!atacked) {
				if(!atack) {
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
			
				monstermove(g);
				}
				else if(atack) {
					atack(g);
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
		drawvat( mx, my, width, height, board.loadmap.lomap[board.loadmap.map],g);
		if(my+60-board.pm.dichy-32>0 && mx-board.pm.dichx-16>0 && my+60-board.pm.dichy<560-height && mx-board.pm.dichx<768-width) {
			 colli.setCollisionm(board.loadmap.lomap[board.loadmap.map].mapcolli, mx, my+48, width, height,50+so);
			}
}
		
	public void monstermove(Graphics g) {
		detectplayer();
		Random r = new Random();
		if(detectplayer && (mi==0||mi==1)) {
			rx = board.pm.mx-32+board.pm.dichx;
			ry = board.pm.my+board.pm.dichy + 28 - height;
			if(board.start.dokho==2) {
				vel++;
			}
			try {
				scaley = (ry-my)/Math.abs(ry-my);
				scalex = (rx-mx)/Math.abs(rx-mx);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			mi=2;
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
					colli.checkcollisionm( mx, my+32, width, height,vel,this, board.loadmap.lomap[board.loadmap.map],50+so);
					
					if(atack==true) {
						ry=my;
						my=my-scaley*vel;
						colli.collision = false;
					}
					else if(colli.collision==true) {
						if(detectplayer) {
							my = my-scaley*vel;
							mx = mx+scalex*vel;
							colli.collision = false;
						}
						else {
							ry=my;
							my=my-scaley*vel;
							colli.collision = false;
						}
							
						}
						
					}
					else {
							if((scalex*(rx-mx))>vel) {
							mx= mx + scalex*vel;
							
								colli.checkcollisionm( mx, my+32, width, height,vel,this, board.loadmap.lomap[board.loadmap.map],50+so);
							if(atack==true) {
								rx=mx;
								mx=mx-scalex*vel;
								colli.collision = false;
							}
							else if(colli.collision==true) {
								if(detectplayer) {
								mx=mx-scalex*vel;
								my= my + scaley*vel;
								colli.collision = false;
								}
								else {
									rx = mx;
									mx = mx- scalex*vel;
									colli.collision = false;
								}
								
							}
							
						}
						else {
							mi=0;
							detectplayer = false;
						}
					}
			}
		
		}
	public void detectplayer() {
		
		for(int i = my-16-board.pm.dichy;i<my-board.pm.dichy+height;i++) {
			for(int j = mx-board.pm.dichx;j<mx-board.pm.dichx+width;j++) {
				try {
						if(rangedetecty>=Math.abs(board.pm.my-i) && rangedetectx>= Math.abs(board.pm.mx-j)) {
							detectplayer = true;
							break;
						}
							else {
								detectplayer=false;
							}
					
				
				} catch (Exception e) {
					// TODO: handle exception
			
			}
			}
		}
		checkplayer();
		
		
	}
	public void monsterhp(Graphics g){
		if(newhp<=0) {
			alive=false;
			dying=true;
		}
		hp=newhp;
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
	public void atack(Graphics g) {
		
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
			board.pm.Thanhmau(g);
			atk = 0;
		}
		
	}
	public void atacked() {
		if(atackedcounter<4) {
			if(scalex ==-1) {
			monster = monsteratked[0].getImage();
			}
			else  {
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
		for(int i = my-16-board.pm.dichy;i<my-board.pm.dichy+height;i++) {
			for(int j = mx-board.pm.dichx;j<mx-board.pm.dichx+width;j++) {
					if(rangey>=Math.abs(board.pm.my-i) && rangex>= Math.abs(board.pm.mx-j)) {
						atack = true;
						detectplayer = false;
						break;
					}
			}
		}
	}
	public void drawvat(int x, int y, int width, int height, map map, Graphics g) {
		boolean canbreak=false;
		for (int i=x;i<x+width;i++) {
			for(int j=y-200;j<y+height;j++) {
				if(j>0  && j%16==0) {
					if(j/16 < map.maph/16) {
					for(int z=i/16-5;z<i/16+5;z++) {
						if(z>0&&z<map.mapw/16 ) {
							if(map.mapo[z][j/16]>4) {
								if( my+height< j+map.vat[map.mapo[z][j/16]].height) {
									canbreak = true;
									g.drawImage(map.vat[map.mapo[z][j/16]].anhvat,z*16-board.pm.dichx,j-board.pm.dichy+60,board);
									if(board.pm.my+board.pm.dichy > y+map.vat[map.mapo[z][j/16]].height+32) {
										g.drawImage(board.pm.player, board.pm.mx,board.pm.my,board);
				 						}

								}
							}
						
						}
					}
					}
				}
				if(canbreak) {
					break;
				}
			}
			
		}
	}
		
}
