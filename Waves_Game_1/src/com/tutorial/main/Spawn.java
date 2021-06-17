package com.tutorial.main;

import java.util.Random;

public class Spawn {
	
	private Handler handler;
	private HUD hud;
	private Random r = new Random();
	
	private int scorekeep = 0;
	
	public Spawn(Handler handler, HUD hud) {
	this.handler = handler;
	this.hud = hud;
	}
	
	public void tick() {
		scorekeep++;
		
		if(scorekeep >= 250) {
			scorekeep = 0;
			hud.setlevel(hud.getlevel() + 1);
		
			
			if(hud.getlevel() == 2) {
				handler.addObject(new BasicEnemy(r.nextInt(Game.width - 50), r.nextInt(Game.height - 50), ID.BasicEnemy, handler));
			}
			else if(hud.getlevel() == 3) {
				handler.addObject(new FastEnemy(r.nextInt(Game.width - 50), r.nextInt(Game.height - 50), ID.FastEnemy, handler));
				}
			else if(hud.getlevel() == 4) {
				handler.addObject(new FastEnemy(r.nextInt(Game.width - 50), r.nextInt(Game.height - 50), ID.FastEnemy, handler));
				}
			else if(hud.getlevel() == 5) {
				handler.addObject(new SmartEnemy(r.nextInt(Game.width - 50), r.nextInt(Game.height - 50), ID.SmartEnemy, handler));
				}
			else if(hud.getlevel() == 6) {
				handler.addObject(new BasicEnemy(r.nextInt(Game.width - 50), r.nextInt(Game.height - 50), ID.BasicEnemy, handler));
				}
			else if(hud.getlevel() == 7) {
				handler.addObject(new BasicEnemy(r.nextInt(Game.width - 50), r.nextInt(Game.height - 50), ID.BasicEnemy, handler));
				}
			else if(hud.getlevel() == 10) {
				handler.clearEnemys();
				handler.addObject(new Boss1((Game.width / 2) -48, -98, ID.Boss1, handler));
				}
			
		}
	}

}
