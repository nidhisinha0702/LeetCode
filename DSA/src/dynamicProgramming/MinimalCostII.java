package dynamicProgramming;

import java.util.Arrays;

public class MinimalCostII {

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
			//this is a bottom up approach with tabulation technique
				dp[0]=0;
				
				for(int i=1;i<n;i++) {
					int mini = Integer.MAX_VALUE;
					for(int j=1;j<=k;j++) {
						if(i-j>=0) {
							dp[i] = dp[i - j] + Math.abs(arr[i] - arr[i-j]);
							mini = Math.min(mini, dp[i]);
						}
					}dp[i]=mini;
				}return dp[n-1];
			}

}
