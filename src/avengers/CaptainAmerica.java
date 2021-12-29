package avengers;

import gui.Player;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class CaptainAmerica extends Avengers implements Drawable {

	private int row;
	private int column;
	private int price = 500;
	private int[] position = new int[2];
	private int health = 6000;
	private int power = 0;
	private StackPane stackPane = new StackPane();
	private Group root = new Group();
	private ImageView image;
	private double osizeX;
	private double osizeY;
	private double sizeX;
	private double sizeY;
	private boolean shrink = false;

	public CaptainAmerica(int row, int column, Group root, Player player) {
		this.row = row;
		this.column = column;
		this.image = new ImageView(new Image(ClassLoader.getSystemResource("CaptainAmerica.png").toString()));
		stackPane.getChildren().add(image);
		this.root = root;
		root.getChildren().add(stackPane);
		stackPane.setTranslateX((int) (200 + (column - 1) * 106));
		stackPane.setTranslateY((int) (80 + (row - 1) * 121));
		this.osizeX = 90;
		this.osizeY = 90;
		this.sizeX = 90;
		this.sizeY = 90;
	}

	public int getRow() {
		return this.row;
	}

	public int getColumn() {
		return this.column;
	}

	public void removeImage() {
		this.stackPane.getChildren().remove(this.image);
		this.root.getChildren().remove(this.stackPane);
	}

	public void setPosition(int row, int column) {
		this.row = row;
		this.column = column;
	}

	public void setSize(double width, double height) {
		this.image.setFitWidth(width);
		this.image.setFitHeight(height);
	}

	public int[] getPosition() {
		return position;
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

	public void setPower(int power) {
		this.power = power;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void step() {
		if (this.sizeX > (1.05 * osizeX) || this.sizeY > (1.05 * osizeY)) {
			this.shrink = true;
		} else if (this.sizeX < (0.95 * osizeX) || this.sizeY < (0.95 * osizeY)) {
			this.shrink = false;
		}

		if (shrink) {
			this.setSize(1 * this.sizeX - 0.1, this.sizeY);

			this.sizeX = this.sizeX - 0.1;
		} else {
			this.setSize(1 * this.sizeX + 0.1, this.sizeY);
			this.sizeX = this.sizeX + 0.1;
		}
	}

	public String getName() {
		return "CaptainAmerica";
	}
}
