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
	
	public InputStream mapmatrix;
	public BufferedReader readmap;
	View board;
	Collider colli = new Collider();
	public int mapw;
	public int maph;
	public int[][] mapcolli = new int[784][560];
	public Image Map;
	public ImageIcon map;
	public map(View board) {
		this.board = board;
	}
	
	public void createmap(Graphics g) {
		
		colli.setCollisionvat(mapcolli, 0, 0, 768, 560, 0);
		colli.setCollisionmap(this.mapcolli, 0, 0, 16, 512);
		colli.setCollisionmap(this.mapcolli, 768-16, 0, 16, 512);
		colli.setCollisionmap(this.mapcolli, 0, 60, 768, 16);
		colli.setCollisionmap(this.mapcolli, 0,512, 768, 16);
		vemap(g);
	}
	public void vemap(Graphics g) {
		
		ve ve = new ve(board);
		g.drawImage(Map,-board.pm.dichx,60-board.pm.dichy,board);
		
		try {
			readmap = new BufferedReader(new InputStreamReader(mapmatrix));
			int col = 0;
			int row = 0;
			while(col<48 && row <35) {
			String line = readmap.readLine()  ;
			while(col<48) {
				String numbers[] = line.split(" ");
				
				int num =  Integer.parseInt(numbers[col]);
				ve.vevat(g, num, col, row, mapcolli);
				
				col++;
				
			}
			if(col == 48) {
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
}
