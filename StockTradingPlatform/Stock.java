package StockTradingPlatform;

public class Stock {
	  private String Symbol;
	    private String Name;
	    private double Currentprice;
	    private double Change;
		public String getSymbol() {
			return Symbol;
		}
		public void setSymbol(String symbol) {
			Symbol = symbol;
		}
		public String getName() {
			return Name;
		}
		public void setName(String name) {
			Name = name;
		}
		public double getCurrentPrice() {
			return Currentprice;
		}
		public void setCurrentPrice(double currentprice) {
			Currentprice = currentprice;
		}
		public double getChange() {
			return Change;
		}
		public void setChange(double change) {
			Change = change;
		}
		public Stock(String symbol, String name, double currentprice, double change) {
			super();
			Symbol = symbol;
			Name = name;
			Currentprice = currentprice;
			Change = change;
		}
		@Override
		public String toString() {
			return Symbol + " : " + Name + " -> $" + Currentprice +", ( " + Change + " % ) "; 
		}
	     
		public void UpdatePrice(double newprice) {
			Change =(newprice - Currentprice) / Currentprice * 100;
			Currentprice = newprice;
		}
	    
	    
}
