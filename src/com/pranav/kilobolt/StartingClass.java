package com.pranav.kilobolt;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Frame;
import java.awt.RenderingHints.Key;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class StartingClass extends Applet implements Runnable, KeyListener{

	@Override
	public void init() {
		// TODO Auto-generated method stub
		super.init();
		setSize(800, 480);
		setBackground(Color.BLACK);
		setFocusable(true);
		addKeyListener(this);
		Frame frame = (Frame) this.getParent().getParent();
		frame.setTitle("Q-Bot Alpha");
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		super.start();
		Thread thread = new Thread(this);
		thread.start();
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		super.stop();
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		repaint();
		while (true) {
			try {
				Thread.sleep(17);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		switch(e.getKeyCode()) {
		
		case KeyEvent.VK_UP:
			System.out.println("Move up");
			break;
		case KeyEvent.VK_DOWN:
			System.out.println("Move Down");
			break;
		case KeyEvent.VK_LEFT:
			System.out.println("Move left");
			break;
		case KeyEvent.VK_RIGHT:
			System.out.println("Move right");
			break;
		case KeyEvent.VK_SPACE:
			System.out.println("Jump");
			break;
		} // switch ends
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		switch(e.getKeyCode()) {
		
		case KeyEvent.VK_UP:
			System.out.println("Stop Moving Up");
			break;
		case KeyEvent.VK_DOWN:
			System.out.println("Stop Moving Down");
			break;
		case KeyEvent.VK_LEFT:
			System.out.println("Stop Moving Left");
			break;
		case KeyEvent.VK_RIGHT:
			System.out.println("Stop Moving Right");
			break;
		case KeyEvent.VK_SPACE:
			System.out.println("Stop Jump");
			break;
		} // switch ends
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
