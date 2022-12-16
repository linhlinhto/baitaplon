package map;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Random;
import view.View;

import javax.swing.ImageIcon;

import model.Collider;
import model.vat;
import monster.Frog;
import monster.monster;
import view.View;

public class map1 extends map {
	boolean havekey;
	 int ruong =4,eventt;
	public map1(View board) {
		super(board);
		// TODO Auto-generated constructor stub
		loadmap();
		createmaptxt();
		monster();
	}
	public void loadmap() {
		inruong=0;
		this.mapw = 2448;
		this.maph = 1088;
		this.map = new ImageIcon("src/Image/map/map1/map1.png"); // load background map
		this.Map = map.getImage();
		loadanh();
		havekey = false;
		eventt=0;
		}
		public void createmaptxt() {
		
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
		monster[0] = new Frog(board);
		this.monster = new monster[monsternum];

		this.monster[0] = this.spwammonster(monster, 1);
		this.monster[0].startx = 128;
		this.monster[0].starty = 248;
		this.monster[0].Init();

		}
		public void loadanh() { // load anh cua do vat tren map
			vat[2] = new vat();
			vat[2].height = 80;
			vat[2].width = 16;
			vat[2].colliheight = 80;
		vat[7] = new vat();
		vat[7].loadanh =  new ImageIcon("src/Image/map/map1/cayhoa.png");
		vat[7].anhvat = vat[7].loadanh.getImage();
		vat[7].height = 144;
		vat[7].width = 112;
		vat[7].colliheight = 0;
		vat[8] = new vat();
		vat[8].name = "Object";
		vat[8].loadanh = new ImageIcon("src/Image/map/map1/ruong.png");
		vat[8].anhvat = vat[8].loadanh.getImage();
		vat[8].height = 32;
		vat[8].width = 32;
		vat[8].colliheight = 16;
		vat[9] = new vat();
		vat[9].loadanh = new ImageIcon("src/Image/map/map1/ruongmo.png");
		vat[9].anhvat = vat[9].loadanh.getImage();
		vat[9].height = 32;
		vat[9].width = 32;
		vat[9].colliheight = 16;
		vat[10] = new vat();
		vat[10].loadanh =  new ImageIcon("src/Image/map/map1/Props.png");
		vat[10].anhvat = vat[10].loadanh.getImage();
		vat[10].height = 64;
		vat[10].width = 94;
		vat[10].colliheight = 64;
		vat[11] = new vat();
		vat[11].loadanh = new ImageIcon("src/Image/map/map1/wall.png");
		vat[11].anhvat = vat[11].loadanh.getImage();
		vat[11].height = 64;
		vat[11].width = 64;
		vat[11].colliheight = 16;
		vat[12] = new vat();
		vat[12].loadanh = new ImageIcon("src/Image/map/map1/wall2.png");
		vat[12].loadanh2 = new ImageIcon("src/Image/map/map1/wall2.png");
		vat[12].anhvat = vat[12].loadanh.getImage();
		vat[12].height = 116;
		vat[12].width = 16;
		vat[12].colliheight = 64;
		vat[13] = new vat();
		vat[13].loadanh = new ImageIcon("src/Image/map/map1/wall3.png");
		vat[13].anhvat = vat[13].loadanh.getImage();
		vat[13].height = 64;
		vat[13].width = 128;
		vat[13].colliheight = 16 ;
		vat[14] = new	vat();
		vat[14].name = "Object1";
		vat[14].loadanh = new ImageIcon("src/Image/map/map1/door.png");
		vat[14].anhvat = vat[14].loadanh.getImage();
		vat[14].height = 64;
		vat[14].width = 48;
		vat[14].colliheight = 16 ;
		vat[15] = new vat();
		vat[15].loadanh = new ImageIcon("src/Image/map/map1/opendoor.png");
		vat[15].anhvat = vat[15].loadanh.getImage();
		vat[15].height = 60;
		vat[15].width = 48;
		vat[15].colliheight = 0 ;
		vat[16] = new vat();
		vat[16].loadanh = new ImageIcon("src/Image/map/map1/thung.png");
		vat[16].anhvat = vat[16].loadanh.getImage();
		vat[16].height = 72;
		vat[16].width = 48;
		vat[16].colliheight = 48 ;
		vat[17] = new vat();
		vat[17].loadanh = new ImageIcon("src/Image/map/map1/goccay.png");
		vat[17].anhvat = vat[17].loadanh.getImage();
		vat[17].height = 32;
		vat[17].width = 16;
		vat[17].colliheight = 16 ;
		vat[18] = new vat();
		vat[18].loadanh = new ImageIcon("src/Image/map/map1/tuong.png");
		vat[18].anhvat = vat[18].loadanh.getImage();
		vat[18].height = 160;
		vat[18].width = 80;
		vat[18].colliheight = 48;
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
		else if(inruong==4) {
			if (ruong==1) {
			thongbao = "ban nhan duoc chia khoa";
			havekey=true;
			inruong++;
			inbang=true;
			g.setColor(Color.GREEN);
			}
			else {
				inruong++;
			}
		}
		
		if(inbang == true) {
		bang(g,thongbao);
		}
		else {
			inruong++;
			if(inruong>=5) {
				
				this.event = false;
				this.inevent = false;
				ruong--;
				mapo[col][row]++;
				inruong=0;
			}
		}
		
		}
	@Override
	public void specialevent(Graphics g, int col, int row){
		String thongbao=null;
		if(eventt==0) {
		if(havekey) {
			thongbao = "Ban da mo cua";
			inbang = true;
			mapo[col][row]++;
			eventt++;
		}
		else {
			thongbao = "Ban khong co chia khoa";
			inbang= true;
			eventt++;
		}
		}
		if(!inbang && eventt != 0) {
			this.event = false;
			this.inevent = false;
			eventt=0;
		}
		else if(inbang) {
			bang(g, thongbao);
		}
		
	}
		
	 

}
