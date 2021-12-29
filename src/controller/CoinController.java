package controller;

import avengers.Avengers;
import avengers.BlackWidow;
import exception.RemoveCoinFailedException;
import gui.Player;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.Group;

public class CoinController implements EventHandler<MouseEvent> {

	Player player;
	Group root;
	Label coin;
	Label coinOriginal;

	public CoinController(Player player, Group root, Label coinOriginal) {
		this.root = root;
		this.player = player;
		this.coinOriginal = coinOriginal;
	}

	public void handle(MouseEvent event) {
		int row = 0;
		int column = 0;
		if (event.getX() >= 200 && event.getX() <= 1260) {
			if (event.getY() >= 80 && event.getY() <= 700) {
				if (event.getY() >= 80 && event.getY() <= 201) {
					row = 1;
				} else if (event.getY() < 322) {
					row = 2;
				} else if (event.getY() < 443) {
					row = 3;
				} else if (event.getY() < 564) {
					row = 4;
				} else if (event.getY() < 685) {
					row = 5;
				}

				if (event.getX() >= 200 && event.getX() <= 306) {
					column = 1;
				} else if (event.getX() <= 412) {
					column = 2;
				} else if (event.getX() <= 518) {
					column = 3;
				} else if (event.getX() <= 624) {
					column = 4;
				} else if (event.getX() <= 730) {
					column = 5;
				} else if (event.getX() <= 836) {
					column = 6;
				} else if (event.getX() <= 942) {
					column = 7;
				} else if (event.getX() <= 1048) {
					column = 8;
				} else if (event.getX() <= 1154) {
					column = 9;
				} else if (event.getX() <= 1260) {
					column = 10;
				}
			}
		}
		for (Avengers avengers : this.player.getAvengers()) {
			if ("BlackWidow".equals(avengers.getName())) {
				if (row == avengers.getRow() && column == avengers.getColumn()) {
					BlackWidow blackWidow = (BlackWidow) avengers;
					if (blackWidow.isHasCoin()) {
						try {
							blackWidow.removeCoin();
						} catch (RemoveCoinFailedException e) {
							e.printStackTrace();
						}
						blackWidow.setHasCoin(false);
						this.root.getChildren().remove(coinOriginal);
						if (this.coin != null) {
							this.root.getChildren().remove(this.coin);
							player.setCoin(player.getCoin() + 500);
						} else {
							player.setCoin(player.getCoin() + 500);
						}
					}
				}
			}
		}

	}

}