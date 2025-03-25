package dpOnSubsequence;

public class BestStockWithFees {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] prices = {1,3,2,8,4,9};
		int fee = 2;
		System.out.println("Best time to buy and sell stock with transaction fee is : "+maxProfit(prices, fee));

	}
	private static int maxProfit(int[] prices, int fee) {
        int aheadNotBuy, aheadBuy, curNotBuy, curBuy;
        int n = prices.length;
        aheadNotBuy = aheadBuy = 0;
        for(int ind=n-1;ind>=0;ind--){
            //sell
            curNotBuy = Math.max(prices[ind] + aheadBuy, 0 + aheadNotBuy);
            //buy
            curBuy = Math.max(-prices[ind] - fee + aheadNotBuy, 0 + aheadBuy);

            aheadBuy = curBuy;
            aheadNotBuy = curNotBuy;
        }return aheadBuy;
    }
}
