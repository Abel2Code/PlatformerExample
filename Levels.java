package application;

import javafx.scene.control.Label;

public class Levels {
	
	public static Label[][] createLevel(int levelNum){
		switch(levelNum){
			case 1: return firstLevel(); 
			case 2:
			case 3:
		}
		return new Label[0][0];
	}
	
	public static Label[][] firstLevel(){
		Label[][] labels = new Label[][]{
			{labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background")},
			{labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background")},
			{labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background")},
			{labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background")},
			{labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background")},
			{labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background")},
			{labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background")},
			{labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background")},
			{labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("solid")     },
			{labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background")},
			{labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("solid")     ,labelInit("solid")     ,labelInit("background")},
			{labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background")},
			{labelInit("background"),labelInit("background"),labelInit("solid")     ,labelInit("background"),labelInit("background"),labelInit("background"),labelInit("solid")     ,labelInit("solid")     ,labelInit("solid")     ,labelInit("background"),labelInit("solid")     ,labelInit("solid")     ,labelInit("background"),labelInit("background"),labelInit("background")},
			{labelInit("background"),labelInit("solid")     ,labelInit("solid")     ,labelInit("solid")     ,labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background"),labelInit("background")},
			{labelInit("solid")     ,labelInit("solid")     ,labelInit("solid")     ,labelInit("solid")     ,labelInit("solid")     ,labelInit("solid")     ,labelInit("solid")     ,labelInit("solid")     ,labelInit("solid")     ,labelInit("solid")     ,labelInit("solid")     ,labelInit("solid")     ,labelInit("solid")     ,labelInit("solid")     ,labelInit("solid")}
		};
		return labels;
		
	}
	
	private static Label labelInit(String style){
		Label tempLabel = new Label();
		tempLabel.getStyleClass().add(style);
		tempLabel.setText("hi");
		
		/*
		 * Add Label height and width preferences if necessary
		 */
		
		return tempLabel;
	}
	
	
}
