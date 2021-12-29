package avengers;

import bullet.Bullet;
import gui.Player;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class Hulk extends Avengers implements Drawable {
	
	private int price = 2000;
	private int row;
	private int column;
	private int health = 2000;
	private int power = 3000;
	private StackPane stackPane = new StackPane();
	private Group root = new Group();
	private ImageView image;
	private double osizeX;
	private double osizeY;
	private double sizeX;
	private double sizeY;
	private boolean shrink = false;
	private Player player;
	private int shootFrequency = 0;

	public Hulk(int row, int column, Group root, Player player) {
		this.player = player;
		this.row = row;
		this.column = column;
		this.image = new ImageView(new Image(ClassLoader.getSystemResource("Hulk.png").toString()));
		stackPane.getChildren().add(image);
		this.root = root;
		root.getChildren().add(stackPane);
		stackPane.setTranslateX((int) (200 + (column - 1) * 104));
		stackPane.setTranslateY((int) (80 + (row - 1) * 121));
		this.osizeX = 90;
		this.osizeY = 90;
		this.sizeX = 90;
		this.sizeY = 90;
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

	public int getRow() {
		return this.row;
	}

	public int getColumn() {
		return this.column;
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

	public void step() {
		if (this.sizeX > (1.05 * osizeX) || this.sizeY > (1.05 * osizeY)) {
			this.shrink = true;
		} else if (this.sizeX < (0.95 * osizeX) || this.sizeY < (0.95 * osizeY)) {
			this.shrink = false;
		}

		if (shootFrequency == 3000) {			
			Bullet bullet = new Bullet(this.row, this.column, this.root, this.player, this.getName());
			this.player.addBullet(bullet);
			shootFrequency = 0;
		} else {
			shootFrequency++;
		}

		if (shrink) {
			this.setSize(1 * this.sizeX, this.sizeY - 0.1);

			this.sizeY = this.sizeY - 0.1;
		} else {
			this.setSize(1 * this.sizeX, this.sizeY + 0.1);
			this.sizeY = this.sizeY + 0.1;
		}
	}

	public String getName() {
		return "Hulk";
	}
}
