
public class AutomoblieTester {

	public static void main(String[] args) {
		
		Automobile myBMW = new Automobile(24);
		
		myBMW.fillUp(20);
		myBMW.takeTrip(100);
		
		double fuelLeft = myBMW.reportFuel();
		
		System.out.println(fuelLeft);
		
	}

}
