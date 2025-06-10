package DpOnStocks;

import java.util.Arrays;

public class MaxProfitTwoTxn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int prices[] = {3,3,5,0,0,3,1,4};
		System.out.println("Maximum profit for at most two txn is : "+maxProfit1(prices));

	}
	 private static int maxProfit(int[] prices) {
	        int n = prices.length;
	        int dp[][][] = new int[n][2][3];//n->ind,o/1->buy,0/1/2->txn cap
	        for(int row[][]:dp)
	        for(int r[]:row)
	        Arrays.fill(r,-1);
	        return f(0,1,2,prices,n,dp);
	    }
	    private static int f(int ind, int buy, int cap, int prices[], int n, int dp[][][]){
	        //base case
	    	if(ind==n || cap == 0) return 0;
	        
	    	//memoize step
	        if(dp[ind][buy][cap] != -1) return dp[ind][buy][cap];
	        
	        int profit = 0;
	        
	        if(buy==1){
	            profit = Math.max((-prices[ind] + f(ind+1,0,cap,prices,n,dp)),(0+f(ind+1,1,cap,prices,n,dp)));
	        }else{//sell and the txn is complete so cap - 1
	            profit = Math.max((prices[ind] + f(ind+1,1,cap-1,prices,n,dp)),(0+ f(ind+1,0,cap,prices,n,dp)));
	        }
	        return dp[ind][buy][cap]=profit;
	    }
	    
	    private static int maxProfitTabulation(int[] prices) {
	        int n = prices.length;
	        int dp[][][] = new int[n+1][2][3];//n+1->ind,o/1->buy,0/1/2->txn cap
	        for(int row[][]:dp)
	        for(int r[]:row)
	        Arrays.fill(r,0);

	        //base case is zero so we are not writing it
	        
	        for(int ind=n-1;ind>=0;ind--){
	            for(int buy=0;buy<=1;buy++){
	                for(int cap = 1;cap<=2;cap++){//for cap = 0 its always 0 so skip
	                    if(buy==1){
	                        dp[ind][buy][cap] = Math.max((-prices[ind] + dp[ind+1][0][cap]),(0+dp[ind+1][1][cap]));
	                    }else{//sell
	                        dp[ind][buy][cap] = Math.max((prices[ind] + dp[ind+1][1][cap-1]),(0 + dp[ind+1][0][cap]));
	                    } 
	                }
	            }
	        }
	        return dp[0][1][2];
	    }
	    
	    private static int maxProfitSpaceOptimization(int[] prices) {
	        int n = prices.length;
	        int after[][] = new int[2][3];//n+1->ind,o/1->buy,0/1/2->txn cap
	        int cur[][] = new int[2][3];
	        for(int r[]:after)
	        Arrays.fill(r,0);

	        for(int ind=n-1;ind>=0;ind--){
	            for(int buy=0;buy<=1;buy++){
	                for(int cap = 1;cap<=2;cap++){//for cap = 0 its always 0 so skip
	                    if(buy==1){
	                        cur[buy][cap] = Math.max((-prices[ind] + after[0][cap]),(0 + after[1][cap]));
	                    }else{//sell
	                        cur[buy][cap] = Math.max((prices[ind] + after[1][cap-1]),(0 + after[0][cap]));
	                    } 
	                }
	            }after=cur;
	        }
	        return after[1][2];
	    }

	    //Another solution
	    private static int maxProfit1(int[] prices) {
	        int n = prices.length;
	        int dp[][] = new int[n+1][4];
	        for(int rows[]:dp)
	        Arrays.fill(rows,-1);
	        return ff(0,0,prices,n,dp);
	    }
	    private static int ff(int ind, int txn, int prices[], int n, int dp[][]){
	        //0,1,2,3 for buy(even) and sell(odd)
	        //base case
	        if(ind == n || txn == 4) return 0;
	        if(dp[ind][txn] != -1) return dp[ind][txn];
	        //explore all possibilities
	        int profit = 0;
	        if(txn % 2 == 0){//buy
	            profit = Math.max((-prices[ind] + ff(ind+1, txn+1, prices, n, dp)), (0 + ff(ind+1, txn, prices, n, dp)));
	        }
	        else profit = Math.max((prices[ind] + ff(ind+1, txn+1, prices, n, dp)), (0 + ff(ind+1, txn, prices, n, dp)));
	        return dp[ind][txn]=profit;
	    }
	    public int maxProfitTab(int[] prices) {
	        int n = prices.length;
	        int dp[][] = new int[n+1][5];
	        for(int rows[]:dp)
	        Arrays.fill(rows,0);

	        for(int ind=n-1;ind>=0;ind--){
	            for(int txn = 3;txn>=0;txn--){
	            int profit = 0;
	            if(txn % 2 == 0){//buy
	                profit = Math.max((-prices[ind] + dp[ind+1][txn+1]), (0 + dp[ind+1][txn]));
	            }
	            else profit = Math.max((prices[ind] + dp[ind+1][txn+1]), (0 + dp[ind+1][txn]));
	            dp[ind][txn]=profit;
	            }
	        }
	        return dp[0][0];
	    }
	    private static int maxProfitSpcOpti(int[] prices) {
	        int n = prices.length;
	        int after[] = new int[5];
	        int cur[] = new int[5];
	        Arrays.fill(after,0);

	        for(int ind=n-1;ind>=0;ind--){
	            for(int txn = 3;txn>=0;txn--){
	            int profit = 0;
	            if(txn % 2 == 0){//buy
	                profit = Math.max((-prices[ind] + after[txn+1]), (0 + after[txn]));
	            }
	            else profit = Math.max((prices[ind] + after[txn+1]), (0 + after[txn]));
	            cur[txn]=profit;
	            }after=cur;
	        }
	        return after[0];
	    }
}
