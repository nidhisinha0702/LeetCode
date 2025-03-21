package DpOnStocks;

public class MaxProfit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int prices[] = {7,1,5,3,6,4};
		System.out.println("The best time to buy stock is : "+maxProfit(prices));
	}
	private static int maxProfit(int[] prices) {
        int mini = prices[0];
        int n = prices.length;
        int maxProfit = 0;
        for(int i = 1;i<n;i++){
                int cost = prices[i] - mini;
                maxProfit = Math.max(maxProfit,cost);
                mini = Math.min(mini,prices[i]);
            }return maxProfit;
    }
}
