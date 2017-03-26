
public class LinearFunction implements LinearFunctionMethods {
	
	private double slope;
	private double yIntc;
	
	public LinearFunction(double slope, double yIntc) {
		this.slope = slope;
		this.yIntc= yIntc;
	}

	@Override
	public double getSlope() {
		return slope;
	}

	@Override
	public double getYIntercept() {
		return yIntc;
	}

	@Override
	public double getRoot() {
		return -yIntc / slope;
	}

	@Override
	public double getYValue(double x) {
		return slope * x + yIntc;
	}

	@Override
	public double getXValue(double y) {
		return (y - yIntc) / slope;
	}

}
