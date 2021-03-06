package com.AdamWalters.com.zain.Level;

import com.AdamWalters.com.zain.graphics.Screen;
import com.AdamWalters.com.zain.Level.tiles.Tile;

public class Level {
	
	protected int width, height;
	protected int[] tilesInt;
	protected int[] tiles;
	
	public static Level spawn = new SpawnLevel ("/levels/level.png");
	
	public Level(int width, int height) {
		this.width = width;
		this.height = height;
		tilesInt = new int [width * height];
		generateLevel();
	}
	
	public Level(String path) {
		loadLevel(path);
		generateLevel();
	}

	protected void generateLevel() {
	}
	
	protected void loadLevel(String path) {
	}

	public void tick() {
	}
	
	@SuppressWarnings
	("unused") private void time() {
	}
	
	public void render(int xScroll, int yScroll, Screen screen) {
		
        if (xScroll < 0)
        	xScroll = 0;
        if (xScroll > ((width << 3) - screen.width))
        	xScroll = ((width << 3) - screen.width);
        if (yScroll < 0)
        	yScroll = 0;
        if (yScroll > ((height << 3) - screen.height))
        	yScroll = ((height << 3) - screen.height);
        
		screen.setOffset(xScroll, yScroll);
		/** >> 4 = /16 **/
		int x0 = xScroll >> 4;
		int x1 = (xScroll + screen.width + 16) >> 4;
		int y0 = yScroll >> 4;
		int y1 = (yScroll + screen.height + 16) >> 4;
		for (int y = y0; y < y1; y++) {
			for (int x = x0; x < x1; x++) {
				getTile(x, y).render(x, y, screen);
			}
		}
	}
	//Grass = 0xFF00 / 0x00FF00
	//Flower = 0xFFFF00
	//Rock = 0x878787
	//first two ff = 100% opaque & first two 00 = 100% transparent.
	public Tile getTile(int x, int y) {
		if (x < 0 || y < 0 || x >= width || y >= height) return Tile.voidTile;
		if (tiles[x + y * width] == Tile.col_spawn_grass) return Tile.spawn_grass;
		if (tiles[x + y * width] == Tile.col_spawn_flower) return Tile.spawn_flower;
		if (tiles[x + y * width] == Tile.col_spawn_rock) return Tile.spawn_rock;
		if (tiles[x + y * width] == Tile.col_spawn_cobble) return Tile.spawn_cobble;
		if (tiles[x + y * width] == Tile.col_spawn_cobble2) return Tile.spawn_cobble2;
		if (tiles[x + y * width] == Tile.col_spawn_door) return Tile.spawn_door;
		if (tiles[x + y * width] == Tile.col_spawn_glass) return Tile.spawn_glass;
		if (tiles[x + y * width] == Tile.col_spawn_crate) return Tile.spawn_crate;
		if (tiles[x + y * width] == Tile.col_spawn_spawnpoint) return Tile.spawn_spawnpoint;
		
		return Tile.voidTile;
	}
	

}
