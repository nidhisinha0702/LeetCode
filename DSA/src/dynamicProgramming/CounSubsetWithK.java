package dynamicProgramming;

import java.util.Arrays;

public class CounSubsetWithK {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []arr = {1,1,4,5};
		int target = 5;
		System.out.println("Count the number of subsequence with sum k::"+findWays(arr,target));

	}
	 public static int findWays(int num[], int tar) {
	        // Write your code here.
	        int n = num.length;
	        int dp[][]= new int[n][tar+1];
	        for(int[] rows:dp) Arrays.fill(rows,-1);
	        return f(n-1,tar,num,dp);
	    }
	    private static int f(int ind,int sum,int []num,int dp[][]){
	        if(sum == 0) return 1;
	        if(ind == 0) return (num[0] == sum ?1:0);
	        if(dp[ind][sum] != -1) return dp[ind][sum];
	        int notpick = f(ind-1,sum,num,dp);
	        int pick = 0;
	        if(num[ind]<=sum) pick = f(ind-1,sum-num[ind],num,dp);
	        return dp[ind][sum]=pick + notpick;
	    }

}
