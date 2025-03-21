package DpOnStocks;

import java.util.Arrays;

public class MaxProfitMultipleTxn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int prices[] = {7,1,5,3,6,4};
		System.out.println("The best time to buy stock multiple times is : "+maxProfitSpaceOptimized(prices));
	}
	private static int maxProfit(int[] prices) {
        int n = prices.length;
        int dp[][] = new int[n][2];
        for(int rows[]:dp) Arrays.fill(rows,-1);
        return f(0,1,prices,n,dp);
    }
    private static int f(int ind, int buy, int arr[],int n, int dp[][]){
        //base case
        if(ind == n) return 0;
        //memoize
        if(dp[ind][buy] != -1) return dp[ind][buy];
        //explore ways
        int profit = 0;
        if(buy == 1){
            profit = Math.max((-arr[ind] + f(ind+1,0,arr,n,dp)),
                                (0 + f(ind+1,1,arr,n,dp)));
        }else{
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
}
