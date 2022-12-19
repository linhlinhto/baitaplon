package map;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.ImageIcon;

import model.vat;
import monster.Frog;
import monster.monster;
import view.View;

public class map2 extends map {

	public map2(View board) {
		super(board);
		// TODO Auto-generated constructor stub
		loadmap();
		createmaptxt();
		monster();
	}
	public void loadmap() {
		inruong=0;
		this.mapw = 1280;
		this.maph = 1930;
		this.map = new ImageIcon("src/Image/map/map2/map2.png"); // load background map
		this.Map = map.getImage();
		loadanh();
		}
		public void createmaptxt() {
		
		try {
			this.mapmatrix = getClass().getResourceAsStream("/maptxt/map2.txt");
			createmap(mapmatrix);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		}
		public void monster() {
			this.monsternum = 8;
			this.monster = new monster[monsternum];

			this.spwammonster(this.monster,0,128,248,2);
			this.spwammonster(this.monster,1,268,248,2);
			this.spwammonster(this.monster,2,196,412,2);
			this.spwammonster(this.monster,3,1048,1576,2);
			this.spwammonster(this.monster,4,984,1428,2);
			this.spwammonster(this.monster,5,678,798,2);
			this.spwammonster(this.monster,6,784,1820,2);
			this.spwammonster(this.monster,7,164,1768,2);

		}
		public void loadanh() { // load anh cua do vat tren map
			vat[1] = new vat();
			vat[1].height = 80;
			vat[1].width = 16;
			vat[1].colliheight = 80;
			vat[3] = new vat();
			vat[3].height = 16;
			vat[3].width = 96;
			vat[3].colliheight = 16;
		vat[7] = new vat();
		vat[7].loadanh =  new ImageIcon("src/Image/map/map2/thung.png");
		vat[7].anhvat = vat[7].loadanh.getImage();
		vat[7].height = 72;
		vat[7].width = 48;
		vat[7].colliheight = 48;
		vat[8] = new vat();
		vat[8].name = "Object";
		vat[8].loadanh = new ImageIcon("src/Image/map/map2/ruong.png");
		vat[8].anhvat = vat[8].loadanh.getImage();
		vat[8].height = 32;
		vat[8].width = 32;
		vat[8].colliheight = 16;
		vat[9] = new vat();
		vat[9].loadanh = new ImageIcon("src/Image/map/map2/ruongmo.png");
		vat[9].anhvat = vat[9].loadanh.getImage();
		vat[9].height = 32;
		vat[9].width = 32;
		vat[9].colliheight = 16;
		vat[10] = new vat();
		vat[10].loadanh =  new ImageIcon("src/Image/map/map2/well.png");
		vat[10].anhvat = vat[10].loadanh.getImage();
		vat[10].height = 48;
		vat[10].width = 64;
		vat[10].colliheight = 48;
		vat[11] = new vat();
		vat[11].loadanh = new ImageIcon("src/Image/map/map2/tuong.png");
		vat[11].anhvat = vat[11].loadanh.getImage();
		vat[11].height = 160;
		vat[11].width = 80;
		vat[11].colliheight = 48;
		vat[12] = new vat();
		vat[12].loadanh = new ImageIcon("src/Image/map/map2/dacongu.png");
		vat[12].anhvat = vat[12].loadanh.getImage();
		vat[12].height = 72;
		vat[12].width = 48;
		vat[12].colliheight = 32;
		
		
		}
		@Override
		public void openchest(Graphics g, int col,int row) {
		Random r = new Random();
		String thongbao=" ";
		int rate;
		g.setColor(Color.WHITE);
		if(inruong==0) {
		rate =  r.nextInt(100);
		
		if(rate<75 ) {
			
			thongbao="Ban nhan duoc 1 binh mau";
			board.pm.poison++;
			inruong++;
			inbang=true;
		}
		}
		else if(inruong==2) {
		rate = r.nextInt(200);
		thongbao = "ban nhan duoc "+rate+" exp";
		board.pm.exp +=rate;
		inruong++;
		inbang=true;
		}
		if(inbang == true) {
		bang(g,thongbao);
		}
		else {
			inruong++;
			if(inruong>=3) {
				
				this.event = false;
				this.inevent = false;
				mapo[col][row]++;
				inruong=0;
			}
		}
		
		}

}
