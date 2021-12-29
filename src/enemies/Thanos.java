package enemies;

public interface Thanos {

	public void setImagePosition(double x, double y);

	public double getImagePositionX();

	public int getRow();

	public int getColumn();

	public int getHealth();

	public void setHealth(int health);

	public int getPower();

	public void setSpeed(double speed);

	public void setColumn(int column);

	public void step();

	public void removeImage();

}
