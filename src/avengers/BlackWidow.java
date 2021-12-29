package avengers;

import exception.RemoveCoinFailedException;
import gui.Player;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class BlackWidow extends Avengers implements Drawable {

	private int row;
	private int column;
	private int price = 500;
	private int[] position = new int[2];
	private int health = 1000;
	private int power = 0;
	private StackPane s = new StackPane();
	private Group root = new Group();
	private ImageView image;
	private double osizeX;
	private double osizeY;
	private double sizeX;
	private double sizeY;
	private boolean shrink = false;
	private int shootFrequency = 0;
	private ImageView coinImage;
	private boolean hasCoin = false;
	private StackPane s2 = new StackPane();

	public BlackWidow(int row, int column, Group root, Player player) {
		this.coinImage = new ImageView(new Image(ClassLoader.getSystemResource("CoinIcon.png").toString()));
		this.s2.getChildren().add(coinImage);
		this.row = row;
		this.column = column;
		this.image = new ImageView(new Image(ClassLoader.getSystemResource("BlackWidow.png").toString()));
		s.getChildren().add(image);
		this.root = root;
		root.getChildren().add(s);
		s.setTranslateX((int) (200 + (column - 1) * 106));
		s.setTranslateY((int) (80 + (row - 1) * 121));
		this.osizeX = 90;
		this.osizeY = 90;
		this.sizeX = 90;
		this.sizeY = 90;
	}

	public void removeImage() {
		this.s.getChildren().remove(this.image);
		this.root.getChildren().remove(this.s);
		this.s2.getChildren().remove(this.coinImage);
		this.root.getChildren().remove(this.s2);
	}

	public void removeCoin() throws RemoveCoinFailedException  {
		try {
		  	this.s2.getChildren().remove(this.coinImage);
		  	this.root.getChildren().remove(this.s2);
		} catch (Exception e) {
			e.printStackTrace();
		}		  
	}

	public int getRow() {
		return this.row;
	}

	public int getColumn() {
		return this.column;
	}

	public void setPosition(int row, int column) {
		this.row = row;
		this.column = column;
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

	public void setSize(double width, double height) {
		this.image.setFitWidth(width);
		this.image.setFitHeight(height);
	}

	public void step() {
		if (this.sizeX > (1.05 * osizeX) || this.sizeY > (1.05 * osizeY)) {
			this.shrink = true;
		} else if (this.sizeX < (0.95 * osizeX) || this.sizeY < (0.95 * osizeY)) {
			this.shrink = false;
		}

		if (shrink) {
			this.setSize(1 * this.sizeX - 0.1, this.sizeY - 0.1);

			this.sizeX = this.sizeX - 0.1;
			this.sizeY = this.sizeY - 0.1;
		} else {
			this.setSize(1 * this.sizeX + 0.1, this.sizeY + 0.1);
			this.sizeX = this.sizeX + 0.1;
			this.sizeY = this.sizeY + 0.1;
		}

		if (shootFrequency == 5000) {
			StackPane s2 = new StackPane();
			s2.getChildren().add(this.coinImage);
			s2.setTranslateX((int) (200 + (column - 1) * 104));
			s2.setTranslateY((int) (80 + (row - 1) * 121));
			root.getChildren().add(s2);
			this.s2 = s2;
			shootFrequency = 0;
			hasCoin = true;
		} else {
			shootFrequency++;
		}
	}

	public boolean isHasCoin() {
		return hasCoin;
	}

	public void setHasCoin(boolean bool) {
		hasCoin = bool;
	}

	public String getName() {
		return "BlackWidow";
	}
	
}