package dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;

public class HouseRobber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(2,1,4,9));
		int ans = maximumNonAdjacentSum(arr);
		System.out.println("The maximum money that robber can stole is::"+ans);

	}
	public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
		// Write your code here.
		int n = nums.size();
		int dp[] = new int[n+1];
		Arrays.fill(dp,-1);
		return f(n-1,nums,dp);
	}
	//Top-down approach 
	private static int f(int ind,ArrayList<Integer> nums,int[] dp){
		if( ind == 0) return nums.get(ind);
		if( ind == -1) return 0;
		if(dp[ind]!=-1) return dp[ind];

		int pick = nums.get(ind) + f(ind - 2,nums,dp);
		int notPick = 0 + f(ind -1,nums,dp);
		return dp[ind]=Math.max(pick,notPick);
	}
	//bottom-up approach
	 private static int rob(int[] nums) {
	        int n = nums.length;
	        int dp[] = new int[n+1];
	        Arrays.fill(dp,-1);
	        dp[0]=nums[0];
	        int neg =0;
	        for(int i =1;i<n;i++){
	            int pick = nums[i];
	            if(i>1)
	            pick += dp[i-2];
	            int notpick = 0 + dp[i-1];
	            dp[i] = Math.max(pick,notpick);
	        }return dp[n-1];
	    }
	 //space optimization
	 private static int robSpace(int[] nums) {
		 int n = nums.length;
	        int prev = nums[0];
	        int prev2 = 0;
	        for(int i =1;i<n;i++){
	            int pick = nums[i];
	            if(i>1)
	            pick += prev2;
	            int notpick = 0 + prev;
	            int curri = Math.max(pick,notpick);
	            prev2 = prev;
	            prev = curri;
	        }return prev;
	 }
}
