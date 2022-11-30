package view;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import model.Collider;

public class Bee extends monster {
	
	public Bee(View board) {
		super(board);
		Initmonster();
		
		
	}
	public void Initmonster() {
		this.maxhp = 20;
		this.monsternumim=5;
		this.width=94 ;
		this.height=81;
	this.monsterdame = 20;
	this.vel = 1;
	this.donei=false;
	monsterim = new ImageIcon[10];
	monsterim[0] = new ImageIcon("src/Image/monster/ong1.png");
	monsterim[1] = new ImageIcon("src/Image/monster/ong2.png");
	monsterim[2] = new ImageIcon("src/Image/monster/ong3.png");
	monsterim[3] = new ImageIcon("src/Image/monster/ong4.png");
	monsterim[4] = new ImageIcon("src/Image/monster/ong5.png");
	monsterim[5] = new ImageIcon("src/Image/monster/ong6.png");
	monsterim[6] = new ImageIcon("src/Image/monster/ong7.png");
	monsterim[7] = new ImageIcon("src/Image/monster/ong8.png");
	monsterim[8] = new ImageIcon("src/Image/monster/ong9.png");
	monsterim[9] = new ImageIcon("src/Image/monster/ong10.png");
	}
	
}
