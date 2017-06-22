package application;

import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Platform;
import javafx.scene.control.Label;

/* Bugs:
 * 	Movement when falling leaves trail
 *  If solid below when falling, solid will be deleted 
 */

public class Player {
	Coordinate position;
	Boolean falling = false;
	Boolean jumping = false;
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
		if(position.getX() != 0 && jumping == true && labels[position.getY() - 1][position.getX() - 1].getStyleClass().contains("solid")){
			return;
		}
		if(position.getX() != 0 && labels[position.getY()][position.getX() - 1].getStyleClass().contains("background")){
			if(jumping != true || position.getX() == 14){
				labels[position.getY()][position.getX()].getStyleClass().clear();
				labels[position.getY()][position.getX()].getStyleClass().add("background");
				
				labels[position.getY()][position.getX() - 1].getStyleClass().clear();
				labels[position.getY()][position.getX() - 1].getStyleClass().add("player");
				
			} else{
				labels[position.getY()][position.getX()].getStyleClass().clear();
				labels[position.getY()][position.getX()].getStyleClass().add("background");
				labels[position.getY() - 1][position.getX()].getStyleClass().clear();
				labels[position.getY() - 1][position.getX()].getStyleClass().add("background");
				
				switch(counter){
				case 0:			
					labels[position.getY()][position.getX() - 1].getStyleClass().clear();
					labels[position.getY()][position.getX() - 1].getStyleClass().add("playerBottomJump1");
					labels[position.getY() - 1][position.getX() - 1].getStyleClass().clear();
					labels[position.getY() - 1][position.getX() - 1].getStyleClass().add("playerTopJump1");
					break;
				case 1:
					labels[position.getY()][position.getX() - 1].getStyleClass().clear();
					labels[position.getY()][position.getX() - 1].getStyleClass().add("playerBottomJump2");
					labels[position.getY() - 1][position.getX() - 1].getStyleClass().clear();
					labels[position.getY() - 1][position.getX() - 1].getStyleClass().add("playerTopJump2");
					break;
				case 2:
					labels[position.getY()][position.getX() - 1].getStyleClass().clear();
					labels[position.getY()][position.getX() - 1].getStyleClass().add("playerBottomJump3");
					labels[position.getY() - 1][position.getX() - 1].getStyleClass().clear();
					labels[position.getY() - 1][position.getX() - 1].getStyleClass().add("playerTopJump3");
					break;
				case 3:
					labels[position.getY()][position.getX() - 1].getStyleClass().clear();
					labels[position.getY()][position.getX() - 1].getStyleClass().add("playerBottomJump4");
					labels[position.getY() - 1][position.getX() - 1].getStyleClass().clear();
					labels[position.getY() - 1][position.getX() - 1].getStyleClass().add("playerTopJump4");
					break;
				case 4:
					labels[position.getY()][position.getX() - 1].getStyleClass().clear();
					labels[position.getY()][position.getX() - 1].getStyleClass().add("background");
					labels[position.getY() - 1][position.getX() - 1].getStyleClass().clear();
					labels[position.getY() - 1][position.getX() - 1].getStyleClass().add("player");
				
				}
			}
			position.setX(position.getX() - 1);
		}
	}
	
	public void moveRight(Label[][] labels){
		if(position.getX() != 14 && jumping == true && (labels[position.getY() - 1][position.getX() + 1].getStyleClass().contains("solid"))){
			return;
		}
		
		if(position.getX() != 14 && labels[position.getY()][position.getX() + 1].getStyleClass().contains("background")){
			if(!jumping){
				labels[position.getY()][position.getX()].getStyleClass().clear();
				labels[position.getY()][position.getX()].getStyleClass().add("background");
				
				labels[position.getY()][position.getX() + 1].getStyleClass().clear();
				labels[position.getY()][position.getX() + 1].getStyleClass().add("player");
			} else{
				labels[position.getY()][position.getX()].getStyleClass().clear();
				labels[position.getY()][position.getX()].getStyleClass().add("background");
				labels[position.getY() - 1][position.getX()].getStyleClass().clear();
				labels[position.getY() - 1][position.getX()].getStyleClass().add("background");
				
				switch(counter){
				case 0:			
					labels[position.getY()][position.getX() + 1].getStyleClass().clear();
					labels[position.getY()][position.getX() + 1].getStyleClass().add("playerBottomJump1");
					labels[position.getY() - 1][position.getX() + 1].getStyleClass().clear();
					labels[position.getY() - 1][position.getX() + 1].getStyleClass().add("playerTopJump1");
					break;
				case 1:
					labels[position.getY()][position.getX() + 1].getStyleClass().clear();
					labels[position.getY()][position.getX() + 1].getStyleClass().add("playerBottomJump2");
					labels[position.getY() - 1][position.getX() + 1].getStyleClass().clear();
					labels[position.getY() - 1][position.getX() + 1].getStyleClass().add("playerTopJump2");
					break;
				case 2:
					labels[position.getY()][position.getX() + 1].getStyleClass().clear();
					labels[position.getY()][position.getX() + 1].getStyleClass().add("playerBottomJump3");
					labels[position.getY() - 1][position.getX() + 1].getStyleClass().clear();
					labels[position.getY() - 1][position.getX() + 1].getStyleClass().add("playerTopJump3");
					break;
				case 3:
					labels[position.getY()][position.getX() + 1].getStyleClass().clear();
					labels[position.getY()][position.getX() + 1].getStyleClass().add("playerBottomJump4");
					labels[position.getY() - 1][position.getX() + 1].getStyleClass().clear();
					labels[position.getY() - 1][position.getX() + 1].getStyleClass().add("playerTopJump4");
					break;
				case 4:
					labels[position.getY()][position.getX() + 1].getStyleClass().clear();
					labels[position.getY()][position.getX() + 1].getStyleClass().add("background");
					labels[position.getY() - 1][position.getX() + 1].getStyleClass().clear();
					labels[position.getY() - 1][position.getX() + 1].getStyleClass().add("player");
				}
			}
			position.setX(position.getX() + 1);
		} 
		
		if(jumping == true){
			labels[position.getY() - 1][position.getX() - 1].getStyleClass().clear();
			labels[position.getY() - 1][position.getX() - 1].getStyleClass().add("background");
		}
	}
	
	public void jump(Label[][] labels){
		if(labels[position.getY() - 1][position.getX()].getStyleClass().contains("background")){
			EnvironmentGUIPane.condition = true;
			jumping = true;
			TimerTask startJump = new TimerTask() {
				
				@Override
				public void run() {
					switch(counter){
					case -1:
						counter++;
						break;
					case 0:
						labels[position.getY()][position.getX()].getStyleClass().clear();
						labels[position.getY()][position.getX()].getStyleClass().add("playerBottomJump1");
						labels[position.getY() - 1][position.getX()].getStyleClass().clear();
						labels[position.getY() - 1][position.getX()].getStyleClass().add("playerTopJump1");
						counter++;
						break;
					case 1:
						labels[position.getY()][position.getX()].getStyleClass().clear();
						labels[position.getY()][position.getX()].getStyleClass().add("playerBottomJump2");
						labels[position.getY() - 1][position.getX()].getStyleClass().clear();
						labels[position.getY() - 1][position.getX()].getStyleClass().add("playerTopJump2");
						counter++;
						break;
					case 2:
						labels[position.getY()][position.getX()].getStyleClass().clear();
						labels[position.getY()][position.getX()].getStyleClass().add("playerBottomJump3");
						labels[position.getY() - 1][position.getX()].getStyleClass().clear();
						labels[position.getY() - 1][position.getX()].getStyleClass().add("playerTopJump3");
						counter++;
						break;
					case 3:
						labels[position.getY()][position.getX()].getStyleClass().clear();
						labels[position.getY()][position.getX()].getStyleClass().add("playerBottomJump4");
						labels[position.getY() - 1][position.getX()].getStyleClass().clear();
						labels[position.getY() - 1][position.getX()].getStyleClass().add("playerTopJump4");
						counter++;
						break;
					case 4:
						labels[position.getY()][position.getX()].getStyleClass().clear();
						labels[position.getY()][position.getX()].getStyleClass().add("background");
						labels[position.getY() - 1][position.getX()].getStyleClass().clear();
						labels[position.getY() - 1][position.getX()].getStyleClass().add("player");
						position.setY(position.getY() - 1);
						jumping = false;
						falling = true;
						counter++;
					case 5:
						labels[position.getY()][position.getX()].getStyleClass().clear();
						labels[position.getY()][position.getX()].getStyleClass().add("playerTopJump4");
						labels[position.getY() + 1][position.getX()].getStyleClass().clear();
						labels[position.getY() + 1][position.getX()].getStyleClass().add("playerBottomJump4");
						counter++;
						break;
					case 6:
						labels[position.getY()][position.getX()].getStyleClass().clear();
						labels[position.getY()][position.getX()].getStyleClass().add("playerTopJump3");
						labels[position.getY() + 1][position.getX()].getStyleClass().clear();
						labels[position.getY() + 1][position.getX()].getStyleClass().add("playerBottomJump3");
						counter++;
						break;
					case 7:
						labels[position.getY()][position.getX()].getStyleClass().clear();
						labels[position.getY()][position.getX()].getStyleClass().add("playerTopJump2");
						labels[position.getY() + 1][position.getX()].getStyleClass().clear();
						labels[position.getY() + 1][position.getX()].getStyleClass().add("playerBottomJump2");
						counter++;
						break;
					case 8:
						labels[position.getY()][position.getX()].getStyleClass().clear();
						labels[position.getY()][position.getX()].getStyleClass().add("playerTopJump1");
						labels[position.getY() + 1][position.getX()].getStyleClass().clear();
						labels[position.getY() + 1][position.getX()].getStyleClass().add("playerBottomJump1");
						counter++;
						break;
					case 9:
						labels[position.getY()][position.getX()].getStyleClass().clear();
						labels[position.getY()][position.getX()].getStyleClass().add("background");
						labels[position.getY() + 1][position.getX()].getStyleClass().clear();
						labels[position.getY() + 1][position.getX()].getStyleClass().add("player");
						position.setY(position.getY() + 1);
						counter = -1;
						falling = false;
						EnvironmentGUIPane.condition = false;
						// Call fall method or execute fall through case 5-8
						
						
						Platform.runLater(new Runnable(){
							
							@Override
							public void run() {
								jumpTimer.cancel();
								jumpTimer = new Timer();
								falling = false;
							}
							
						});
					}
				}
				
				
			};	
			
			jumpTimer.schedule(startJump, 0, 1000);
		}
	}

	public void fall(){ //If falling, will execute gravity
		
	}
}