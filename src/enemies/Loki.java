package enemies;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class Loki implements Thanos {
	
	private int row;
	private int column;
	private int health = 3000;
	private int power = 10;
	private StackPane stackPane = new StackPane();
	private Group root = new Group();
	private ImageView thanosImage;
	private double imageY;
	private double imageX;
	private double speed = -0.01;

	public Loki(int row, int column, Group root) {
		this.row = row;
		this.column = column;
		this.thanosImage = new ImageView(new Image(ClassLoader.getSystemResource("Loki.png").toString()));
		stackPane.getChildren().add(thanosImage);
		root.getChildren().add(stackPane);
		stackPane.setTranslateX((int) (200 + (column - 1) * 106));
		stackPane.setTranslateY((int) (80 + (row - 1) * 121));
		this.imageX = 200 + (column - 1) * 106;
		this.imageY = 80 + (row - 1) * 121;
	}

	public void removeImage() {
		this.stackPane.getChildren().remove(thanosImage);
		this.root.getChildren().remove(stackPane);
	}

	public void setImagePosition(double x, double y) {
		this.imageX = x;
		this.imageY = y;
	}

	public double getImagePositionX() {
		return this.imageX;
	}

	public int getRow() {
		return this.row;
	}

	public int getColumn() {
		int LokiCol = 0;
		if (getImagePositionX() >= 200 && getImagePositionX() <= 306) {
			LokiCol = 1;
		} else if (getImagePositionX() <= 412) {
			LokiCol = 2;
		} else if (getImagePositionX() <= 518) {
			LokiCol = 3;
		} else if (getImagePositionX() <= 624) {
			LokiCol = 4;
		} else if (getImagePositionX() <= 730) {
			LokiCol = 5;
		} else if (getImagePositionX() <= 836) {
			LokiCol = 6;
		} else if (getImagePositionX() <= 942) {
			LokiCol = 7;
		} else if (getImagePositionX() <= 1048) {
			LokiCol = 8;
		} else if (getImagePositionX() <= 1154) {
			LokiCol = 9;
		} else if (getImagePositionX() <= 1260) {
			LokiCol = 10;
		}
		return LokiCol;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getPower() {
		return power;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

    public void step() {
        double imageX = getImagePositionX() + this.speed;
        setImagePosition(imageX, imageY);
        stackPane.setTranslateY(this.imageY);
        stackPane.setTranslateX(imageX);
    }
    
}
