package com.AdamWalters.com.zain.Gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import com.AdamWalters.com.zain.src.Game;

public class Gui  implements MouseListener{
	
	public Gui(Game game) {
		game.addMouseListener(this);
		
	}
	static int clickedX = 0;
	static int clickedY = 0;
	public static void defaultButton(int ID ,Graphics g,int x,int y,int sizeX, int sizeY, String text, int arc, int border){
		if(g instanceof Graphics2D){
			Graphics2D g2 = (Graphics2D)g;
			g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		}
		g.setColor(Color.YELLOW);
		g.fillRoundRect(x, y, sizeX, sizeY, arc, arc);
		g.setColor(Color.BLUE);
		g.fillRoundRect(x+border, y+border, sizeX-(border*2), sizeY-(border*2), arc, arc);
		if(clickedX<x+sizeX &&clickedX>x &&clickedY<y+sizeY &&clickedY>y ){
			buttonClick(ID);
			clickedX = 0;
			clickedY = 0;
		}
}
	public static void renderDebug(Graphics g){
		if(g instanceof Graphics2D){
			Graphics2D g2 = (Graphics2D)g;
			g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		}
		g.setColor(Color.BLUE);
        g.drawString(Game.mouseX+","+Game.mouseY , Game.mouseX, Game.mouseY);
        g.setColor(Color.BLACK);
        g.drawLine(Game.mouseX-6, Game.mouseY, Game.mouseX+6, Game.mouseY);
        g.drawLine(Game.mouseX, Game.mouseY-6, Game.mouseX, Game.mouseY+6);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		clickedX = e.getX();
		clickedY = e.getY();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		clickedX = e.getX();
		clickedY = e.getY();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}
	
	public static void buttonClick(int ID){
		switch (ID){
			case 1 :
				System.out.println("button one recognised");
				break;
			case 2 :
				System.out.println("button two recognised");
				break;
		}
	}
	
	public static void HUB(Graphics g){
		if(g instanceof Graphics2D){
			Graphics2D g2 = (Graphics2D)g;
			g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		}
		
	}
	public static void HealthBar(int ID ,Graphics g, int x, int y, int sizeX, int sizeY, String text,int arc, int border) {
		g.setColor(Color.GREEN);
		g.fillRoundRect(x, y, sizeX, sizeY, arc, arc);
		g.setColor(Color.RED);
		g.fillRoundRect(x+border, y+border, sizeX-(border*2), sizeY-(border*2), arc, arc);
		g.setColor(Color.BLACK);
		g.drawString(text, 60, 54);
	}
	
	public static void ManaBar(int ID ,Graphics g, int x, int y, int sizeX, int sizeY, String text,int arc, int border) {
		g.setColor(Color.GREEN);
		g.fillRoundRect(x, y, sizeX, sizeY, arc, arc);
		g.setColor(Color.BLUE);
		g.fillRoundRect(x+border, y+border, sizeX-(border*2), sizeY-(border*2), arc, arc);
		g.setColor(Color.YELLOW);
		g.drawString(text, 75, 113);
	}
	
	public static void BossHealthBar(int ID ,Graphics g, int x, int y, int sizeX, int sizeY, String text,int arc, int border) {
		g.setColor(Color.BLUE);
		g.fillRoundRect(x, y, sizeX, sizeY, arc, arc);
		g.setColor(Color.RED);
		g.fillRoundRect(x+border, y+border, sizeX-(border*2), sizeY-(border*2), arc, arc);
		g.setColor(Color.WHITE);
		g.drawString(text, 416, 54);
	}

}
	
