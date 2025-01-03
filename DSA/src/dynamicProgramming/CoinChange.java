package dynamicProgramming;

import java.util.Arrays;

public class CoinChange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int coins[]= {1,2,5};
		int amount = 11;
		System.out.println("The fewest number of coins that is needed to make up the amount::"+coinChange(coins,amount));

	}

	//Recursive and Memoization TC-> >= 2^n(exponential) SC->O(n*T)+>=O(n)
	private static int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int dp[][] = new int[n][amount+1];
        for(int[] rows:dp)  Arrays.fill(rows,-1);
        int ans = f(n-1,amount,coins,dp);
        if(ans>=(int)(1e9)) return -1;
        return ans;
    }
    private static int f(int ind,int T, int[] coins, int dp[][]){
        if(ind == 0){
            if(T % coins[0] == 0) return T/coins[0];
            return (int)1e9;
        }
        if(dp[ind][T] != -1) return dp[ind][T];
        int nottake = 0 + f(ind-1,T,coins,dp);
        int take = (int)1e9;
        if(coins[ind]<=T) take = 1 + f(ind,T-coins[ind],coins,dp);
        return dp[ind][T]=Math.min(take,nottake);


    }
}
