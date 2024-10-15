package StockTradingPlatform;

import java.util.Scanner;

public class StrockTrading_Main {
	public static void main(String[] args) {
	    StockTradingPlatform platform = new StockTradingPlatform();
	TrackingPortfolio portfolio = new TrackingPortfolio();
	    Scanner sc = new Scanner(System.in);

	    while (true) {
			System.out.println("\n********************STOCK TRADING PLATFORM********************");
		  System.out.println("\n[1] View Market Data\n[2] Buy Stock\n[3] Sell Stock\n[4] Track Portfolio\n[5] Update Market Data\n[6] Exit");
	      
	        System.out.println("Choose an option: ");
	        int option = sc.nextInt();

	        switch (option) {
	            case 1:
					System.out.println("\n-----MARKET DATA-----"); 
	                platform.printMarketData();
	                break;
	            case 2:
	            	System.out.println("\n-----BUY STOCK-----");
					  System.out.println("Enter stock symbol: ");
	                String symbol = sc.next();
	                
	                Stock stock = platform.getStockBySymbol(symbol);
	                if (stock != null) {
	                    System.out.println("Enter quantity: ");
	                    int quantity = sc.nextInt();
	                    platform.portfolio.buyStock(stock, quantity);
	                } else {
	                    System.out.println("Stock not found!");
	                }
	                break;
	            case 3:
	            	System.out.println("\n-----SELL STOCK-----");
	                System.out.println("Enter stock symbol: ");
	                symbol = sc.next();
	                
	                stock = platform.getStockBySymbol(symbol);
	                if (stock != null) {
	                    System.out.println("Enter quantity: ");
	                    int quantity = sc.nextInt();
	                    platform.portfolio.sellStock(stock, quantity);
	                } else {
	                    System.out.println("Stock not found!");
	                }
	                break;
	            case 4:
	                platform.portfolio.printPortfolio(platform.stocks);
	                System.out.println("\nPortfolio Value: $" + platform.portfolio.getPortfolioValue(platform.stocks) + "\n");
	                break;
	            case 5:
	                platform.updateMarketData();
	                System.out.println("Market data updated.\n");
	                break;
	            case 6:
	                System.out.println("Exiting...");
	                sc.close();
	                return;
	            default:
	                System.out.println("Invalid option! Please try again....");
	        }
	    }
	}
}
