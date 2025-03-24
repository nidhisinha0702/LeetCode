package DpOnStocks;

import java.util.Arrays;

public class MaxProfitCooldown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int prices[] = {2,1};
		System.out.println("The maximum profit after buy and sell with a cooldown is : "+maxProfitSpcOpti(prices));

	}
	private static int maxProfit(int[] prices) {
        int n = prices.length;
        int dp[][] = new int[n][2];
        for(int row[]:dp)
        Arrays.fill(row,-1);
        return f(0,1,prices,dp);
    }
    private static int f(int ind, int buy, int prices[], int dp[][]){

        if(ind >= prices.length) return 0;
        if(dp[ind][buy] != -1) return dp[ind][buy];
        if(buy==1){
            return dp[ind][buy]=Math.max(-prices[ind] + f(ind+1,0,prices,dp), 0 + f(ind+1,1,prices,dp));
        }
        return dp[ind][buy]=Math.max(prices[ind] + f(ind+2,1,prices,dp), 0 + f(ind+1,0,prices,dp));
    }
    
    private static int maxProfitTabulation(int[] prices) {
        int n = prices.length;
        int dp[][] = new int[n+2][2];
        for(int row[]:dp)
        Arrays.fill(row,0);
        for(int ind = n-1;ind>=0;ind--){
            for(int buy = 0;buy<=1;buy++){
                if(buy==1)
                    dp[ind][buy]= Math.max(-prices[ind] + dp[ind+1][0], 0 + dp[ind+1][1]);
                else
                    dp[ind][buy] = Math.max(prices[ind] + dp[ind+2][1], 0 + dp[ind+1][0]);
            }
        }
        return dp[0][1];
    }
    
    private static int maxProfitSpcOpti(int[] prices) {
    	int n = prices.length;
        int front2[] = new int[2]; 
        int front1[] = new int[2];
        Arrays.fill(front2,0);
        Arrays.fill(front1,0);
        for(int ind = n-1;ind>=0;ind--){
            int cur[] = new int[2];
            for(int buy = 0;buy<=1;buy++){
                if(buy==1)
                    cur[buy]= Math.max(-prices[ind] + front1[0], 0 + front1[1]);
                else
                    cur[buy] = Math.max(prices[ind] + front2[1], 0 + front1[0]);
            }
            front2=front1;
            front1=cur;
        }
        return front1[1];
    }
}
