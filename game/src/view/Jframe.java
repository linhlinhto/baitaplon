package view;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class Jframe extends JFrame {
	public Jframe(View board) {
		this.add(board);
		this.setName("RPG Game");
		this.setSize(768,576);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
