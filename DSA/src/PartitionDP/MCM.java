package PartitionDP;

import java.util.Arrays;

public class MCM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {10,20,30,40,50};
		System.out.println("The minimum operation for matrix chain multiplication : "+mcmTab(arr));

	}
	 static int matrixMultiplication(int arr[]) {
	        // code here
	        int N = arr.length;
	        int dp[][] = new int[N][N];
	        for(int[] row:dp)
	        Arrays.fill(row,-1);
	        return f(1,N-1,arr,dp);
	    }
	    
	    private static int f(int i, int j, int[] arr, int[][] dp){
	        if(i==j) return 0;
	        if(dp[i][j] != -1) return dp[i][j];
	        int mini = (int)1e9;
	        for(int k=i;k<j;k++){
	            int steps = (arr[i-1] * arr[k] * arr[j]) + f(i,k, arr, dp) + f(k+1,j, arr, dp);
	            if(steps < mini){
	                mini = steps;
	            }
	        }
	        return dp[i][j] = mini;
	    }
	    
	    private static int mcmTab(int nums[]) {
	    	int n = nums.length;
	    	//declare the array of size n*n
	        int dp[][] = new int[n][n];
	        for(int[] rows:dp)
	        Arrays.fill(rows,0);

	        //base case
	        for(int i=1;i<n;i++)
	        dp[i][i]=0;//when both i=j

	        //write down the changing parameter
	        for(int i=n-1;i>0;i--){ //i was 1 - n-1 so opposite
	            for(int j=i+1;j<n;j++){ //j was n-1 - 1 , but j can not be before i so i+1 - n-1
	                int mini = (int)1e9; //copy the recurrence
	                for(int k=i;k<j;k++){
	                    int steps = (nums[i-1] * nums[k] * nums[j]) + dp[i][k] + dp[k+1][j];
	                    if(steps<mini) mini = steps;
	                }dp[i][j] = mini;
	            }
	        }return dp[1][n-1];
	    }
}
