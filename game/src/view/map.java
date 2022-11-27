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

public class map {
	ve ve;
	public InputStream mapmatrix;
	public BufferedReader readmap;
	View board;
	Collider colli = new Collider();
	public int mapw;
	public int maph;
	public int[][] mapcolli ;
	public int[][] mapo;
	public Image Map;
	public ImageIcon map;
	public map(View board) {
		this.board = board;
		ve = new ve(board);
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
	public void vemap(Graphics g) {
		 
		
		g.drawImage(Map,-board.pm.dichx,60-board.pm.dichy,board);
		board.pm.Thanhmau(g);
		g.drawImage(board.pm.player , board.pm.mx,board.pm.my,board);
		colli.setCollisionvat(mapcolli, 0, 0, 768, 560, 0);
		colli.setCollisionmap(this.mapcolli, 0, 0, 16, 512);
		colli.setCollisionmap(this.mapcolli, 768-16, 0, 16, 512);
		colli.setCollisionmap(this.mapcolli, 0, 60, 768, 16);
		colli.setCollisionmap(this.mapcolli, 0,516, 768, 16);
		int col =0;
		int row =0;
		while(col<this.mapw/16 && row <this.maph/16) {
			
			while(col<this.mapw/16) {
					if(mapo[col][row]>6) {
						ve.vevat(g,mapo[col][row], col, row, mapcolli);
					}
				col++;
				
			}
			if(col == this.mapw/16) {
				col = 0;
				row++;	
			}
			}
	}
}
