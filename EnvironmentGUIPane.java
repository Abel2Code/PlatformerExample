package application;

import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;

public class EnvironmentGUIPane extends GridPane{
	static Label[][] labels;
	private int rows;
	private int columns;
	private Player player = new Player(0,13);
	public static boolean condition = false;
	
	
	
	public void startLevel(int levelNum){
		labels = Levels.createLevel(levelNum);
		rows = labels.length;
		columns = labels[0].length;
		
		for(int r = 0; r < rows; r++){
			for(int c = 0; c < columns; c++){
				add(labels[c][r], r, c);  // DONT FORGET TO ADD LABEL TO GRIDPANE :)
			}
		}
		
		labels[13][0] = Levels.labelInit("player");
		add(labels[13][0], 0, 13);
		
		Main.scene.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>(){
			@Override
			public void handle(KeyEvent event) {
				if(event.getCode() == KeyCode.RIGHT || event.getCode() == KeyCode.D){
					player.moveRight();
				} else if(event.getCode() == KeyCode.LEFT || event.getCode() == KeyCode.A){
					player.moveLeft();
				} else if((event.getCode() == KeyCode.UP || event.getCode() == KeyCode.W) && condition == false){
					player.jump();
				}
			}
		});
	}
	
}
