package view;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

import javax.swing.ImageIcon;

import model.Collider;
import model.vat;

public class map1 extends map {
	

	public map1(View board) {
		super(board);
		// TODO Auto-generated constructor stub
		loadmap();
		createmaptxt();
		monster();
	}
	public void loadmap() {
		this.map = new ImageIcon("src/Image/map/map1.png");
		this.Map = map.getImage();
		loadanh();
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
	public void monster() {
		this.monsternum = 1;
		monster[] monster = new monster[6];
		this.monster = new monster[monsternum];
		monster[0] = new Bee(board);
		int[] rate = new int[1];
		rate[0] = 100;
		this.monster[0] = this.spwammonster(monster, 1, rate);
		this.monster[0].startx = 128;
		this.monster[0].starty = 248;
		this.monster[0].Init();
		this.monster[0].chieu=1;
		this.monster[0].mi =0;
	}
	public void loadanh() {
		vat[7] = new vat();
		vat[7].loadanh =  new ImageIcon("src/Image/map/da.png");
		vat[7].anhvat = vat[7].loadanh.getImage();
		vat[7].height = 72;
		vat[7].width = 48;
		vat[7].colliheight = 64;
		vat[8] = new vat();
		vat[8].loadanh =  new ImageIcon("src/Image/map/dacongu.png");
		vat[8].anhvat = vat[8].loadanh.getImage();
		vat[8].height = 72;
		vat[8].width = 48;
		vat[8].colliheight = 32;
		vat[9] = new vat();
		vat[9].loadanh =  new ImageIcon("src/Image/map/da2.png");
		vat[9].anhvat = vat[9].loadanh.getImage();
		vat[9].height = 96;
		vat[9].width = 48;
		vat[9].colliheight = 32;
		vat[10] = new vat();
		vat[10].loadanh =  new ImageIcon("src/Image/map/dacongu2.png");
		vat[10].anhvat = vat[10].loadanh.getImage();
		vat[10].height = 96;
		vat[10].width = 48;
		vat[10].colliheight = 32;
		vat[11] = new vat();
		vat[11].loadanh = new ImageIcon("src/Image/map/tuong.png");
		vat[11].anhvat = vat[11].loadanh.getImage();
		vat[11].height = 160;
		vat[11].width = 80;
		vat[11].colliheight = 48;
		vat[12] = new vat();
		vat[12].loadanh = new ImageIcon("src/Image/map/bui.png");
		vat[12].anhvat = vat[12].loadanh.getImage();
		vat[12].height = 32;
		vat[12].width = 36;
		vat[12].colliheight = 6;
		vat[13] = new vat();
		vat[13].loadanh = new ImageIcon("src/Image/map/buihoa.png");
		vat[13].anhvat = vat[13].loadanh.getImage();
		vat[13].height = 32;
		vat[13].width = 36;
		vat[13].colliheight = 6;
		vat[14] = new vat();
		vat[14].loadanh = new ImageIcon("src/Image/map/cay.png");
		vat[14].anhvat = vat[14].loadanh.getImage();
		vat[14].height = 144;
		vat[14].width = 112;
		vat[14].colliheight = 16 ;
		vat[15] = new vat();
		vat[15].loadanh = new ImageIcon("src/Image/map/cayhoa.png");
		vat[15].anhvat = vat[15].loadanh.getImage();
		vat[15].height = 144;
		vat[15].width = 112;
		vat[15].colliheight = 16 ;
		vat[16] = new vat();
		vat[16].loadanh = new ImageIcon("src/Image/map/thung.png");
		vat[16].anhvat = vat[16].loadanh.getImage();
		vat[16].height = 48;
		vat[16].width = 32;
		vat[16].colliheight = 32 ;
		vat[17] = new vat();
		vat[17].loadanh = new ImageIcon("src/Image/map/ruong.png");
		vat[17].anhvat = vat[17].loadanh.getImage();
		vat[17].height = 32;
		vat[17].width = 32;
		vat[17].colliheight = 16;
		vat[18] = new vat();
		vat[18].loadanh = new ImageIcon("src/Image/map/ghe.png");
		vat[18].anhvat = vat[18].loadanh.getImage();
		vat[18].height = 48;
		vat[18].width = 60;
		vat[18].colliheight = 24;
		
		
	}
	 

}
