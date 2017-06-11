package application;

import javafx.scene.control.Label;

public class Player {
	Coordinate position;
	Boolean falling = false;
	int timeFalling = 0;
	
	public Player(int x, int y){
		position = new Coordinate(x, y);
	}
	
	public void setPosition(int x, int y){
		position.setX(x);
		position.setY(y);
	}
	
	public Coordinate getPosition(){
		return position;
	}
	
	public void moveLeft(Label[][] labels){
		if(position.getX() != 0 && labels[position.getX() - 1][position.getY()].getStyle() == "background"){
			System.out.println("Left");
		}
	}
	
	public void moveRight(Label[][] labels){
		if(position.getX() != 14 && labels[position.getY()][position.getX() + 1].getStyleClass().contains("background")){
			labels[position.getY()][position.getX()].getStyleClass().clear();
			labels[position.getY()][position.getX()].getStyleClass().add("background");
//			System.out.println(position.getY() + "  " + position.getX());
//			labels[position.getY()][position.getX() + 1].getStyleClass().clear();
//			labels[position.getY()][position.getX() + 1].getStyleClass().add("player");
			position.setX(position.getX() + 1);
		} else{
			
		}
	}

	public void isFalling(){ //If falling, will execute gravity
		
	}
}