package application;

import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Platform;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

public class MainMenu {
	private static Timer mainMenuTimer = new Timer();
		
	public static GridPane createMainMenu(){
		GridPane menu = new GridPane();
		Button playground = new Button("Playground");
		playground.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<Event>(){
			@Override
			public void handle(Event event){
				Main.currentLevel = 0;
			}
		});
		menu.add(playground, 0, 0);
		menu.add(new Label("\t"), 1, 0);
		
		Button level1 = new Button("Level 1");
		level1.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<Event>(){
			@Override
			public void handle(Event event) {
				Main.currentLevel = 1;
			}			
		});	
		
		menu.add(level1, 2, 0);
		
		menu.add(new Label("\t"), 3, 0);
		
		Button level2 = new Button("Level 2");
		level2.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<Event>(){
			@Override
			public void handle(Event event) {
				Main.currentLevel = 2;
			}			
		});
		
		menu.add(level2, 4, 0);
		chooseLevel();
		
		return menu;
	}
	
	private static void chooseLevel(){
		
		TimerTask startLevel = new TimerTask() {
			
			@Override
			public void run() {
				if(Main.currentLevel != -1){
					Platform.runLater(new Runnable(){
	
						@Override
						public void run() {
							EnvironmentGUIPane pane = new EnvironmentGUIPane();
							pane.startLevel(Main.currentLevel);
							Main.scene.setRoot(pane);
						}
						
					});
				
					mainMenuTimer.cancel();
				}
				
			}
			
			
		};	
		mainMenuTimer.schedule(startLevel,0, 100);
	}
}
