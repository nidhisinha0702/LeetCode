package dynamicProgramming;

import java.util.Arrays;

public class MinimalCost {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {10,30,40,50,20};
		int k = 3;
		int ans = minimizeCost(k,arr);
		System.out.println("The minimum cost in which a frog will jump k steps::"+ans);

	}
	
	private static int minimizeCost(int k, int arr[]) {
		int n = arr.length;
		int dp[] = new int[n+1];
		Arrays.fill(dp,-1);
		return frogJump(n-1,k,dp,arr);
	}
	//this is a recursive approach with memoization technique
	private static int frogJump(int ind,int k,int dp[],int arr[]) {
		if(ind == 0) return 0;
		if(dp[ind]!=-1) return dp[ind];
		int mini = Integer.MAX_VALUE;
		for(int j=1;j<=k;j++) {
			if(ind-j>=0) {
				int step = frogJump(ind-j,k,dp,arr) + Math.abs(arr[ind] - arr[ind-j]);
				mini = Math.min(mini, step);
			}
		}return mini;
	}
	
}
