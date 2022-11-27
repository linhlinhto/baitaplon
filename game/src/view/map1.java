package view;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

import javax.swing.ImageIcon;

import model.Collider;

public class map1 extends map {
	

	public map1(View board) {
		super(board);
		// TODO Auto-generated constructor stub
		loadmap();
		createmaptxt();
	}
	public void loadmap() {
		this.map = new ImageIcon("src/Image/map/map1.png");
		this.Map = map.getImage();
		
	}
	public void createmaptxt() {
		this.mapw = 1920;
		this.maph = 1088;
		try {
			this.mapmatrix = getClass().getResourceAsStream("/maptxt/map1.txt");
			createmap(mapmatrix);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
	 

}
