package model;

import java.awt.Graphics;
import java.awt.Image;

import view.View;
import view.map1;

public class loadmap {
	public int[][] mapcolli;
	public int map;
	public int mapw;
	public int maph;
	View board;
	private map1 map1 ;
	public loadmap(View board) {
		this.board = board;
		Initmap();
		map1 = new map1(board);
	}
	
	public void Initmap() {
		map =1;
		
	}
	public void loadthismap(Graphics g) {
		if(this.map == 1) {
			
			maph = map1.maph;
			mapw = map1.mapw;
			map1.vemap(g);
			mapcolli = map1.mapcolli;
		}
	}
}
