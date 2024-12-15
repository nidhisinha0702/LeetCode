package dynamicProgramming;

import java.util.Arrays;

public class FrogJumpII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {10,20, 30, 10};
		int n = 4;
		//int ans = frogJump(n,arr);
		int ans = frogJumpS(n,arr);
		System.out.println("the minimum total energy used by the frog to reach from '1st' stair to 'Nth' stair:"+ans);

	}
	//Bottom up approach but space here is O(n)
	 private static int frogJump(int n, int heights[]) {
	        int[] dp = new int[n+1];
	        Arrays.fill(dp,-1);
	        dp[0]=0;
	        for(int i=1;i<n;i++) {
	        	int fs = dp[i-1] + Math.abs(heights[i] - heights[i-1]);
	        	int ss = Integer.MAX_VALUE;
	        	if(i>1) ss = dp[i-2] + Math.abs(heights[i] - heights[i-2]);
	        	
	        	dp[i]=Math.min(fs, ss);
	        }return dp[n-1];
	    }
	 //bottom up approach with space optimization
	 private static int frogJumpS(int n, int heights[]) {
		 
		 int prev = 0;
		 int prev2 = 0;
		 for(int i=1;i<n;i++) {
			 int fs = prev + Math.abs(heights[i] - heights[i-1]);
			 int ss = Integer.MAX_VALUE;
	        	if(i>1) ss = prev2 + Math.abs(heights[i] - heights[i-2]);
	        int curri = Math.min(fs, ss);
	        prev2 = prev;
	        prev = curri;
		 }return prev;
	 }

}
