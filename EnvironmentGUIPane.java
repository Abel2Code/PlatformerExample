package application;

import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class EnvironmentGUIPane extends BorderPane{
	Label[][] labels;
	int rows;
	int columns;
	
	public EnvironmentGUIPane(Label[][] labels){
		this.labels = labels;
//		rows = labels.length; // Get logic to find 2d array length
//		columns = labels[].length; 
	}
	
	
}
