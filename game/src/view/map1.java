package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Random;

import javax.swing.ImageIcon;

import model.Collider;
import model.vat;
import monster.Frog;
import monster.monster;

public class map1 extends map {
		int inruong;
		int congu;
		int dacongu;
	public map1(View board) {
		super(board);
		// TODO Auto-generated constructor stub
		loadmap();
		createmaptxt();
		monster();
		
	}
	public void loadmap() {
		inruong=0;
		congu=0;
		dacongu=0;
		this.mapw = 1920;
		this.maph = 1088;
		this.map = new ImageIcon("src/Image/map/map1/map1.png"); // load background map
		this.Map = map.getImage();
		loadanh();
	}
	public void createmaptxt() {
		
		try {
			this.mapmatrix = getClass().getResourceAsStream("/maptxt/map4.txt");
			createmap(mapmatrix);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
	public void monster() {
		this.monsternum = 1;
		monster[] monster = new monster[6];
		monster[0] = new Frog(board);
		this.monster = new monster[monsternum];
		int[] rate = new int[1];
		rate[0] = 100;
		this.monster[0] = this.spwammonster(monster, 1, rate);
		this.monster[0].startx = 128;
		this.monster[0].starty = 248;
		this.monster[0].Init();
	
	}
	public void loadanh() {   // load anh cua do vat tren map
		vat[7] = new vat();
		vat[7].name = "Object1";
		vat[7].loadanh =  new ImageIcon("src/Image/map/map1/da.png");
		vat[7].eventdone = false;
		vat[7].anhvat = vat[7].loadanh.getImage();
		vat[7].height = 72;
		vat[7].width = 48;
		vat[7].colliheight = 32;
		
		vat[9] = new vat();
		vat[9].name = "Object1";
		vat[9].loadanh =  new ImageIcon("src/Image/map/map1/da2.png");
		vat[9].eventdone = false;
		vat[9].anhvat = vat[9].loadanh.getImage();
		vat[9].height = 96;
		vat[9].width = 48;
		vat[9].colliheight = 32;
		vat[10] = new vat();
		vat[10].loadanh =  new ImageIcon("src/Image/map/map1/dacongu2.png");
		vat[10].eventdone = false;
		vat[10].anhvat = vat[10].loadanh.getImage();
		vat[10].height = 96;
		vat[10].width = 48;
		vat[10].colliheight = 32;
		vat[11] = new vat();
		vat[11].loadanh = new ImageIcon("src/Image/map/map1/tuong.png");
		vat[11].anhvat = vat[11].loadanh.getImage();
		vat[11].height = 160;
		vat[11].width = 80;
		vat[11].colliheight = 48;
		vat[12] = new vat();
		vat[12].name = "Object2";
		vat[12].loadanh = new ImageIcon("src/Image/map/map1/bui.png");
		vat[12].loadanh2 = new ImageIcon("src/Image/map/map1/buihoa.png");
		vat[12].anhvat = vat[12].loadanh.getImage();
		vat[12].height = 32;
		vat[12].width = 36;
		vat[12].colliheight = 6;
		vat[14] = new vat();
		vat[14].loadanh = new ImageIcon("src/Image/map/map1/cay.png");
		vat[14].loadanh2 = new ImageIcon("src/Image/map/map1/cayhoa.png");
		vat[14].anhvat = vat[14].loadanh.getImage();
		vat[14].height = 144;
		vat[14].width = 112;
		vat[14].colliheight = 16 ;
		vat[16] = new	vat();
		vat[16].loadanh = new ImageIcon("src/Image/map/map1/thung.png");
		vat[16].anhvat = vat[16].loadanh.getImage();
		vat[16].height = 48;
		vat[16].width = 32;
		vat[16].colliheight = 32 ;
		vat[17] = new vat();
		vat[17].name = "Object";
		vat[17].loadanh = new ImageIcon("src/Image/map/map1/ruong.png");
		vat[17].eventdone = false;
		vat[17].anhvat = vat[17].loadanh.getImage();
		vat[17].height = 32;
		vat[17].width = 32;
		vat[17].colliheight = 16;
		vat[18] = new vat();
		vat[18].loadanh = new ImageIcon("src/Image/map/map1/ruongmo.png");
		vat[18].anhvat = vat[18].loadanh.getImage();
		vat[18].height = 32;
		vat[18].width = 32;
		vat[18].colliheight = 16;
		
		vat[19] = new vat();
		vat[19].loadanh = new ImageIcon("src/Image/map/map1/ghe.png");
		vat[19].anhvat = vat[19].loadanh.getImage();
		vat[19].height = 48;
		vat[19].width = 60;
		vat[19].colliheight = 24;
		
		
	}
	@Override
	public void openchest(Graphics g, int col,int row) {
		Random r = new Random();
		String thongbao=" ";
		int rate;
		g.setColor(Color.WHITE);
		if(inruong==0) {
			thongbao = "Ban nhan duoc 1 ngon ngu co";
			congu+=2;
			inruong++;
			inbang=true;
		}
		if(inruong==2) {
		rate =  r.nextInt(100);
		
		if(rate<75 ) {
			thongbao="Ban nhan duoc 1 binh mau";
			board.pm.poison++;
			inruong++;
			inbang=true;
		}
		}
		else if(inruong==4) {
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
			if(inruong>=5) {
				
				this.event = false;
				this.inevent = false;
				mapo[col][row]++;
				inruong=0;
			}
		}
		
	}
	@Override
public void specialevent(Graphics g, int col, int row){
		String thongbao=" ";
		if(congu%2==0&&congu>0) {
			thongbao = "Ban da kich hoat da co ngu ";
			congu--;
			inbang= true;
		}
		else {
			event = false;
		}
		
		if(inbang == true) {
			bang(g,thongbao);
			}
			else if(congu>0) {
					congu--;
					this.event = false;
					this.inevent = false;
					mapo[col][row]++;
			}
	}
	 

}
