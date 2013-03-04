package com.AdamWalters.com.zain.Level;

public class Level {
	
	private int width, height;
	private int[] tiles;
	
	public Level (int width, int height) {
		this.width = width;
		this.height = height;
		tiles = new int [width * height];
		generateLevel();
	}

	private void generateLevel() {
	}


}
