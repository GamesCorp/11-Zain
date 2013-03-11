package com.AdamWalters.com.zain.level.tiles.spawn_level;

import com.AdamWalters.com.zain.level.tiles.Tile;
import com.AdamWalters.com.zain.graphics.Screen;
import com.AdamWalters.com.zain.graphics.Sprite;

public class SpawnCobble2Tile extends Tile {

	public SpawnCobble2Tile(Sprite sprite) {
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
