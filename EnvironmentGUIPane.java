package application;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class EnvironmentGUIPane extends GridPane{
	Label[][] labels;
	int rows;
	int columns;
	
	public void startLevel(int levelNum){
		labels = Levels.createLevel(levelNum);
		rows = labels.length;
		columns = labels[0].length;
		
		for(int r = 0; r < rows; r++){
			for(int c = 0; c < columns; c++){
				add(labels[c][r], r, c);  // DONT FORGET TO ADD LABEL TO GRIDPANE :)
			}
		}
	}
	
}
