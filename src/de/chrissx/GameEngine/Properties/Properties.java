package de.chrissx.GameEngine.Properties;

import de.chrissx.GameEngine.Logging.LogType;

public class Properties {

	private int buffers, fps, ticks, width, height;
	private long sleep;
	private String name;
	private boolean fullscreen;
	private LogType logType;
	
	public Properties() {
		
	}
	
	public Properties(int buffers, int fps, int ticks, String name, int width, int height, boolean fullscreen, LogType logType, long sleep) {
		this.buffers = buffers;
		this.fps = fps;
		this.ticks = ticks;
		this.name = name;
		this.width = width;
		this.height = height;
		this.fullscreen = fullscreen;
		this.logType = logType;
		this.sleep = sleep;
	}

	public int getBuffers() {
		return buffers;
	}

	public void setBuffers(int buffers) {
		this.buffers = buffers;
	}

	public int getFps() {
		return fps;
	}

	public void setFps(int fps) {
		this.fps = fps;
	}

	public int getTicks() {
		return ticks;
	}

	public void setTicks(int ticks) {
		this.ticks = ticks;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public boolean isFullscreen() {
		return fullscreen;
	}

	public void setFullscreen(boolean fullscreen) {
		this.fullscreen = fullscreen;
	}

	public LogType getLogType() {
		return logType;
	}

	public void setLogType(LogType logType) {
		this.logType = logType;
	}

	public long getSleep() {
		return sleep;
	}

	public void setSleep(long sleep) {
		this.sleep = sleep;
	}
}
