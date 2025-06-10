package DpOnStocks;

import java.util.Arrays;

public class MaxProfitMultipleTxn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int prices[] = {7,1,5,3,6,4};
		System.out.println("The best time to buy stock multiple times is : "+maxProfitVariableSol(prices));
	}
	private static int maxProfit(int[] prices) {
        int n = prices.length;
        //n for arr indices and buy is 2 for (0/1)
        int dp[][] = new int[n][2];
        for(int rows[]:dp) Arrays.fill(rows,-1);
        return f(0,1,prices,n,dp);
    }
	//TC->O(2^n), SC->O(n)
    private static int f(int ind, int buy, int arr[],int n, int dp[][]){
        //base case
        if(ind == n) return 0;
        //memoize
        if(dp[ind][buy] != -1) return dp[ind][buy];
        //explore ways
        int profit = 0;
        //we can buy
        if(buy == 1){
        	//we have two choice for buy-> buy/notbuy
        	//if we are buying that means -ve price added to profit
        	//move to next ind and we can not buy on the next day
        	//it not buying price added is 0 and move to next ind and can buy on the next day
            profit = Math.max((-arr[ind] + f(ind+1,0,arr,n,dp)),
                                (0 + f(ind+1,1,arr,n,dp)));
        }else{
        	//similarly for sell two choice
            profit = Math.max((arr[ind] + f(ind+1,1,arr,n,dp)),
                                (0 + f(ind+1,0,arr,n,dp)));
        }return dp[ind][buy] = profit;
    }
    private static int maxProfitTabulation(int[] prices) {
        int n = prices.length;
        int dp[][] = new int[n+1][2];
        for(int rows[]:dp) Arrays.fill(rows,0);
        //base case
        dp[n][1]=dp[n][0] = 0;
        //changing parameter
        for(int ind=n-1;ind>=0;ind--){
            for(int buy=0;buy<2;buy++){
                 int profit = 0;
                    if(buy == 1){
                        profit = Math.max((-prices[ind] + dp[ind+1][0]),
                                            (0 + dp[ind+1][1]));
                    }else{
                        profit = Math.max((prices[ind] + dp[ind+1][1]),
                                            (0 + dp[ind+1][0]));
                    } dp[ind][buy] = profit;
            }
        }
        return dp[0][1];
    }
    private static int maxProfitSpaceOptimized(int[] prices) {
        int n = prices.length;
        int prev[] = new int[2];
        int cur[] = new int[2];
        Arrays.fill(prev,0);
        //base case
        cur[1]=prev[0] = 0;
        //changing parameter
        for(int ind=n-1;ind>=0;ind--){
            for(int buy=0;buy<2;buy++){
                 int profit = 0;
                    if(buy == 1){
                        profit = Math.max((-prices[ind] + prev[0]),
                                            (0 + prev[1]));
                    }else{
                        profit = Math.max((prices[ind] + prev[1]),
                                            (0 + prev[0]));
                    } cur[buy] = profit;
            }prev=cur;
        }
        return prev[1];
    }
    
    private static int maxProfitVariableSol(int[] prices) {
    	int aheadBuy,aheadNotBuy, curBuy, curNotBuy;
    	
    	aheadBuy = aheadNotBuy = 0;
    	int n = prices.length;
    	for(int ind = n-1; ind>=0;ind--) {
    		curNotBuy = Math.max(prices[ind] + aheadBuy, 0 + aheadNotBuy);
    		curBuy = Math.max(-prices[ind] + aheadNotBuy, 0 + aheadBuy);
    		
    		aheadNotBuy = curNotBuy;
    		aheadBuy = curBuy;
    	}
    	return aheadBuy;
    }
}
