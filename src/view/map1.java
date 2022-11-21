package view;

import java.awt.Image;

import javax.swing.ImageIcon;
import model.Collider;

public class map1 {
	Collider checkcolli = new Collider();
	public Image da;
	public int soda=1;
	public int[] dax = new int[soda];
	public int[] day = new int[soda];
	public int mapw = 768;
	public int maph = 592;
	public int[][] mapcolli = new int[800][608];
	public Image Map;
	public ImageIcon map,Da;
	public map1() {
		loadImage();
		createmap();
	}
	public void loadImage() {
		ImageIcon Da = new ImageIcon("src/Image/map/da.png");
		da = Da.getImage();
		map = new ImageIcon("src/Image/map/map1.png");
		Map = map.getImage();
		
	}
	public void createmap() {
		dax[0] = 512;
		day[0] = 240;
		
		checkcolli.setCollision0(mapcolli, 0, 0, 800, 608);
		checkcolli.setCollision2(mapcolli, 512+16,240+100-16,48+16, 48);
		checkcolli.setCollision2(mapcolli, 0, 0, 16, 608);
		checkcolli.setCollision2(mapcolli, 768, 0, 16, 608);
		checkcolli.setCollision2(mapcolli, 0, 32, 800, 16);
		checkcolli.setCollision2(mapcolli, 0,512, 800, 16);
	}
	
}
