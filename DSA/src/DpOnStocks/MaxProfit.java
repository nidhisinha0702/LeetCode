package DpOnStocks;

public class MaxProfit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int prices[] = {7,1,5,3,6,4};
		System.out.println("The best time to buy stock is : "+maxProfit(prices));
	}
	//TC->O(n)
	private static int maxProfit(int[] prices) {
		//1st guy is the minimum
        int mini = prices[0];
        int n = prices.length;
        int maxProfit = 0;
        for(int i = 1;i<n;i++){
        	//current cost of buying current stock 
                int cost = prices[i] - mini;
                //find the max profit
                maxProfit = Math.max(maxProfit,cost);
                //new minimum
                mini = Math.min(mini,prices[i]);
            }return maxProfit;
    }
}
