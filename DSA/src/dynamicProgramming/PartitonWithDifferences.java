package dynamicProgramming;

import java.util.Arrays;

public class PartitonWithDifferences {
	private static final int mod = (int)1e9 + 7;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {5,2,6,4};
		int n = arr.length;
		int d = 3;
		System.out.println("The number of susequences with given differences are: "+countPartitions(n,d,arr));

	}
	public static int countPartitions(int n, int d, int[] arr) {
		// Write your code here.
		int totSum = 0;
		for(int a:arr){
			totSum += a;
		}
		if(totSum - d < 0 || ((totSum - d) % 2 == 1)) return 0;
		return findWays(arr,(totSum - d)/2);
		
	}
	 public static int findWays(int num[], int tar) {
 			int n = num.length;
	        int dp[][]= new int[n][tar+1];
	        for(int[] rows:dp) Arrays.fill(rows,-1);
	        return f(n-1,tar,num,dp);
	 }
	private static int f(int ind,int sum,int num[],int dp[][]){
		if(ind == 0){
			if(sum == 0 && num[0] == 0) return 2;
			if(sum == 0 || num[0] == sum) return 1;
			return 0;
		}
	        if(dp[ind][sum] != -1) return dp[ind][sum];
	        int notpick = f(ind-1,sum,num,dp);
	        int pick = 0;
	        if(num[ind]<=sum) pick = f(ind-1,sum-num[ind],num,dp);
	        return dp[ind][sum]=(pick + notpick)%mod;
	}
}
