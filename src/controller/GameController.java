package controller;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.util.*;
import avengers.Avengers;
import bullet.Bullet;
import enemies.Enemy;
import enemies.Thanos;
import gui.GameStage;
import gui.Player;
import gui.ViewManager;

public class GameController implements EventHandler<KeyEvent> {

	private Player player;
	private Enemy enemy;
	private boolean playerWin = false;
	private boolean thanosWin = false;
	private Stage stage;
	private Timer timer;

	public GameController(Player player, Enemy enemy, Stage initStage) {
		this.player = player;
		this.enemy = enemy;
		this.stage = initStage;
	}

	public void initialize() {
		this.startTimer();
	}

	private void startTimer() {
		this.timer = new Timer();
		TimerTask timerTask = new TimerTask() {
			public void run() {
				Platform.runLater(new Runnable() {
					public void run() {
						updateAnimation();
					}
				});
			}
		};

		long frameTimeInMilliseconds = 1l;
		this.timer.schedule(timerTask, 0, frameTimeInMilliseconds);
	}

	public Player getPlayer() {
		return player;
	}

	private void updateAnimation() {
		ArrayList<Avengers> avengersList = checkAvengers();
		ArrayList<Thanos> thanosList = checkThanos();
		ArrayList<Bullet> bulletList = checkBullet();
		runFight(avengersList, thanosList, bulletList);

		for (Bullet bullet : bulletList) {
			bullet.step();
		}
		for (Avengers avengers : avengersList) {
			avengers.step();
		}
		for (Thanos thanos : enemy.getThanos()) {
			thanos.step();
		}
	}

	private ArrayList<Avengers> checkAvengers() {
		ArrayList<Avengers> avengersList = player.getAvengers();
		return avengersList;
	}

	private ArrayList<Bullet> checkBullet() {
		ArrayList<Bullet> bulletList = player.getBullet();
		return bulletList;
	}

	private ArrayList<Thanos> checkThanos() {
		ArrayList<Thanos> thanosList = enemy.getThanos();
		return thanosList;
	}

	private void runFight(ArrayList<Avengers> avengersList, ArrayList<Thanos> ThanosList,
			ArrayList<Bullet> bulletList) {
		boolean avengerDie = false;
		ArrayList<Thanos> blockThanos = new ArrayList<Thanos>();
		for (Iterator<Thanos> iterator2 = ThanosList.iterator(); iterator2.hasNext();) {
			Thanos thanos = iterator2.next();
			if (thanos.getImagePositionX() < 200) {
				this.thanosWin = true;
				this.playerWin = false;
			}
			for (Iterator<Avengers> iterator = avengersList.iterator(); iterator.hasNext();) {
				Avengers avengers = iterator.next();
				int avengersRow = avengers.getRow();
				int avengersColumn = avengers.getColumn();
				int thanosRow = thanos.getRow();
				int thanosColumn = thanos.getColumn();

				if (avengers.getName().equals("Ironman") || avengers.getName().equals("Hawkeye")
						|| avengers.getName().equals("Hulk") || avengers.getName().equals("Thor")) {
					for (Iterator<Bullet> iterator3 = bulletList.iterator(); iterator3.hasNext();) {
						Bullet bullet = iterator3.next();
						int bulletRow = bullet.getRow();
						int bulletX = (int) Math.round(bullet.getImagePositionX());
						if (avengersRow == bulletRow && bulletRow == thanosRow
								&& bulletX == (int) thanos.getImagePositionX()) {
							bullet.removeImage();
							int thanosHealth = thanos.getHealth();
							int avengersPower = avengers.getPower();
							thanos.setHealth(thanosHealth - avengersPower);
							iterator3.remove();
							if (thanos.getHealth() <= 0) {
								thanos.removeImage();
								iterator2.remove();
							}
						}
						if (bullet.getImagePositionX() > 1260) {
							bullet.removeImage();
							iterator3.remove();
						}
					}
				}

				if (avengersRow == thanosRow && avengersColumn == thanosColumn) {
					thanos.setSpeed(0);
					blockThanos.add(thanos);
					int avengersHealth = avengers.getHealth();
					int ThanosPower = thanos.getPower();
					avengers.setHealth(avengersHealth - ThanosPower);
					if (avengers.getHealth() <= 0) {
						avengerDie = true;
					}
				}
				if (avengerDie == true) {
					avengers.removeImage();
					iterator.remove();
				}
				avengerDie = false;
			}

		}
		if (enemy.getThanos().isEmpty()) {
			this.playerWin = true;
			this.thanosWin = false;
		}
		if (playerWin || thanosWin) {
			checkIfEnd();
		}

	}

	public void checkIfEnd() {
		try {
			this.timer.cancel();
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			if (this.playerWin && !this.thanosWin) {
				alert.setTitle("You win the Game");
				alert.setHeaderText("Congratulation!");
				alert.setContentText("Thanos has been defeat!!\nyou just save the world!");
			}
			else if (!this.playerWin && this.thanosWin) {
				alert.setTitle("You lose the Game");
				alert.setHeaderText("Oh no!");
				alert.setContentText("Our base has been defeat!!\nyou cannot save the world!");
			}
			alert.showAndWait();
			playerWin = false;
			thanosWin = false;
			Pane temp = new Pane();
			ViewManager viewManager = new ViewManager();
			temp.getChildren().add(viewManager.getMainPane());
			Scene menuScene = new Scene(temp);
			if (stage != null) {
				stage.setScene(menuScene);
				stage.setFullScreen(true);
				stage.setResizable(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void handle(KeyEvent keyEvent) {
	}
}