package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class FastEnemy extends GameObject {

	private Handler handler;
	
	public FastEnemy(int x, int y, ID id, Handler handler) {
		
		super(x, y, id);
		
		this.handler = handler;
		
		velx = 2;
		vely = 9;
	}
	
	public Rectangle getbounds() {
		return new Rectangle((int) x,(int) y, 16, 16);
	}


	public void tick() {
		x += velx;
		y += vely;
		
		if(x <= 0 || x >= Game.width - 16) velx *= -1;
		if(y <= 0 || y >= Game.height - 44) vely *= -1;
		
		handler.addObject(new Trail((int) x,(int) y, ID.Trail, Color.magenta, 16, 16, 0.02f, handler));       // trail for the enemies
		
	}

	public void rendor(Graphics g) {
		g.setColor(Color.MAGENTA);
		g.fillRect((int) x, (int)  y, 16, 16);
		
	}
}

