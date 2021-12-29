

package bullet;

import audio.AudioLoader;
import gui.Player;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.media.AudioClip;

public class Bullet {
	private double velocityX = 0.2;
	private double row;
	private double column;
	private ImageView bulletImage;
	private Player player;
	private AudioClip audioClip;
	private Group root = new Group();
	private StackPane s = new StackPane();
	private double imageY;
	private double imageX;

	public Bullet(int row, int column, Group root, Player player, String name) {
		this.player = player;
		this.row = row;
		this.column = column;
		this.bulletImage = new ImageView(new Image(ClassLoader.getSystemResource(name + "Bullet.png").toString()));
		s.getChildren().add(bulletImage);
		this.root = root;
		root.getChildren().add(s);
		s.setTranslateX((int) (250 + (column - 1) * 106));
		s.setTranslateY((int) (100 + (row - 1) * 121));
		AudioLoader.SHOOT.play();
		this.imageX = 250 + (column - 1) * 106;
		this.imageY = 100 + (row - 1) * 121;
	}

	public void setPosition(double row, double column) {
		this.row = row;
		this.column = column;
	}

	public void removeImage() {
		this.s.getChildren().remove(this.bulletImage);
		this.root.getChildren().remove(this.s);
	}

	public int getRow() {
		return (int) this.row;
	}

	public int getColumn() {
		return (int) this.column;
	}

	public void step() {
		double imageX = getImagePositionX() + velocityX;
		setImagePosition(imageX, imageY);
		s.setTranslateY(this.imageY);
		s.setTranslateX(imageX);
	}

	public void setImagePosition(double x, double y) {
		this.imageX = x;
		this.imageY = y;
	}

	public double getImagePositionX() {
		return this.imageX;
	}

	public void makeSound() {
		this.audioClip.play();
	}
}