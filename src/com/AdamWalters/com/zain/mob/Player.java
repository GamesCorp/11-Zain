package com.AdamWalters.com.zain.mob;

import com.AdamWalters.com.zain.graphics.Screen;
import com.AdamWalters.com.zain.graphics.Sprite;
import com.AdamWalters.com.zain.input.InputHandler;

public class Player extends Mob {
	
	private InputHandler input;
	
	
	public Player(InputHandler input) {
		this.input = input;
	}
	
	public Player(int x, int y, InputHandler input) {
		this.x = x;
		this.y = y;
		this.input = input;
	}
	
	public void update() {
		int xa = 0, ya = 0;
		if (input.up) ya--;
		if (input.down) ya++;
		if (input.left) xa--;
		if (input.right) xa++;
		
		if (xa != 0 || ya != 0) move(xa, ya);
	}
	
	public void render(Screen screen) {
		int xx = x - 16;
		int yy = y - 16;
		
		screen.renderPlayer(xx, yy, Sprite.player0);
	}

}
