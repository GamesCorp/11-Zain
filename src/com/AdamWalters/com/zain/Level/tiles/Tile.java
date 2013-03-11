package com.AdamWalters.com.zain.Level.tiles;

import com.AdamWalters.com.zain.graphics.Screen;
import com.AdamWalters.com.zain.graphics.Sprite;
import com.AdamWalters.com.zain.Level.tiles.spawn_level.SpawnCobbleTile;
import com.AdamWalters.com.zain.Level.tiles.spawn_level.SpawnCrateTile;
import com.AdamWalters.com.zain.Level.tiles.spawn_level.SpawnDoorTile;
import com.AdamWalters.com.zain.Level.tiles.spawn_level.SpawnFlowerTile;
import com.AdamWalters.com.zain.Level.tiles.spawn_level.SpawnGlassTile;
import com.AdamWalters.com.zain.Level.tiles.spawn_level.SpawnGrassTile;
import com.AdamWalters.com.zain.Level.tiles.spawn_level.SpawnRockTile;

public class Tile {
	
	public int x, y;
	public Sprite sprite;
	
	public static Tile grass = new GrassTile(Sprite.grass);
	public static Tile flower = new FlowerTile(Sprite.flower);
	public static Tile rock = new RockTile(Sprite.rock);
	public static Tile cobble = new CobbleTile(Sprite.cobble);
	public static Tile door = new DoorTile(Sprite.door);
	public static Tile glass = new GlassTile(Sprite.glass);
	public static Tile crate = new CrateTile(Sprite.crate);
	public static Tile voidTile = new VoidTile(Sprite.voidSprite);
	
	public static Tile spawn_grass = new SpawnGrassTile(Sprite.spawn_grass);
	public static Tile spawn_flower = new SpawnFlowerTile(Sprite.spawn_flower);
	public static Tile spawn_rock = new SpawnRockTile(Sprite.spawn_rock);
	public static Tile spawn_cobble = new SpawnCobbleTile(Sprite.spawn_cobble);
	public static Tile spawn_door = new SpawnDoorTile(Sprite.spawn_door);
	public static Tile spawn_glass = new SpawnGlassTile(Sprite.spawn_glass);
	public static Tile spawn_crate = new SpawnCrateTile(Sprite.spawn_crate);
	
	public static final int col_spawn_grass = 0xff00ff00;
	public static final int col_spawn_flower = 0xffffff00;
	public static final int col_spawn_rock = 0xff808080;
	public static final int col_spawn_cobble = 0xff282828;
	public static final int col_spawn_cobble2 = 0xff
	public static final int col_spawn_door = 0xff000000;
	public static final int col_spawn_glass = 0xff43DBDB;
	public static final int col_spawn_crate = 0xff7F3300;
	
	public Tile(Sprite sprite) {
		this.sprite = sprite;
	}
	
	public void render(int x, int y, Screen screen) {
	}
	
	public boolean solid() {
		return false;
	}

}
