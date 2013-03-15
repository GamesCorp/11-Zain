package com.AdamWalters.com.zain.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import com.AdamWalters.com.zain.src.Game;

@SuppressWarnings("serial") public class MyMouseListener extends Game implements MouseListener, MouseMotionListener{
{

}

public MyMouseListener(Game game) {
	game.addMouseListener(this);
	game.addMouseMotionListener(this);
}


@Override
public void mouseDragged(MouseEvent e) {
	Game.mouseX = e.getX();
	Game.mouseY = e.getY();	
}

@Override
public void mouseMoved(MouseEvent e) {
	Game.mouseX = e.getX();
	Game.mouseY = e.getY();		
}

@Override
public void mouseClicked(MouseEvent e) {
	
}

@Override
public void mouseEntered(MouseEvent e) {
	
}

@Override
public void mouseExited(MouseEvent e) {
	
}

@SuppressWarnings("unused") @Override
public void mousePressed(MouseEvent e) {
	int X = e.getX();
	int Y = e.getY();
}

@Override
public void mouseReleased(MouseEvent e) {
	
}
}
