package com.tutorial.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Game extends Canvas implements Runnable{

	private static final long serialVersionUID = 7030720699942773641L;

	public static final int width = 640, height = width / 12 * 9;     // gives a width of 640 and height to a ratio of 16:9 
	
	private Thread thread;
	private boolean running = false;
	
	private Random r;
	private Handler handler;
	private HUD hud;
	private Spawn spawner;
	private Menu menu;
	
	public enum State{
		Menu,
		Help,
		Game
	};
	
	public State gameState = State.Menu;                 //Allows us to cast state as a type that holds the menu and game values 
	
	public Game() {
		this.setFocusable(true);                                                   // this lets us start playing the game without having to click on the window
		handler = new Handler(); 
		menu = new Menu(this, handler);
		
		this.addKeyListener(new KeyInput(handler));
		this.addMouseListener(menu);
		
		new window(width, height, "Waves Game 1", this);
		
		hud = new HUD();
		
		spawner = new Spawn(handler, hud);
		
		r = new Random();
		
		if(gameState == State.Game) {
		
			handler.addObject(new player(width/2-32, height/2-32, ID.player, handler));      // spawns the player in the middle of the screen
			handler.addObject(new BasicEnemy(r.nextInt(Game.width - 50), r.nextInt(Game.height - 50), ID.BasicEnemy, handler));     //spawns basic enemy into the game
			
		}
		
	}
	
	public synchronized void start() {
		thread = new Thread(this);                                    // initialize the new thread in this(instance of the game class
		thread.start();                                               // starts the thread 
		running = true;                                               // checks if it is running or not running
	}     
	
	public synchronized void stop() {
		try {
			thread.join();                                            // thread.join stops the thread
			running = false;					
		}catch (Exception e) {
			e.printStackTrace();                                      // runs an error bug 
		}
	}    
	
	public void run() {                                               
		 long lastTime = System.nanoTime();                           // Start method calls the run method and creates a game loop to update the game 
		 double amountOfTicks = 60.0;
		 double ns = 1000000000 / amountOfTicks;
		 double delta = 0;
		 long timer = System.currentTimeMillis();
		// int frames = 0;                                                   //comment frames out
		 while(running) {
			 long now = System.nanoTime();
			 delta += (now - lastTime) / ns;
			 lastTime = now;
			 while(delta >= 1) {
				 tick();
				 delta--;
			 }
			 if(running)
				 render();
			// frames++;                                                 //comment frames out
			 
			 if(System.currentTimeMillis() - timer > 1000) {
				 timer += 1000;  
				 //System.out.println("FPS: " + frames);
				 //frames = 0;                                       //comment frames out
			 }
		 }
		 stop();                                                    // ends the game loop
	}
	
	private void tick() {
		handler.tick();
		
		if(gameState == State.Game) {
			hud.tick();
			spawner.tick();
		}
		else if(gameState == State.Menu) {
			menu.tick();
		}
		
	}
	
	private void render() {                                         // Run method calls render method that calls the handler method
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);                           // creates three buffers
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.black);
		g.fillRect(0, 0, width, height);
		
		
		handler.rendor(g);
		
		if(gameState == State.Game) {
			hud.rendor(g);
		}
		else if(gameState == State.Menu || gameState == State.Help) {                // Rendors the Game menu
			menu.rendor(g); 
		}	
		
		g.dispose();
		bs.show(); 
	}
	 
	public static float clamp(float var, float min, float max) {                       // this method makes it so the player cannot go pass room width or height
		
		if(var >= max)
			return var = max;
		
		else if( var <= min)
			return var = min;
		else 
			return var;
	}
	
	public static void main(String args[]) {
		new Game();
	}
	
	
}
