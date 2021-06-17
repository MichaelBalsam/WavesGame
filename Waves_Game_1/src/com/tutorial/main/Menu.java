package com.tutorial.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import com.tutorial.main.Game.State;

public class Menu extends MouseAdapter {
	
	private Game game;
	private Handler handler;
	private Random r = new Random();
	
	public Menu(Game game, Handler handler) {
		this.game = game;
		this.handler = handler;
	}
	
	public void mousePressed(MouseEvent e) {                               //make sure use proper name for mousepressed and mouseReleased
		
		int mousex = e.getX();                         //storing x position into mousex variable
		int mousey = e.getY();                         //storing y position into mousey variable 
		
		if(game.gameState == State.Menu) {
			//play button 
			if(MouseOver(mousex, mousey, 220, 140, 200, 64)) {
				game.gameState = State.Game;
				handler.addObject(new player(Game.width/2-32, Game.height/2-32, ID.player, handler));   
				handler.addObject(new BasicEnemy(r.nextInt(Game.width - 50), r.nextInt(Game.height - 50), ID.BasicEnemy, handler));   
			}
			
			//help button 
			if(MouseOver(mousex, mousey, 220, 240, 200, 64)) {
				game.gameState = State.Help;
			}
			
			//Quit button 
			if(MouseOver(mousex, mousey, 220, 340, 200, 64)) {
				System.exit(1);
				}
			}
			
		//Back button for help
		if(game.gameState == State.Help) {
			if(MouseOver(mousex, mousey, 220, 340, 200, 64)) {
				game.gameState = State.Menu;
				return;
				}
		}
		
	}
	
	public void mouseReleased(MouseEvent e) {
		
	}
	
	private boolean MouseOver(int mousex, int mousey, int x, int y, int width, int height) {
		
		if(mousex > x && mousex < x + width) {                     //checks to see if mouse x position is within the width if true continue else false get out of loop 
			if(mousey > y && mousey < y + height) {                //checks to see if mouse y position is within the height if true continue else false get out of loop 
				return true;
			}else return false;
		}else return false;
	}
		
	
	public void tick() {
			
	}
	
	public void rendor(Graphics g) {
		
		if(game.gameState == State.Menu) {
		
		Font fnt = new Font("arial", 1, 50);                  //set font for menu system
		Font fnt2 = new Font("arial", 1, 30);
		
		g.setFont(fnt);
		g.setColor(Color.cyan);                         
		g.drawString("Menu", 250, 90);                       // sets the location and dimensions of the menu system
		
		g.setFont(fnt2);
		g.setColor(Color.red);
		g.drawRect(220, 140, 200, 64);
		g.drawString("Play", 290, 180);
		
		g.setColor(Color.white);
		g.drawRect(220, 240, 200, 64);
		g.drawString("Help", 290, 281);
		
		g.setColor(Color.blue);
		g.drawRect(220, 340, 200, 64);
		g.drawString("Quit", 290, 380);
		}
		else if(game.gameState == State.Help) {
			Font fnt = new Font("arial", 1, 50);    
			Font fnt2 = new Font("arial", 1, 30);
			Font fnt3 = new Font("arial", 1, 20);
			
			g.setFont(fnt);
			g.setColor(Color.white);
			g.drawString("Help", 250, 90); 
			
			g.setFont(fnt3);
			g.drawString("Use WASD keys to move player and avoid enemies", 70, 190);
			g.drawString("Created by Michael Balsam", 70, 230);
			g.drawString("Credit RealTutsGML Youtube", 70, 270);
			
			g.setFont(fnt2);
			g.setColor(Color.orange);
			g.drawRect(220, 340, 200, 64);
			g.drawString("Back", 283, 380);
		}
	
	}

}
