package model;

import java.awt.Graphics;
import view.map;

import view.View;
import view.map1;

public class loadmap {
	public map[] lomap;
	public int map;
	public int mapw;
	public int maph;
	public Spwammonster[] sp;
	View board;
	public loadmap(View board) {
		this.board = board;
		Initmap();
		map=1;
		lomap = new map[5];
		lomap[1] = new map1(board);	
	}
	
	public void Initmap() {
		map =1;
	}
	public void drawmap(Graphics g) {
			maph = lomap[map].maph;
			mapw = lomap[map].mapw;
			lomap[map].vemap(g);
		
	}
}
