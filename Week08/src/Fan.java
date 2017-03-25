
public class Fan {

	public final int SLOW = 1;
	public final int MEDIUM = 2;
	public final int FAST = 3;
	private int speed;
	private boolean isOn;
	private double radius;
	private String color;
	
	public Fan() {
		speed = SLOW;
		isOn = false;
		radius = 5;
		color = "blue";
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public boolean isOn() {
		return isOn;
	}

	public void setOn(boolean isOn) {
		this.isOn = isOn;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	public String toString() {
		if (isOn)
			return "Speed: " + speed + ", Color: " + color + ", Radius: " + radius + ".";
		else
			return "The fan is off " + ", Color: " + color + ", Radius: " + radius + ".";
	}
}
