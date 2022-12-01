package model;

import java.awt.Graphics;
import view.Frog;
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
		monster[0] = new Frog(board);
	}
}
