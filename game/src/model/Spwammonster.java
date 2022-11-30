package model;

import java.awt.Graphics;

import view.Bee;
import view.View;
import view.monster;

public class Spwammonster {
	public monster[] monster;
	View board;
	public Spwammonster(View board) {
		this.board = board;
		monster = new monster[6];
		Spwam();
	}
	public void Spwam() {
		monster[1] = new Bee(board);
	}
}
