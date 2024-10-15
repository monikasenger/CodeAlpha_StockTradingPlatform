package StockTradingPlatform;

import java.util.ArrayList;
import java.util.Scanner;

public class StockTradingPlatform {
	  ArrayList<Stock> stocks= new ArrayList<>();;
	 TrackingPortfolio portfolio = new TrackingPortfolio();
	 public StockTradingPlatform() {
		    stocks.add(new Stock("UP", "Upstox", 150.0, 2.5));
		    stocks.add(new Stock("ANG", "Angel One", 2500.0, 1.2));
		    stocks.add(new Stock("ZER", "Zerodha", 200.0, 3.1));
		}

	 //method to print the market data
		public void printMarketData() {
		    for (Stock stock : stocks) {
		        System.out.println(stock);
		    }
		}

		//method to get stock symbol
		public Stock getStockBySymbol(String symbol) {
		    for (Stock stock : stocks) {
		        if (stock.getSymbol().equals(symbol)) {
		            return stock;
		        }
		    }
		    return null;
		}

		//method to update market data
		public void updateMarketData() {
		    for (Stock stock : stocks) {
		        double newPrice = stock.getCurrentPrice() + (Math.random() - 0.5) * 10;
		        stock.UpdatePrice(newPrice);
		    }
		}

	
}

