package application;

import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Platform;
import javafx.scene.control.Label;

/* Bugs:
 *  
 */

public class Player {
	Coordinate position;
	Boolean falling = false;
	Boolean jumping = false;
	int timeFalling = 0;
	private static Timer jumpTimer = new Timer();
	private static int counter = -1;
	private static int timerLength = 300;
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
	
	public void moveLeft(){
		cancelTimer();
		if(position.getX() != 0 && jumping == true && EnvironmentGUIPane.labels[position.getY() - 1][position.getX() - 1].getStyleClass().contains("solid")){
			return;
		}
		if(position.getX() != 0 && EnvironmentGUIPane.labels[position.getY()][position.getX() - 1].getStyleClass().contains("background")){
			cancelTimer();
			if((!(jumping || falling))|| position.getX() == 14){
				EnvironmentGUIPane.labels[position.getY()][position.getX()].getStyleClass().clear();
				EnvironmentGUIPane.labels[position.getY()][position.getX()].getStyleClass().add("background");
				
				EnvironmentGUIPane.labels[position.getY()][position.getX() - 1].getStyleClass().clear();
				EnvironmentGUIPane.labels[position.getY()][position.getX() - 1].getStyleClass().add("player");
				
			} else{
				EnvironmentGUIPane.labels[position.getY()][position.getX()].getStyleClass().clear();
				EnvironmentGUIPane.labels[position.getY()][position.getX()].getStyleClass().add("background");
				EnvironmentGUIPane.labels[position.getY() - 1][position.getX()].getStyleClass().clear();
				EnvironmentGUIPane.labels[position.getY() - 1][position.getX()].getStyleClass().add("background");
				
				switch(counter - 1){
				case 0:			
					EnvironmentGUIPane.labels[position.getY()][position.getX() - 1].getStyleClass().clear();
					EnvironmentGUIPane.labels[position.getY()][position.getX() - 1].getStyleClass().add("playerBottomJump1");
					EnvironmentGUIPane.labels[position.getY() - 1][position.getX() - 1].getStyleClass().clear();
					EnvironmentGUIPane.labels[position.getY() - 1][position.getX() - 1].getStyleClass().add("playerTopJump1");
					break;
				case 1:
					EnvironmentGUIPane.labels[position.getY()][position.getX() - 1].getStyleClass().clear();
					EnvironmentGUIPane.labels[position.getY()][position.getX() - 1].getStyleClass().add("playerBottomJump2");
					EnvironmentGUIPane.labels[position.getY() - 1][position.getX() - 1].getStyleClass().clear();
					EnvironmentGUIPane.labels[position.getY() - 1][position.getX() - 1].getStyleClass().add("playerTopJump2");
					break;
				case 2:
					EnvironmentGUIPane.labels[position.getY()][position.getX() - 1].getStyleClass().clear();
					EnvironmentGUIPane.labels[position.getY()][position.getX() - 1].getStyleClass().add("playerBottomJump3");
					EnvironmentGUIPane.labels[position.getY() - 1][position.getX() - 1].getStyleClass().clear();
					EnvironmentGUIPane.labels[position.getY() - 1][position.getX() - 1].getStyleClass().add("playerTopJump3");
					break;
				case 3:
					EnvironmentGUIPane.labels[position.getY()][position.getX() - 1].getStyleClass().clear();
					EnvironmentGUIPane.labels[position.getY()][position.getX() - 1].getStyleClass().add("playerBottomJump4");
					EnvironmentGUIPane.labels[position.getY() - 1][position.getX() - 1].getStyleClass().clear();
					EnvironmentGUIPane.labels[position.getY() - 1][position.getX() - 1].getStyleClass().add("playerTopJump4");
					break;
				case 4:
					EnvironmentGUIPane.labels[position.getY() + 1][position.getX() - 1].getStyleClass().clear();
					EnvironmentGUIPane.labels[position.getY() + 1][position.getX() - 1].getStyleClass().add("background");
					EnvironmentGUIPane.labels[position.getY()][position.getX() - 1].getStyleClass().clear();
					EnvironmentGUIPane.labels[position.getY()][position.getX() - 1].getStyleClass().add("player");
					break;
				case 5:
					EnvironmentGUIPane.labels[position.getY()][position.getX() - 1].getStyleClass().clear();
					EnvironmentGUIPane.labels[position.getY()][position.getX() - 1].getStyleClass().add("playerTopJump4");
					EnvironmentGUIPane.labels[position.getY() + 1][position.getX() - 1].getStyleClass().clear();
					EnvironmentGUIPane.labels[position.getY() + 1][position.getX() - 1].getStyleClass().add("playerBottomJump4");
					break;
				case 6:
					EnvironmentGUIPane.labels[position.getY()][position.getX() - 1].getStyleClass().clear();
					EnvironmentGUIPane.labels[position.getY()][position.getX() - 1].getStyleClass().add("playerTopJump4");
					EnvironmentGUIPane.labels[position.getY() + 1][position.getX() - 1].getStyleClass().clear();
					EnvironmentGUIPane.labels[position.getY() + 1][position.getX() - 1].getStyleClass().add("playerBottomJump4");
					break;
				case 7:
					EnvironmentGUIPane.labels[position.getY()][position.getX() - 1].getStyleClass().clear();
					EnvironmentGUIPane.labels[position.getY()][position.getX() - 1].getStyleClass().add("playerTopJump3");
					EnvironmentGUIPane.labels[position.getY() + 1][position.getX() - 1].getStyleClass().clear();
					EnvironmentGUIPane.labels[position.getY() + 1][position.getX() - 1].getStyleClass().add("playerBottomJump3");
					break;
				case 8:
					EnvironmentGUIPane.labels[position.getY()][position.getX() - 1].getStyleClass().clear();
					EnvironmentGUIPane.labels[position.getY()][position.getX() - 1].getStyleClass().add("playerTopJump2");
					EnvironmentGUIPane.labels[position.getY() + 1][position.getX() - 1].getStyleClass().clear();
					EnvironmentGUIPane.labels[position.getY() + 1][position.getX() - 1].getStyleClass().add("playerBottomJump2");
					break;
				case 9:
					EnvironmentGUIPane.labels[position.getY()][position.getX() - 1].getStyleClass().clear();
					EnvironmentGUIPane.labels[position.getY()][position.getX() - 1].getStyleClass().add("playerTopJump1");
					EnvironmentGUIPane.labels[position.getY() + 1][position.getX() - 1].getStyleClass().clear();
					EnvironmentGUIPane.labels[position.getY() + 1][position.getX() - 1].getStyleClass().add("playerBottomJump1");
					break;
				case 10:
					EnvironmentGUIPane.labels[position.getY()][position.getX() - 1].getStyleClass().clear();
					EnvironmentGUIPane.labels[position.getY()][position.getX() - 1].getStyleClass().add("background");
					EnvironmentGUIPane.labels[position.getY() + 1][position.getX() - 1].getStyleClass().clear();
					EnvironmentGUIPane.labels[position.getY() + 1][position.getX() - 1].getStyleClass().add("player");
				
				}
				canFall();
			}
			position.setX(position.getX() - 1);
			if(falling == true){
				EnvironmentGUIPane.labels[position.getY() + 1][position.getX() + 1].getStyleClass().clear();
				EnvironmentGUIPane.labels[position.getY() + 1][position.getX() + 1].getStyleClass().add("background");
			}
		}
	}
	
	public void moveRight(){
		if(position.getX() != 14 && jumping == true && (EnvironmentGUIPane.labels[position.getY() - 1][position.getX() + 1].getStyleClass().contains("solid"))){
			return;
		}
		
		if(position.getX() != 14 && EnvironmentGUIPane.labels[position.getY()][position.getX() + 1].getStyleClass().contains("background")){
			if(!(jumping || falling)){
				System.out.println("MovRigh");
				EnvironmentGUIPane.labels[position.getY()][position.getX()].getStyleClass().clear();
				EnvironmentGUIPane.labels[position.getY()][position.getX()].getStyleClass().add("background");
				
				EnvironmentGUIPane.labels[position.getY()][position.getX() + 1].getStyleClass().clear();
				EnvironmentGUIPane.labels[position.getY()][position.getX() + 1].getStyleClass().add("player");
				System.out.println("CALLING TESTTTT");
				canFall();
			} else{
				EnvironmentGUIPane.labels[position.getY()][position.getX()].getStyleClass().clear();
				EnvironmentGUIPane.labels[position.getY()][position.getX()].getStyleClass().add("background");
				EnvironmentGUIPane.labels[position.getY() - 1][position.getX()].getStyleClass().clear();
				EnvironmentGUIPane.labels[position.getY() - 1][position.getX()].getStyleClass().add("background");
				switch(counter - 1){
				case 0:			
					EnvironmentGUIPane.labels[position.getY()][position.getX() + 1].getStyleClass().clear();
					EnvironmentGUIPane.labels[position.getY()][position.getX() + 1].getStyleClass().add("playerBottomJump1");
					EnvironmentGUIPane.labels[position.getY() - 1][position.getX() + 1].getStyleClass().clear();
					EnvironmentGUIPane.labels[position.getY() - 1][position.getX() + 1].getStyleClass().add("playerTopJump1");
					break;
				case 1:
					System.out.println("Breaks");
					EnvironmentGUIPane.labels[position.getY()][position.getX() + 1].getStyleClass().clear();
					EnvironmentGUIPane.labels[position.getY()][position.getX() + 1].getStyleClass().add("playerBottomJump2");
					EnvironmentGUIPane.labels[position.getY() - 1][position.getX() + 1].getStyleClass().clear();
					EnvironmentGUIPane.labels[position.getY() - 1][position.getX() + 1].getStyleClass().add("playerTopJump2");
					break;
				case 2:
					EnvironmentGUIPane.labels[position.getY()][position.getX() + 1].getStyleClass().clear();
					EnvironmentGUIPane.labels[position.getY()][position.getX() + 1].getStyleClass().add("playerBottomJump3");
					EnvironmentGUIPane.labels[position.getY() - 1][position.getX() + 1].getStyleClass().clear();
					EnvironmentGUIPane.labels[position.getY() - 1][position.getX() + 1].getStyleClass().add("playerTopJump3");
					break;
				case 3:
					EnvironmentGUIPane.labels[position.getY()][position.getX() + 1].getStyleClass().clear();
					EnvironmentGUIPane.labels[position.getY()][position.getX() + 1].getStyleClass().add("playerBottomJump4");
					EnvironmentGUIPane.labels[position.getY() - 1][position.getX() + 1].getStyleClass().clear();
					EnvironmentGUIPane.labels[position.getY() - 1][position.getX() + 1].getStyleClass().add("playerTopJump4");
					break;
				case 4:
					EnvironmentGUIPane.labels[position.getY()][position.getX() + 1].getStyleClass().clear();
					EnvironmentGUIPane.labels[position.getY()][position.getX() + 1].getStyleClass().add("player");
					break;
				case 5:
					EnvironmentGUIPane.labels[position.getY()][position.getX() + 1].getStyleClass().clear();
					EnvironmentGUIPane.labels[position.getY()][position.getX() + 1].getStyleClass().add("playerTopJump4");
					EnvironmentGUIPane.labels[position.getY() + 1][position.getX() + 1].getStyleClass().clear();
					EnvironmentGUIPane.labels[position.getY() + 1][position.getX() + 1].getStyleClass().add("playerBottomJump4");
					break;
				case 6:
					EnvironmentGUIPane.labels[position.getY()][position.getX() + 1].getStyleClass().clear();
					EnvironmentGUIPane.labels[position.getY()][position.getX() + 1].getStyleClass().add("playerTopJump4");
					EnvironmentGUIPane.labels[position.getY() + 1][position.getX() + 1].getStyleClass().clear();
					EnvironmentGUIPane.labels[position.getY() + 1][position.getX() + 1].getStyleClass().add("playerBottomJump4");
					break;
				case 7:
					EnvironmentGUIPane.labels[position.getY()][position.getX() + 1].getStyleClass().clear();
					EnvironmentGUIPane.labels[position.getY()][position.getX() + 1].getStyleClass().add("playerTopJump3");
					EnvironmentGUIPane.labels[position.getY() + 1][position.getX() + 1].getStyleClass().clear();
					EnvironmentGUIPane.labels[position.getY() + 1][position.getX() + 1].getStyleClass().add("playerBottomJump3");
					break;
				case 8:
					EnvironmentGUIPane.labels[position.getY()][position.getX() + 1].getStyleClass().clear();
					EnvironmentGUIPane.labels[position.getY()][position.getX() + 1].getStyleClass().add("playerTopJump2");
					EnvironmentGUIPane.labels[position.getY() + 1][position.getX() + 1].getStyleClass().clear();
					EnvironmentGUIPane.labels[position.getY() + 1][position.getX() + 1].getStyleClass().add("playerBottomJump2");
					break;
				case 9:
					EnvironmentGUIPane.labels[position.getY()][position.getX() + 1].getStyleClass().clear();
					EnvironmentGUIPane.labels[position.getY()][position.getX() + 1].getStyleClass().add("playerTopJump1");
					EnvironmentGUIPane.labels[position.getY() + 1][position.getX() + 1].getStyleClass().clear();
					EnvironmentGUIPane.labels[position.getY() + 1][position.getX() + 1].getStyleClass().add("playerBottomJump1");
					break;
				case 10:
					EnvironmentGUIPane.labels[position.getY()][position.getX() + 1].getStyleClass().clear();
					EnvironmentGUIPane.labels[position.getY()][position.getX() + 1].getStyleClass().add("background");
					EnvironmentGUIPane.labels[position.getY() + 1][position.getX() + 1].getStyleClass().clear();
					EnvironmentGUIPane.labels[position.getY() + 1][position.getX() + 1].getStyleClass().add("player");
				}
				canFall();
			}
			position.setX(position.getX() + 1);
		} 
		
		if(falling == true){
			EnvironmentGUIPane.labels[position.getY() + 1][position.getX() - 1].getStyleClass().clear();
			EnvironmentGUIPane.labels[position.getY() + 1][position.getX() - 1].getStyleClass().add("background");
		}
	}
	
	public void jump(){
		if(EnvironmentGUIPane.labels[position.getY() - 1][position.getX()].getStyleClass().contains("background")){
			EnvironmentGUIPane.condition = true;
			jumping = true;
			counter = 0;
			TimerTask startJump = new TimerTask() {
				
				@Override
				public void run() {
					switch(counter){
					case -1:
						counter++;
						break;
					case 0:
						EnvironmentGUIPane.labels[position.getY()][position.getX()].getStyleClass().clear();
						EnvironmentGUIPane.labels[position.getY()][position.getX()].getStyleClass().add("playerBottomJump1");
						EnvironmentGUIPane.labels[position.getY() - 1][position.getX()].getStyleClass().clear();
						EnvironmentGUIPane.labels[position.getY() - 1][position.getX()].getStyleClass().add("playerTopJump1");
						counter++;
						break;
					case 1:
						EnvironmentGUIPane.labels[position.getY()][position.getX()].getStyleClass().clear();
						EnvironmentGUIPane.labels[position.getY()][position.getX()].getStyleClass().add("playerBottomJump2");
						EnvironmentGUIPane.labels[position.getY() - 1][position.getX()].getStyleClass().clear();
						EnvironmentGUIPane.labels[position.getY() - 1][position.getX()].getStyleClass().add("playerTopJump2");
						counter++;
						break;
					case 2:
						EnvironmentGUIPane.labels[position.getY()][position.getX()].getStyleClass().clear();
						EnvironmentGUIPane.labels[position.getY()][position.getX()].getStyleClass().add("playerBottomJump3");
						EnvironmentGUIPane.labels[position.getY() - 1][position.getX()].getStyleClass().clear();
						EnvironmentGUIPane.labels[position.getY() - 1][position.getX()].getStyleClass().add("playerTopJump3");
						counter++;
						break;
					case 3:
						EnvironmentGUIPane.labels[position.getY()][position.getX()].getStyleClass().clear();
						EnvironmentGUIPane.labels[position.getY()][position.getX()].getStyleClass().add("playerBottomJump4");
						EnvironmentGUIPane.labels[position.getY() - 1][position.getX()].getStyleClass().clear();
						EnvironmentGUIPane.labels[position.getY() - 1][position.getX()].getStyleClass().add("playerTopJump4");
						counter++;
						break;
					case 4:
						EnvironmentGUIPane.labels[position.getY()][position.getX()].getStyleClass().clear();
						EnvironmentGUIPane.labels[position.getY()][position.getX()].getStyleClass().add("background");
						EnvironmentGUIPane.labels[position.getY() - 1][position.getX()].getStyleClass().clear();
						EnvironmentGUIPane.labels[position.getY() - 1][position.getX()].getStyleClass().add("player");
							
						
						jumping = false;
						falling = true;
						EnvironmentGUIPane.condition = false;
						position.setY(position.getY() - 1);	
						counter++;
						canFall();
						break;
						
//						case 5:
//							if(!EnvironmentGUIPane.labels[position.getY() + 1][position.getX()].getStyleClass().contains("background")){
//								counter = -1;
//								EnvironmentGUIPane.condition = false;
//								Platform.runLater(new Runnable(){
//									
//									@Override
//									public void run() {
//										jumpTimer.cancel();
//										jumpTimer = new Timer();
//										falling = false;
//									}
//									
//								});
//							return;
//							} 
//							
//						EnvironmentGUIPane.labels[position.getY()][position.getX()].getStyleClass().clear();
//						EnvironmentGUIPane.labels[position.getY()][position.getX()].getStyleClass().add("playerTopJump4");
//						EnvironmentGUIPane.labels[position.getY() + 1][position.getX()].getStyleClass().clear();
//						EnvironmentGUIPane.labels[position.getY() + 1][position.getX()].getStyleClass().add("playerBottomJump4");
//						
//						counter++;
//						break;
//					case 6: counter++; break;
//					case 7:
//						EnvironmentGUIPane.labels[position.getY()][position.getX()].getStyleClass().clear();
//						EnvironmentGUIPane.labels[position.getY()][position.getX()].getStyleClass().add("playerTopJump3");
//						EnvironmentGUIPane.labels[position.getY() + 1][position.getX()].getStyleClass().clear();
//						EnvironmentGUIPane.labels[position.getY() + 1][position.getX()].getStyleClass().add("playerBottomJump3");
//						counter++;
//						break;
//					case 8:
//						EnvironmentGUIPane.labels[position.getY()][position.getX()].getStyleClass().clear();
//						EnvironmentGUIPane.labels[position.getY()][position.getX()].getStyleClass().add("playerTopJump2");
//						EnvironmentGUIPane.labels[position.getY() + 1][position.getX()].getStyleClass().clear();
//						EnvironmentGUIPane.labels[position.getY() + 1][position.getX()].getStyleClass().add("playerBottomJump2");
//						counter++;
//						break;
//					case 9:
//						EnvironmentGUIPane.labels[position.getY()][position.getX()].getStyleClass().clear();
//						EnvironmentGUIPane.labels[position.getY()][position.getX()].getStyleClass().add("playerTopJump1");
//						EnvironmentGUIPane.labels[position.getY() + 1][position.getX()].getStyleClass().clear();
//						EnvironmentGUIPane.labels[position.getY() + 1][position.getX()].getStyleClass().add("playerBottomJump1");
//						counter++;
//						break;
//					case 10:
//						EnvironmentGUIPane.labels[position.getY()][position.getX()].getStyleClass().clear();
//						EnvironmentGUIPane.labels[position.getY()][position.getX()].getStyleClass().add("background");
//						EnvironmentGUIPane.labels[position.getY() + 1][position.getX()].getStyleClass().clear();
//						EnvironmentGUIPane.labels[position.getY() + 1][position.getX()].getStyleClass().add("player");
//						position.setY(position.getY() + 1);
//						counter = -1;
//						// Call fall method or execute fall through case 5-8
//						
//						
//						Platform.runLater(new Runnable(){
//							
//							@Override
//							public void run() {
//								jumpTimer.cancel();
//								jumpTimer = new Timer();
//								falling = false;
//								EnvironmentGUIPane.condition = false;
//							}
//							
//						});
					}
				}
				
				
			};	
			
			jumpTimer.schedule(startJump, 0, timerLength);
		}
	}
	
	private void canFall(){
		if(EnvironmentGUIPane.labels[position.getY() + 1][position.getX()].getStyleClass().contains("background")){
			
			EnvironmentGUIPane.condition = true;
			falling = true;
			TimerTask startJump = new TimerTask() {
				
				@Override
				public void run() {
					
					switch(counter){						
						case 5:
							if(!EnvironmentGUIPane.labels[position.getY() + 1][position.getX()].getStyleClass().contains("background")){
								counter = -1;
								EnvironmentGUIPane.condition = false;
								cancelTimer();
							return;
							} 
							
						EnvironmentGUIPane.labels[position.getY()][position.getX()].getStyleClass().clear();
						EnvironmentGUIPane.labels[position.getY()][position.getX()].getStyleClass().add("playerTopJump4");
						EnvironmentGUIPane.labels[position.getY() + 1][position.getX()].getStyleClass().clear();
						EnvironmentGUIPane.labels[position.getY() + 1][position.getX()].getStyleClass().add("playerBottomJump4");
						
						counter++;
						break;
					case 6: counter++; break;
					case 7:
						EnvironmentGUIPane.labels[position.getY()][position.getX()].getStyleClass().clear();
						EnvironmentGUIPane.labels[position.getY()][position.getX()].getStyleClass().add("playerTopJump3");
						EnvironmentGUIPane.labels[position.getY() + 1][position.getX()].getStyleClass().clear();
						EnvironmentGUIPane.labels[position.getY() + 1][position.getX()].getStyleClass().add("playerBottomJump3");
						counter++;
						break;
					case 8:
						EnvironmentGUIPane.labels[position.getY()][position.getX()].getStyleClass().clear();
						EnvironmentGUIPane.labels[position.getY()][position.getX()].getStyleClass().add("playerTopJump2");
						EnvironmentGUIPane.labels[position.getY() + 1][position.getX()].getStyleClass().clear();
						EnvironmentGUIPane.labels[position.getY() + 1][position.getX()].getStyleClass().add("playerBottomJump2");
						counter++;
						break;
					case 9:
						EnvironmentGUIPane.labels[position.getY()][position.getX()].getStyleClass().clear();
						EnvironmentGUIPane.labels[position.getY()][position.getX()].getStyleClass().add("playerTopJump1");
						EnvironmentGUIPane.labels[position.getY() + 1][position.getX()].getStyleClass().clear();
						EnvironmentGUIPane.labels[position.getY() + 1][position.getX()].getStyleClass().add("playerBottomJump1");
						counter++;
						break;
					case 10:
						EnvironmentGUIPane.labels[position.getY()][position.getX()].getStyleClass().clear();
						EnvironmentGUIPane.labels[position.getY()][position.getX()].getStyleClass().add("background");
						EnvironmentGUIPane.labels[position.getY() + 1][position.getX()].getStyleClass().clear();
						EnvironmentGUIPane.labels[position.getY() + 1][position.getX()].getStyleClass().add("player");
						position.setY(position.getY() + 1);
						counter = -1;
						// Call fall method or execute fall through case 5-8
					default:
						cancelTimer();					
						
					
					}
				}
				
				
			};	
			
			jumpTimer.schedule(startJump, 0, timerLength);
		
		} else{
			counter = -1;
		}
	}
	
	public void cancelTimer(){
		Platform.runLater(new Runnable(){
			
			@Override
			public void run() {
				jumpTimer.cancel();
				jumpTimer = new Timer();
				falling = false;
				EnvironmentGUIPane.condition = false;
			}
			
		});
	}
}