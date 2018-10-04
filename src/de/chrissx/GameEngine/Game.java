package de.chrissx.GameEngine;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.List;

import de.chrissx.GameEngine.Logging.GameLogger;
import de.chrissx.GameEngine.Properties.Properties;
import de.chrissx.GameEngine.display.Display;
import de.chrissx.GameEngine.threading.GameThreader;
import de.chrissx.GameEngine.world.World;

public class Game extends GameObject{

	private Graphics g;
	
	private Display display;
	private BufferStrategy bs;
	
	private GameLogger logger;
	
	private Properties props;
	
	private List<World> worlds = new ArrayList<World>();
	
	private boolean running = true;
	
	private GameThreader threader = new GameThreader();
	
	private Thread mainGameLoop;
	
	public Game(Properties props) {
		this.props = props;
		logger = new GameLogger(props.getLogType());
		display = new Display(props.getName(), props.getWidth(), props.getHeight(), logger);
		display.getCanvas().createBufferStrategy(props.getBuffers());
		bs = display.getCanvas().getBufferStrategy();
		g = bs.getDrawGraphics();
		mainGameLoop = new Thread(new Runnable() {
			long lastTick = System.currentTimeMillis(), lastRender = System.currentTimeMillis(), curr = System.currentTimeMillis(), sleep = props.getSleep();
			int tickTime = 1000/props.getTicks(), frameTime = 1000/props.getFps();
			@Override
			public void run() {
				while(running) {
					curr = System.currentTimeMillis();
					if(curr >= lastTick + tickTime) {
						tick();
					}
					if(curr >= lastRender + frameTime) {
						render(g);
					}
					try {
						Thread.sleep(sleep);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	public void render(Graphics g) {
		
	}
	
	public void tick() {
		
	}
	
	public void startLoop() {
		mainGameLoop.start();
	}
	
	@SuppressWarnings("deprecation")
	public void stopLoop() {
		mainGameLoop.stop();
	}
}
