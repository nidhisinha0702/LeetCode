package PartitionDP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class BurstBalloons {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[]= {3,1,5,8};
		System.out.println("the maximum cost to burst baloons are : "+maxCoinsTab(nums));

	}
	private static int maxCoins(int[] nums) {
	       ArrayList<Integer> arr = (ArrayList<Integer>) Arrays.stream(nums).boxed().collect(Collectors.toList());
	       int n = arr.size();
	       arr.add(1);
	       arr.add(0,1);
	       int [][]dp = new int[n+1][n+1];
	       for(int rows[]:dp)
	       Arrays.fill(rows,-1);
	       return f(1,n,arr,dp);
	    }
	    private static int f(int i, int j, ArrayList<Integer>  nums, int dp[][]){
	        if(i>j) return 0;
	        if(dp[i][j]!=-1) return dp[i][j];
	        int maxi = Integer.MIN_VALUE;
	        for(int ind=i;ind<=j;ind++){
	            int cost = nums.get(i-1) * nums.get(ind) * nums.get(j+1) + f(i,ind-1,nums,dp) + f(ind+1,j,nums,dp);
	            maxi = Math.max(maxi,cost);
	        }return dp[i][j]=maxi;
	    }
	    
	    private static int maxCoinsTab(int[] nums) {
	        ArrayList<Integer> arr = (ArrayList<Integer>) Arrays.stream(nums).boxed().collect(Collectors.toList());
	        int n = arr.size();
	        arr.add(1);
	        arr.add(0,1);
	        int [][]dp = new int[n+2][n+2];
	        for(int rows[]:dp)
	        Arrays.fill(rows,0);

	         for(int i=n;i>=1;i--){
	             for(int j=1;j<=n;j++){
	                 if(i>j) continue;
	                 int maxi = Integer.MIN_VALUE;
	                 for(int ind=i;ind<=j;ind++){
	                     int cost = arr.get(i-1) * arr.get(ind) * arr.get(j+1) + dp[i][ind-1] + dp[ind+1][j];
	                     maxi = Math.max(maxi,cost);
	                 } dp[i][j]=maxi;
	             }
	         }
	        return dp[1][n];
	     }
}
