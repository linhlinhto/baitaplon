package view;

import javax.swing.ImageIcon;

import model.vat;

public class anhvat {
	public vat[] vat;
	
	public anhvat(){
		vat = new vat[20];
		loadanh();
	}
	public void loadanh() {
		vat[7] = new vat();
		vat[7].loadanh =  new ImageIcon("src/Image/map/da.png");
		vat[7].anhvat = vat[7].loadanh.getImage();
		vat[7].height = 100;
		vat[7].width = 48;
		vat[7].colliheight = 64;
		vat[8] = new vat();
		vat[8].loadanh = new ImageIcon("src/Image/map/tuong.png");
		vat[8].anhvat = vat[8].loadanh.getImage();
		vat[8].height = 160;
		vat[8].width = 80;
		vat[8].colliheight = 64;
		
		
	}
}
