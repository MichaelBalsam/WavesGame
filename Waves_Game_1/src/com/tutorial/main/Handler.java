package com.tutorial.main;

import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {                                      //loops through all objects and individually update and rendors them to the screen

	LinkedList<GameObject> object = new LinkedList<GameObject>();
	
	public void tick() { 
		for(int i = 0; i < object.size(); i++) {                    //loops through every object 
			GameObject tempObject = object.get(i);
			
			tempObject.tick();
		}
	}
	
	public void rendor(Graphics g) {
		for(int i = 0; i < object.size(); i++) {                    //loops through every object and renders them
			GameObject tempObject = object.get(i);
			
			tempObject.rendor(g);
		}
	}
	
	public void clearEnemys() {
		for(int i = 0; i < object.size(); i++) {                    //loops through every object 
			GameObject tempObject = object.get(i);
			
			if(tempObject.getid() == ID.player)
			{
				object.clear();
				addObject(new player((int)tempObject.getx(), (int)tempObject.gety(), ID.player, this));     //clears game then adds player back to where they where and starts boss round
			}
		}
	}
	
	public void addObject(GameObject object) {
		this.object.add(object);
	}
	
	public void removeObject(GameObject object) {
		this.object.remove(object);
	}
}
