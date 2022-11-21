package test;

import java.awt.Color;
import view.View;
import javax.swing.JFrame;

public class test {
	public static void main(String[] args) {
		JFrame scr = new JFrame();
		
		View board = new View();
		board.setBackground(Color.BLACK);
		scr.add(board);
		scr.setSize(768,512);
		scr.setResizable(false);
		scr.setLocationRelativeTo(null);
		scr.setVisible(true);
		scr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
