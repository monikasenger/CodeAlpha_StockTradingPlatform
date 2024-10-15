package StockTradingPlatform;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TrackingPortfolio {
	 private Map<String, Integer> stocks;
	    private double cash;
	    
	    //constructor of Tracking portfolio class
	    public TrackingPortfolio() {
	stocks = new HashMap<>();
    cash = 10000.0;
}

	    
	    //buy stock method
public void buyStock(Stock stock, int quantity) {
    double totalCost = stock.getCurrentPrice() * quantity;
    if (cash >= totalCost) {
        cash -= totalCost;
        stocks.put(stock.getSymbol(), stocks.getOrDefault(stock.getSymbol(), 0) + quantity);
        System.out.println("\nYou bought " + quantity + " shares of " + stock.getName() + " at $" + stock.getCurrentPrice() + ".");
    } else {
        System.out.println("\nInsufficient cash balance!");
    }
}


//sell stock method
public void sellStock(Stock stock, int quantity) {
    if (stocks.containsKey(stock.getSymbol()) && stocks.get(stock.getSymbol()) >= quantity) {
        cash += stock.getCurrentPrice() * quantity;
        stocks.put(stock.getSymbol(), stocks.get(stock.getSymbol()) - quantity);
        if (stocks.get(stock.getSymbol()) == 0) {
            stocks.remove(stock.getSymbol());
        }
        System.out.println("\nYou sold " + quantity + " shares of " + stock.getName() + " at $" + stock.getCurrentPrice() + ".");
    } else {
        System.out.println("\nNot enough shares to sell!");
    }
}


//print portfolio method
public void printPortfolio(ArrayList<Stock> allStocks) {
    System.out.println("Portfolio--");
    for (Map.Entry<String, Integer> entry : stocks.entrySet()) {
        String symbol = entry.getKey();
        int quantity = entry.getValue();
        Stock stock = getStockBySymbol(symbol, allStocks);
        if (stock != null) {
            System.out.println(stock.getName() + " (" + symbol + "): " + quantity + " shares at $" + stock.getCurrentPrice() + " each.");
        }
    }
    System.out.println("Cash: $" + cash);
}


//get portfolio value method
public double getPortfolioValue(ArrayList<Stock> allStocks) {
    double value = cash;
    for (Map.Entry<String, Integer> entry : stocks.entrySet()) {
        Stock stock = getStockBySymbol(entry.getKey(), allStocks);
        if (stock != null) {
            value += stock.getCurrentPrice() * entry.getValue();
        }
    }
    return value;
}


//get stock method
private Stock getStockBySymbol(String symbol, ArrayList<Stock> allStocks) {
    for (Stock stock : allStocks) {
        if (stock.getSymbol().equals(symbol)) {
            return stock;
        }
    }
    return null;
}
}
