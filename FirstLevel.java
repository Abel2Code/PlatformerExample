package application;

import javafx.scene.control.Label;

public class FirstLevel {
	
	public EnvironmentGUIPane getLayout(){
		return new EnvironmentGUIPane(createLabels());
	}
	
	private Label[][] createLabels(){
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
	
	private Label labelInit(String style){
		Label tempLabel = new Label();
		tempLabel.getStyleClass().add(style);
		
		/*
		 * Add Label height and width preferences if necessary
		 */
		
		return tempLabel;
	}
	
	
}
