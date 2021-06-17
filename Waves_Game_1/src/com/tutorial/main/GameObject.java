package com.tutorial.main;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class GameObject {

	protected float x, y;
	protected ID id;
	protected float velx, vely;                    //control the speed in the x and y direction (vel) is velocity
	
	
	public GameObject(float x, float y, ID id) {    // constructor for game object 
		this.x = x;
		this.y = y;
		this.id = id;
	}
	
	public abstract void tick();
	
	public abstract void rendor(Graphics g);
	
	public abstract Rectangle getbounds();            // has intersect method that returns true if one object collides with another. 
	
	//getter and setter methods 
	
	public void setx(int x) {
		this.x = x;
	}
	public void sety(int y) {
		this.y = y;
	}
	public float getx() {
		return x;
	}
	public float gety() {
		return y;
	}
	public void setid(ID id) {
		this.id = id;
	}
	public ID getid() {
		return id;
	}
	public void setvelx(int velx) {
		this.velx = velx;
	}
	public void setvely(int vely) {
		this.vely = vely;
	}
	public float getvelx() {
		return velx;
	}
	public float getvely() {
		return  vely;
	}
	
}
