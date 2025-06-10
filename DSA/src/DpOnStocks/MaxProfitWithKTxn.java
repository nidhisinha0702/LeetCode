package DpOnStocks;

import java.util.Arrays;

public class MaxProfitWithKTxn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int prices[] = {1,7,9,8,2};
		int k = 2;
		
		System.out.println("The maximum profit with at most k txn is : "+maxProfitTab(k,prices));

	}
	 private static int maxProfit(int k, int[] prices) {
	        int n = prices.length;
	        int dp[][] = new int[n][2*k];
	        for(int rows[]:dp)
	        Arrays.fill(rows,-1);

	        return f(0,0,prices,n,k,dp);
	    }
	    private static int f(int ind, int txn, int prices[], int n, int k, int dp[][]){
	        //base case 1 txn - buy & sell (2)
	        if(ind == n || txn == 2 * k) return 0;
	        //memoize
	        if(dp[ind][txn] != -1) return dp[ind][txn];
	        //explore all ways
	        int profit = 0;
	        if(txn % 2 == 0){//buy
	            profit = Math.max((-prices[ind] + f(ind+1,txn+1,prices,n,k, dp)),
	                                (0 + f(ind+1,txn,prices,n,k, dp)));
	        }else{//sell
	           profit = Math.max((prices[ind] + f(ind+1,txn+1,prices,n,k, dp)),
	                                (0 + f(ind+1,txn,prices,n,k,dp)));
	        }
	        //return max
	        return dp[ind][txn]=profit;
	    }
	    
	    private static int maxProfitTab(int k, int[] prices) {
	    	int n = prices.length;
	    	int dp[][] = new int[n+1][2*k+1];
	    	
	    	//base case is zero so ignore
	    	//changing parameter
	    	for(int ind=n-1;ind>=0;ind--) {
	    		for(int trnNo=2*k-1;trnNo>=0;trnNo--) {
	    			int profit = 0;
	    	        if(trnNo % 2 == 0){//buy
	    	            profit = Math.max((-prices[ind] + dp[ind+1][trnNo+1]),
	    	                                (0 + dp[ind+1][trnNo]));
	    	        }else{//sell
	    	           profit = Math.max((prices[ind] + dp[ind+1][trnNo+1]),
	    	                                (0 + dp[ind+1][trnNo]));
	    	        }
	    	        
	    	        dp[ind][trnNo] = profit;
	    		}
	    	}
	    	
	    	return dp[0][0];
	    	
	    }
	    private static int maxProfitSpcOpt(int k, int[] prices) {
	        int n = prices.length;
	        int after[] = new int[2*k+1];
	        int cur[] = new int[2*k+1];
	        Arrays.fill(after,0);

	        for(int ind=n-1;ind>=0;ind--){
	            for(int txn=2*k-1;txn>=0;txn--){
	                int profit = 0;
	            if(txn % 2 == 0){//buy
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
