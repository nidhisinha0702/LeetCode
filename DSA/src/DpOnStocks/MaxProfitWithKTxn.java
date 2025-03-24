package DpOnStocks;

import java.util.Arrays;

public class MaxProfitWithKTxn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int prices[] = {3,2,6,5,0,3};
		int k = 2;
		
		System.out.println("The maximum profit with at most k txn is : "+maxProfit(k,prices));

	}
	 private static int maxProfit(int k, int[] prices) {
	        int n = prices.length;
	        int dp[][] = new int[n][2*k];
	        for(int rows[]:dp)
	        Arrays.fill(rows,-1);

	        return f(0,0,prices,n,k,dp);
	    }
	    private static int f(int ind, int txn, int prices[], int n, int k, int dp[][]){
	        //base case
	        if(ind==n || txn==2*k) return 0;
	        if(dp[ind][txn] != -1) return dp[ind][txn];
	        //explore all ways
	        int profit = 0;
	        if(txn%2 == 0){//buy
	            profit = Math.max((-prices[ind] + f(ind+1,txn+1,prices,n,k, dp)),
	                                (0 + f(ind+1,txn,prices,n,k, dp)));
	        }else{//sell
	           profit = Math.max((prices[ind] + f(ind+1,txn+1,prices,n,k, dp)),
	                                (0 + f(ind+1,txn,prices,n,k,dp)));
	        }
	        //return max
	        return dp[ind][txn]=profit;
	    }
	    
	    private static int maxProfitSpcOpt(int k, int[] prices) {
	        int n = prices.length;
	        int after[] = new int[2*k+1];
	        int cur[] = new int[2*k+1];
	        Arrays.fill(after,0);

	        for(int ind=n-1;ind>=0;ind--){
	            for(int txn=2*k-1;txn>=0;txn--){
	                int profit = 0;
	            if(txn%2 == 0){//buy
	                profit = Math.max((-prices[ind] + after[txn+1]),
	                                    (0 + after[txn]));
	            }else{//sell
	                profit = Math.max((prices[ind] + after[txn+1]),
	                                    (0 + after[txn]));
	            }
	            //return max
	            cur[txn]=profit;
	            }after=cur;
	        }
	        return after[0];
	    }
}
