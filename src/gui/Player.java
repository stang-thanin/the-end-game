package gui;

import java.util.ArrayList;
import avengers.Avengers;
import bullet.Bullet;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class Player {
	private int coin = 2000;
	private ArrayList<Avengers> avengersList = new ArrayList<Avengers>();
	private ArrayList<Bullet> bulletList = new ArrayList<Bullet>();
	Group root = new Group();
	Label coinLabel;
	Label coinOriginal;

	public Player(Group root, Label priceLabel) {
		this.coinOriginal = priceLabel;
		this.root = root;
	}

	public int getCoin() {
		return this.coin;
	}

	public ArrayList<Avengers> getAvengers() {
		return avengersList;
	}

	public ArrayList<Bullet> getBullet() {
		return bulletList;
	}

	public void setCoin(int coin) {
		this.coin = coin;
		this.root.getChildren().remove(this.coinLabel);
		this.root.getChildren().remove(this.coinOriginal);
		this.coinLabel = new Label(Integer.toString(getCoin()));
		coinLabel.setFont(new Font("Consolas", 26));
		coinLabel.setAlignment(Pos.CENTER_RIGHT);
		coinLabel.setTextFill(Color.WHITE);
		coinLabel.setPrefWidth(115);
		coinLabel.setPrefHeight(40);
		coinLabel.setLayoutX(20);
		coinLabel.setLayoutY(20);
		this.root.getChildren().add(coinLabel);
	}
	
	public void addAvengers(Avengers avengers) {
		avengersList.add(avengers);
	}

	public void addBullet(Bullet bullet) {
		bulletList.add(bullet);
	}

}