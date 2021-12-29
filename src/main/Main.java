package main;

import gui.ViewManager;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

	public void start(Stage mainStage) {
		try {
			ViewManager viewManager = new ViewManager();
			mainStage = viewManager.getMainStage();
			mainStage.setResizable(false);
			mainStage.setFullScreen(true);
			mainStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}