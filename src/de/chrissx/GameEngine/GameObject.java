package de.chrissx.GameEngine;

import java.awt.Graphics;

public abstract class GameObject {

	public abstract void tick();
	
	public abstract void render(Graphics g);
}