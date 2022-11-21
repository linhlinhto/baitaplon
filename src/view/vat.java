package view;

import java.awt.Image;

import javax.swing.ImageIcon;

public class vat {
	public Image da;
	public Image tuong;
	public  vat() {
		loadvat();
	}
	public void loadvat() {
		ImageIcon Da = new ImageIcon("src/Image/map/da.png");
		da = Da.getImage();
		ImageIcon Tuong = new ImageIcon("src/Image/map/tuong.png");
		tuong = Tuong.getImage();
	}
}
