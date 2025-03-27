package dpOnLIS;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {10,9,2,5,3,7,101,18};
		System.out.println("The longest increasing subsequence is : "+lengthOfLISSpcOpti(arr));
		
	}
	
	private static int lengthOfLIS(int[] nums) {
		 int n = nums.length;
	        int dp[][] = new int[n][n+1];//0-n-1(ind),0-n(prev_ind)
	        for(int rows[]:dp)
	        Arrays.fill(rows,-1);
	        return f(0,-1,nums,dp);
    }
	
	private static int f(int ind, int prev_ind, int[] nums, int [][]dp) {
		//base case
				if(ind == nums.length) return 0;
		        //memoization
		        if(dp[ind][prev_ind+1] != -1) return dp[ind][prev_ind+1];//coordinate change while accessing and returning
				//not-take
				
				int len = 0 + f(ind+1, prev_ind, nums, dp);
				//take
				if(prev_ind == -1 || (nums[ind] > nums[prev_ind]))
				len = Math.max(len,  1 + f(ind+1, ind, nums, dp));
				
				return dp[ind][prev_ind+1] = len;//coordinate change while storing
	}
	
	private static int lengthOfLISTabulation(int[] nums) {
		int n = nums.length;
        int dp[][] = new int[n+1][n+1];//0-n-1(ind),0-n(prev_ind)
        for(int rows[]:dp)
        Arrays.fill(rows,0);

        for(int ind=n-1;ind>=0;ind--){
            for(int prev_ind=ind-1;prev_ind>=-1;prev_ind--){
                int len = 0 + dp[ind+1][prev_ind+1];
                //take
                if(prev_ind == -1 || (nums[ind] > nums[prev_ind]))
                len = Math.max(len,  1 + dp[ind+1][ind+1]);
                
                dp[ind][prev_ind+1] = len;
            }
        }
        return dp[0][-1+1];
	}

	private static int lengthOfLISSpcOpti(int[] nums) {
        int n = nums.length;
        int next[] = new int[n+1];//0-n-1(ind),0-n(prev_ind)
        int cur[] = new int[n+1];
        Arrays.fill(next,0);

        for(int ind=n-1;ind>=0;ind--){
            for(int prev_ind=ind-1;prev_ind>=-1;prev_ind--){
                int len = 0 + next[prev_ind+1];
                //take
                if(prev_ind == -1 || (nums[ind] > nums[prev_ind]))
                len = Math.max(len,  1 + next[ind+1]);
                
                cur[prev_ind+1] = len;
            }next=cur;
        }
        return next[-1+1];
    }
}
