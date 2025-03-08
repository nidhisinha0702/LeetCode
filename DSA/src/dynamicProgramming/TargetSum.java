package dynamicProgramming;

import java.util.Arrays;

public class TargetSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = {1,1,1,1,1};
		int target = 3;
		System.out.println("The number of different expression that can be built with taget sum target is : "+findTargetSumWays(nums,target));

	}
	 private static int findTargetSumWays(int[] nums, int target) {
	        return countPartitions(nums.length,target,nums);
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
		        // Write your code here.
		        int n = num.length;
		        int dp[][]= new int[n][tar+1];
		        for(int[] rows:dp) Arrays.fill(rows,0);
		        
		        if(num[0] == 0) dp[0][0]=2;
				else dp[0][0]=1;
		        if(num[0] != 0 && num[0]<=tar) dp[0][num[0]] = 1;

		        for(int ind=1;ind<n;ind++){
		            for(int sum=0;sum<=tar;sum++){
		                int notpick = dp[ind-1][sum];
		                int pick = 0;
		                if(num[ind]<=sum) pick = dp[ind-1][sum-num[ind]];
		                dp[ind][sum] = (pick + notpick);
		            }
		        }
		        return dp[n-1][tar];
		    }
}
