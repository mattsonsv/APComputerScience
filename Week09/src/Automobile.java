
public class Automobile {
	
	private double mpg;
	private double gallons;
	
	public Automobile(double milesPerGallon) {
		mpg = milesPerGallon;
		gallons = 0.0;
	}
	
	public void fillUp(int gal) {
		gallons += gal;
	}
	
	public void takeTrip(int miles) {
		gallons -= miles / mpg;
	}
	
	public double reportFuel() {
		return gallons;
	}
	
}
