package gui;

import javafx.animation.TranslateTransition;
import javafx.scene.SubScene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.util.Duration;

public class GameSubScene extends SubScene {
	
	private static final int WIDTH = 540;
	private static final int HEIGHT = 520;

	private final String BACKGROUND_IMAGE = "ClassLoader.getSystemResource(\"menuLabel.png\").toString()";

	private boolean isHidden;

	public GameSubScene() {
		super(new AnchorPane(), WIDTH, HEIGHT);
		prefHeight(HEIGHT);
		prefWidth(WIDTH);

		BackgroundImage image = new BackgroundImage(new Image(ClassLoader.getSystemResource("menuLabel.png").toString(), WIDTH, HEIGHT, false, true),
				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, null);
		AnchorPane root2 = (AnchorPane) this.getRoot();

		root2.setBackground(new Background(image));
		setLayoutX(1280);
		setLayoutY(120);
		setVisible(false);
		isHidden = true;
	}

	public void moveSubScene() {

		TranslateTransition transition = new TranslateTransition();
		transition.setDuration(Duration.millis(1000));
		transition.setNode(this);
		if (isHidden) {
			setVisible(true);
			transition.setToX(-970);
			isHidden = false;
		} else {
			transition.setToX(0);
			isHidden = true;
		}

		transition.play();
	}

	public AnchorPane getPane() {
		return (AnchorPane) this.getRoot();
	}

	public static int getSubSceneWidth() {
		return WIDTH;
	}

	public static int getSubSceneHeight() {
		return HEIGHT;
	}

	public void setHidden(boolean isHidden) {
		this.isHidden = isHidden;
	}

}
