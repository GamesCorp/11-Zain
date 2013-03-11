package com.AdamWalters.com.zain.level.tiles.spawn_level;

import com.AdamWalters.com.zain.graphics.Screen;
import com.AdamWalters.com.zain.graphics.Sprite;
import com.AdamWalters.com.zain.level.tiles.Tile;

public class SpawnGlassTile extends Tile {

	public SpawnGlassTile(Sprite sprite) {
		super(sprite);
	}
	
	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << 4, y << 4, this);
	}
	
	public boolean breakable() {
		return true;
	}
	
	
	/**
	public boolean solid() {
		return true;		<<--Redundant if left false. / This makes the Tile solid.
	} **/

}
