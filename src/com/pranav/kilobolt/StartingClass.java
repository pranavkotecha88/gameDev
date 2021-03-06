package com.pranav.kilobolt;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;

public class StartingClass extends Applet implements Runnable, KeyListener{

	private Robot robot;
	private Image image, character;
	private Graphics second;
	private URL base;
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		//super.init();
		setSize(800, 480);
		setBackground(Color.BLACK);
		setFocusable(true);
		addKeyListener(this);
		Frame frame = (Frame) this.getParent().getParent();
		frame.setTitle("Q-Bot Alpha");
		try {
			base = getDocumentBase();
		} catch (Exception e) {
			
		}
		
		character = getImage(base, "data/character.png");
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		//super.start();
		robot = new Robot();
		Thread thread = new Thread(this);
		thread.start();
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		//super.stop();
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		//super.destroy();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		while (true) {
			robot.update();
			repaint();
			try {
				
				Thread.sleep(17);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void update(Graphics g) {
		if(image == null) {
			image = createImage(this.getWidth(), this.getHeight());
			second = image.getGraphics();
		}
		
		second.setColor(getBackground());
		second.fillRect(0, 0, getWidth(), getHeight());
		second.setColor(getForeground());
		paint(second);
		
		g.drawImage(image, 0, 0, this);
	}

	@Override
	public void paint(Graphics g) {
		g.drawImage(character, robot.getCenterX() - 61, robot.getCenterY() - 63, this);
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
			robot.moveLeft();
			//System.out.println("Move left");
			break;
		case KeyEvent.VK_RIGHT:
			robot.moveRight();
			//System.out.println("Move right");
			break;
		case KeyEvent.VK_SPACE:
			robot.jump();
			//System.out.println("Jump");
			break;
		} // switch ends
	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch(e.getKeyCode()) {
		
		case KeyEvent.VK_UP:
			System.out.println("Stop Moving Up");
			break;
		case KeyEvent.VK_DOWN:
			System.out.println("Stop Moving Down");
			break;
		case KeyEvent.VK_LEFT:
			robot.stop();
//			System.out.println("Stop Moving Left");
			break;
		case KeyEvent.VK_RIGHT:
			robot.stop();
//			System.out.println("Stop Moving Right");
			break;
		case KeyEvent.VK_SPACE:
			System.out.println("Stop Jump");
			break;
		} // switch ends
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

}
