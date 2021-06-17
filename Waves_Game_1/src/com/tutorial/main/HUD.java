package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;

public class HUD {

	public static float HEALTH = 100;
	private float greenValue = 255;             // red green blue values go from 0-255.
	
	private int score = 0;
	private int level = 1;
	
	public void tick() {	
		HEALTH = (int) Game.clamp(HEALTH, 0, 100); 
		greenValue = (int) Game.clamp(greenValue, 0, 255);
		
		greenValue = HEALTH*2;
		
		score++;
		
	}
	
	
	public void rendor(Graphics g) {
		g.setColor(Color.DARK_GRAY);
		g.fillRect(15, 15, 200, 32);
		g.setColor(new Color(75, (int) greenValue, 0));      // as the health bar goes down the color goes from green to red to indicate low health.
		//g.setColor(Color.green);
		g.fillRect(15, 15, (int) HEALTH * 2, 32);
		g.setColor(Color.blue);
		g.drawRect(15, 15, 200, 32);
		
		g.setColor(Color.white);
		g.drawString("score: " + score, 10, 64);
		g.drawString("level: " + level, 10, 80);
		
		
	}
	
	public void score(int score) {     //setter method 
		
		this.score = score;
	}
	
	public int getscore() {                // getter method
		return score;
	}
	
	
	public int getlevel() {
		return level;
	}
	
	public void setlevel(int level) {
		this.level = level;
	}
}
