package map;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import view.View;

import javax.swing.ImageIcon;
import model.Collider;
import model.vat;
import monster.Dragon_fly1;
import monster.Frog;
import monster.Spore1;
import monster.monster;
import view.ve;

public class map {
	public boolean inevent = false,boss= false;
	public boolean event=false,inbang = false;
	ve ve;
	public InputStream mapmatrix;
	public BufferedReader readmap;
	View board;
	Collider colli = new Collider();
	public monster[] monster;
	public int monsternum,monstermaxnum,inruong;
	public int mapw;
	public int maph;
	public int[][] mapcolli ;
	public int[][] mapo;
	public Image Map,bang;
	public ImageIcon map,Bang;
	public vat vat[];
	public map(View board) {
		inruong=0;
		this.board = board;
		ve = new ve(board);
		this.vat = new vat[101];
		
		Bang = new ImageIcon("src/Image/map/map3/bang.png");
		bang = Bang.getImage();
		
	}
	
	public void createmap(InputStream mapmatrix) {		// Doc map tu file txt
		vat[100] = new vat();
		vat[100].width = mapw-16;
		vat[100].height = 16;
		vat[100].colliheight=16;
		
		vat[99] = new vat();
		vat[99].width = 16;
		vat[99].height = maph-16;
		vat[99].colliheight=maph-16;
		
		mapcolli = new int[this.mapw+16][this.maph+96];				// Doc map tu file txt
		mapo = new int[mapw/16][maph/16];			// Doc map tu file txt
		try {
			
			readmap = new BufferedReader(new InputStreamReader(mapmatrix)); // Doc map tu file txt
			
			int col = 0;									// Doc map tu file txt
			int row = 0;
		
			while(col<this.mapw/16 && row <this.maph/16) {			// Doc map tu file txt
				
			String line = readmap.readLine()  ;
			while(col<this.mapw/16) {
				String numbers[] = line.split(" ");						// Doc map tu file txt
				
				int num =  Integer.parseInt(numbers[col]);				// Doc map tu file txt
				
				mapo[col][row] = num;									// Doc map tu file txt
				
				
				
				col++;													// Doc map tu file txt
				
			}
			if(col == this.mapw/16) {
				col = 0;
				row++;	
			}
			}
			readmap.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void spwammonster(monster[] monster,int number,int startx,int starty, int map  ) {
		int i = (int) (Math.random()*3);
		if(i==0) {
			monster[number] = new Frog(board);
		}
		else if(i==1) {
			monster[number] = new Dragon_fly1(board);
		}
		else if(i==2) {
			monster[number] = new Spore1(board);
		}
		this.monster[number].startx = startx;
		this.monster[number].starty = starty;
		this.monster[number].Init(map,number);
		
	}
	
	public void vemap(Graphics g) {
		 
		
		g.drawImage(Map,-board.pm.dichx,60-board.pm.dichy,board);
		g.drawImage(board.pm.player, board.pm.mx,board.pm.my,board);
		colli.setCollisionvat(mapcolli, 0, 0, mapw, maph,0);
		int col =0;
		int row =0;
		
		
			while(col<this.mapw/16 && row <this.maph/16) {						// ve map tu mang da doc tu file txt
				
				while(col<this.mapw/16) {// ve map tu mang da doc tu file txt
					try {
							ve.vevat(g,mapo[col][row], col, row, mapcolli,this); // ve map tu mang da doc tu file txt
					} catch (Exception e) {						// ve map tu mang da doc tu file txt
						// TODO: handle exception								// ve map tu mang da doc tu file txt
					}
					if(vat[mapo[col][row]]!=null&&vat[mapo[col][row]].name == "Object") {
						if(Math.abs(board.pm.mx-col*16+board.pm.dichx)<48&&Math.abs(board.pm.my-row*16-60+board.pm.dichy)<48) {
							colli.checkObject(this,board.pm.mx+board.pm.dichx,board.pm.my+board.pm.dichy,board.pm.pwidth,board.pm.pheight,board.pm.vel, mapcolli, mapo[col][row]);// mo ruong
							if(event) {									// mo ruong
								openchest(g, col,row);
							}
							}
					}
					if(vat[mapo[col][row]]!=null&&vat[mapo[col][row]].name == "Object1") {
						if(Math.abs(board.pm.mx-col*16+board.pm.dichx)<vat[mapo[col][row]].width&&Math.abs(board.pm.my-row*16-60+board.pm.dichy)<vat[mapo[col][row]].height) {
						colli.checkObject(this,board.pm.mx+board.pm.dichx,board.pm.my+board.pm.dichy,board.pm.pwidth,board.pm.pheight,board.pm.vel, mapcolli, mapo[col][row]);
							
							if(event) {
								specialevent(g,col,row);
							}
							}
					}
					col++;														// ve map tu mang da doc tu file txt
					
				}																// ve map tu mang da doc tu file txt
				if(col == this.mapw/16) {
					col = 0;													// ve map tu mang da doc tu file txt
					row++;														// ve map tu mang da doc tu file txt
				}
				}
			for(int i=0;i<monstermaxnum;i++) {
				if(monster[i]!=null) {
					 ve.vequai(g,i, monster,this);			// Ve quai vat
					if( monster[i].hp <=0) {
						monsternum--;
						monster[i]=null;		// quai vat bien mat sau khi chet
					}
				}
			}
			if(boss) {
				checkboss();
			}
			board.pm.Thanhmau(g);
			}
	public void openchest(Graphics g,int col,int row) {
		
	}
	public void bang(Graphics g,String Thongbao) {
		g.drawImage(bang, 234,0,board);
		g.setFont(new Font("Arial",Font.BOLD,16));
		g.drawString(Thongbao, 260, 75);
		board.timer.stop();
		
	}
	public void specialevent(Graphics g, int col, int row){
		
	}
	public void checkboss() {
		
	}
}
