package dynamicProgramming;

import java.util.Arrays;

public class SubsetSumK {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 1, 2, 3, 4 };
        int k = 4;
        int n = arr.length;
        System.out.println("The subset sum is equal to k::"+subsetSumToK(n,k,arr));

	}
	 private static boolean subsetSumToK(int n, int k, int arr[]){
	        // Write your code here.
	        int dp[][] = new int[n][k+1];
	        for(int[] rows:dp){
	            Arrays.fill(rows,-1);
	        }
	        return f(n-1,k,arr,dp);
	    }
	    private static boolean f(int ind,int target, int arr[],int dp[][]){
	        if(target == 0) return true;
	        if(ind == 0) return (arr[0] == target);
	        if(dp[ind][target] != -1) return dp[ind][target] == 0 ? false : true;
	        boolean nottake = f(ind-1,target,arr,dp);
	        boolean take =false;
	        if(arr[ind]<=target) take = f(ind -1, target-arr[ind],arr,dp);
	        dp[ind][target] = take || nottake ? 1:0;
	        return take||nottake;
	    }

}
