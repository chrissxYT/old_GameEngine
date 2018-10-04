package de.chrissx.GameEngine.threading;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import de.chrissx.GameEngine.GameObject;

public class GameThreader extends GameObject{
	
	private List<Runnable> repeatingSyncTasks = new ArrayList<Runnable>();
	private HashMap<Runnable, Integer> syncDelays = new HashMap<Runnable, Integer>();
	private HashMap<Runnable, Integer> syncTimes = new HashMap<Runnable, Integer>();
	private HashMap<Runnable, Long> lastTimesSync = new HashMap<Runnable, Long>();
	
	private List<Runnable> repeatingAsyncTasks = new ArrayList<Runnable>();
	private HashMap<Runnable, Integer> asyncDelays = new HashMap<Runnable, Integer>();
	private HashMap<Runnable, Integer> asyncTimes = new HashMap<Runnable, Integer>();
	private HashMap<Runnable, Long> lastTimesAsync = new HashMap<Runnable, Long>();

	public void runTaskSync(Runnable r) {
		Thread t = new Thread(r);
		t.start();
		try {
			t.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void runTaskAsync(Runnable r) {
		Thread t = new Thread(r);
		t.start();
	}
	
	public void repeatTaskAsync(int times, Runnable r) {
		Thread t = new Thread(r);
		runTaskAsync(new Runnable() {
			@Override
			public void run() {
				boolean b = true;
				int times_ = times;
				t.start();
				while (b){
					try {
						t.join();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					t.start();
					times_--;
					if(times_ <= 0) {
						b = false;
					}
				}
			}
		});
	}
	
	public void repeatTaskAsync(int times, int delay_ms, Runnable r) {
		Thread t = new Thread(r);
		repeatingAsyncTasks.add(t);
		asyncDelays.put(t, delay_ms);
		asyncTimes.put(t, times);
	}
	
	public void repeatTaskSync(int times, int delay_ms, Runnable r) {
		Thread t = new Thread(r);
		repeatingSyncTasks.add(t);
		syncDelays.put(t, delay_ms);
		syncTimes.put(t, times);
	}
	
	public void tick() {
		for(Runnable r : repeatingSyncTasks) {
			if(System.currentTimeMillis() + syncDelays.get(r) >= lastTimesSync.get(r)) {
				lastTimesSync.remove(r);
				lastTimesSync.put(r, System.currentTimeMillis());
				int times = syncTimes.get(r) - 1;
				syncTimes.remove(r);
				syncTimes.put(r, times);
				Thread t = new Thread(r);
				t.start();
				try {
					t.join();
				} catch (InterruptedException e) {e.printStackTrace();}
			}
			if(syncTimes.get(r) <= 0) {
				syncTimes.remove(r);
				repeatingSyncTasks.remove(r);
				syncDelays.remove(r);
				syncTimes.remove(r);
			}
		}
		
		for(Runnable r : repeatingAsyncTasks) {
			if(System.currentTimeMillis() + asyncDelays.get(r) >= lastTimesAsync.get(r)) {
				lastTimesAsync.remove(r);
				lastTimesAsync.put(r, System.currentTimeMillis());
				int times = asyncTimes.get(r) - 1;
				asyncTimes.remove(r);
				asyncTimes.put(r, times);
				Thread t = new Thread(r);
				t.start();
			}
			if(asyncTimes.get(r) <= 0) {
				asyncTimes.remove(r);
				repeatingAsyncTasks.remove(r);
				asyncDelays.remove(r);
				asyncTimes.remove(r);
			}
		}
	}
	
	public void render(Graphics g) {
		
	}
}
