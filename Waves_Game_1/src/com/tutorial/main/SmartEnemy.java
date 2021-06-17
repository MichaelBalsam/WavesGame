package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class SmartEnemy extends GameObject {

	private Handler handler;
	private GameObject player;  
	
	public SmartEnemy(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		
		for(int i = 0; i < handler.object.size(); i++) {
			if(handler.object.get(i).getid() == ID.player) player = handler.object.get(i);
		}
		
	}
	
	public Rectangle getbounds() {
		return new Rectangle((int)x,(int)y, 20, 20);
	}


	public void tick() {
		x += velx;
		y += vely;
		
		float diffx = x - player.getx() - 8;          //tracking algorithm 
		
		float diffy = y - player.gety() - 8;
		
		float distance = (float) Math.sqrt((x-player.getx()) * (x - player.getx()) + (y-player.gety()) * (y - player.gety()));       
		
		velx = (float) ((-1/distance) * diffx);
		vely = (float) ((-1/distance) * diffy);
		
		if(x <= 0 || x >= Game.width - 16) velx *= -1;
		if(y <= 0 || y >= Game.height - 44) vely *= -1;
		
		handler.addObject(new Trail((int)x,(int)y, ID.Trail, Color.green, 20, 20, 0.02f, handler));       // trail for the enemies
		
	}

	public void rendor(Graphics g) {
		g.setColor(Color.green);
		g.fillRect((int)x,(int) y, 20, 20);
		
	}

}
