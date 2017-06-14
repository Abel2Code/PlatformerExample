package application;

import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Platform;
import javafx.scene.control.Label;

public class Player {
	Coordinate position;
	Boolean falling = false;
	int timeFalling = 0;
	private static Timer jumpTimer = new Timer();
	private static int counter = -1;
	
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
		if(position.getX() != 0 && labels[position.getY()][position.getX() - 1].getStyleClass().contains("background")){
			labels[position.getY()][position.getX()].getStyleClass().clear();
			labels[position.getY()][position.getX()].getStyleClass().add("background");
			
			labels[position.getY()][position.getX() - 1].getStyleClass().clear();
			labels[position.getY()][position.getX() - 1].getStyleClass().add("player");
			position.setX(position.getX() - 1);
		}
	}
	
	public void moveRight(Label[][] labels){
		if(position.getX() != 14 && labels[position.getY()][position.getX() + 1].getStyleClass().contains("background")){
			labels[position.getY()][position.getX()].getStyleClass().clear();
			labels[position.getY()][position.getX()].getStyleClass().add("background");
			
			labels[position.getY()][position.getX() + 1].getStyleClass().clear();
			labels[position.getY()][position.getX() + 1].getStyleClass().add("player");
			position.setX(position.getX() + 1);
		} 
	}
	
	public void jump(Label[][] labels){
		if(labels[position.getY() - 1][position.getX()].getStyleClass().contains("background")){
			System.out.println("YES");
			TimerTask startJump = new TimerTask() {
				
				@Override
				public void run() {
					
					switch(counter){
					case -1:
						position.setY(position.getY() - 1); 
						counter++;
						break;
					case 0:
						labels[position.getY() + 1][position.getX()].getStyleClass().clear();
						labels[position.getY() + 1][position.getX()].getStyleClass().add("playerBottemJump1");
						labels[position.getY()][position.getX()].getStyleClass().clear();
						labels[position.getY()][position.getX()].getStyleClass().add("playerTopJump1");
						counter++;
						break;
					case 1:
						labels[position.getY() + 1][position.getX()].getStyleClass().clear();
						labels[position.getY() + 1][position.getX()].getStyleClass().add("playerBottemJump2");
						labels[position.getY()][position.getX()].getStyleClass().clear();
						labels[position.getY()][position.getX()].getStyleClass().add("playerTopJump2");
						counter++;
						break;
					case 2:
						labels[position.getY() + 1][position.getX()].getStyleClass().clear();
						labels[position.getY() + 1][position.getX()].getStyleClass().add("playerBottemJump3");
						labels[position.getY()][position.getX()].getStyleClass().clear();
						labels[position.getY()][position.getX()].getStyleClass().add("playerTopJump3");
						counter++;
						break;
					case 3:
						labels[position.getY() + 1][position.getX()].getStyleClass().clear();
						labels[position.getY() + 1][position.getX()].getStyleClass().add("playerBottemJump4");
						labels[position.getY()][position.getX()].getStyleClass().clear();
						labels[position.getY()][position.getX()].getStyleClass().add("playerTopJump4");
						counter++;
						break;
					case 4:
						labels[position.getY() + 1][position.getX()].getStyleClass().clear();
						labels[position.getY() + 1][position.getX()].getStyleClass().add("background");
						labels[position.getY()][position.getX()].getStyleClass().clear();
						labels[position.getY()][position.getX()].getStyleClass().add("player");
						counter = -1;
						// Call fall method or execute fall through case 5-8
						
						
						Platform.runLater(new Runnable(){
							
							@Override
							public void run() {
								jumpTimer.cancel();
							}
							
						});
					}
				}
				
				
			};	
			
			jumpTimer.schedule(startJump, 0, 100);
		}
	}

	public void fall(){ //If falling, will execute gravity
		
	}
}