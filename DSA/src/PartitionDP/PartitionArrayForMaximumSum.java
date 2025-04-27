package PartitionDP;

import java.util.Arrays;

public class PartitionArrayForMaximumSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,15,7,9,2,5,10};
		int n = 7;
		int k = 3;
		System.out.println("Largest sum of the given array after partitioning is : "+maxSumAfterPartitioningTab(arr,k));

	}
	 private static int maxSumAfterPartitioning(int[] arr, int k) {
	        int n = arr.length;
	        int dp[] = new int[n];
	        Arrays.fill(dp,-1);
	        return f(0,n,k,arr,dp);
	    }

	    private static int f(int ind, int n, int k, int arr[], int dp[]){
	        if(ind == n) return 0;
	        if(dp[ind]!=-1) return dp[ind];
	        int len=0, maxi=Integer.MIN_VALUE, maxAns=Integer.MIN_VALUE;
	        for(int j=ind;j<Math.min(ind+k,n);j++){
	            len++;
	            maxi = Math.max(maxi,arr[j]);
	            int sum = (len * maxi) + f(j+1, n, k, arr,dp);
	            maxAns = Math.max(sum,maxAns);
	        }return dp[ind]=maxAns;
	    }
	    
	    private static int maxSumAfterPartitioningTab(int[] arr, int k) {
	        int n = arr.length;
	        int dp[] = new int[n+1];
	        Arrays.fill(dp,0);
	        dp[n]=0;
	        for(int ind=n-1;ind>=0;ind--){
	             int len=0, maxi=Integer.MIN_VALUE, maxAns=Integer.MIN_VALUE;
	                for(int j=ind;j<Math.min(ind+k,n);j++){
	                    len++;
	                    maxi = Math.max(maxi,arr[j]);
	                    int sum = (len * maxi) + dp[j+1];
	                    maxAns = Math.max(sum,maxAns);
	                } dp[ind]=maxAns;
	        }

	        return dp[0];
	    }

}
