package com.tutorial.main;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class window extends Canvas {

	private static final long serialVersionUID = -5528816561237195534L;
                                                          
	public window(int width, int height, String title, Game game) {            // constructor also create instance of game within the window constructor parameters 
		JFrame frame = new JFrame(title);                                       // creates the frame of the window 
		
		frame.setPreferredSize(new Dimension(width, height));                  
		frame.setMaximumSize(new Dimension(width, height));                    
		frame.setMinimumSize(new Dimension(width, height));                   
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);                  // Makes sure the program exits properly 
		frame.setResizable(false);                                             // Does not allow us to resize the game window
		frame.setLocationRelativeTo(null);                                     // When the game starts it will be in the middle of the screen (not necessary)
		frame.add(game);                                                       // important adds game class into the frame
		frame.setVisible(true);                                                // used to allow us to see the frame
		game.start();                                                            // runs the start method in class game
		
	}

}
