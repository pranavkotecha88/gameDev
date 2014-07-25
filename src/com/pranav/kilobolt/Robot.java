package com.pranav.kilobolt;

/*
 * Class Robot : Used to describe the speed and controlling the x and y
 * co-ordinates of the robot
 * 
 * */
public class Robot {

	public int getCenterX() {
		return centerX;
	}

	public void setCenterX(int centerX) {
		this.centerX = centerX;
	}

	public int getCenterY() {
		return centerY;
	}

	public void setCenterY(int centerY) {
		this.centerY = centerY;
	}

	public boolean isJumped() {
		return jumped;
	}

	public void setJumped(boolean jumped) {
		this.jumped = jumped;
	}

	public int getSpeedX() {
		return speedX;
	}

	public void setSpeedX(int speedX) {
		this.speedX = speedX;
	}

	public int getSpeedY() {
		return speedY;
	}

	public void setSpeedY(int speedY) {
		this.speedY = speedY;
	}

	private int centerX = 100;
	private int centerY = 382;
	
	private boolean jumped = false;
	
	private int speedX = 0;
	private int speedY = 0;
	
	/*
	 * Method which updates the position of the robot
	 */
	public void update() {
		// Moves Character or Scrolls Background accordingly.
		if(speedX < 0) {
			centerX += speedX;
		} // end if(speedX < 0) 
		else if (speedX == 0) {
			System.out.println("Dont scoll the background");
		} // end if (speedX == 0)
		else {
			if(centerX <= 150) {
				centerX += speedX;
			} // end if(centerX <= 150)
			else {
				System.out.println("Scroll background here");
			} // end else 
		} // end else
		
		// Update the Y position
		if(centerX + centerY >= 382) {
			centerY = 382;
		} // end if(centerX + centerY >= 382)
		else {
			centerY = speedY;
		} // end else
		
		// Handles Jumping
		if(jumped == true) {
			speedY += 1;
			
			if(centerY + speedY >= 382) {
				centerY = 382;
				speedY = 0;
				jumped = false;
			} // end if(centerY + speedY >= 382)
		} // end if(jumped == true)
		
		// Prevents going beyond X co-ordinate of 0
		if(centerX + speedX <= 60) {
			centerX = 61;
		} // end if(centerX + speedX <= 60)
		
	} // end update
	
	// Moves the robot to right side
	public void moveRight() {
		speedX = 6;
	} // ends moveRight()
	
	// Moves the robot to left side
	public void moveLeft() {
		speedX = -6;
	} // ends moveLeft()
	
	// stops the robot
	public void stop() {
		speedX = 0;
	} // end stop()
	
	// makes the robot jump
	public void jump() {
		if(!jumped) {
			speedY = -15;
			jumped = true;
		} // end if(!jumped) 
	} // end jump()
	
} // End of Robot class
