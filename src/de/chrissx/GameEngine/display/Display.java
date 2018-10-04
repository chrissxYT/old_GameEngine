package de.chrissx.GameEngine.display;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

import de.chrissx.GameEngine.Logging.GameLogger;

public class Display {

	private JFrame frame;
	private Canvas canvas;
	private GameLogger l;
	
	private String title = "CX' GameEngine-Game";
	private int width, height;
	
	public Display(String title, int width, int height, GameLogger l) {
		this.title = title;
		this.width = width;
		this.height = height;
		this.l = l;
		
		createDisplay();
	}
	
	
	private void createDisplay() {
		l.log("Creating display.");
		frame = new JFrame(title);
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width, height));
		canvas.setMaximumSize(new Dimension(width, height));
		canvas.setMinimumSize(new Dimension(width, height));
		canvas.setFocusable(false);
		
		frame.add(canvas);
		frame.pack();
	}
	
	public Canvas getCanvas() {
		return canvas;
	}
	
	public JFrame getFrame() {
		return frame;
	}
}
