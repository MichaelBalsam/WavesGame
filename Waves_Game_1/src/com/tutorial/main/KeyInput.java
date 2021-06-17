package com.tutorial.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter{

	private Handler handler;
	private boolean[] KeyDown = new boolean [4];                        // creates a array of boolean values 4 counts
	
	public KeyInput(Handler handler) {                                
		this.handler = handler;
		
		KeyDown[0] = false;                               // KeyDown 0 is W key 
		KeyDown[1] = false;                               // KeyDown 1 is S key 
		KeyDown[2] = false;                               // KeyDown 2 is D key 
		KeyDown[3] = false;                               // KeyDown 3 is A key 
		
	}
	
	public void keyPressed(KeyEvent e) {                                   //make sure its keyPressed or it wont work!!!!!!
		int key = e.getKeyCode();
		
		for(int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getid() == ID.player) {
				//Key Events for player 1
				
				if(key == KeyEvent.VK_W) { tempObject.setvely(-5);  KeyDown[0] = true; }        //moves player 1 upwards using the W key
				if(key == KeyEvent.VK_S) { tempObject.setvely(5);  KeyDown[1] = true; }  
				if(key == KeyEvent.VK_D) { tempObject.setvelx(5);  KeyDown[2] = true; }  
				if(key == KeyEvent.VK_A) { tempObject.setvelx(-5);  KeyDown[3] = true; }  
				
			}
		}	
		
		if(key == KeyEvent.VK_ESCAPE) System.exit(1);                       //allows us to press escape to close the game
		
	}
	
	
	public void keyReleased(KeyEvent e) {                                // make sure its keyReleased or it wont work!!!!!!!
		int key = e.getKeyCode();
		
		for(int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getid() == ID.player) {
				//Ket Events for player 1 
				
				if(key == KeyEvent.VK_W)  KeyDown[0] = false;   //tempObject.setvely(0);                   //stops player 1 from moving 
				if(key == KeyEvent.VK_S) KeyDown[1] = false;   //tempObject.setvely(0); 
				if(key == KeyEvent.VK_D) KeyDown[2] = false;   //tempObject.setvelx(0); 
				if(key == KeyEvent.VK_A)  KeyDown[3] = false;   //tempObject.setvelx(0); 
				
				// Vertical movement 
				if(!KeyDown[0] && !KeyDown[1]) tempObject.setvely(0);                     // prevents keys from getting stuck when changing quickly 
				// Horizontal movement 
				if(!KeyDown[2] && !KeyDown[3]) tempObject.setvelx(0);             
				
			}
			
		}	
	}
}
