package gui;

import javafx.scene.Scene;
import javafx.stage.Stage;
import controller.AvengersDragController;
import controller.AvengersDragDropController;
import controller.AvengersDragOverController;
import controller.CoinController;
import controller.GameController;
import enemies.Enemy;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class GameStage {

	private Group root;
	private Scene gameScene;
	private Stage mainStage;

	private static Stage initiateStage = new Stage();

	public GameStage(ViewManager viewManager) {

		this.mainStage = viewManager.getMainStage();

		this.root = new Group();
		gameScene = new Scene(root, 1280, 720);
		Image background = new Image(ClassLoader.getSystemResource("GameBackground.png").toString());
		ImageView backgroundView = new ImageView();
		backgroundView.setImage(background);
		root.getChildren().add(backgroundView);

		StackPane blackWidowButtonPane = new StackPane();
		ImageView blackWidowButton = new ImageView(new Image(ClassLoader.getSystemResource("BlackWidowButton.png").toString()));
		blackWidowButton.setFitWidth(160);
		blackWidowButton.setFitHeight(90);
		blackWidowButtonPane.getChildren().add(blackWidowButton);
		blackWidowButtonPane.setPrefSize(160, 90);
		blackWidowButtonPane.setLayoutX(20);
		blackWidowButtonPane.setLayoutY(80);
		blackWidowButtonPane.setId("BlackWidow");

		StackPane ironmanButtonPane = new StackPane();
		ImageView ironmanButton = new ImageView(new Image(ClassLoader.getSystemResource("IronmanButton.png").toString()));
		ironmanButton.setFitWidth(160);
		ironmanButton.setFitHeight(90);
		ironmanButtonPane.getChildren().add(ironmanButton);
		ironmanButtonPane.setPrefSize(160, 90);
		ironmanButtonPane.setLayoutX(20);
		ironmanButtonPane.setLayoutY(170);
		ironmanButtonPane.setId("Ironman");

		StackPane captainAmericaButtonPane = new StackPane();
		ImageView captainAmericaButton = new ImageView(new Image(ClassLoader.getSystemResource("CaptainAmericaButton.png").toString()));
		captainAmericaButton.setFitWidth(160);
		captainAmericaButton.setFitHeight(90);
		captainAmericaButtonPane.getChildren().add(captainAmericaButton);
		captainAmericaButtonPane.setPrefSize(160, 90);
		captainAmericaButtonPane.setLayoutX(20);
		captainAmericaButtonPane.setLayoutY(260);
		captainAmericaButtonPane.setId("CaptainAmerica");
		
		StackPane hawkeyeButtonPane = new StackPane();
		ImageView hawkeyeButton = new ImageView(new Image(ClassLoader.getSystemResource("HawkeyeButton.png").toString()));
		hawkeyeButton.setFitWidth(160);
		hawkeyeButton.setFitHeight(90);
		hawkeyeButtonPane.getChildren().add(hawkeyeButton);
		hawkeyeButtonPane.setPrefSize(160, 90);
		hawkeyeButtonPane.setLayoutX(20);
		hawkeyeButtonPane.setLayoutY(350);
		hawkeyeButtonPane.setId("Hawkeye");
		
		StackPane hulkButtonPane = new StackPane();
		ImageView hulkButton = new ImageView(new Image(ClassLoader.getSystemResource("HulkButton.png").toString()));
		hulkButton.setFitWidth(160);
		hulkButton.setFitHeight(90);
		hulkButtonPane.getChildren().add(hulkButton);
		hulkButtonPane.setPrefSize(160, 90);
		hulkButtonPane.setLayoutX(20);
		hulkButtonPane.setLayoutY(440);
		hulkButtonPane.setId("Hulk");
		
		StackPane thorButtonPane = new StackPane();
		ImageView thorButton = new ImageView(new Image(ClassLoader.getSystemResource("ThorButton.png").toString()));
		thorButton.setFitWidth(160);
		thorButton.setFitHeight(90);
		thorButtonPane.getChildren().add(thorButton);
		thorButtonPane.setPrefSize(160, 90);
		thorButtonPane.setLayoutX(20);
		thorButtonPane.setLayoutY(530);
		thorButtonPane.setId("Thor");

		Label coinLabel = new Label(Integer.toString(2000));
		coinLabel.setFont(new Font("Consolas", 26));
		coinLabel.setTextFill(Color.WHITE);
		coinLabel.setAlignment(Pos.CENTER_RIGHT);
		coinLabel.setPrefWidth(115);
		coinLabel.setPrefHeight(40);
		coinLabel.setLayoutX(20);
		coinLabel.setLayoutY(20);

		ImageView coinImage = new ImageView(new Image(ClassLoader.getSystemResource("CoinIcon.png").toString()));
		coinImage.setFitHeight(40);
		coinImage.setFitWidth(40);
		coinImage.setLayoutX(140);
		coinImage.setLayoutY(20);
		
		Button backToMenuButton = new Button("EXIT GAME");
		Image image = new Image(ClassLoader.getSystemResource("MiniMenuButton.png").toString());
		backToMenuButton.setBackground(new Background(new BackgroundImage(image, BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, null)));
		backToMenuButton.setPrefHeight(60);
		backToMenuButton.setPrefWidth(160);
		backToMenuButton.setLayoutX(20);
		backToMenuButton.setLayoutY(640);
		backToMenuButton.setPadding(new Insets(0));
		backToMenuButton.setTextFill(Color.LIGHTCYAN);
		backToMenuButton.setFont(new Font("Consolas Bold", 20));
		backToMenuButton.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent arg0) {
				Pane b = new Pane();
				b.getChildren().add(viewManager.getMainPane());
				Scene a = new Scene(b);
				if(mainStage!= null) {
					mainStage.setScene(a);
					mainStage.setFullScreen(true);
					mainStage.setResizable(false);
				}
			}
		});
		
		root.getChildren().add(coinLabel);
		root.getChildren().add(coinImage);
		root.getChildren().add(blackWidowButtonPane);
		root.getChildren().add(ironmanButtonPane);
		root.getChildren().add(captainAmericaButtonPane);
		root.getChildren().add(hawkeyeButtonPane);
		root.getChildren().add(thorButtonPane);
		root.getChildren().add(hulkButtonPane);
		root.getChildren().add(backToMenuButton);

		Enemy enemy = new Enemy(root);
		Player player = new Player(root, coinLabel);
		
		blackWidowButtonPane.setOnDragDetected(new AvengersDragController(blackWidowButtonPane, new Image(ClassLoader.getSystemResource("BlackWidow.png").toString())));
		ironmanButtonPane.setOnDragDetected(new AvengersDragController(ironmanButtonPane, new Image(ClassLoader.getSystemResource("Ironman.png").toString())));
		captainAmericaButtonPane.setOnDragDetected(new AvengersDragController(captainAmericaButtonPane, new Image(ClassLoader.getSystemResource("CaptainAmerica.png").toString())));
		hawkeyeButtonPane.setOnDragDetected(new AvengersDragController(hawkeyeButtonPane, new Image(ClassLoader.getSystemResource("Hawkeye.png").toString())));
		thorButtonPane.setOnDragDetected(new AvengersDragController(thorButtonPane, new Image(ClassLoader.getSystemResource("Thor.png").toString())));
		hulkButtonPane.setOnDragDetected(new AvengersDragController(hulkButtonPane, new Image(ClassLoader.getSystemResource("Hulk.png").toString())));

		gameScene.setOnDragOver(new AvengersDragOverController());
		gameScene.setOnDragDropped(new AvengersDragDropController(root, player));
		gameScene.setOnMouseClicked(new CoinController(player, root, coinLabel));

		GameController controller = new GameController(player, enemy, initiateStage);
		controller.initialize();
	}

	public Scene getGameScene() {
		return gameScene;
	}
	
}