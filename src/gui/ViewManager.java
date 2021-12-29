package gui;

import java.util.ArrayList;
import audio.AudioLoader;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ViewManager {

	private static final int HEIGHT = 720;
	private static final int WIDTH = 1280;
	private AnchorPane mainPane;
	private Scene mainScene;
	private Stage mainStage;

	private int MENU_BUTTONS_START_X = 100;
	private int MENU_BUTTONS_START_Y = 150;

	private GameSubScene HelpSubScene;
	private GameSubScene CreditSubScene;
	private GameSubScene NowShowing;

	private ArrayList<Button> menuButtons;
	private GameStage gameStage;

	public ViewManager() {

		menuButtons = new ArrayList<Button>();
		mainPane = new AnchorPane();
		mainScene = new Scene(mainPane, WIDTH, HEIGHT);

		createLogo();
		createButtons();
		createBackground();
		CreateSubScenes();

		keyboardListener();

		mainStage = new Stage();
		mainStage.setScene(mainScene);
		mainStage.setFullScreen(true);
		mainStage.setResizable(false);
		gameStage = new GameStage(this);

	}

	private void keyboardListener() {
		mainPane.setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event) {
				if (event.getCode() == KeyCode.ESCAPE) {
					mainStage.close();
				}
			}
		});
	}

	private void CreateSubScenes() {
		HelpSubScene = new GameSubScene();
		mainPane.getChildren().add(HelpSubScene);
		CreditSubScene = new GameSubScene();
		mainPane.getChildren().add(CreditSubScene);
	}

	private void ShowSubScene(GameSubScene scene) {
		if (NowShowing != null) {
			NowShowing.moveSubScene();
		}
		scene.moveSubScene();
		NowShowing = scene;
	}

	private void addMenuButton(Button button) {
		button.setLayoutX(MENU_BUTTONS_START_X);
		button.setLayoutY(MENU_BUTTONS_START_Y + (menuButtons.size() * 100));
		menuButtons.add(button);
		mainPane.getChildren().add(button);
	}

	private void createButtons() {
		createStartButton();
		createHelpButton();
		createCreditButton();
		createQuitButton();
	}

	private void createStartButton() {
		Button start = new Button("NEW GAME");
		Image image = new Image(ClassLoader.getSystemResource("menuButton.png").toString());
		start.setBackground(new Background(new BackgroundImage(image, BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, null)));
		start.setPrefHeight(80);
		start.setPrefWidth(190);
		start.setTextFill(Color.LIGHTCYAN);
		start.setFont(new Font("Consolas Bold", 30));
		addMenuButton(start);

		start.setOnMouseEntered(new EventHandler<MouseEvent>() {

			public void handle(MouseEvent event) {
				mainScene.setCursor(Cursor.HAND);
				start.setEffect(new DropShadow(20, Color.SKYBLUE));
				AudioLoader.Mouse_Enter_Sound.play();
			}
		});

		start.setOnMouseExited(new EventHandler<MouseEvent>() {

			public void handle(MouseEvent event) {
				mainScene.setCursor(Cursor.DEFAULT);
				start.setEffect(null);
			}

		});

		start.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent arg0) {
				gameStage = new GameStage(getThisViewManager());
				mainStage.setScene(gameStage.getGameScene());
				mainStage.setFullScreen(true);
				mainStage.setResizable(false);
			}
		});

	}

	private void createHelpButton() {
		Button help = new Button("HOW TO PLAY");
		Image image = new Image(ClassLoader.getSystemResource("menuButton.png").toString());
		help.setBackground(new Background(new BackgroundImage(image, BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, null)));
		help.setPrefHeight(80);
		help.setPrefWidth(190);
		help.setTextFill(Color.LIGHTCYAN);
		help.setFont(new Font("Consolas Bold", 24));
		addMenuButton(help);

		help.setOnMouseEntered(new EventHandler<MouseEvent>() {

			public void handle(MouseEvent event) {
				mainScene.setCursor(Cursor.HAND);
				help.setEffect(new DropShadow(20, Color.SKYBLUE));
				AudioLoader.Mouse_Enter_Sound.play();
			}
		});

		help.setOnMouseExited(new EventHandler<MouseEvent>() {

			public void handle(MouseEvent event) {
				mainScene.setCursor(Cursor.DEFAULT);
				help.setEffect(null);
			}
		});

		help.setOnMouseClicked(new EventHandler<MouseEvent>() {

			public void handle(MouseEvent arg0) {
				ShowSubScene(HelpSubScene);

				HelpSubScene.getPane().getChildren().clear();

				Label credit = new Label(
						"Many of Thanos are invading!!\n"
						+ "Help the Avengers team to save our base.\n"
								+ " - Each Avengers team member has different\n"
								+ "   individual ability, Drag and drop an\n"
								+ "   Avengers card on the battlefield by\n"
								+ "   expense with the coin.\n"
								+ " - Plan your team to fight all the Thanos,\n"
								+ "   when they're all cleared, you'll win\n"
								+ "   the game.\n"
								+ " - Don't let the Thanos enter your base or\n"
								+ "   you will lose.");
				credit.setAlignment(Pos.TOP_LEFT);
				credit.setTranslateY(100);
				credit.setTranslateX(60);
				credit.setPrefWidth(GameSubScene.getSubSceneWidth() - 120);
				credit.setPrefHeight(GameSubScene.getSubSceneWidth());
				credit.setTextFill(Color.LIGHTCYAN);
				credit.setFont(new Font("Consolas", 16));
				HelpSubScene.getPane().getChildren().addAll(credit);
			}
		});

	}

	private void createCreditButton() {
		Button credit = new Button("CREDIT");
		Image image = new Image(ClassLoader.getSystemResource("menuButton.png").toString());
		credit.setBackground(new Background(new BackgroundImage(image, BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, null)));
		credit.setPrefHeight(80);
		credit.setPrefWidth(190);
		credit.setTextFill(Color.LIGHTCYAN);
		credit.setFont(new Font("Consolas Bold", 30));
		addMenuButton(credit);

		credit.setOnMouseEntered(new EventHandler<MouseEvent>() {

			public void handle(MouseEvent event) {
				mainScene.setCursor(Cursor.HAND);
				credit.setEffect(new DropShadow(20, Color.SKYBLUE));
				AudioLoader.Mouse_Enter_Sound.play();
			}
		});

		credit.setOnMouseExited(new EventHandler<MouseEvent>() {

			public void handle(MouseEvent event) {
				mainScene.setCursor(Cursor.DEFAULT);
				credit.setEffect(null);
			}
		});

		credit.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent arg0) {
				ShowSubScene(CreditSubScene);
				CreditSubScene.getPane().getChildren().clear();

				Label credit = new Label("            - GAME EDITOR -\n\n" + "SUPPAWICH TAWORNPICHAYACHAI  6231364021\n"
						+ "THANIN    SAWETKITITHAM      6230238421\n\n" + "     PROGRAMMING METHODOLOGY  2020");
				credit.setAlignment(Pos.TOP_CENTER);
				credit.setTranslateY(120);
				credit.setPrefWidth(GameSubScene.getSubSceneWidth());
				credit.setPrefHeight(GameSubScene.getSubSceneWidth());
				credit.setTextFill(Color.LIGHTCYAN);
				credit.setFont(new Font("Consolas", 20));

				CreditSubScene.getPane().getChildren().addAll(credit);
			}
		});
	}

	private void createQuitButton() {
		Button quit = new Button("QUIT");
		Image image = new Image(ClassLoader.getSystemResource("menuButton.png").toString());
		quit.setBackground(new Background(new BackgroundImage(image, BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, null)));
		quit.setPrefHeight(80);
		quit.setPrefWidth(190);
		quit.setTextFill(Color.LIGHTCYAN);
		quit.setFont(new Font("Consolas Bold", 30));
		addMenuButton(quit);

		quit.setOnMouseEntered(new EventHandler<MouseEvent>() {

			public void handle(MouseEvent event) {
				mainScene.setCursor(Cursor.HAND);
				quit.setEffect(new DropShadow(20, Color.SKYBLUE));
				AudioLoader.Mouse_Enter_Sound.play();
			}
		});

		quit.setOnMouseExited(new EventHandler<MouseEvent>() {

			public void handle(MouseEvent event) {
				mainScene.setCursor(Cursor.DEFAULT);
				quit.setEffect(null);
			}
		});

		quit.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent arg0) {
				mainStage.close();
				System.exit(0);
			}
		});

	}

	private void createLogo() {
		ImageView logo = new ImageView(new Image(ClassLoader.getSystemResource("End_Game.png").toString()));
		logo.setLayoutX(815);
		logo.setLayoutY(30);
		logo.setFitHeight(86);
		logo.setFitWidth(400);

		logo.setOnMouseEntered(new EventHandler<MouseEvent>() {

			public void handle(MouseEvent event) {
				logo.setEffect(new DropShadow(20, Color.SKYBLUE));
				AudioLoader.Mouse_Enter_Sound.play();
			}
		});

		logo.setOnMouseExited(new EventHandler<MouseEvent>() {

			public void handle(MouseEvent event) {
				logo.setEffect(null);
			}
		});

		mainPane.getChildren().add(logo);
	}

	private void createBackground() {
		Image backgroundImage = new Image(ClassLoader.getSystemResource("menuBackground.jpg").toString(), WIDTH, HEIGHT, false, true);
		BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, null);
		mainPane.setBackground(new Background(background));
	}

	public Stage getMainStage() {
		return mainStage;
	}
	
	public ViewManager getThisViewManager() {
		return this;
	}
	
	public Scene getMainScene() {
		return mainScene;
	}

	public void setMainScene(Scene mainScene) {
		this.mainScene = mainScene;
	}	

	public AnchorPane getMainPane() {
		mainPane.setPrefSize(1280, 720);
		return mainPane;
	}

	public void setMainPane(AnchorPane mainPane) {
		this.mainPane = mainPane;
	}
}
