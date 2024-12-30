package dynamicProgramming;

import java.util.Arrays;

public class CountWithSubsetKII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []arr = {0,10,0};
		int target = 0;
		System.out.println("Count the number of subsequence with sum k::"+findWaysSO(arr,target));
	}
	//TC->O(n)+O(n*tar) SC->O(n*tar)
	 public static int findWays(int num[], int tar) {
	        // Write your code here.
	        int n = num.length;
	        int dp[][]= new int[n][tar+1];
	        for(int[] rows:dp) Arrays.fill(rows,0);
	        
	        for(int i=0;i<n;i++) dp[i][0]=1;
	        if(num[0]<=tar) dp[0][num[0]] = 1;

	        for(int ind=1;ind<n;ind++){
	            for(int sum=0;sum<=tar;sum++){
	                int notpick = dp[ind-1][sum];
	                int pick = 0;
	                if(num[ind]<=sum) pick = dp[ind-1][sum-num[ind]];
	                dp[ind][sum] = pick + notpick;
	            }
	        }
	        return dp[n-1][tar];
	    }
	 
	 public static int findWaysSO(int num[], int tar) {
	        // Write your code here.
	        int n = num.length;
	        int prev[]= new int[tar+1];
	        Arrays.fill(prev,0);
	        prev[0]=1;
	        if(num[0]<=tar) prev[num[0]]=1;
	        for(int ind=1;ind<n;ind++){
	             int cur[]= new int[tar+1];
	             cur[0]=1;
	            for(int sum=0;sum<=tar;sum++){
	                int notpick = prev[sum];
	                int pick = 0;
	                if(num[ind]<=sum) pick = prev[sum-num[ind]];
	                cur[sum] = pick + notpick;
	            }prev=cur;
	        }
	        return prev[tar];
	    }
}
