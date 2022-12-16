package model;

import java.awt.Graphics;

import map.map;
import map.map1;
import map.map2;
import map.map3;
import view.View;

public class loadmap {
	public map[] lomap;
	public int map;
	public int mapw;
	public int maph;
	View board;
	public loadmap(View board) {
		this.board = board;
		Initmap();
	
	}
	
	public void Initmap() {
		lomap = new map[5];
		lomap[1] = new map1(board);	
		lomap[2] = new map2(board);	
		lomap[3] = new map3(board);	
		map = 2;
	}
	public void drawmap(Graphics g) {
			maph = lomap[map].maph;
			mapw = lomap[map].mapw;
			lomap[map].vemap(g);
		
	}
}
