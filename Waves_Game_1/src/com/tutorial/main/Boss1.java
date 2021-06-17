package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Boss1 extends GameObject {

	private Handler handler;
	Random r = new Random();
	
	private int timer = 49;
	private int timer2 = 70;
	
	public Boss1(int x, int y, ID id, Handler handler) {
		
		super(x, y, id);
		
		this.handler = handler;
		
		velx = 0;
		vely = 2;
	}
	
	public Rectangle getbounds() {
		return new Rectangle((int)x,(int) y, 78, 78);
	}


	public void tick() {
		x += velx;
		y += vely;
		
		if(timer <= 0)        //set timer to stop bosses vertical movement 
			vely = 0;
		else timer--;
		
		if(timer <= 0) timer2--;              //set timer for bosses horizontal movement
		if(timer2 <= 0)
		{
			if(velx == 0)velx = 3;
			
			if(velx > 0)
			velx += 0.005f;
			else if(velx < 0)
			velx -= 0.005f;
			
			velx = Game.clamp(velx, -10, 10);
			
			int spawn = r.nextInt(6);
			if(spawn == 0) handler.addObject(new Boss1_Bullet((int)x+48, (int)y+48, ID.BasicEnemy, handler));

		}
		
		if(x <= 0 || x >= Game.width - 78) velx *= -1;
		//if(y <= 0 || y >= Game.height - 44) vely *= -1;
		
		//handler.addObject(new Trail((int)x,(int) y, ID.Trail, Color.orange, 78, 78, 0.009f, handler));       // trail for the enemies
		
	}

	public void rendor(Graphics g) {
		g.setColor(Color.magenta);
		g.fillRect((int)x,(int)y, 78, 78);
		
	}

}
