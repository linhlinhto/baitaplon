package view;

import java.awt.Image;

import javax.swing.ImageIcon;

public class map {
	public int mapd,mapr;
	public int[][] mapsize = new int[50][34] ;
	public Image map1;
	public Image tuong;
	public void  createmap1() {
		mapd = 768;
		mapr = 512;
		ImageIcon map11 = new ImageIcon("src/Image/map/nghich.png");
		ImageIcon tuongi = new ImageIcon("src/Image/map/tuong.png");
		tuong = tuongi.getImage();
		map1 = map11.getImage();
		for(int i =0;i<34;i++) {
			mapsize[0][i] = 3;
			mapsize[49][i]= 3;
		}
		for(int i=0;i<50;i++) {
			mapsize[i][0]=3;
			mapsize[i][33]=3;
		}
		for(int i =0;i<48;i++) {
			for(int j=0;j<32;j++) {
			mapsize[i][j] = 1 ;
			}
		}
		
		for(int i=304/16;i<364/16;i++) {
			for(int j =276/16;j<312/16;j++) {
				mapsize[i][j] = 2 ;
			}
		}
		
	}
}
