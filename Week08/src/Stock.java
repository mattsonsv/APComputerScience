
public class Stock {
	
	public String symbol;
	public String name;
	public double previousClosingPrice;
	public double currentPrice;
	
	public Stock(String sym, String nam) {
		symbol = sym;
		name = nam;
	}
	
	public double getChangePercent() {
		return currentPrice / previousClosingPrice;
	}
	
}
