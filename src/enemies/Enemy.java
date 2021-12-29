package enemies;

import java.util.ArrayList;
import javafx.scene.Group;
import java.util.*;

public class Enemy {

	private ArrayList<Thanos> thanosList = new ArrayList<Thanos>();
	Group root = new Group();
	Random rand = new Random();

	public Enemy(Group root) {
		this.root = root;
		thanosList = generateThanos();
	}

	public ArrayList<Thanos> generateThanos() {
		int lokiNum = 18;
		int thanosMNum = 15;
		for (int j = 0; j < lokiNum; j++) {
			Loki loki = new Loki(rand.nextInt(5) + 1, rand.nextInt(5) + 11, root);
			thanosList.add(loki);
		}
		for (int k = 0; k < thanosMNum; k++) {
			ThanosM thanos_m = new ThanosM(rand.nextInt(5) + 1, rand.nextInt(5) + 11, root);
			thanosList.add(thanos_m);
		}
		return thanosList;
	}

	public ArrayList<Thanos> getThanos() {
		return thanosList;
	}

}