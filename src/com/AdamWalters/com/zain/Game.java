package com.AdamWalters.com.zain;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import com.AdamWalters.com.zain.graphics.Screen;
import com.AdamWalters.com.zain.input.InputHandler;

public class Game extends Canvas implements Runnable {
	private static final long serialVersionUID = 1L;

	public static int width = 300;
	public static int height = 168; //16 * 9
	public static int scale = 3;
	public static String title;

	private Thread thread;
	private JFrame frame;
	private InputHandler key;
	private boolean running = false;

	private Screen screen;

	private BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();

	public Game() {
		Dimension size = new Dimension(width * scale, height * scale);
		setPreferredSize(size);

		screen = new Screen(width, height);
		frame = new JFrame();
		
		key = new InputHandler();
		addKeyListener(key);
	}

	public synchronized void start() {
		running = true;
		thread = new Thread(this, "Display");
		thread.start();
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
				frame.setTitle(title + "  |  " + ticks + "ups, " + frames + " fps");
				ticks = 0;
				frames = 0;
			}
		}
		stop();
	}
	
	int x = 0, y = 0;
	
	public void tick() {
		key.tick();
		if (key.up) y--;
		if (key.down) y++;
		if (key.left) x--;
		if (key.right) x++;
	}

	public void render() {
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			/** Increasing number could improve speed but would slow down performance **/
			createBufferStrategy(3);
			return;
		}
		
		screen.clear();
		screen.render(x, y);

		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = screen.pixels[i];
		}

		Graphics g = bs.getDrawGraphics();
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
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