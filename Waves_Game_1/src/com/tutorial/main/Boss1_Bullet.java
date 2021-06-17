package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Boss1_Bullet extends GameObject {

	private Handler handler;
	Random r = new Random();
	
	public Boss1_Bullet(int x, int y, ID id, Handler handler) {
		
		super(x, y, id);
		
		this.handler = handler;
		
		velx = r.nextInt(5- -5) + -5;             // Gives a random number from -5 to positive 5
		vely = 5;
	}
	
	public Rectangle getbounds() {
		return new Rectangle((int)x,(int) y, 16, 16);
	}


	public void tick() {
		x += velx;
		y += vely;
		
		//if(x <= 0 || x >= Game.width - 16) velx *= -1;
		//if(y <= 0 || y >= Game.height - 44) vely *= -1;
		
		if(y >= Game.height) handler.removeObject(this);
		
		handler.addObject(new Trail((int)x,(int) y, ID.Trail, Color.white, 16, 16, 0.02f, handler));       // trail for the enemies
		
	}

	public void rendor(Graphics g) {
		g.setColor(Color.white);
		g.fillRect((int)x,(int)y, 16, 16);
		
	}

}
