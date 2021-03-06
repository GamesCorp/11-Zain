package com.AdamWalters.com.zain.Level.tiles;

import com.AdamWalters.com.zain.graphics.Screen;
import com.AdamWalters.com.zain.graphics.Sprite;

public class CrateTile extends Tile {

	public CrateTile(Sprite sprite) {
		super(sprite);
	}
	
	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << 4, y << 4, this);
	}
	
	public boolean solid() {
		return true;		//<<--Redundant if left false. / This makes the Tile solid.
	} 

}
