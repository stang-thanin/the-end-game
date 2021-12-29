package avengers;

public abstract class Avengers implements Drawable  {

	public abstract int getHealth();

	public abstract void setHealth(int health);

	public abstract int getPower();

	public abstract void setPower(int power);

	public abstract int getPrice();

	public abstract String getName();

	public void setPosition(int x, int y) {}

	public void step() {}

	public void removeImage() {}

	public int getRow() {
		return 0;
	}

	public int getColumn() {
		return 0;
	}

}