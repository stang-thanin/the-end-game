package controller;

import avengers.Avengers;
import avengers.BlackWidow;
import avengers.CaptainAmerica;
import avengers.Hawkeye;
import avengers.Hulk;
import avengers.Ironman;
import avengers.Thor;
import gui.Player;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.input.DragEvent;

public class AvengersDragDropController implements EventHandler<DragEvent> {

	Group root;
	Player player;

	public AvengersDragDropController(Group root, Player player) {
		this.root = root;
		this.player = player;
	}

	@Override
	public void handle(DragEvent event) {
		int row = 1;
		int column = 1;
		String type = event.getDragboard().getString();

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
				} else if (event.getX() <= 528) {
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

				boolean add = true;

				for (Avengers avengers : player.getAvengers()) {
					if (avengers.getRow() == row && avengers.getColumn() == column) {
						add = false;
					}
				}

				if (add) {
					switch (type) {
					case "Ironman":
						if (this.player.getCoin() >= 1000) {
							Ironman ironman = new Ironman(row, column, root, player);
							player.addAvengers(ironman);
							player.setCoin(player.getCoin() - ironman.getPrice());
						}
						break;
					case "CaptainAmerica":
						if (this.player.getCoin() >= 500) {
							CaptainAmerica captainAmerica = new CaptainAmerica(row, column, root, player);
							player.addAvengers(captainAmerica);
							player.setCoin(player.getCoin() - captainAmerica.getPrice());
						}
						break;
					case "BlackWidow":
						if (this.player.getCoin() >= 500) {
							BlackWidow blackWidow = new BlackWidow(row, column, root, player);
							player.addAvengers(blackWidow);
							player.setCoin(player.getCoin() - blackWidow.getPrice());
						}
						break;
					case "Hawkeye":
						if (this.player.getCoin() >= 1750) {
							Hawkeye hawkeye = new Hawkeye(row, column, root, player);
							player.addAvengers(hawkeye);
							player.setCoin(player.getCoin() - hawkeye.getPrice());
						}
						break;
					case "Hulk":
						if (this.player.getCoin() >= 2000) {
							Hulk hulk = new Hulk(row, column, root, player);
							player.addAvengers(hulk);
							player.setCoin(player.getCoin() - hulk.getPrice());
						}
						break;
					case "Thor":
						if (this.player.getCoin() >= 1500) {
							Thor thor = new Thor(row, column, root, player);
							player.addAvengers(thor);
							player.setCoin(player.getCoin() - thor.getPrice());
						}
						break;
					}
				}
			}
		}
		
	}

}