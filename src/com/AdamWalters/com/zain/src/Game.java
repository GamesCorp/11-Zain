package com.AdamWalters.com.zain.src;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import com.AdamWalters.com.zain.Gui.Gui;
import com.AdamWalters.com.zain.Level.Level;
import com.AdamWalters.com.zain.Level.TileCoordinate;
import com.AdamWalters.com.zain.graphics.Screen;
import com.AdamWalters.com.zain.input.InputHandler;
import com.AdamWalters.com.zain.input.MyMouseListener;
import com.AdamWalters.com.zain.mob.Player;
import com.AdamWalters.com.zain.out.SoundEffect;

public class Game extends Canvas implements Runnable {
	private static final long serialVersionUID = 1L;

	public static int width = 300;
	public static int height = 168; //16 * 9
	public static int scale = 3;
	public static String title;

    static SoundEffect SE;
	private Thread thread;
	private JFrame frame;
	private InputHandler key;
	private Level level;
	private Player player;
	private boolean running = false;
	SoundEffect sound;
	public static int mouseY;
	public static int mouseX;
	

    public Gui GuiMouse;
    public MyMouseListener MouseMovement;
	
	private Screen screen;

	private BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();

    public void init() {
        GuiMouse = new Gui(this);
        MouseMovement = new MyMouseListener(this);
        }
	
	public Game() {
		Dimension size = new Dimension(width * scale, height * scale);
		setPreferredSize(size);

		screen = new Screen(width, height);
		frame = new JFrame();
		key = new InputHandler();
		level = Level.spawn;
		TileCoordinate playerSpawn = new TileCoordinate(12, 23);
		player = new Player(playerSpawn.x(), playerSpawn.y(), key);//12 * 16, 23 * 16
		addKeyListener(key);
		
	}

	public synchronized void start() {
		running = true;
		thread = new Thread(this, "Display");
		thread.start();
        SE = new SoundEffect("res/Sound/AnotherWorld.wav");
        SE.start();

	}

	public synchronized void stop() {
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		final double ns = 1000000000.0 / 60.0;
		double delta = 0;
		int frames = 0;
		int ticks = 0;
		requestFocus();
        init();
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				tick();
				ticks++;
				delta--;
			}
			render();
			frames++;
			
			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println(ticks + "tps, " + frames + " fps");
				frame.setTitle(title + "  |  " + ticks + "tps, " + frames + " fps "+ frame.getWidth()+" Width "+frame.getHeight()+" Height");
				ticks = 0;
				frames = 0;
			}
		}
		stop();
	}
	
	public void tick() {
		key.tick();
		player.update();
		
	}

	public void render() {
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			/** Increasing number could improve speed but would slow down performance **/
			createBufferStrategy(3);
			return;
		}
		
		screen.clear();
		
        
		int xScroll = player.x - screen.width / 2;
		int yScroll = player.y - screen.height / 2;
		level.render(xScroll, yScroll, screen);
		player.render(screen);
		
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = screen.pixels[i];
		}

		Graphics g = bs.getDrawGraphics();
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		Gui.renderDebug(g);
		g.setColor(Color.WHITE);
		g.setColor(Color.RED);
		Font a = new Font("Hobo Std", Font.PLAIN, 32);
		g.setFont(a);
		Gui.HealthBar(1, g, 20, 20, 200, 40, "HEALTH", 40, 4);
		Gui.ManaBar(2, g, 20, 80, 200, 40, "MANA", 40, 4);
		Gui.BossHealthBar(1, g, 300, 20, 300, 40, "BOSS", 40, 4);
		Gui.defaultButton(1, g, 20, 349, 150, 70, "Button 1", 19, 4);
		Gui.defaultButton(2, g, 20, 420, 150,  70, "Button 2", 19, 4);
		
		
		g.dispose();
		bs.show();
	}

	public static void main(String[] args) {
		Game game = new Game();
		game.frame.setResizable(true);
		game.frame.setTitle(Game.title = "Zain");
		game.frame.add(game);
		game.frame.pack();
		game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.frame.setLocationRelativeTo(null);
		game.frame.setVisible(true);

		game.start();
	}

}