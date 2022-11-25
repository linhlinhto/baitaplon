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
	}
}
