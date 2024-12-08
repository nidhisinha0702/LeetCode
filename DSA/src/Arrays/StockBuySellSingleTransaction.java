package Arrays;

public class StockBuySellSingleTransaction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[]  prices = {5, 1, 2, 3, 4};
		int ans = maxProfit(prices);
		System.out.println("Maximum Profit for this transaction is "+ans);
	}
	private static int maxProfit(int[] prices) {
		 int n = prices.length;
	        int buyStock = Integer.MAX_VALUE;
	        int maxProfit = 0;
	        //here the intuition is we keep a minPrice for buying stock ans subtract it with every element and store in maxProfit
	        //because we cannot sell before buying we need not have to worry about the previous day just comparing it with next would do the job
	        
	        for(int i=0;i<n;i++){
	            //buying stock only when the price is minimum
	            buyStock = Math.min(buyStock,prices[i]);
	            //now we cannot sell before buying so start selling after that
	            maxProfit = Math.max(maxProfit,prices[i]-buyStock);
	            
	        }
	        return maxProfit;

	}

}
