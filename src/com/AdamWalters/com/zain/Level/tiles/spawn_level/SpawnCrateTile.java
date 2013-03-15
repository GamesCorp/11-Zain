package com.AdamWalters.com.zain.Level.tiles.spawn_level;

import com.AdamWalters.com.zain.graphics.Screen;
import com.AdamWalters.com.zain.graphics.Sprite;
import com.AdamWalters.com.zain.Level.tiles.Tile;
public class SpawnCrateTile extends Tile {

	public SpawnCrateTile(Sprite sprite) {
		super(sprite);
	}
	
	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << 4, y << 4, this);
	}
	
	public boolean solid() {
		return true;		//<<--Redundant if left false. / This makes the Tile solid.
	} 
	
	public boolean breakable() {
		return true;
	}

}
