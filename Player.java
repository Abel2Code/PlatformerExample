package application;

import javafx.scene.control.Label;

public class Player {
	Coordinate position;
	Boolean falling = false;
	int timeFalling = 0;
	
	public Player(double x, double y){
		position = new Coordinate(x, y);
	}
	
	public void setPosition(double x, double y){
		position.setX(x);
		position.setY(y);
	}
	
	public Coordinate getPosition(){
		return position;
	}
	
	public void moveLeft(Label[][] labels){
//		if(player)
	}
	
	public void moveRight(){
		
	}

	public void isFalling(){ //If falling, will execute gravity
		
	}
}