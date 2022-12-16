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
import monster.monster;
import view.ve;

public class map {
	public boolean inevent = false;
	public boolean event=false,inbang = false;
	ve ve;
	public InputStream mapmatrix;
	public BufferedReader readmap;
	View board;
	Collider colli = new Collider();
	public monster[] monster;
	public int monsternum,inruong;
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
		this.vat = new vat[20];
		Bang = new ImageIcon("src/Image/map/map3/bang.png");
		bang = Bang.getImage();
		
	}
	
	public void createmap(InputStream mapmatrix) {    // Doc map tu file txt
		
		mapcolli = new int[mapw][maph];				// Doc map tu file txt
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
	public monster spwammonster(monster[] monster,int number ) {
		int i = (int) (Math.random()*number);
		return monster[i];
		
	}
	
	public void vemap(Graphics g) {
		 
		
		g.drawImage(Map,-board.pm.dichx,60-board.pm.dichy,board);
		board.pm.Thanhmau(g);
		g.drawImage(board.pm.player , board.pm.mx,board.pm.my,board);
		
		colli.setCollisionvat(mapcolli, 0, 0, 768, 560, 0);
		if(board.pm.dichx==0) {
		colli.setCollisionmap(this.mapcolli, 0, 0, 16, 560);
		}
		if(board.pm.dichx>= this.mapw -board.Width  ) {
		colli.setCollisionmap(this.mapcolli, 768-32, 0, 16, 560);
		}
		if(board.pm.dichy==0  ) {
		colli.setCollisionmap(this.mapcolli, 0, 60, 768, 16);
		}
		if(board.pm.dichy>= this.maph -board.Height  ) {
		colli.setCollisionmap(this.mapcolli, 0,560-32, 768, 16);
		}
		int col =0;
		int row =0;
			while(col<this.mapw/16 && row <this.maph/16) {						// ve map tu mang da doc tu file txt
				
				while(col<this.mapw/16) {// ve map tu mang da doc tu file txt
					try {
							ve.vevat(g,mapo[col][row], col, row, mapcolli,this); // ve map tu mang da doc tu file txt
					} catch (Exception e) {										// ve map tu mang da doc tu file txt
						// TODO: handle exception								// ve map tu mang da doc tu file txt
					}
					if(vat[mapo[col][row]]!=null&&vat[mapo[col][row]].name == "Object") {
						if(Math.abs(board.pm.mx-col*16+board.pm.dichx)<48&&Math.abs(board.pm.my-row*16-60+board.pm.dichy)<48) {
						colli.checkObject(this,board.pm.mx,board.pm.my,board.pm.pwidth,board.pm.pheight,board.pm.vel, mapcolli, mapo[col][row]); // mo ruong
							if(event) {									// mo ruong
								openchest(g, col,row);
							}
							}
					}
					if(vat[mapo[col][row]]!=null&&vat[mapo[col][row]].name == "Object1") {
						if(Math.abs(board.pm.mx-col*16+board.pm.dichx)<vat[mapo[col][row]].width&&Math.abs(board.pm.my-row*16-60+board.pm.dichy)<vat[mapo[col][row]].height) {
						colli.checkObject(this,board.pm.mx,board.pm.my,board.pm.pwidth,board.pm.pheight,board.pm.vel, mapcolli, mapo[col][row]);
							
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
		
				for(int i=0;i<monsternum;i++) {
					if(monster[i]!=null) {
						 ve.vequai(g,i, monster);			// Ve quai vat
						if(!monster[i].alive&&!monster[i].dying) {
							monster[i]=null;			// quai vat bien mat sau khi chet
						}
					}
				}
			}
	public void openchest(Graphics g,int col,int row) {
		
	}
	public void bang(Graphics g,String Thongbao) {
		g.drawImage(bang, 234,0,board);
		//g.setFont(new Font(Thongbao, Font.BOLD, 24));
		g.drawString(Thongbao, 260, 75);
		board.timer.stop();
		
	}
public void specialevent(Graphics g, int col, int row){
		
	}
}
