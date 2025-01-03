package dynamicProgramming;

import java.util.Arrays;

public class CoinChangeII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int coins[]= {1,2,5};
		int amount = 11;
		System.out.println("The fewest number of coins that is needed to make up the amount::"+coinChangeSO(coins,amount));

	}
	//Tabulation TC-> O(n*T) SC-> >>O(n*T)
	 private static int coinChange(int[] coins, int amount) {
	        int n = coins.length;
	        int dp[][] = new int[n][amount+1];
	        for(int[] rows:dp)  Arrays.fill(rows,0);

	        //base case the target can vary from 0 to amount
	        for(int T=0;T<=amount;T++){
	            if(T % coins[0] == 0) dp[0][T] = T/coins[0];
	            else dp[0][T]=(int)1e9;
	        }
	        //check for the parameters
	        for(int ind=1;ind<n;ind++){
	            for(int T=0;T<=amount;T++){
	                 int nottake = 0 + dp[ind-1][T];
	                int take = (int)1e9;
	                if(coins[ind]<=T) take = 1 + dp[ind][T-coins[ind]];
	                dp[ind][T]=Math.min(take,nottake);
	            }
	        }

	        int ans = dp[n-1][amount];
	        if(ans>=(int)(1e9)) return -1;
	        return ans;
	    }
	 
	 //Space Optimization
	 private static int coinChangeSO(int[] coins, int amount) {
	        int n = coins.length;
	        int prev[] = new int[amount+1];
	        Arrays.fill(prev,0);

	        //base case the target can vary from 0 to amount
	        for(int T=0;T<=amount;T++){
	            if(T % coins[0] == 0) prev[T] = T/coins[0];
	            else prev[T]=(int)1e9;
	        }
	        //check for the parameters
	        for(int ind=1;ind<n;ind++){
	             int cur[] = new int[amount+1];
	             Arrays.fill(cur,0);
	            for(int T=0;T<=amount;T++){
	                 int nottake = 0 + prev[T];
	                int take = (int)1e9;
	                if(coins[ind]<=T) take = 1 + cur[T-coins[ind]];
	                cur[T]=Math.min(take,nottake);
	            }prev=cur;
	        }

	        int ans = prev[amount];
	        if(ans>=(int)(1e9)) return -1;
	        return ans;
	    }
}
