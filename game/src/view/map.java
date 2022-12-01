package view;

import java.awt.Graphics;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.ImageIcon;
import model.Collider;
import model.Spwammonster;
import model.vat;

public class map {
	ve ve;
	public InputStream mapmatrix;
	public BufferedReader readmap;
	View board;
	Collider colli = new Collider();
	public monster[] monster;
	public int monsternum;
	public int mapw;
	public int maph;
	public int[][] mapcolli ;
	public int[][] mapo;
	public Image Map;
	public ImageIcon map;
	public vat[] vat;
	public map(View board) {
		this.board = board;
		ve = new ve(board);
		vat = new vat[20];
	}
	
	public void createmap(InputStream mapmatrix) {
		
		mapcolli = new int[mapw][maph];
		mapo = new int[mapw/16][maph/16];
		try {
			
			readmap = new BufferedReader(new InputStreamReader(mapmatrix));
			
			int col = 0;
			int row = 0;
		
			while(col<this.mapw/16 && row <this.maph/16) {
				
			String line = readmap.readLine()  ;
			while(col<this.mapw/16) {
				String numbers[] = line.split(" ");
				
				int num =  Integer.parseInt(numbers[col]);
				
				mapo[col][row] = num;
				
				col++;
				
			}
			if(col == this.mapw/16) {
				col = 0;
				row++;	
			}
			}
			readmap.close();
		} catch (Exception e) {
			System.out.println("chiu");
			// TODO: handle exception
		}
	}
	public monster spwammonster(monster[] monster,int number,int[] rate ) {
		int m=0;
		int i = (int) (Math.random()*100);
		for(int j =0;j<number;j++) {
			if(j>=1) {
			if(i<rate[j] && i >rate[j-1] ) {
				m=j;
			}
			}
			else {
				m=j;
			}
		}
		return monster[m];
		
	}
	
	public void vemap(Graphics g) {
		 
		
		g.drawImage(Map,-board.pm.dichx,60-board.pm.dichy,board);
		board.pm.Thanhmau(g);
		g.drawImage(board.pm.player , board.pm.mx,board.pm.my,board);
		colli.setCollisionvat(mapcolli, 0, 0, 768, 560, 0);
		colli.setCollisionmap(this.mapcolli, 0, 0, 16, 512);
		colli.setCollisionmap(this.mapcolli, 768-16, 0, 16, 512);
		colli.setCollisionmap(this.mapcolli, 0, 60, 768, 16);
		colli.setCollisionmap(this.mapcolli, 0,516-16, 768, 16);
		int col =0;
		int row =0;
		colli.setCollisionvat(board.loadmap.lomap[board.loadmap.map].mapcolli,board.pm.mx, board.pm.my+60,board.pm.pwidth , board.pm.pheight, 50);
			while(col<this.mapw/16 && row <this.maph/16) {
				
				while(col<this.mapw/16) {
					try {
							ve.vevat(g,mapo[col][row], col, row, mapcolli,this);
					} catch (Exception e) {
						// TODO: handle exception
					}
					col++;
					
				}
				if(col == this.mapw/16) {
					col = 0;
					row++;	
				}
				}
		
				for(int i=0;i<monsternum;i++) {
					if(monster[i]!=null) {
						if(monster[i].mx+monster[i].width-board.pm.dichx>0&&monster[i].my+monster[i].height+60-board.pm.dichy>0&&monster[i].mx-board.pm.dichx<768&&monster[i].my-board.pm.dichy+60<560) {
						
						ve.vequai(g,i, monster);
						
					}
						if(!monster[i].alive&&!monster[i].dying) {
							monster[i]=null;
						}
					}
				}
			}
}
