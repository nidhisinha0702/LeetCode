package DpOnStocks;

import java.util.Arrays;

public class NormalShortSellTxn {

	//we can perform three operation buy(1), sell(2), nothing(0) ith day
	private static long f(int ind, int k, int status, int prices[], int n, long dp[][][]) {
		//base case
		if(k == 0) return 0; //txn are finished
		
		if(ind == n) {//last ind past last day
			if(k >= 0 && status == 0) return 0;//
			else return Integer.MIN_VALUE;//invalid
		}
		
		//memoize
		if(dp[ind][k][status] != Integer.MIN_VALUE) return dp[ind][k][status];
		//try all ways
		long take = 0, nottake = 0;
		//nothing - for nottake
		nottake = f(ind+1, k, status, prices, n, dp);
		
		if(status == 1) {//buy has been done in previous step
			//sell and complete the txn
			take = prices[ind] + f(ind+1, k-1, 0, prices, n, dp);//now send status 0 means any three can be done
		}else if(status == 2) {//sell has been done in previous step
			//buy and complete the txn
			take = -prices[ind] + f(ind+1, k-1, 0, prices, n, dp);//now send status 0 means any three can be done
		}else {//nothing has been done in previous step
			//take the max of both buy and sell
			//and send the same status to the next function call
			take = Math.max(-prices[ind] + f(ind+1, k, 1, prices, n, dp), prices[ind] + f(ind+1, k, 2, prices, n, dp));
		}
		return dp[ind][k][status] = Math.max(take, nottake);
		
	}
	
	private static long profit(int[] prices, int k) {
		int n = prices.length;
		long dp[][][] = new long[n][k+1][3];
		for(long row[][]:dp)
			for(long r[]:row)
				Arrays.fill(r,Integer.MIN_VALUE);
		return f(0, k, 0, prices, n, dp);
	}
	public static void main(String[] args) {
		// WAP to write a recurrence relation for normal transaction and short selling txn
		int prices[] = {1,7,9,8,2}; int k = 2;
		//initially we start with ind 0, do nothing, k remaining, arr
		System.out.println("Max profit after k txn : "+profit(prices,k));
	}

}
