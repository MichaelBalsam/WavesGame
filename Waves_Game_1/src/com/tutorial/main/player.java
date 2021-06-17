package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

public class player extends GameObject{

	Random r = new Random();
	Handler handler;
	
	public player(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		
	}
	
	public Rectangle getbounds() {
		return new Rectangle((int) x, (int) y, 32, 32);                     //recast all rectangles to integers
	}


	public void tick() {
		x += velx;
		y += vely;
		
		x = Game.clamp((int)x, 0, Game.width - 44);
		y = Game.clamp((int)y, 0, Game.height - 72);
		
		handler.addObject(new Trail((int)x,(int)  y, ID.Trail, Color.cyan, 32, 32, 0.05f, handler));  // trail for the player
		
		collision();
	}
	
	private void collision() {
		for(int i = 0; i < handler.object.size(); i++) {
			
			GameObject tempobject = handler.object.get(i);
			
			if(tempobject.getid() == ID.BasicEnemy || tempobject.getid() == ID.FastEnemy || tempobject.getid() == ID.SmartEnemy) {
				if(getbounds().intersects(tempobject.getbounds())) {        //tempObject is now considered basic enemy
					//collision code
					HUD.HEALTH -= 2;                                 //every time a enemy collides with the player the health will go down		
				}
				
			}
			if(tempobject.getid() == ID.Boss1) {
				if(getbounds().intersects(tempobject.getbounds())) {        //tempObject is now considered Boss enemy
					//collision code
					HUD.HEALTH -= 1000;                                 //every time a enemy collides with the player the health will go down to zero		
				}
				
			}
			
		}
			
			
	}

	public void rendor(Graphics g) {
		g.setColor(Color.cyan);
		g.fillRect((int)x,(int)y, 32, 32);
		
		Graphics2D g2d = (Graphics2D) g;             
		                    
		g.setColor(Color.green);
	   g2d.draw(getbounds());               //shows the collision boundary for the object
		
		
	}

}
