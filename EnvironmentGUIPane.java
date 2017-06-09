package application;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class EnvironmentGUIPane extends GridPane{
	private Label[][] labels;
	private int rows;
	private int columns;
	private Player player = new Player(1,0);
	
	
	
	public void startLevel(int levelNum){
		labels = Levels.createLevel(levelNum);
		rows = labels.length;
		columns = labels[0].length;
		
		for(int r = 0; r < rows; r++){
			for(int c = 0; c < columns; c++){
				add(labels[c][r], r, c);  // DONT FORGET TO ADD LABEL TO GRIDPANE :)
			}
		}
		
		labels[0][13] = Levels.labelInit("player");
		add(labels[0][13], 0, 13);
	}
	
}
